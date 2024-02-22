package com.ems.hib.dao;

import java.util.List;

import com.ems.hib.dto.CountryMaster;

public interface CountryMasterDAO {

	public CountryMaster getCountry(Long id);
	public List<CountryMaster> countryMasterList();
}
