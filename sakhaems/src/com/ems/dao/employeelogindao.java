package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeelogindao {
	public boolean getdata(String eid, String epass) throws Exception {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ems","skaha-dell-1","welcome");
		PreparedStatement ps=con.prepareStatement("select * from employee1 where empid=? and password=?");
		ps.setString(1,eid);
		ps.setString(2,epass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return true;
		else
			return false;
	}

}
