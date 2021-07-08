package com.cognizant.springlearn.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Model.Country;

@Service
public class CountryService {

	public Country getCountry(String code) {
		List<String> presentCountry = new ArrayList<String>(Arrays.asList("in","us","de","jp"));
		
		if(presentCountry.indexOf(code)!=-1) {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
			Country country =  (Country) context.getBean(code.toLowerCase());
			return country;
		}	
		return null;
	}
}
