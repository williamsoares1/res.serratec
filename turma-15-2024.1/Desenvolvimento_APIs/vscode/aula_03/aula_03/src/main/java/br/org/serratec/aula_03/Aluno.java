package br.org.serratec.aula_03;

public class Aluno {
    private int id;
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

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public String exibeDados() {
        return String.format("ID: %s - Nome: %s - Curso: %s - Periodo: %s", id, nome, curso, periodo);
    }
}
