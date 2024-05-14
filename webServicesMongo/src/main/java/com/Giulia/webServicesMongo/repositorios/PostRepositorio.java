package com.Giulia.webServicesMongo.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Giulia.webServicesMongo.dominio.Post;

@Repository
public interface PostRepositorio extends MongoRepository<Post, String> {

	List<Post> findByTituloContaining(String texto);
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
