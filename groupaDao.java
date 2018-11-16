package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.groupaBean;
import com.db.DBHelper;
public class groupaDao {
	//获取列表
		public List<groupaBean> GetList(String strwhere,String strorder){
			String sql="select * from `groupa`";
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
			List<groupaBean> list=new ArrayList<groupaBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					groupaBean cnbean=new groupaBean();
					cnbean.setGroupId(rs.getInt("groupId"));
					
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
		//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println("");
		}
}
