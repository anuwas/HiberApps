package com.ems.sp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ems.hib.dao.CityMasterDAO;
import com.ems.hib.dao.CountryMasterDAO;
import com.ems.hib.dao.UserMasterDAO;
import com.ems.hib.dto.CityMaster;
import com.ems.hib.dto.CountryMaster;
import com.ems.hib.dto.UserMaster;
import com.ems.session.AbstractSession;

@Controller
@SessionAttributes("sesvar")
public class UserController {

	@Autowired
	private UserMasterDAO userMasterDao;
	@Autowired
	private CityMasterDAO cityMasterDao;
	@Autowired
	private CountryMasterDAO countryMasterDao;
	@Autowired
	private AbstractSession abstractSession;
	
	@RequestMapping(value = "/addUser",method = RequestMethod.GET)
	   public String AddUser(ModelMap model,HttpServletRequest request) {
		List<CountryMaster> countryMasterList = countryMasterDao.countryMasterList();
		List<CityMaster> cityMasterList = cityMasterDao.cityMasterList();
		model.addAttribute("countryMasterList", countryMasterList);
		model.addAttribute("cityMasterList", cityMasterList);
		model.addAttribute("userMaster", new UserMaster());
		model.addAttribute("countryMaster", new CountryMaster());
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute("sesvar"));
	      return "addUser";
	   }
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	   public String SaveUser(@ModelAttribute("userMaster") UserMaster userMaster, BindingResult result) {
			if(null != userMaster) 
	        	userMasterDao.addUserMaster(userMaster);
	        return "addUser";
	   }
	
	@RequestMapping(value = "/editUser",method = RequestMethod.GET)
	   public String editUser(ModelMap model,@RequestParam Long id) {
		List<CountryMaster> countryMasterList = countryMasterDao.countryMasterList();
		List<CityMaster> cityMasterList = cityMasterDao.cityMasterList();
		model.addAttribute("countryMasterList", countryMasterList);
		model.addAttribute("cityMasterList", cityMasterList);
		UserMaster usermaster=userMasterDao.getUserMaster(id);
		model.addAttribute("userMaster", usermaster);
	      return "editUser";
	   }
	
	@RequestMapping(value = "/editUser",method = RequestMethod.POST)
	   public String editUserSavr(@ModelAttribute("userMaster") UserMaster userMaster) {
		if(null != userMaster) 
        	userMasterDao.editUserMaster(userMaster);
        return "redirect:userlist";
	   }
	
	@RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
	   public String deleteUserCntrl(ModelMap model,@RequestParam Long id) {
		userMasterDao.deleteUser(id);
		return "redirect:userlist";
	   }
	
	
	@RequestMapping(value = "/userlist",method = RequestMethod.GET)
	   public String UserList(ModelMap model,HttpServletRequest request) {
		 List<UserMaster> itemList = userMasterDao.userMasterList();
	      model.addAttribute("itemList", itemList);
	      HttpSession session=request.getSession();
	      session.setAttribute("sesvar", "anupam");
	      
	      return "userlist";
	   }
	
	@RequestMapping(value = "/userlogin",method = RequestMethod.GET)
	   public @ResponseBody String UserLogin(ModelMap model,@RequestParam String email) {
		UserMaster userMaster=userMasterDao.getUsreMasterByEmail(email);
		return userMaster.getPassword();
	   }
	
}
