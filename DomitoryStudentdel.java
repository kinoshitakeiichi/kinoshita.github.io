package com.action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.StudentBean;
import com.dao.DomitoryDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;
public class DomitoryStudentdel extends ActionSupport{
	private int ID;
	private StudentBean stu;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public StudentBean getStu() {
		return stu;
	}
	public void setStu(StudentBean stu) {
		this.stu = stu;
	}
	
	//处理用户请求的execute方法
		public String execute() throws Exception {
				
				//解决乱码，用于页面输出
				HttpServletResponse response=null;
				response=ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				
//				创建session对象
				HttpSession session = ServletActionContext.getRequest().getSession();
//				验证是否正常登录
				if(session.getAttribute("id")==null){
					out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
					out.flush();out.close();return null;
				}
				stu=new StudentDao().GetBean(ID);
				int Did=stu.getStudent_DomitoryID();
				stu.setStudent_DomitoryID(0);
				stu.setStudent_State("未入住");
				new DomitoryDao().AddN(Did, -1);
				new StudentDao().Update(stu);
				
				out.print("<script language='javascript'>window.location='DomitoryUpdate.action?Domitory_ID="+Did+"'</script>");
				out.flush();out.close();
				return null;
			}

}
