package com.ems.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ems.hib.dao.CountryMasterDAO;
import com.ems.hib.dto.CountryMaster;

@RestController
public class CountryapiController {

	@Autowired
	private CountryMasterDAO countryMasterDao;
	
	@RequestMapping(value = "/countrylistapi", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CountryMaster> countryListAPI() {
		List<CountryMaster> listOfCountryMaster=countryMasterDao.countryMasterList();
		return listOfCountryMaster;
	}
	
}
