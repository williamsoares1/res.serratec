select * from sistema.tutor where lower(nome) like 's%';

select * from sistema.medico where upper(nome) like upper('%r%');

select * from sistema.medico where nome ilike '%O';