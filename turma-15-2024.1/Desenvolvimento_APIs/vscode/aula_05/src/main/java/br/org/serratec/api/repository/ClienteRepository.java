package br.org.serratec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.api.model.Cliente;
import java.util.List;
import java.time.LocalDate;



public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByDataNascimentoAfter(LocalDate dataNascimento);

    List<Cliente> findByNomeContaining(String nome);
}
