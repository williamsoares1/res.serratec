select nome, telefone, idcargo, contato 
	from sistema.medico md
left join sistema.telefones tl on tl.idpessoa = md.idmedico
where tl.contato = 'Numero pessoal';

select numero, data_hora, fu.nome as "Funcionario", md.nome as "Medico", tt.nome as "Tutor", me.nome as "Nome", me.valor, quantidade, valor_total 
	from sistema.vendas v
join sistema.venda_itens vi on vi.idvenda = v.idvenda
left join sistema.medico md on md.idmedico = v.idmedico
left join sistema.tutor tt on tt.idtutor = v.idtutor
left join sistema.funcionario fu on fu.idfuncionario = v.idfuncionario
left join sistema.medicamento me on me.idmedicamento = vi.idmedicamento
	order by fu.nome;