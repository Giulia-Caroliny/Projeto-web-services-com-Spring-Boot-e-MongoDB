package com.Giulia.webServicesMongo.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

import com.Giulia.webServicesMongo.DTOs.AutorDTO;
import com.Giulia.webServicesMongo.DTOs.ComentarioDTO;

@Document
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@org.springframework.data.annotation.Id
	private String id;
	private Date data;
	private String titulo;
	private String corpo;

	private AutorDTO autor;

	public List<ComentarioDTO> comentario = new ArrayList<ComentarioDTO>();

	public Post() {
		super();
	}

	public Post(String id, Date data, String titulo, String corpo, AutorDTO autor) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	public List<ComentarioDTO> getComentario() {
		return comentario;
	}

	public void setComentario(List<ComentarioDTO> comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
