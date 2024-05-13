package com.Giulia.webServicesMongo.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Giulia.webServicesMongo.DTOs.UsuarioDTO;
import com.Giulia.webServicesMongo.dominio.Usuario;
import com.Giulia.webServicesMongo.repositorios.UsuarioRepositorio;
import com.Giulia.webServicesMongo.servicos.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServicos {

	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(String id) {
		Optional<Usuario> user = repositorio.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}

	public void deletar(String id) {
		repositorio.deleteById(id);
	}

	public Usuario atualizar(Usuario usuario) {
		Usuario aux = findById(usuario.getId());
		atualizar(aux, usuario);
		return repositorio.save(aux);
	}

	private void atualizar(Usuario aux, Usuario usuario) {
		aux.setNome(usuario.getNome());
		aux.setEmail(usuario.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO udto) {
		return new Usuario(udto.getId(), udto.getNome(), udto.getEmail());
	}
}
