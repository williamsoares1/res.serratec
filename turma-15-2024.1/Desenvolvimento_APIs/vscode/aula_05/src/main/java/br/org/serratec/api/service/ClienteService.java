package br.org.serratec.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.api.dtos.ClienteDTO;
import br.org.serratec.api.model.Cliente;
import br.org.serratec.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    public List<ClienteDTO> obterTodos(){
        return repositorio.findAll().stream().map(c -> 
            new ClienteDTO( c.getId(), c.getNome(), c.getCpf(), c.getEmail(), c.getDataNascimento())
        ).toList();
    }

    public Optional<ClienteDTO> obterPorId(Long id){
        Optional<Cliente> cliente = repositorio.findById(id);

        if (cliente.isPresent()) {
            return Optional.of(cliente.get().toDTO());
        }

        return Optional.empty();
    }

    public ClienteDTO salvar(ClienteDTO clientedto) {
        Cliente cliente = repositorio.save(clientedto.toEntity());
        return cliente.toDTO();
    }

    public Optional<ClienteDTO> atualizar(Long id, ClienteDTO cliente){
        Cliente clienteEntity = cliente.toEntity();

        if(repositorio.existsById(id)){
            clienteEntity.setId(id);
            repositorio.save(clienteEntity);
            return Optional.of(clienteEntity.toDTO());
        }

        return Optional.empty();
    }

    public Boolean excluir(Long id){
        
        if(repositorio.existsById(id)){
            repositorio.deleteById(id);
            return true;
        }

        return false;
    }
}
