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
import com.qdu.pojo.Page;
import com.qdu.util.Paging;

import net.sf.json.JSONObject;

/**
 * @author lidcha
 * @createDate ：2019年7月24日
 */
// @WebServlet("/queryAllStudent")
public class QueryAllServlet extends HttpServlet {

	/**
	 * 用于判断序列化文件是否过期
	 */
	private static final long serialVersionUID = 1109426405669495906L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置返回数据格式及编码，防止出现中文乱码
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取参数
		String strPage = (String) req.getParameter("strPage");
		System.out.println(strPage+"==============");
		int count = Paging.getTotals();//总记录数
		int pageSize = 10;//每页数量
		int totalPages = Paging.getTotalPages(count, pageSize);//总页数
		int p = Paging.getCurrentPage(strPage, totalPages);//待显示页码
		
		Page<Employee> tempPage = new Page<Employee>(totalPages, count, p);
		
		//调用dao层去执行查询
		InfoDao dao = new InfoDaoImpl();
		Page<Employee> pageBean = dao.getAllStudent(tempPage);
		
		//判断从数据库中是否查出了数据
		if (pageBean.getList().isEmpty())
			req.setAttribute("msg", "查询无果");
		else {
			//如果有数据，将其转为json对象传到前端
			JSONObject json = JSONObject.fromObject(pageBean);
			PrintWriter out = resp.getWriter();
			out.print(json);// 直接返回json对象
			System.out.println(json);
		}
		// req.getRequestDispatcher("queryAll.jsp").forward(req, resp);
	}

}
