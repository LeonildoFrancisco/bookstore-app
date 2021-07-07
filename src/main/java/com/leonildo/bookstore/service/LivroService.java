package com.leonildo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.leonildo.bookstore.domain.Livro;
import com.leonildo.bookstore.dtos.LivroTDO;
import com.leonildo.bookstore.repositories.LivroRepository;
import com.leonildo.bookstore.service.exceptions.ObjectNotFoundException;

@Service 
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public Livro findById(Integer id) {
		Optional<Livro> optional = livroRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não Encontrado! id: " + id + "Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll() {
		return livroRepository.findAll();
	}

	public Livro update(Integer id, LivroTDO livroTDO) {
		Livro livro = findById(id);
		livro.setTitulo(livroTDO.getTitulo());
		livro.setNome_autor(livroTDO.getNome_autor());
		livro.setTexto(livroTDO.getTexto());
		return livroRepository.save(livro);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			livroRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new com.leonildo.bookstore.service.exceptions.DataIntegrityViolationException(
					"Livro não pode ser deletado.");
		}
	}

	public Livro create(Livro livro) {
		livro.setId(null);
		return livroRepository.save(livro);	
	}


}
