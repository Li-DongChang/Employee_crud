package com.qdu.dao;

import com.qdu.pojo.Employee;
import com.qdu.pojo.Page;

/**
* @author lidcha
* @createDate ：2019年7月23日
*/
public interface InfoDao {
	public Page<Employee> getAllStudent(Page<Employee> page);
	
	public String insertEmployee(Employee e);
	
	public boolean deleteEmp(int uid);
	
	public Employee getEmpByID(String empID);
	
	public boolean updateEmp(Employee e);
}
