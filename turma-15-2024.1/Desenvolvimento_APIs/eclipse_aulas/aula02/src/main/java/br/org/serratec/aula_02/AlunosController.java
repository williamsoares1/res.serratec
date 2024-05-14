package br.org.serratec.aula_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
	
	@GetMapping
	public String saudacao() {
		return "Que o Flamengo ganhe hoje Deus, Amém!!";
	}
}
