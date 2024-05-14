package br.org.serratec.aula_03;

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

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    private List<Aluno> alunos = new ArrayList<>();
    int id = 0;

    @GetMapping
    public List<Aluno> mostrarTodos() {
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno mostrar(@PathVariable int id) {
        int indice = obterIndice(id);

        if (indice != -1) {
            return alunos.get(indice);
        }

        return null;
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        aluno.setId(++id);
        alunos.add(aluno);
        return aluno;
    }

    @PutMapping("/alterar/{id}")
    public Aluno alterar(@PathVariable int id, @RequestBody Aluno alunoAlterado) {
        int indice = obterIndice(id);

        if (indice != -1) {
            alunoAlterado.setId(id);
            alunos.set(indice, alunoAlterado);
            return alunoAlterado;
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String excluir(@PathVariable int id) {
        int indice = obterIndice(id);

        if (indice != -1) {
            alunos.remove(indice);
            return "Aluno excluido com sucesso!";
        }

        return "Não foi possivel localizar o aluno.";
    }

    private int obterIndice(int id) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}