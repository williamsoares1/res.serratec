package br.org.serratec.aula_02;

public class Aluno {
    private String nome;
    private String curso;
    private String periodo;

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String exibeDados(){
        return String.format("Nome: %s - Curso: %s - Periodo: %s", nome, curso, periodo);
    }
}
