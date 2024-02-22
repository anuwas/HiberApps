package com.ems.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.hib.dao.UserMasterDAO;
import com.ems.hib.dto.UserMaster;
import com.ems.session.AbstractSession;

@RestController
public class UserapiController {

	@Autowired
	private UserMasterDAO userMasterDao;
	
	@Autowired
	private AbstractSession abstractSession;
	
	
	@RequestMapping(value = "/userlistapi/{sessionid}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserMaster> userListApi(@PathVariable String sessionid) {
		List<UserMaster> listOfUserMaster=null;
		if(abstractSession.checkSessionID(sessionid)){
			listOfUserMaster = userMasterDao.userMasterList();
		}
		return listOfUserMaster;
	}
	
	@RequestMapping(value = "/getuser/{sessionid}/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public UserMaster getUserMasterByIDApi(@PathVariable String sessionid,@PathVariable Long id) {
		UserMaster user=null;
		if(abstractSession.checkSessionID(sessionid)){
			user=userMasterDao.getUserMaster(id);
		}
		return user;
	}
	
	@RequestMapping(value = "/saveuserapi/{sessionid}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void saveUserMasterAPI(@RequestBody UserMaster userMaster,@PathVariable String sessionid) {
		if(abstractSession.checkSessionID(sessionid)){
			userMasterDao.addUserMaster(userMaster);
		}
	}
	
	
	@RequestMapping(value = "/updateuserapi/{sessionid}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUserMasterAPI(@RequestBody UserMaster userMaster,@PathVariable String sessionid) {
		if(abstractSession.checkSessionID(sessionid)){
			userMasterDao.editUserMaster(userMaster);
		}
	}
	
	@RequestMapping(value = "/deleteuserapi/{sessionid}/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUserMasterAPI(@PathVariable Long id,@PathVariable String sessionid) {
		if(abstractSession.checkSessionID(sessionid)){
			userMasterDao.deleteUser(id);
		}
	}
	

	@RequestMapping(value = "/userloginapi", method = RequestMethod.POST, headers = "Accept=application/json")
	public Map<String,Object> UserLogin(@RequestBody UserMaster userMaster) {
		UserMaster returnObj=null;
		UserMaster userMasterObj=userMasterDao.getUsreMasterByEmail(userMaster.getEmail());
		if(userMasterObj!=null)
		{
			if(userMasterObj.getPassword().equals(userMaster.getPassword())){
				returnObj=userMasterObj;
				abstractSession.createSession(userMasterObj);//,request,session);
				System.out.println(abstractSession.getSessionID());
			}
		}

		Map<String,Object> returnStr=new HashMap<String, Object>();
		returnStr.put("loggedUser", returnObj);
		returnStr.put("sessionID", abstractSession.getSessionID());
		return returnStr;
	}
	
	@RequestMapping(value = "/tests", method = RequestMethod.POST, headers = "Accept=application/json")
	public  void tests(HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("sesvar"));
	}
	
}
