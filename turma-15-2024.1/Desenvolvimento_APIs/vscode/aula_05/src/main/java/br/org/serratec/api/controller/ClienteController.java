package br.org.serratec.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.api.dtos.ClienteDTO;
import br.org.serratec.api.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService servico;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obterTodos() {
        return ResponseEntity.ok(servico.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterPorId(@PathVariable Long id) {
        return ResponseEntity.of(servico.obterPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClienteDTO> cadastrarCliente(@Valid @RequestBody ClienteDTO cliente) {
        return ResponseEntity.ok(servico.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> alterarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        return ResponseEntity.of(servico.atualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {

        if(!servico.excluir(id)){
            return ResponseEntity.notFound().build();
        };

        return ResponseEntity.noContent().build();
    }
}
