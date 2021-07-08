package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ListModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Exception.CountryNotFoundException;
import com.cognizant.springlearn.Model.Country;
import com.cognizant.springlearn.Service.CountryService;
import javax.validation.Valid;


@RestController
public class CountryController {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private Logger log = LoggerFactory.getLogger(CountryController.class);
			
	@Autowired
	private CountryService countryService;

	@GetMapping(path = "/country")
	public ResponseEntity<Country> getCountryIndia() {
		Country country = context.getBean("in", Country.class);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

	@GetMapping(path = "/countries")
	public ResponseEntity<List<Country>> getAllCountries() {
		@SuppressWarnings("unchecked")
		List<Country> countryList = (List<Country>) context.getBean("countryList");
		return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
	}

	@GetMapping(path = "/countries/{code}")
	public ResponseEntity<Country> getCountry(@PathVariable String code) throws CountryNotFoundException {
		Country country= countryService.getCountry(code);
		if (country!=null) {
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}
		else {
			throw new CountryNotFoundException();
		}
	}
	
	@PostMapping(path = "/addcountry")
	public Country addCountry(@Valid @RequestBody Country country) {
		log.info("start add country");
		return country;
	}
	

}
