package com.ems.service;

import com.ems.dao.employeelogindao;

public class employeeLoginService {
	public boolean isValidate(String eid,String epass) throws Exception
	{
		employeelogindao eld=new employeelogindao();
		return eld.getdata(eid, epass);
	}

}
