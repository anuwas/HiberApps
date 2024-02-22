package com.ems.sp.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.sp.bean.Country;
import com.ems.sp.service.ApiCountryService;

@RestController
public class ApicountryController {

	ApiCountryService countryService = new ApiCountryService();

	@RequestMapping(value = "/apicountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/apicountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/apicountries", method = RequestMethod.POST, headers = "Accept=application/json")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@RequestMapping(value = "/apicountries", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);

	}

	@RequestMapping(value = "/apicountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);

	}
}
