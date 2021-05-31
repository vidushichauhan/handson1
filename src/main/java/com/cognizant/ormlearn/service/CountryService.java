package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


//import javax.transaction.Transactional;




@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	@Transactional
	public List<Country> getAllCountries() {
		var it = countryRepository.findAll();

//        var countryname = new ArrayList<Country>();
//        it.forEach(e -> countryname.add(e));

//        return countryname;
		return it;
	}
	
	  @Transactional
	    public Country findCountryByCode(String countryCode) throws NotFoundException{

	        Optional<Country> result = countryRepository.findById(countryCode);

	        if(!result.isPresent()){
	            throw new NotFoundException("Country not found in DB.");
	        }

	        return result.get();

	    }
	  @Transactional
	    public void addCountry(Country country){
	        countryRepository.save(country);
	    }
	
	  @Transactional
	    public Country updateCountry(String countryCode,String countryName) throws NotFoundException {
	        Country country = this.findCountryByCode(countryCode);
	        country.setName(countryName);
	       // country.setName(countryName);
	        countryRepository.save(country);
	        return country;
	    }
	  

	    @Transactional
	    public void deleteCountry(String countryCode) throws NotFoundException {

	        Country country = this.findCountryByCode(countryCode);

	        countryRepository.deleteById(countryCode);

	    }
	    
	    @Transactional
	    public Iterable<Country> getCountryByName(String countryName){
	        return countryRepository.findByNameContainsOrderByName(countryName);
	    }
	    
	    public Iterable<Country> getCountriesByNameStartWith(String chr){
	        return countryRepository.findByNameStartsWith(chr);
	    }
	    
	
	
	
	
}
