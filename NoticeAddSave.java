package com.action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.NoticeBean;
import com.dao.NoticeDao;
import com.opensymphony.xwork2.ActionSupport;
public class NoticeAddSave extends ActionSupport{
	private String title;
	private String author;
	private String re_data;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRe_data() {
		return re_data;
	}
	public void setRe_data(String re_data) {
		this.re_data = re_data;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
//		创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
//		验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询
		NoticeBean nobean=new NoticeBean();
		nobean.setAuthor(author);
		nobean.setRe_data(re_data);
		nobean.setTitle(title);
		if(!(isInvalid(content)))
		{
			nobean.setContent(content);
		}
		new NoticeDao().Add(nobean);
		
		out.print("<script language='javascript'>alert('修改成功！');window.location='Notice.action';</script>");
		out.flush();out.close();
				
		return null;
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

}
