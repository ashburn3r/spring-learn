package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.springlearn.Model.Country;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		//displayDate();
		//displayCountry();
		displayCountries();
	}

	public static void displayDate() throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		System.out.println("Inside Display method");
		java.util.Date date = dateFormat.parse("31/08/2018");
		LOGGER.debug(date.toString());
	}

	public static void displayCountry() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country anotherCountry = context.getBean("country", Country.class);

		Country country = (Country) context.getBean("country", Country.class);
		LOGGER.info("Start");

		LOGGER.debug("Country : {}", country.toString());

	}
	
	public static void displayCountries() {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> country=(List<Country>) context.getBean("countryList");
		LOGGER.info("Start");
		
		for(Country c:country) {
			LOGGER.debug("Country : {}",c.toString());
		}
		
		LOGGER.info("End");
	}

}
