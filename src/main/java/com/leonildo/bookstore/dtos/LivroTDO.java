package com.leonildo.bookstore.dtos;

import java.io.Serializable;

import com.leonildo.bookstore.domain.Livro;

public class LivroTDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titulo;
	private String nome_autor;
	private String texto;
	
	public LivroTDO() {
		super();
	}

	public LivroTDO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nome_autor = livro.getNome_autor();
		this.texto = livro.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome_autor() {
		return nome_autor;
	}

	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
	
}
