package br.org.serratec.ex_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ex_02.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
