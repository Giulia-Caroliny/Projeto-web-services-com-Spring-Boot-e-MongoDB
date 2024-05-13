package com.Giulia.webServicesMongo.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.Giulia.webServicesMongo.DTOs.UsuarioDTO;
import com.Giulia.webServicesMongo.dominio.Post;
import com.Giulia.webServicesMongo.dominio.Usuario;
import com.Giulia.webServicesMongo.servicos.UsuarioServicos;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecursos {

	@Autowired
	private UsuarioServicos servicos;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = servicos.findAll();
		List<UsuarioDTO> listaDTO = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
		Usuario user = servicos.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(user));
	}
	
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		Usuario user = servicos.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuario) {
		Usuario user = servicos.fromDTO(usuario);
		user = servicos.inserir(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		servicos.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@RequestBody UsuarioDTO usuario, @PathVariable String id) {
		Usuario user = servicos.fromDTO(usuario);
		user.setId(id);
		user = servicos.inserir(user);
		user = servicos.atualizar(user);
		return ResponseEntity.noContent().build();
	}

}
