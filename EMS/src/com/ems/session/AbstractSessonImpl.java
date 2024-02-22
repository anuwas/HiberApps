package com.ems.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ems.hib.dto.UserMaster;

//@Component
public class AbstractSessonImpl implements AbstractSession{
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;

	public HttpSession createSession(UserMaster userMaster)
	{//,HttpServletRequest request,HttpSession session) {
		session=request.getSession();
		String sessionID=session.getId();
		session.setAttribute("userMasterSessObj", userMaster);
		session.setAttribute("sessionID", sessionID);
		return session;
	}

	public boolean checkSessionID(String sessionID) {
		boolean status=true;
		if(sessionID==null)
		{
			status=false;
		}else {
			try{
				String StoredSessionID=(String) session.getAttribute("sessionID");
				//System.out.println("paramP session "+sessionID);
				//System.out.println("paramS session "+StoredSessionID);
				if(StoredSessionID==null){
					status=false;
				}else{
					if(!StoredSessionID.equals(sessionID)){
						status=false;
					}
				}
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			
		}
		return status;
	}

	public String getSessionID() {
		String sessionID=(String) session.getAttribute("sessionID");
		return sessionID;
	}

	

}
