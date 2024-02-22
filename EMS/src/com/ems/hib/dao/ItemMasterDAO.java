package com.ems.hib.dao;

import java.util.List;
import com.ems.hib.dto.ItemMaster;

public interface ItemMasterDAO {

	public List<ItemMaster> list();
	public void add(ItemMaster item);
	public void  update(ItemMaster item);
	public ItemMaster  getItem(Long id);
	public void  delete(Long id);
	
}
