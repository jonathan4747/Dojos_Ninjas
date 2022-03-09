package com.codingdojo.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Dojo;


@Repository
public interface RepositorioDojo extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();
	@SuppressWarnings("unchecked")
	Dojo save(Dojo nuevoDojo);
	
	Dojo findById(long id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT n.nombre AS 'first_name' , n.apellido AS 'last_name' , n.edad AS 'age' "
					+ "FROM dojos d JOIN ninjas n "
					+ "ON d.id = n.dojo_id "
					+ "WHERE d.id = :id",nativeQuery = true)
	List<Object[]> ListadeNinjas(@Param("id") long id);
	
}
