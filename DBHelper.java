package com.db;
import java.sql.*;
public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/Upsushe?useSSL=false&serverTimezone=UTC";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.cj.jdbc.Driver";	
	//�������ݿ�����
	public Connection getConn()
	{
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){
			System.out.println("����װ���쳣��");
		}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("����������ʧ�ܣ�");
			System.out.println("dbuser:"+dbUser+"\ndbpassword:"+dbPassword);
		}
		return conn;		
	}	
////    �����࣬��ע�ͣ�
//	public static void main(String[] args)
//	{
//		System.out.println(new DBHelper().getConn());
//	}
}
