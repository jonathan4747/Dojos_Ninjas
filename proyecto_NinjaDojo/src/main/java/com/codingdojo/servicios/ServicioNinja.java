package com.codingdojo.servicios;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.modelos.Ninja;
import com.codingdojo.repositorios.RepositorioNinja;

@Service
public class ServicioNinja {
	@Autowired
	RepositorioNinja repositorioNinja;
	
	public Ninja CreateNinja(Ninja nuevoNinja) {
		return repositorioNinja.save(nuevoNinja);
	} 
	
	

}
