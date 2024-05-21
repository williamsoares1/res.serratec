package org.br.serratec.api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro")
public class RegistroFuncionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long id;
    private String cnpj;
    private String alvara;
    private LocalDate dataAltorizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAlvara() {
        return alvara;
    }

    public void setAlvara(String alvara) {
        this.alvara = alvara;
    }

    public LocalDate getDataAltorizacao() {
        return dataAltorizacao;
    }

    public void setDataAltorizacao(LocalDate dataAltorizacao) {
        this.dataAltorizacao = dataAltorizacao;
    }
}
