package br.org.serratec.api.dtos;

import java.time.LocalDate;

import br.org.serratec.api.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClienteDTO(
        Long id,
        @NotBlank String nome,
        @Size(min = 11, max = 11) @Pattern(regexp = "\\d{11}", message = "O valor não esta no padrão adequado") String cpf,
        @Email @NotBlank String email,
        @Past @NotNull LocalDate dataNascimento) {

    public Cliente toEntity() {
        return new Cliente(this.id, this.nome, this.cpf(), this.email, this.dataNascimento);
    }
}
