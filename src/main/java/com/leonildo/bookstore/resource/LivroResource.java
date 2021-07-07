package com.leonildo.bookstore.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leonildo.bookstore.domain.Livro;
import com.leonildo.bookstore.dtos.LivroTDO;
import com.leonildo.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro){
		livro = livroService.create(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroTDO>> findAll(){
		List<Livro> livros = livroService.findAll();
		List<LivroTDO> livroTDOs = livros.stream().map(livro -> new LivroTDO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroTDOs);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroTDO> update(@PathVariable Integer id, @Valid @RequestBody LivroTDO livroTDO){
		Livro livro = livroService.update(id, livroTDO);
		return ResponseEntity.ok().body(new LivroTDO(livro));		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
