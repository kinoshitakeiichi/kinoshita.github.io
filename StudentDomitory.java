package com.action;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.struts2.ServletActionContext;
import com.bean.BuildingBean;
import com.bean.DomitoryBean;
import com.bean.StudentinfoBean;
import com.dao.BuildingDao;
import com.dao.DomitoryDao;
import com.dao.StudentinfoDao;
import com.opensymphony.xwork2.ActionSupport;
public class StudentDomitory extends ActionSupport{
	//下面是Action内用于封装用户请求参数的属性
	private List<StudentinfoBean> StudentinfoList;
	private List<DomitoryBean> Domitorylist;
	private List<BuildingBean> Buildinglist;
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
	
	public List<BuildingBean> getBuildinglist() {
		return Buildinglist;
	}
	public void setBuildinglist(List<BuildingBean> Buildinglist) {
		this.Buildinglist = Buildinglist;
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

		//处理用户请求的execute方法
	public String execute() throws Exception {
			
			//解决乱码，用于页面输出
			HttpServletResponse response=null;
			response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			//创建session对象
			HttpSession session = ServletActionContext.getRequest().getSession();
			//验证是否正常登录
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
				out.flush();out.close();return null;
			}
			//查询条件
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
			strWhere+=" and Student_State='未入住'";
			//查询所有
			StudentinfoList=new StudentinfoDao().GetList(strWhere, strOrder);
			Buildinglist=new BuildingDao().GetList("", "Building_ID");
			Domitorylist=new DomitoryDao().GetList("Domitory_Number<4","Domitory_ID");
			
			if(StudentinfoList.size()==0){
				out.print("<script language='javascript'>alert('暂无学生数据！');window.location='Notice.action';</script>");
				out.flush();out.close();
				return SUCCESS;
			}
			
			int ds=StudentinfoList.size()/4;
			int count=0;
			Iterator<DomitoryBean> Dom=Domitorylist.iterator();
			while(Dom.hasNext()){
				count++;
				if(count>ds)
					Dom.remove();
				Dom.next();
			}
			
			return SUCCESS;
		}
		
		//判断是否空值
		private boolean isInvalid(String value) {
			return value.equals("null");
		}
		
		
//		public static void main(String[] args){
//			List<StudentinfoBean> l=new StudentinfoDao().GetList("1=1 and Student_State='未入住'", "Sport DESC limit 0,4");
//			Iterator<StudentinfoBean> li= l.iterator();
////			for (StudentinfoBean stu : l) {
////				System.out.print(stu.getStudent_Name()+" ");
////				System.out.print(stu.getStudnet_Sex()+" ");
////				System.out.print(stu.getStudent_State()+" ");
////				System.out.print(stu.getClassName()+" ");
////				System.out.println(stu.getSpecializedSubgect_Name());
////			}
//			while(li.hasNext()){
//				StudentinfoBean stu=li.next();
//				System.out.print(stu.getStudent_Name()+" ");
//				System.out.print(stu.getStudnet_Sex()+" ");
//				System.out.print(stu.getStudent_State()+" ");
//				System.out.print(stu.getClassName()+" ");
//				System.out.println(stu.getSpecializedSubgect_Name());
//			}
//			System.out.println(l.size());
//		}
}
