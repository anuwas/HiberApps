package com.ems.session;


import javax.servlet.http.HttpSession;

import com.ems.hib.dto.UserMaster;

public interface AbstractSession {

	public HttpSession createSession(UserMaster userMaster);//,HttpServletRequest request,HttpSession session);
	public boolean checkSessionID(String sessionID);
	public String getSessionID();
}
