package com.trabalho.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.api.dtos.ProdutoDTO;
import com.trabalho.api.services.ProdutoService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarTodos(){
		return ResponseEntity.ok(service.buscarTodos());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO cadastrar(@RequestBody ProdutoDTO produto) {
		return service.cadastrar(produto);
	}
}
