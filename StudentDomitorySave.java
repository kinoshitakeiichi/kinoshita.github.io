package com.action;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.bean.BuildingBean;
import com.bean.DomitoryBean;
import com.bean.StudentinfoBean;
import com.dao.BuildingDao;
import com.dao.DomitoryDao;
import com.dao.StudentDao;
import com.dao.StudentinfoDao;
import com.opensymphony.xwork2.ActionSupport;
public class StudentDomitorySave extends ActionSupport{
	//������Action�����ڷ�װ�û��������������
	private List<StudentinfoBean> StudentinfoList;
	private List<DomitoryBean> Domitorylist;
	private String sex;
	private String department;
	private String hobby;

	public List<StudentinfoBean> getStudentinfoList() {
		return StudentinfoList;
	}
	public void setStudentinfoList(List<StudentinfoBean> StudentinfoList) {
		this.StudentinfoList = StudentinfoList;
	}
	public List<DomitoryBean> getDomitorylist() {
		return Domitorylist;
	}
	public void setDomitorylist(List<DomitoryBean> Domitorylist) {
		this.Domitorylist = Domitorylist;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return this.sex;
	}
	public void setDepartment(String department){
		this.department=department;
	}
	public String getDepartment(){
		return this.department;
	}
	public void setHobby(String hobby){
		this.hobby=hobby;
	}
	public String getHobby(){
		return this.hobby;
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
			//��ѯ����
			String strWhere="1=1";
			String strOrder="";
			if(!isInvalid(sex)){
				strWhere+=" and Student_Sex='"+sex+"'";
			}
			if(!isInvalid(department)){
				strWhere+=" and Department_Name='"+department+"'";
			}
			if(!isInvalid(hobby)){
				strOrder+=""+hobby+" DESC";
			}
			strWhere+=" and Student_State='δ��ס'";
			//��ѯ����
			StudentinfoList=new StudentinfoDao().GetList(strWhere, strOrder);
			Domitorylist=new DomitoryDao().GetList("Domitory_Number<4","Domitory_ID");
			int ds=StudentinfoList.size()/4;
			int count=0;
			Iterator<DomitoryBean> Dom=Domitorylist.iterator();
			while(Dom.hasNext()){
				count++;
				if(count>ds)
					Dom.remove();
				Dom.next();
			}
			int DId = 0;
			Dom=Domitorylist.iterator();
			
			for(StudentinfoBean stu:StudentinfoList){
				int ID=stu.getStudent_ID();
				if(count%4==0 && Dom.hasNext()){
					DId=Dom.next().getDomitory_ID();
				}
				new StudentinfoDao().Update(ID, DId);
				new DomitoryDao().AddN(DId,1);
				count++;
			}
			
			out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='Notice.action';</script>");
			out.flush();out.close();
			return SUCCESS;
		}
		
		//�ж��Ƿ��ֵ
		private boolean isInvalid(String value) {
			return value.equals("null");
		}
}
