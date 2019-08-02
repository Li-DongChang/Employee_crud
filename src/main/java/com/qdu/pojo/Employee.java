package com.qdu.pojo;
/**
* @author lidcha
* @createDate ：2019年7月24日
*/
public class Employee {
	private  Integer emp_id;
	private  String emp_name;
	private  String gender;
	private  String email;
	private  String dept;
	public Employee(Integer emp_id, String emp_name, String gender, String email, String dept) {
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
	}
	public Employee(String emp_name, String gender, String email, String dept) {
		this.emp_name = emp_name;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
	}
	
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", gender=" + gender + ", email=" + email
				+ ", dept=" + dept + "]";
	}
	
}
