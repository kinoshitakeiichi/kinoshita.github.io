package com.db;
import java.sql.*;
public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/Upsushe?useSSL=false&serverTimezone=UTC";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.cj.jdbc.Driver";	
	//返回数据库连接
	public Connection getConn()
	{
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){
			System.out.println("驱动装载异常！");
		}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("服务器启动失败！");
			System.out.println("dbuser:"+dbUser+"\ndbpassword:"+dbPassword);
		}
		return conn;		
	}	
////    测试类，请注释！
//	public static void main(String[] args)
//	{
//		System.out.println(new DBHelper().getConn());
//	}
}
