package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.SubgectBean;
import com.db.DBHelper;
public class SubgectDao {
	public List<SubgectBean> Getlist (String strwhere,String strorder){
		String sql=" select * from `subgect`";
		
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
		List<SubgectBean> list=new ArrayList<SubgectBean>();
		try {
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next())
			{
				SubgectBean cnbean=new SubgectBean();
				cnbean.setSubgect_ID(rs.getInt("Subgect_ID"));
				cnbean.setSubgect_Name(rs.getString("Subgect_Name"));
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
	//≤‚ ‘
		public static void main(String[] args) {
//			
//			String sql=" select * from `subgect`";
//			
//			Statement stat = null;
//			ResultSet rs=null;
//			Connection conn=new DBHelper().getConn();
//			
//			try {
//				stat=conn.createStatement();
//				rs=stat.executeQuery(sql);
//				while(rs.next())
//				{
//					SubgectBean cnbean=new SubgectBean();
//				
//					System.out.println(rs.getString("Subgect_Name"));
//				}
//			}catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
			
	}		
}