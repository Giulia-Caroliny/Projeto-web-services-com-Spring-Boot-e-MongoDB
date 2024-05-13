package com.Giulia.webServicesMongo.recursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Giulia.webServicesMongo.dominio.Post;
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

}
