package br.org.serratec.aula_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @GetMapping
    public String saudacao() {
        return "Olá Mundo!!";
    }

    @GetMapping("/{nome}")
    public String saudacaoEsp(@PathVariable String nome) {
        return "Olá " + nome + "! Seja bem-vindo!";
    }

    @GetMapping("/texto")
    public String obterTextoDigitado(@RequestBody String texto) {
        return "Texto enviado pelo usuario: " + texto;
    }

    @GetMapping("/objeto")
    public String exibirDadosEnviados(@RequestBody Aluno aluno) {
        return aluno.exibeDados();
    }

}