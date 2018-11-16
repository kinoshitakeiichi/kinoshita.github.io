package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.NoticeBean;
import com.db.DBHelper;
public class NoticeDao {
	//获取列表
		public List<NoticeBean> GetList(String strwhere,String strorder){
			String sql="select * from `notice`";
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
			List<NoticeBean> list=new ArrayList<NoticeBean>();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					NoticeBean cnbean=new NoticeBean();
					cnbean.setID(rs.getInt("ID"));
					cnbean.setTitle(rs.getString("title"));
					cnbean.setRe_data(rs.getString("re_data"));
					cnbean.setContent(rs.getString("content"));
					cnbean.setAuthor(rs.getString("author"));
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
		public NoticeBean GetBean(int id){
			String sql="select * from `notice` where ID="+id;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			NoticeBean cnbean=new NoticeBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while(rs.next()){
					cnbean.setID(rs.getInt("ID"));
					cnbean.setTitle(rs.getString("title"));
					cnbean.setRe_data(rs.getString("re_data"));
					cnbean.setContent(rs.getString("content"));
					cnbean.setAuthor(rs.getString("author"));
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
		public void Add(NoticeBean cnbean){
			String sql="insert into `notice` (";
			sql+="title,re_data,content,author";
			sql+=") values(";
			sql+="'"+cnbean.getTitle()+"','"+cnbean.getRe_data()+"','"+cnbean.getContent()+"','"+cnbean.getAuthor()+"'";
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
		public void Update(NoticeBean cnbean){
			String sql="update `notice` set ";
			sql+="title='"+cnbean.getTitle()+"',";
			sql+="re_data='"+cnbean.getRe_data()+"',";
			sql+="content='"+cnbean.getContent()+"',";
			sql+="author='"+cnbean.getAuthor()+"'";
			sql+=" where ID='"+cnbean.getID()+"'";
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
			String sql="delete from `notice` where ";
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