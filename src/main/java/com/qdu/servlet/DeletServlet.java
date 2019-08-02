package com.qdu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdu.dao.InfoDao;
import com.qdu.dao.InfoDaoImpl;

/**
* @author lidcha
* @createDate ：2019年8月1日
*/
public class DeletServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7019333633203903306L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete的servlet正在执行");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String userID = req.getParameter("userID");
		int uid = (int)Integer.parseInt(userID);
		InfoDao infoDao = new InfoDaoImpl();
		boolean flag = infoDao.deleteEmp(uid);
		PrintWriter out = resp.getWriter();
		if(flag)
			out.print("删除成功！");
		else
			out.print("删除失败，请重试！");
	}
	
}
