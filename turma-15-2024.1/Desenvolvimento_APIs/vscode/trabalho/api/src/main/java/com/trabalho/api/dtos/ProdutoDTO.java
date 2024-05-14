package com.trabalho.api.dtos;

import com.trabalho.api.domain.Produto;
import com.trabalho.api.domain.Tipo;

public record ProdutoDTO(Long id,
        String nome,
        String descricao,
        Double preco,
        Tipo tipo) {

    public Produto toEntity() {
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.tipo);
    }

}
