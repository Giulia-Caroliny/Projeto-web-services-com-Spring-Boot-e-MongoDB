package com.Giulia.webServicesMongo.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Giulia.webServicesMongo.dominio.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {

}
