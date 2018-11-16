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
	
	//�����û������execute����
	public String execute() throws Exception {
			
			//������룬����ҳ�����
			HttpServletResponse response=null;
			response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
//			����session����
			HttpSession session = ServletActionContext.getRequest().getSession();
//			��֤�Ƿ�������¼
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
				out.flush();out.close();return null;
			}
			
			//��ѯ
			nobean=new NoticeDao().GetBean(Integer.valueOf(ID));
			return SUCCESS;
		}
}
