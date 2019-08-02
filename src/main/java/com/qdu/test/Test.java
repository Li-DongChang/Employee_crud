package com.qdu.test;

import com.qdu.dao.InfoDao;
import com.qdu.dao.InfoDaoImpl;
import com.qdu.pojo.Employee;

/**
* @author lidcha
* @createDate ：2019年7月25日
*/
public class Test {
	public static void main(String[] args) {
		InfoDao dao = new InfoDaoImpl();
		Employee e = new Employee("张三","M","zhangsan@163.com","开发部");
		System.out.println(dao.insertEmployee(e));
	}
}
