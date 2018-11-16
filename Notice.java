package com.action;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.NoticeBean;
import com.dao.NoticeDao;
import com.opensymphony.xwork2.ActionSupport;
public class Notice extends ActionSupport{
	private List<NoticeBean> Noticelist;
	
	public List<NoticeBean> getNoticelist() {
		return Noticelist;
	}

	public void setNoticelist(List<NoticeBean> noticelist) {
		Noticelist = noticelist;
	}

		//�����û������execute����
		public String execute() throws Exception {
				
				//������룬����ҳ�����
				HttpServletResponse response=null;
				response=ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
				//����session����
				HttpSession session = ServletActionContext.getRequest().getSession();
				//��֤�Ƿ�������¼
				if(session.getAttribute("id")==null){
					out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
					out.flush();out.close();return null;
				}
				
				Noticelist=new NoticeDao().GetList("", "");
				
				return SUCCESS;
			}
			
			//�ж��Ƿ��ֵ
			private boolean isInvalid(String value) {
				return (value == null || value.length() == 0);
			}
			
}
