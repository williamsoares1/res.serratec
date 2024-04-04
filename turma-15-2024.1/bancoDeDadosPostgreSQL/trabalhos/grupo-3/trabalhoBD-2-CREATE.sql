--create schema sistema

create table sistema.cliente 
(
	idcliente serial primary key,
	nome varchar (120),
	nome_usuario varchar (50),
	data_nasc date,
	cpf varchar(11),
	email varchar(80)
);

create table sistema.endereco
(
	idendereco serial primary key,
	idcliente int references sistema.cliente (idcliente),
	rua varchar(100),
	bairro varchar(20),
	cidade varchar(25),
	cep varchar(08)
);

create table sistema.categoria
(
	idcategoria serial primary key,
	nome varchar(60),
	descricao text
);

create table sistema.funcionario
(
	idfuncionario serial primary key,
	nome varchar (80),
	cpf varchar(15)
);

create table sistema.pedido
(
	idpedido serial primary key,
	idcliente integer references sistema.cliente (idcliente),
	idendereco integer references sistema.endereco (idendereco),
	data_pedido timestamp without time zone default now(),
	sopradeletar int
);

create table sistema.produto
(
	idproduto serial primary key,
	idcategoria integer references sistema.categoria (idcategoria),
	nome varchar (100) unique,
	descricao varchar(150),
	qtd_estoque int,
	valor double precision,
	data_fab date
);

create table sistema.pedido_item
(	
	id_pedido_item serial primary key,	
	idpedido integer references sistema.pedido (idpedido),
	idproduto integer references sistema.produto (idproduto),
	idcliente integer references sistema.cliente (idcliente),
	valor double precision,
	qtd int
);

create table sistema.nota_fiscal
(
	codigofiscal int not null,
	idpedido int references sistema.pedido (idpedido),
	observacao text
);