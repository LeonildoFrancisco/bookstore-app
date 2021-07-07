package com.leonildo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonildo.bookstore.domain.Categoria;
import com.leonildo.bookstore.domain.Livro;
import com.leonildo.bookstore.repositories.CategoriaRepository;
import com.leonildo.bookstore.repositories.LivroRepository;

@Service
public class BDService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	

	public void instanciaBaseDeDados() {
		
        System.out.print("Entrou em Instancia dados");
        
		Categoria cat1 = new Categoria(null, "Informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matematica", "Ciencias");
		
		Livro l1 = new Livro(null,"Crean code" , "Robert Martin", "Loren psum", cat1);
		Livro l2 = new Livro(null,"IA" , "Robert Martin", "Perceptron", cat1);
		Livro l3 = new Livro(null,"Analise Mat 2" , "Leonildo", "Limites", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));
	}
}
