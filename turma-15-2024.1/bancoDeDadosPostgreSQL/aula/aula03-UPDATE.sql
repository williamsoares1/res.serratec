update sistema.medicamento set observacao = 'Contraindicado em casos de suspeita de dengue';
where idmedicamento = 4

update sistema.medicamento set nome = 'Anti-rábica P2', laboratorio = 'Lab XI12'
where idmedicamento = 1;

update sistema.tutor set observacao = null
where idtutor = 3;

update sistema.tutor set observacao = observacao || ' - Tutor não possui CPF'
where cpf is null;

update sistema.medico set observacao = 'Menos tempo de descanso'
where idcargo = (select idcargo from sistema.cargo
				 where descricao = 'Medico auxiliar');

update sistema.vendas set valor_total = 
						(select sum(quantidade * valor) from sistema.venda_itens
						where idvenda = 1)
where idvenda = 1;

update sistema.vendas set valor_total = 
						(select sum(quantidade * valor) from sistema.venda_itens
						where idvenda = 2)
where idvenda = 2;

update sistema.vendas set valor_total = 
						(select sum(quantidade * valor) from sistema.venda_itens
						where idvenda = 3)
where idvenda = 3;

update sistema.vendas set valor_total = 
						(select sum(quantidade * valor) from sistema.venda_itens
						where idvenda = 4)
where idvenda = 4;

update sistema.vendas set valor_total = 
						(select sum(quantidade * valor) from sistema.venda_itens
						where idvenda = 5)
where idvenda = 5;