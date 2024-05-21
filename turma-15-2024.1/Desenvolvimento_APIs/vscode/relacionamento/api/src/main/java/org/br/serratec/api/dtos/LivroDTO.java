package org.br.serratec.api.dtos;

import java.util.List;

public record LivroDTO(String titulo,
String isbn,
int anoLancamento,
Long editoraId,
List<Long> autorId) {

}
