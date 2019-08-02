package com.qdu.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* @author lidcha
* @createDate ：2019年7月25日
*/
public class Paging {
	
	public static int getTotals(){
		int t=0;
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select count(*) from tb_employee;";
			ResultSet res = stmt.executeQuery(sql);
			while(res.next())
				t = res.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	
	public static int getTotalPages (int count, int limit){
		return (int)Math.ceil(count/(limit*1.0));
	}
	
	public static int getCurrentPage(String strPage,int totalpages){
		int currentPage;
		 if (strPage == null) { 
			 currentPage = 1;
		    } else {
		        try{
		        	currentPage = java.lang.Integer.parseInt(strPage);
		        }catch(Exception e){
		        	currentPage = 1;
		        }
		        
		        if (currentPage < 1){
		        	currentPage = 1;
		        }
		        
		        if (currentPage > totalpages){
		        	currentPage = totalpages;
		        }                            
		    }
		return currentPage;
	}
	
	
}
