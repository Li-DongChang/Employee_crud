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

import net.sf.json.JSONObject;

/**
 * @author lidcha
 * @createDate ：2019年8月2日
 */
public class GetEmpByID extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5819942498508867214L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");

		String empID = req.getParameter("empID");

		InfoDao infoDao = new InfoDaoImpl();
		Employee employee = infoDao.getEmpByID(empID);
		JSONObject jsonObject = JSONObject.fromObject(employee);
		
		PrintWriter out = resp.getWriter();
		out.print(jsonObject);

	}

}
