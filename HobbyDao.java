package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.HobbyBean;
import com.db.DBHelper;
public class HobbyDao {
	//获取列表
			public List<HobbyBean> GetList(String strwhere,String strorder){
				String sql="select * from `hobby`";
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
				List<HobbyBean> list=new ArrayList<HobbyBean>();
				try{
					stat = conn.createStatement();
					rs = stat.executeQuery(sql);
					while(rs.next()){
						HobbyBean cnbean=new HobbyBean();
						cnbean.setStudent_ID(rs.getInt("Student_ID"));
						cnbean.setSport(rs.getInt("Sport"));
						cnbean.setEsport(rs.getInt("Esport"));
						cnbean.setLetter(rs.getInt("Letter"));
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
			public HobbyBean GetBean(int id){
				String sql="select * from `hobby` where Student_ID="+id;
				Statement stat = null;
				ResultSet rs = null;
				Connection conn = new DBHelper().getConn();
				HobbyBean cnbean=new HobbyBean();
				try{
					stat = conn.createStatement();
					rs = stat.executeQuery(sql);
					while(rs.next()){
						cnbean.setStudent_ID(rs.getInt("Student_ID"));
						cnbean.setSport(rs.getInt("Sport"));
						cnbean.setEsport(rs.getInt("Esport"));
						cnbean.setLetter(rs.getInt("Letter"));
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
			//添加
			public void Add(HobbyBean cnbean){
				String sql="insert into `hobby` (";
				sql+="Student_ID,Sport,Esport,Letter";
				sql+=") values(";
				sql+="'"+cnbean.getStudent_ID()+"','"+cnbean.getSport()+"','"+cnbean.getEsport()+"','"+cnbean.getLetter()+"'";
				sql+=")";
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
			//修改
			public void Update(HobbyBean cnbean){
				String sql="update `hobby` set ";
				sql+="Sport='"+cnbean.getSport()+"',";
				sql+="Esport='"+cnbean.getEsport()+"',";
				sql+="Letter='"+cnbean.getLetter()+"',";
				sql+=" where Student_ID='"+cnbean.getStudent_ID()+"'";
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
			//删除
			public void Delete(String strwhere){
				String sql="delete from `hobby` where ";
				sql+=strwhere;
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