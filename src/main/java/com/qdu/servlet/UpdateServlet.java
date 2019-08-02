package com.qdu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdu.dao.DeptDao;
import com.qdu.dao.DeptDaoImpl;
import com.qdu.dao.InfoDao;
import com.qdu.dao.InfoDaoImpl;
import com.qdu.pojo.Employee;

/**
* @author lidcha
* @createDate ：2019年8月1日
*/
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		DeptDao  deptDao = new DeptDaoImpl();
		String empID = req.getParameter("empID");
		int emp_id = (int)Integer.parseInt(empID);
		String empName = req.getParameter("empName");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		Employee employee = new Employee(emp_id, empName, gender, email, dept);
		InfoDao infoDao = new InfoDaoImpl();
		infoDao.updateEmp(employee);
		
		
	
	}
	
}
