package com.cognizant.ormlearn;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.NotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		//testGetAllCountries();
		//testCountryByCode();
		//testAddCountryName();
		//testUpdateCountry();
		//testDeleteCountry();
		//testGetCountryByName();
		testGetCountriesByNameStartWith();
		
	}
	
//  task 1: to get all country names
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	
//task 2: to get country names from country code
	private static void testCountryByCode() throws NotFoundException {
		LOGGER.info("Start");
		
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("country={}", country);

		LOGGER.info("End");
	}
	
//task 3: to add new country name
	private static void testAddCountryName() throws Exception {
		LOGGER.info("Start");
		
		countryService.addCountry(new Country("ST","Sultanpur"));

		Country result = countryService.findCountryByCode("ST");

		LOGGER.debug("Country {}",result);
		

		LOGGER.info("End");
	}
	
//task 4: to update the country name
	private static void testUpdateCountry() throws Exception {
		LOGGER.info("Start");
		Country country = countryService.updateCountry("ST","Saniapur");
		LOGGER.debug("countries = {}",country);
		LOGGER.info("End");
	}
	
//task 5: to delete the row
	private static void testDeleteCountry() throws Exception {
		LOGGER.info("Start");
		final String countryCode = "ST";
		countryService.deleteCountry(countryCode);
		LOGGER.debug("countries = {} deleted.",countryCode);
		LOGGER.info("End");
	}
//task 6: Find list of countries matching a partial country name
	
	private static void testGetCountryByName(){
		LOGGER.info("Start");

		Iterable<Country> countries = countryService.getCountryByName("ou");
		LOGGER.debug("Countries {}",countries);
		LOGGER.info("---------country List -------------");
		for(Country country: countries)
			LOGGER.info("country = {} ",country);
		LOGGER.info("End");
	}
	
//task 8: Find Countries By Name Start With
	private static void testGetCountriesByNameStartWith(){
		LOGGER.info("Start");

		Iterable<Country> countries = countryService.getCountriesByNameStartWith("Z");
		LOGGER.debug("Countries {}",countries);
		LOGGER.info("---------country List -------------");
		for(Country country: countries)
			LOGGER.info("country = {} ",country);
		LOGGER.info("End");
	}

}
