package com.dao;
import java.util.*;
import com.db.*;
import com.bean.MarkBean;
import java.sql.*;
public class MarkDao {
	//«@È¡ÁÐ±í
	public List<MarkBean> GetList(String strwhere,String strorder){
		String sql="select * from `studentmark` ";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where"+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+="order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs=null;
		Connection conn=new DBHelper().getConn();
		List<MarkBean> list=new ArrayList<MarkBean>();
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				MarkBean cnbean=new MarkBean();
				cnbean.setStudent_ID(rs.getInt("Student_ID"));
				cnbean.setSubgect_ID(rs.getInt("Subgect_ID"));
				cnbean.setStudent_Mark(rs.getInt("Subgect_Mark"));
				list.add(cnbean);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(conn !=null)
					conn.close();
				if(stat !=null)
					stat.close();
				if(rs !=null)
					rs.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;		
	}
	private boolean isInvalid(String value) {
		// TODO Auto-generated method stub
		return (value == null || value.length() == 0);
	}
	//²âÊÔ
		public static void main(String[] args) {
//			
//			String sql="select * from studentmark";
//			Statement stat = null;
//			ResultSet rs=null;
//			Connection conn=new DBHelper().getConn();
//			try {
//				stat=conn.createStatement();
//				rs=stat.executeQuery(sql);
//				while(rs.next())
//				{
//					MarkBean cnbean=new MarkBean();
//					cnbean.setStudent_ID(rs.getInt("Student_ID"));
//					cnbean.setSubgect_ID(rs.getInt("Subgect_ID"));
//					cnbean.setStudent_Mark(rs.getInt("Subgect_Mark"));
//				
//					System.out.println(rs.getInt("Student_ID"));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//
//			
//			
//			
		}
}