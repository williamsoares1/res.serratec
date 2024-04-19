update sistema.cliente set nome = 'Ana P. Souza'
where idcliente = 3;

delete from sistema.funcionario
where idfuncionario = 3;

select * from sistema.pedido
join sistema.pedido_item on sistema.pedido_item.idpedido = sistema.pedido.idpedido;


-- Relacionamento cliente-endereco

select rua, bairro, cidade, nome, nome_usuario, data_nasc, email, cpf from sistema.endereco
join sistema.cliente on sistema.cliente.idcliente = sistema.endereco.idcliente;

------------------------------------------------------



-- Quantos pedidos alguem fez (Com count() e group by)

select
	count(*) as "Pedidos", cl.nome 
		from sistema.pedido_item pi
		
join sistema.cliente cl
	on cl.idcliente = pi.idcliente
	
group by cl.nome;

------------------------------------------------------



-- De quanto foi esses pedidos (com sum() e group by)

select 
	sum(pi.valor * pi.qtd) as "Total", cl.nome 
		from sistema.pedido_item pi
		
join sistema.cliente cl 
	on cl.idcliente = pi.idcliente
	
group by cl.nome;

------------------------------------------------------



-- NF

select 
	codigofiscal as "Codigo", nf.observacao, cl.nome,
	nf.idpedido, pd.nome 
		from sistema.nota_fiscal nf
		
join sistema.pedido pe 
	on pe.idpedido = nf.idpedido
	
join sistema.pedido_item pi
	on pi.idpedido = nf.idpedido
	
join sistema.cliente cl 
	on cl.idcliente = pe.idcliente
	
join sistema.produto pd 
	on pd.idproduto = pi.idproduto
------------------------------------------------------



-- um pedido e mais de uma nf (assumindo um valor parcelado)

select 
	codigofiscal as "Codigo", nf.observacao, cl.nome, 
	((pi.valor * pi.qtd) / (select count(codigofiscal) from sistema.nota_fiscal where idpedido = 3)) as "Total parcelado", 
	pd.nome
		from sistema.nota_fiscal nf
		
join sistema.pedido pe 
	on pe.idpedido = nf.idpedido
	
join sistema.pedido_item pi 
	on pi.idpedido = nf.idpedido
	
join sistema.cliente cl 
	on cl.idcliente = pe.idcliente
	
join sistema.produto pd 
	on pd.idproduto = pi.idproduto
	
where nf.idpedido = 3

------------------------------------------------------