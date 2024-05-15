package br.org.serratec.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.api.dtos.ClienteDTO;
import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    public List<ClienteDTO> obterTodos() {
        return repositorio.findAll().stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getDataNascimento()))
                .toList();
    }

    public Optional<ClienteDTO> obterPorId(Long id) {
        Optional<Cliente> cliente = repositorio.findById(id);

        if (cliente.isPresent()) {
            return Optional.of(cliente.get().toDTO());
        }

        return Optional.empty();
    }

    public List<ClienteDTO> obterPorAnoNasc(String nascimento) {
        return repositorio.findByDataNascimentoAfter(LocalDate.parse(nascimento)).stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getDataNascimento()))
                .collect(Collectors.toList());
    }

    public List<ClienteDTO> obterPorNome(String nome) {
        return repositorio.findByNomeContaining(nome).stream()
                .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getDataNascimento()))
                .collect(Collectors.toList());
    }

    public ClienteDTO salvar(ClienteDTO clientedto) {
        Cliente cliente = repositorio.save(clientedto.toEntity());
        return cliente.toDTO();
    }

    public Optional<ClienteDTO> atualizar(Long id, ClienteDTO cliente) {
        Cliente clienteEntity = cliente.toEntity();

        if (repositorio.existsById(id)) {
            clienteEntity.setId(id);
            repositorio.save(clienteEntity);
            return Optional.of(clienteEntity.toDTO());
        }

        return Optional.empty();
    }

    public Boolean excluir(Long id) {

        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return true;
        }

        return false;
    }
}
