-- 1
select disc.disc_nome as "Disciplina", prof.prof_nome, prof.prof_cidade, disc.curso_nome as "Curso" 
	from turma15.professor_disciplina pd
join turma15.professor prof on prof.prof_numero = pd.prof_numero
join turma15.disciplina disc on disc.disc_codigo = pd.disc_codigo
	where pd.ano = '2018';



-- 2
select prof.prof_nome, disc.disc_nome as "Disciplina", disc.curso_nome as "Curso"
	from turma15.professor_disciplina pd
join turma15.professor prof on prof.prof_numero = pd.prof_numero
join turma15.disciplina disc on disc.disc_codigo = pd.disc_codigo
	where pd.ano = '2018' 
		and disc.curso_nome = 'CST Sistemas para Internet';



-- 3
select al.aluno_nome, al.aluno_cidade, disc.disc_nome as "Disciplina", disc.curso_nome as "Curso" 
	from turma15.matricula ma
join turma15.aluno al on al.aluno_numero = ma.aluno_numero
join turma15.disciplina disc on disc.disc_codigo = ma.disc_codigo
	where ano = '2018'
	order by al.aluno_nome;



-- 4
select al.aluno_nome, al.aluno_cidade, disc.disc_nome as "Disciplina", disc.curso_nome as "Curso" 
	from turma15.matricula ma
join turma15.aluno al on al.aluno_numero = ma.aluno_numero
join turma15.disciplina disc on disc.disc_codigo = ma.disc_codigo
	where ano = '2018'
		and al.aluno_cidade = 'Palmas' 
		and disc.disc_nome = 'Programação de Banco de dados';
		--or disc.disc_nome = 'Banco de dados'



-- 5
select prof.prof_nome, prof.prof_cidade, disc.disc_nome as "Disciplina", disc.curso_nome as "Curso" 
	from turma15.professor_disciplina pd
join turma15.professor prof on prof.prof_numero = pd.prof_numero
join turma15.disciplina disc on disc.disc_codigo = pd.disc_codigo
	where prof.prof_cidade != 'Palmas'
		and disc.curso_nome = 'CST Sistemas para Internet';



-- 6 
select prof.prof_nome, avg(qtd_aulas) as "Media" 
	from turma15.professor_disciplina pd
join turma15.professor prof on prof.prof_numero = pd.prof_numero
join turma15.disciplina disc on disc.disc_codigo = pd.disc_codigo
	group by prof.prof_nome;


-- 7
select prof.prof_nome, sum(qtd_aulas) as "Total de aulas" 
	from turma15.professor_disciplina pd
join turma15.professor prof on prof.prof_numero = pd.prof_numero
join turma15.disciplina disc on disc.disc_codigo = pd.disc_codigo
	group by prof.prof_nome;
	
	

-- 8
select al.aluno_nome, disc.curso_nome as "Curso", disc.disc_codigo ,disc.disc_nome as "Disciplina" 
	from turma15.matricula ma
join turma15.aluno al on al.aluno_numero = ma.aluno_numero
join turma15.disciplina disc on disc.disc_codigo = ma.disc_codigo
	order by al.aluno_nome;