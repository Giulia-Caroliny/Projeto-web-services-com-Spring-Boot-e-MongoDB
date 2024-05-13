package com.Giulia.webServicesMongo.DTOs;

import com.Giulia.webServicesMongo.dominio.Usuario;

public class AutorDTO {

	private String id;
	private String nome;

	public AutorDTO() {
		super();
	}

	public AutorDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
