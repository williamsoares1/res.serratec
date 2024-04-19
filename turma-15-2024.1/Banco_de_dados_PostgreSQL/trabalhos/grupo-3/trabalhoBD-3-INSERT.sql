insert into sistema.cliente
(nome, nome_usuario, data_nasc, cpf, email)
values
('Maria da Silva', 'maria_silva', '1990-05-15', '12345678901', 'maria@gmail.com'),
('João Pereira', 'joao_pereira', '1985-10-20', '98765432109', 'joao@gmail.com'),
('Ana Souza', 'ana_souza', '1988-03-25', '45678912307', 'ana@yahoo.com'),
('Pedro Oliveira', 'pedro_oliveira', '1993-12-10', '78912345603', 'pedro@hotmail.com'),
('Carla Santos', 'carla_santos', '1998-07-08', '32165498705', 'carla@outlook.com');

insert into sistema.endereco 
(idcliente, rua, bairro, cidade, cep)
values
(1,'Rua das Flores', 'Centro', 'São Paulo', '01001000'),
(1,'Rua das Jades', 'Zona-Norte', 'São Paulo', '01001012'),
(2,'Avenida Principal', 'Jardim Botânico', 'Rio de Janeiro', '20000001'),
(3,'Rua da Praia', 'Praia do Canto', 'Vitória', '29000000'),
(4,'Rua das Palmeiras', 'Bosque', 'Belo Horizonte', '30000000'),
(5,'Avenida Central', 'Centro', 'Brasília', '70000000');

insert into sistema.categoria
(nome, descricao)
values
('Eletrônicos', 'Produtos eletrônicos'),
('Livros', 'Livros de todos os gêneros'),
('Roupas', 'Vestuário em geral'),
('Alimentos', 'Produtos alimentícios'),
('Informática', 'Produtos de informática');

insert into sistema.funcionario
(nome, cpf)
values
('João Silva', '11122233344'),
('Maria Oliveira', '55566677788'),
('Carlos Souza', '99900011122'),
('Ana Martins', '33344455566'),
('Luiz Costa', '77788899900');

insert into sistema.produto
(idcategoria, nome, descricao, qtd_estoque, valor, data_fab)
values
(1, 'Smartphone XYZ', 'Último modelo, 128GB', 100, 2500.00, '2023-01-01'),
(2, 'Mesa de Jantar', 'Mesa de madeira, 6 lugares', 50, 1500.00, '2023-02-01'),
(3, 'Jaqueta Jeans', 'Jaqueta azul tamanho M', 75, 300.00, '2023-03-01'),
(4, 'Livro de Ficção Científica', 'Edição de luxo, capa dura', 200, 45.00, '2023-04-01'),
(5, 'Bola de Futebol', 'Bola oficial tamanho padrão', 150, 120.00, '2023-05-01');

insert into sistema.pedido
(idcliente, idendereco, data_pedido)
values
(1, 1, '2024-03-23 10:00:00'),
(2, 3, '2024-03-23 11:00:00'),
(3, 4, '2024-03-23 12:00:00'),
(4, 5, '2024-03-23 13:00:00'),
(5, 6, '2024-03-23 14:00:00'),
(1, 2, '2024-03-23 11:00:00');

insert into sistema.pedido_item
(idpedido, idproduto, idcliente, valor, qtd)
values
(1, 1, 1, (select valor from sistema.produto
		  where idproduto = 1), 1),
(2, 2, 2, (select valor from sistema.produto
		  where idproduto = 2), 1),
(3, 3, 3, (select valor from sistema.produto
		  where idproduto = 3), 2),
(4, 4, 4, (select valor from sistema.produto
		  where idproduto = 4), 3),
(5, 5, 5, (select valor from sistema.produto
		  where idproduto = 5), 2),
(6, 2, 1, (select valor from sistema.produto
		  where idproduto = 2), 4);
		  
insert into sistema.nota_fiscal
(codigofiscal, idpedido, observacao)
values
(1010, 1, 'Dois pedidos em uma NF'),
(1010, 2, 'Dois pedidos em uma NF'),
(8020, 3, '1ª Parcela - mais de uma nf'),
(4521, 3, '2ª Parcela - mais de uma nf'),
(2767, 3, '3ª Parcela - mais de uma nf'),
(3030, 4, 'Um pedido e uma NF');