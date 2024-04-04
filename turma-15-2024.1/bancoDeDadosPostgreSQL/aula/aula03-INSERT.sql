insert into sistema.medico
(nome, cpf, crmv, data_cad, data_nasc, observacao, idcargo)
values
('Dr. Sérgio Rodrigo', '12345678010', '122122-12', now(), '20-08-1989', 'Usa um oculos bacana', 1),
('Dr. Cicolo Polo', '12345678111', '122123-13', now(), '10-10-1969', 'Apelidado de dinossauro pelos colegas', 1),
('Dr. Felipe Gama', '12345678212', '122124-14', now(), '13-12-2002', ' ', 1);

insert into sistema.tutor
(nome, cpf, data_cad, data_nasc, observacao)
values
('Billie Jean', '12345678920', now(), '30-08-1999', 'Recorrente'),
('Senhora Bonvinho', '12345678921', now(), '04-01-1950', 'Pede por cupons de desconto'),
('Senhor Cartidario', '12345678922', now(), '23-01-1962', null),
('Juquinha', '12345678923', now(), '12-10-2003', 'Recorrente');

insert into sistema.especie
(nome)	
values
('Cavalo'), ('Gato'), ('Cachorro'), ('Passarinho');

insert into sistema.raca
(nome)
values
('Persa'), ('SRD'), ('Pincher'), ('Caramelo'), ('Malhado');

insert into sistema.procedimento
(descricao, observacao, valor)
values
('Vacinação', null, 50.00),
('Vermifugação', null, 30.00),
('Tosa', null, 60.00),
('Castração', 'Verficar peso do animal', 200.00),
('Rotina', null, 100.00),
('Cirurgia de rins', null, 750.00);

insert into sistema.tipos_medicamento
(descricao)
values
('Vacina'), ('Vermifugo'), ('Antibiótico'),('Anestesia'),('Anti-inflamatorio'), ('Anti-fungo');

insert into sistema.medicamento
(nome, validade, laboratorio, fornecedor, categoria, valor, posologia, observacao, idtipomed)
values
('Anti-rábica', '23/05/2026', 'Lab X01', 'FarmaLutro', 'Injetavel', 35.00, '1 dose a cada 30 dias 3x, 1 ampola via cutánea', null, 1),
('Anti-inflamatório para cães', '2024-11-30', 'VetLab', 'PetShop XYZ', 'Veterinário', 25.99, 'Administrar conforme orientação do veterinário', 'Mantenha fora do alcance de crianças e animais domésticos', 6),
('Vermífugo para gatos', '2025-07-15', 'VetPharma', 'PetLand', 'Veterinário', 12.50, 'Dose única por via oral', 'Observar possíveis reações adversas após a administração', 2),
('Antipulgas para cães e gatos', '2025-09-30', 'PetCare', 'AnimalStore', 'Veterinário', 18.75, 'Aplicar no dorso do animal de acordo com o peso', 'Evitar contato com os olhos do animal', 3);

insert into sistema.telefones
(idpessoa, tppessoa, telefone, contato, tipo)
values
(1,'T', '+55 21 96740192', 'Numero pessoal', '1'),
(1,'T', '44729321', 'Casa do tutor', '2'),
(2,'T', '+55 22 91231244', 'Numero pessoal', '1'),
(2,'T', '99120423', 'Casa do tutor', '2'),
(3,'T', '+55 21 910129232', 'Numero pessoal', '1'),
(3,'T', '36542443', 'Casa do tutor', '2'),
(4,'T', '+55 21 976274681', 'Numero pessoal', '1'),
(4,'T', '19213123', 'Casa do tutor', '2'),
(5,'T', '+55 19 988428613', 'Numero pessoal', '1'),
(5,'T', '21231334', 'Casa do tutor', '2');

insert into sistema.funcionario
(nome, cpf, data_cad, data_nasc, observacao, idcargo)
values
('Ana H.', '12345678910', now(), '21/06/2000', null, 4),
('Victor Lopes', '12345678911', now(), '04/12/2004', null, 4),
('Carlos Alberto', '12345678912', now(), '22/07/1990', null, 3),
('Maria Dantas', '12345678913', now(), '08/02/1991', null, 3);

insert into sistema.vendas
(numero, data_hora, observacao, idmedico, idtutor, idfuncionario)
values
('0001', '05/03/2024', null, 8, 2, 1),
('0022', '05/03/2024', null, 9, 5, 1),
('0131', '05/03/2024', null, 9, 4, 2),
('0441', '05/03/2024', null, 11, 3, 2);

insert into sistema.vendas
(numero, data_hora, observacao, idmedico, idtutor, idfuncionario)
values
('0445', '06/03/2024', null, 11, 2, 1);

insert into sistema.venda_itens
(idvenda, idmedicamento, quantidade, valor)
values
(5,4,2,(select valor from sistema.medicamento where idmedicamento = 4));