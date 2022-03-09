package com.codingdojo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;

@Repository
public interface RepositorioNinja extends CrudRepository<Ninja,Long>{
	List<Ninja>findAll();
	@SuppressWarnings("unchecked")
	Ninja save(Ninja nuevoNinja);
	
	List<Dojo> findByDojo(Dojo dojo);
	
}
