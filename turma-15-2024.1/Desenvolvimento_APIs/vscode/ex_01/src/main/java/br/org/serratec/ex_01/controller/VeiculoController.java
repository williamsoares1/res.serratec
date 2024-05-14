package br.org.serratec.ex_01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ex_01.model.Veiculo;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private List<Veiculo> veiculos = new ArrayList<>();
    int id = 1;

    @GetMapping
    public List<Veiculo> buscarTodos(){
        return veiculos;
    }

    @GetMapping("/{id}")
    public Veiculo buscarEsp(@PathVariable int id){
        int indice = indice(id);

        if(indice != -1){
            return veiculos.get(indice);
        }

        return null;
    }

    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo){
        veiculo.setId(id++);
        veiculos.add(veiculo);
        return veiculo;
    }

    @PutMapping("/{id}")
    public Veiculo alterar(@PathVariable int id, @RequestBody Veiculo veiculo){
        int indice = indice(id);

        if(indice != -1){
            veiculo.setId(veiculos.get(indice).getId());
            veiculos.set(indice, veiculo);
            return veiculo;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String alterar(@PathVariable int id){
        int indice = indice(id);

        if(indice != -1){
            veiculos.remove(indice);
            return "O item foi excluido com sucesso.";
        }
        return "Item não encontrado ou já excluido.";
    }

    private int indice(int id){
        for(int i = 0; i < veiculos.size(); i++){
            if(veiculos.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
