package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.StudentBean;
import com.bean.StudentinfoBean;
import com.db.DBHelper;
public class StudentinfoDao {
	//获取列表
	public List<StudentinfoBean> GetList(String strwhere,String strorder){
		String sql="select * from `Studentinfo`";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<StudentinfoBean> list=new ArrayList<StudentinfoBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				StudentinfoBean cnbean=new StudentinfoBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				cnbean.setSport(rs.getInt("Sport"));
				cnbean.setEsport(rs.getInt("Esport"));
				cnbean.setLetter(rs.getInt("Letter"));
				cnbean.setClassName(rs.getString("className"));
				cnbean.setSpecializedSubgect_Name(rs.getString("SpecializedSubgect_Name"));
				cnbean.setDepartment_Name(rs.getString("Department_Name"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}	
	//获取指定ID的实体Bean
	public StudentinfoBean GetBean(int id){
		String sql="select * from `Studentinfo` where Student_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		StudentinfoBean cnbean=new StudentinfoBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setStudent_Name(rs.getString("Student_Name"));
				cnbean.setStudent_Sex(rs.getString("Student_Sex"));
				cnbean.setStudent_Class(rs.getString("Student_Class"));
				cnbean.setStudent_State(rs.getString("Student_State"));
				cnbean.setSport(rs.getInt("Sport"));
				cnbean.setEsport(rs.getInt("Esport"));
				cnbean.setLetter(rs.getInt("Letter"));
				cnbean.setClassName(rs.getString("className"));
				cnbean.setSpecializedSubgect_Name(rs.getString("SpecializedSubgect_Name"));
				cnbean.setDepartment_Name(rs.getString("Department_Name"));
				cnbean.setStudent_DomitoryID(rs.getInt("Student_DomitoryID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}	
	public void Update(int ID,int DId){
		String sql="update Student set ";
		sql+="Student_DomitoryID='"+DId+"',";
		sql+="Student_State='入住'";
		sql+=" where Student_ID='"+ID+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
}