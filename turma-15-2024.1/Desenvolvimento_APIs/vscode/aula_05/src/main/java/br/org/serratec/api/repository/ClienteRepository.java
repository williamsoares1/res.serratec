package br.org.serratec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
