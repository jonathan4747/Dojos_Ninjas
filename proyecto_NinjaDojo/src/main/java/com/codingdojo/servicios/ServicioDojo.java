package com.codingdojo.servicios;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.repositorios.RepositorioDojo;

@Service
public class ServicioDojo {
	@Autowired
	RepositorioDojo repositorioDojo;
	
	public Dojo nuevoDojo(Dojo nuevoDojo) {
		return repositorioDojo.save(nuevoDojo);
	}
	
	public List<Dojo> DespliegaDojo(){
		return repositorioDojo.findAll();
	}
	
	public Dojo EncontrarId(Long id) {
		Optional<Dojo> opotionalDojo=repositorioDojo.findById(id); 
		if(opotionalDojo.isPresent()) {
			return opotionalDojo.get(); 
		} 
		else {
			return null;
		}
	}
	public List<Object []> listaNinja(long id) {
		return repositorioDojo.ListadeNinjas(id);
	}
}
