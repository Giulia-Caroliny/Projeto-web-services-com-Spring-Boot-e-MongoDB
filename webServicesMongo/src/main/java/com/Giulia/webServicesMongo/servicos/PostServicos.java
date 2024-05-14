package com.Giulia.webServicesMongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giulia.webServicesMongo.dominio.Post;
import com.Giulia.webServicesMongo.repositorios.PostRepositorio;

@Service
public class PostServicos {

	@Autowired
	private PostRepositorio repositorio;

	public Post findById(String id) {
		Optional<Post> post = repositorio.findById(id);
		return post.get();
	}
	
	public List<Post> findByTitulo(String texto){
		return repositorio.findByTituloContaining(texto);
	}
	
	public List<Post> findByTituloIgnoreCase(String texto){
		return repositorio.searchTitle(texto);
	}
}
