package com.Giulia.webServicesMongo.DTOs;

import java.util.Date;

public class ComentarioDTO {

	private String texto;
	private Date data;
	private AutorDTO autor;

	public ComentarioDTO() {
		super();
	}

	public ComentarioDTO(String texto, Date data, AutorDTO autor) {
		super();
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

}
