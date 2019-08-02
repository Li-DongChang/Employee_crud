package com.qdu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qdu.pojo.Dept;
import com.qdu.util.DBConnection;

/**
 * @author lidcha
 * @createDate ：2019年7月24日
 */
public class DeptDaoImpl implements DeptDao {
	private static DBConnection db;
	private static Connection conn;
	private static Statement stmt;

	public String getDeptName(int i) {
		java.sql.ResultSet result = null;
		String deptName=null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery("select dept_name from tb_dept where dept_id = "+i);
			while(result.next()){
				deptName = result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, result, stmt);
		}
		return deptName;
	}
	//如果方法返回-1，说明发生异常
	public int getDeptID(String d_name) {
		java.sql.ResultSet result = null;
		int deptID = -1;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery("select dept_id from tb_dept where dept_name = '"+d_name+"';");
			while(result.next()){
				deptID = result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, result, stmt);
		}
		return deptID;
	}
	public List<Dept> getAllDept() {
		java.sql.ResultSet result = null;
		List<Dept> list = new ArrayList();
		Dept d;
//		int deptID = -1;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery("select * from tb_dept;");
			while(result.next()){
				d = new Dept(result.getInt(1),result.getString(2));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection.close(conn, result, stmt);
		}
		return list;
	}
		
}
