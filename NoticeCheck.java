package com.action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.NoticeBean;
import com.dao.NoticeDao;
import com.opensymphony.xwork2.ActionSupport;
public class NoticeCheck extends ActionSupport{
	private String ID;
	private NoticeBean nobean;
	
	public String getID(){
		return ID;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public NoticeBean getNobean(){
		return nobean;
	}
	public void setNobean(NoticeBean nobean){
		this.nobean=nobean;
	}
	
	//处理用户请求的execute方法
	public String execute() throws Exception {
			
			//解决乱码，用于页面输出
			HttpServletResponse response=null;
			response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
//			创建session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
//			验证是否正常登录
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
				out.flush();out.close();return null;
			}
			
			//查询
			nobean=new NoticeDao().GetBean(Integer.valueOf(ID));
			return SUCCESS;
		}
}
