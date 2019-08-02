package com.qdu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qdu.pojo.Employee;
import com.qdu.pojo.Page;
import com.qdu.util.DBConnection;

/**
 * @author lidcha
 * @createDate ：2019年7月23日
 */
public class InfoDaoImpl implements InfoDao {
	private static Connection conn;
	private static Statement stmt;

	private static DeptDao dept;

	// 查询
	public Page<Employee> getAllStudent(Page<Employee> page) {
		Employee emp;
		java.sql.ResultSet result = null;
		dept = new DeptDaoImpl();
		List<Employee> empList = new ArrayList<Employee>();
		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from tb_employee order by emp_id limit " + (page.getPage() - 1) * page.getLimit()
					+ "," + page.getLimit();
			System.out.println(sql);
			result = stmt.executeQuery(sql);
			while (result.next()) {
				emp = new Employee(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
						dept.getDeptName(result.getInt(5)));
				// System.out.println(emp.toString());
				// System.out.println("===========");
				if (!emp.equals(null))
					empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, result, stmt);
		}
		page.setList(empList);
		return page;
	}

	// 新增
	public String insertEmployee(Employee e) {
		dept = new DeptDaoImpl();
		System.out.println(e.toString());
		System.out.println(e.getDept());
		System.out.println(dept.getDeptID(e.getDept()));
		try {
			String sql = "insert into tb_employee(emp_name,gender,email,d_id)" + " values('" + e.getEmp_name() + "','"
					+ e.getGender() + "','" + e.getEmail() + "'," + dept.getDeptID(e.getDept()) + ")";
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			int status = stmt.executeUpdate(sql);
			if (status != 0)
				return "增加员工成功";
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBConnection.close(conn, null, stmt);
		}
		return "dao层执行sql语句出错";
	}

	// 删除emp
	public boolean deleteEmp(int uid) {
		dept = new DeptDaoImpl();
		try {
			String sql = "delete from tb_employee where emp_id = " + uid;
			System.out.println("要执行的sql：" + sql);
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			int status = stmt.executeUpdate(sql);
			if (status == 1)
				return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBConnection.close(conn, null, stmt);
		}
		return false;
	}

	public Employee getEmpByID(String empID) {
		dept = new DeptDaoImpl();
		Employee employee = null;
		ResultSet resultSet = null;
		try {
			String sql = "select * from tb_employee where emp_id = " + empID;
			System.out.println("要执行的sql：" + sql);
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()){
				employee = new Employee(resultSet.getInt(1)
						,resultSet.getString(2), resultSet.getString(3)
						,resultSet.getString(4), dept.getDeptName(resultSet.getInt(5)));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBConnection.close(conn, resultSet, stmt);
		}
		return employee;
	}

	public boolean updateEmp(Employee e) {
		dept = new DeptDaoImpl();
		String genderSymbol = e.getGender()=="男"?"M":"F";
		try {
			String sql = "update tb_employee set gender= '"
					+ genderSymbol+"',email = '"
					+e.getEmail()+"',d_id="+dept.getDeptID(e.getDept())
					+" where emp_id = "+e.getEmp_id();
			System.out.println("要执行的sql：" + sql);
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			int status = stmt.executeUpdate(sql);
			if (status == 1)
				return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DBConnection.close(conn, null, stmt);
		}
		return false;
	}

}
