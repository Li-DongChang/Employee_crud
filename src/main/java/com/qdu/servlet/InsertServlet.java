package com.qdu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdu.dao.InfoDao;
import com.qdu.dao.InfoDaoImpl;
import com.qdu.pojo.Employee;

/**
* @author lidcha
* @createDate ：2019年7月27日
*/
public class InsertServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		String emp_name = req.getParameter("empName");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String dept = req.getParameter("dId");
		//待插入员工
		Employee insert_emp = new Employee(emp_name,gender,email,dept);
		
		//调用dao层将员工插入
		InfoDao dao = new InfoDaoImpl();
		String msg = dao.insertEmployee(insert_emp);
		PrintWriter out = resp.getWriter();
		out.print(msg);
		
		
	}
	
}
