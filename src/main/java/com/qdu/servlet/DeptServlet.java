package com.qdu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdu.dao.DeptDao;
import com.qdu.dao.DeptDaoImpl;
import com.qdu.pojo.Dept;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @author lidcha
* @createDate ：2019年7月29日
*/
public class DeptServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		DeptDao dao = new DeptDaoImpl();
		List<Dept> list = dao.getAllDept();
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		PrintWriter out = resp.getWriter();
		out.print(jsonArray);
		
	}
	
}
