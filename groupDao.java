package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.SubgectBean;
import com.bean.groupBean;
import com.db.DBHelper;
public class groupDao {
	public List<groupBean> Getlist (String strwhere,String strorder){
		String sql=" select * from `group` ";
		
		if(!(isInvalid(strwhere)))
		{
			sql+=" where"+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+="order by "+strorder+" desc ";
		}
//		if(!(isInvalid(String.valueOf(Searchpage))))
//		{
//		sql=sql+" limit "+Searchpage+",9";
//		}
		Statement stat = null;
		ResultSet rs=null;
		Connection conn=new DBHelper().getConn();
		List<groupBean> list=new ArrayList<groupBean>();
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				groupBean cnbean=new groupBean();
				cnbean.setStudentId(rs.getInt("Student_ID"));
				cnbean.setStudentName(rs.getString("Student_Name"));
				cnbean.setClassName(rs.getString("className"));
				cnbean.setSubgectName(rs.getString("Subgect_Name"));
				cnbean.setSubgectMark(rs.getInt("Subgect_Mark"));
				
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
		//œyÔ‡´ú´a
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql=" select * from `group`";
		Statement stat = null;
		ResultSet rs=null;
		Connection conn=new DBHelper().getConn();
		List<groupBean> list1=new ArrayList<groupBean>();
		List<groupBean> list2=new ArrayList<groupBean>();
		List<groupBean> list3=new ArrayList<groupBean>();
		List<groupBean> list4=new ArrayList<groupBean>();
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			
			while(rs.next())
			{
				groupBean cnbean=new groupBean();
				cnbean.setStudentId(rs.getInt("Student_ID"));
				cnbean.setStudentName(rs.getString("Student_Name"));
				cnbean.setClassName(rs.getString("className"));
				cnbean.setSubgectName(rs.getString("Subgect_Name"));
				cnbean.setSubgectMark(rs.getInt("Subgect_Mark"));
				//System.out.println(rs.getInt("Student_ID")+rs.getString("Student_Name")+rs.getString("className")+rs.getString("Subgect_Name")+rs.getInt("Subgect_Mark"));	
			list1.add(cnbean);
			}
			int i=list1.size();
			int j=-1;
			
			
				while(rs.next()) {
				groupBean cnbean=new groupBean();
				cnbean.setStudentId(rs.getInt("Student_ID"));
				cnbean.setStudentName(rs.getString("Student_Name"));
				cnbean.setClassName(rs.getString("className"));
				cnbean.setSubgectName(rs.getString("Subgect_Name"));
				cnbean.setSubgectMark(rs.getInt("Subgect_Mark"));
				j++;
				if(j<=i/3)
				{
					System.out.println(j);
					list2.add(cnbean);
				}
				if(j>i/3&&j<=(i/3)*2)
				{
					list3.add(cnbean);
				}
				if(j>(i/3)*2)
				{
					list4.add(cnbean);
				}
				
			}
			
		
			
		System.out.println(j);
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
