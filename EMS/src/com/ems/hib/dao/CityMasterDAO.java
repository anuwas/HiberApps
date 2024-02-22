package com.ems.hib.dao;

import java.util.List;

import com.ems.hib.dto.CityMaster;

public interface CityMasterDAO {

	public CityMaster getCity(Long id);
	public List<CityMaster> cityMasterList();
}
