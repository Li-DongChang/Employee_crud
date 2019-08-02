package com.qdu.dao;

import java.sql.SQLException;
import java.util.List;

import com.qdu.pojo.Dept;

/**
* @author lidcha
* @createDate ：2019年7月24日
*/
public interface DeptDao {
	public String getDeptName(int i) throws SQLException;
	public int getDeptID(String d_name);
	
	public List<Dept> getAllDept();
}
