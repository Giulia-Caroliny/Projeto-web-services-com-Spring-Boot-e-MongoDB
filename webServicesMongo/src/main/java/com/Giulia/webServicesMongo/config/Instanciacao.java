package com.Giulia.webServicesMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Giulia.webServicesMongo.DTOs.AutorDTO;
import com.Giulia.webServicesMongo.DTOs.ComentarioDTO;
import com.Giulia.webServicesMongo.dominio.Post;
import com.Giulia.webServicesMongo.dominio.Usuario;
import com.Giulia.webServicesMongo.repositorios.PostRepositorio;
import com.Giulia.webServicesMongo.repositorios.UsuarioRepositorio;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private PostRepositorio postRepositorio;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		usuarioRepositorio.deleteAll();
		postRepositorio.deleteAll();
		
		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
		
		usuarioRepositorio.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));

		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite", sdf.parse("22/03/2018"), new AutorDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));
		
		post1.getComentario().addAll(Arrays.asList(c1, c2));
		post2.getComentario().addAll(Arrays.asList(c3));
		
		postRepositorio.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		usuarioRepositorio.save(maria);
	}

}
