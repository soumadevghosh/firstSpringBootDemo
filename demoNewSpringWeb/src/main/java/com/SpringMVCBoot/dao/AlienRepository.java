package com.SpringMVCBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.SpringMVCBoot.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer>//It will automatically give us all the CRUD methods(Lien is the class name, Integer is the primary key type)
{
	List<Alien> findByAname(String aname); //Query DSL  must be getBy or findBy followed by variable name starting with capital(findByAnameOrderbyAname)
	
	
	@Query("from Alien where aname= :aname") // our own query with placeholder as aname as specified in @param
	List<Alien> findAlienbyName(@Param("aname") String aname);
}
