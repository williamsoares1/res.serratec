create table sistema.tutor
(
	idtutor serial not null primary key,
	nome varchar(100) not null,
	cpf varchar(11),
	data_cad timestamp not null default now(),
	data_nasc date,
	observacao text
);

create table sistema.cidade
(
	idcidade serial not null primary key,
	nome varchar(100) not null,
	uf varchar(2) not null
);

create table sistema.bairro
(
	idbairro serial not null primary key,
	nome varchar(100) not null
);

create table sistema.endereco
(
	idendereco serial not null primary key,
	logradouro varchar(150),
	idbairro integer references sistema.bairro (idbairro),
	idcidade integer references sistema.cidade (idcidade)
);

create table sistema.enderecos
(
	idenderecos serial not null primary key,
	idpessoa integer,
	tppessoa char(1),
	idindereco integer references sistema.endereco (idendereco),
	nr_endereco varchar(10),
	cep varchar(8)
);

create table sistema.telefones
(
	idtelefone serial not null primary key,
	idpessoa integer not null,
	tppessoa char(1) not null,
	telefone varchar(20) not null,
	contato varchar(60),
	tipo char(1)
);

create table sistema.email
(
	idemail serial not null primary key,
	idpessoa integer not null,
	tppessoa char(1) not null,
	email varchar(120) not null
);

create table sistema.cargo
(
	idcargo serial not null primary key,
	descricao varchar(120),
	salario double precision not null,
	carga_horaria double precision
);

create table sistema.funcionario
(
	idfuncionario serial not null primary key,
	nome varchar(100),
	cpf varchar(11),
	data_cad timestamp not null default now(),
	data_nasc date,
	observacao text,
	idcargo integer references sistema.cargo (idcargo)
);

create table sistema.medico
(
	idmedico serial primary key,
	nome varchar(100),
	cpf varchar(11),
	crmv varchar(10),
	data_cad timestamp not null default now(),
	data_nasc date,
	observacao text,
	idcargo integer references sistema.cargo (idcargo)
);

create table sistema.especialidade
(
	idespecialidade serial primary key,
	descricao varchar(100)
);

create table sistema.medico_esp
(
	idmedicoesp serial primary key,
	idespecialidade integer references sistema.especialidade (idespecialidade),
	idmedico integer references sistema.medico (idmedico)
);

create table sistema.tipos_medicamento
(
	idtipomed serial primary key,
	descricao varchar(100)
);

create table sistema.medicamento
(
	idmedicamento serial primary key,
	nome varchar(100),
	validade date,
	laboratorio varchar(100),
	fornecedor varchar(100),
	categoria varchar(100),
	valor double precision,
	posologia varchar(50),
	observacao text,
	idtipomed integer references sistema.tipos_medicamento (idtipomed)
);

create table sistema.procedimento
(
	idprocedimento serial primary key,
	descricao varchar(100),
	observacao text,
	valor double precision
);

create table sistema.raca
(
	idraca serial primary key,
	nome varchar(60),
	caracteristicas text
);

create table sistema.especie
(
	idespecie serial primary key,
	nome varchar(60)
);

create table sistema.animal
(
	idanimal serial primary key,
	nome varchar(100),
	idraca integer references sistema.raca (idraca),
	idtutor integer references sistema.tutor (idtutor),
	data_nasc date,
	idespecie integer references sistema.especie (idespecie),
	peso double precision,
	tem_pedigree boolean,
	observacao text,
	pelagem varchar(50)
);

create table sistema.agenda
(
	idagenda serial primary key,
	data_agenda date,
	hora time,
	idtutor integer references sistema.tutor (idtutor),
	idanimal integer references sistema.animal (idanimal),
	idmedico integer references sistema.medico (idmedico),
	observacao text
);

create table sistema.consulta
(
	idconsulta serial primary key,
	data_consulta date,
	horario time,
	idanimal integer references sistema.animal (idanimal),
	idtutor integer references sistema.tutor (idtutor),
	valor double precision,
	idmedico integer references sistema.medico (idmedico),
	idagenda integer references sistema.agenda (idagenda),
	observacao text
);

create table sistema.consulta_proc
(
	idconsultaproc serial primary key,
	idconsulta integer references sistema.consulta (idconsulta),
	idprocedimento integer references sistema.procedimento (idprocedimento),
	valor double precision,
	quantidade double precision
);

create table sistema.consulta_med
(
	idconsultamed serial primary key,
	idconsulta integer references sistema.consulta (idconsulta),
	idmedicamento integer references sistema.medicamento (idmedicamento),
	valor double precision,
	quantidade double precision
);

create table sistema.animal_proc
(
	idanimalproc serial primary key,
	idprocedimento integer references sistema.procedimento (idprocedimento),
	idanimal integer references sistema.animal (idanimal),
	data_procedimento timestamp,
	observacao text,
	idmedico integer references sistema.medico (idmedico),
	idfuncionario integer references sistema.funcionario (idfuncionario)
);

create table sistema.vendas
(
	idvenda serial primary key,
	valor_total double precision,
	observacao text,
	idpessoa integer,
	data_hora timestamp,
	numero varchar(15),
	idmedico integer references sistema.medico (idmedico),
	idfuncionario integer references sistema.funcionario (idfuncionario)
);

create table sistema.venda_itens
(
	iditens serial primary key,
	idvenda integer references sistema.vendas (idvendas),
	idmedicamento integer references sistema.medicamento (idmedicamento),
	quantidade double precision,
	valor double precision
);

create table sistema.formas_pgto
(
	idforma serial primary key,
	descricao varchar(60),
	qt_parcelas integer,
	avista boolean
);

create table sistema.vendas_pgto
(
	idvendaspgto serial primary key,
	idvenda integer references sistema.vendas (idvenda),
	idforma integer references sistema.formas_pgto (idforma),
	idconsulta integer references sistema.consulta (idconsulta),
	valor double precision,
	data_pgto timestamp
);

create table sistema.financeiro(
	idfinanceiro serial primary key,
	numero varchar(15),
	idvenda integer references sistema.vendas(idvenda),
	idconsulta integer references sistema.consulta (idconsulta),
	idvendaspgto integer references sistema.vendas_pgto(idvendaspgto),
	idforma integer references sistema.formas_pgto(idforma),
	idtutor integer references sistema.tutor(idtutor),
	valor double precision,
	data_emissao timestamp without time zone,
	data_vencimento timestamp without time zone,
	data_baixa timestamp without time zone,
	valor_pago double precision,
	valor_desconto double precision,
	valor_acrescimo double precision,
	valor_juros double precision,
	valor_multa double precision,
	observacao text
);