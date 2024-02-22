package com.ems.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ems.hib.dao.EmployeeMasterDAO;
import com.ems.hib.dto.EmployeeMaster;
import com.ems.hib.dto.ItemMaster;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeMasterDAO employeeMasterDao; 
	
	
	@RequestMapping(value = "/emplist",method = RequestMethod.GET)
	   public String ProductList(ModelMap model) {
		 List<EmployeeMaster> itemList = employeeMasterDao.employeeList();
	      model.addAttribute("itemList", itemList);
	      return "listEmployee";
	   }
	
	@RequestMapping(value = "/addEmp",method = RequestMethod.GET)
	   public String AddEmp(ModelMap model) {
		model.addAttribute("empMaster", new EmployeeMaster());
	      return "addEmployee";
	   }
	
	@RequestMapping(value = "/addEmp",method = RequestMethod.POST)
	   public String SaveEmp(@ModelAttribute("empMaster") EmployeeMaster empMaster) {
	        if(null != empMaster ) 
	        	employeeMasterDao.addEmployee(empMaster);
	         
	        return "listEmployee";
	   }
	
	@RequestMapping(value = "/editEmp",method = RequestMethod.GET)
	   public String EditEmp(ModelMap model,@RequestParam Long id) {
		EmployeeMaster empMaster=employeeMasterDao.getEmployee(id);
		model.addAttribute("empMaster", empMaster);
	      return "editEmployee";
	   }
	
	@RequestMapping(value = "/deleteEmp",method = RequestMethod.GET)
	   public String EditEmpSave(ModelMap model,@RequestParam Long del_emp_id) {
		employeeMasterDao.deleteEmployee(del_emp_id);
		return "redirect:emplist";
	   }
	
	/*
	 * this is for controller retrn to browser
	@RequestMapping(value = "/editEmpID/{id}",method = RequestMethod.GET)
	   public @ResponseBody String editEmpID(ModelMap model,@PathVariable Long id) {
		EmployeeMaster empMaster=employeeMasterDao.getEmployee(id);
		model.addAttribute("empMaster", empMaster);
	      return "editEmployee";
	   }
	   */
	
}
