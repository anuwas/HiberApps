package com.ems.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.hib.dao.CityMasterDAO;
import com.ems.hib.dto.CityMaster;

@RestController
public class CityapiController {

	@Autowired
	private CityMasterDAO cityMasterDao;
	
	@RequestMapping(value = "/citylistapi", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CityMaster> cityListAPI() {
		List<CityMaster> listOfCityMaster=cityMasterDao.cityMasterList();
		return listOfCityMaster;
	}
	
}
