package com.Giulia.webServicesMongo.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Giulia.webServicesMongo.dominio.Post;
import com.Giulia.webServicesMongo.recursos.util.URL;
import com.Giulia.webServicesMongo.servicos.PostServicos;

@RestController
@RequestMapping(value = "/posts")
public class PostRecursos {

	@Autowired
	private PostServicos servicos;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = servicos.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodeParam(texto);
		List<Post> lista = servicos.findByTitulo(texto);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/title")
	public ResponseEntity<List<Post>> findByTituloIgnoreCase(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodeParam(texto);
		List<Post> lista = servicos.findByTituloIgnoreCase(texto);
		return ResponseEntity.ok().body(lista);
	}

}
