package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
	 //@Query("select c from country c where co_name like %?1% order by co_name")
	Iterable<Country> findByNameContainsOrderByName(String countryName);

	Iterable<Country> findByNameStartsWith(String chr);

	//Iterable<Country> findByNameContainsOrderByName(String countryName);

	

	
	
}
