package br.org.serratec.aula_04;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private int anoLancamento;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public Genero getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
