package com.action;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.aaist.groupaaist;
import com.bean.MarkBean;
import com.bean.StudentBean;
import com.bean.SubgectBean;
import com.bean.groupBean;
import com.bean.groupaBean;
import com.dao.MarkDao;
import com.dao.StudentDao;
import com.dao.SubgectDao;
import com.dao.groupDao;
import com.dao.groupaDao;
import com.opensymphony.xwork2.ActionSupport;
public class StudentGroup extends ActionSupport{
	//下面是Action用開封裝用戶請求的屬性
	private String SearchRow;
	private String SearchKey;
	private String SubgectName;	
	private int Searchpage;
	
public String getSubgectName() {
		return SubgectName;
	}
	public void setSubgectName(String subgectName) {
		SubgectName = subgectName;
	}
public int getSearchpage() {
		return Searchpage;
	}
	public void setSearchpage(int searchpage) {
		Searchpage = searchpage;
	}
	private List<groupBean> grouplist;
	private List list;
	private List<groupaBean>groupalist;
	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}	
	public List<groupBean> getGrouplist() {
		return grouplist;
	}
	public void setGrouplist(List<groupBean> grouplist) {
		this.grouplist = grouplist;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public List<groupaBean> getGroupalist() {
		return groupalist;
	}
	public void setGroupalist(List<groupaBean> groupalist) {
		this.groupalist = groupalist;
	}
	//處理用戶請求的execute方法
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
		//查詢條件
		String strWhere=" 1=1";
		if(!(isInvalid(SearchKey)))
		{
			strWhere+=" and "+SearchRow+"= '"+SearchKey+"'";
		}
		if(!(isInvalid(SubgectName)))
		{
			strWhere+=" and Subgect_Name= '"+SubgectName+"'";
		}	
		else
		{
			strWhere+=" and Subgect_Name='计算机导论'";
		}
		//查询所有	
		grouplist=new groupDao().Getlist(strWhere, "Subgect_Mark");
		
		
		groupalist=new groupaDao().GetList(null, null);
		 list=new ArrayList();
		 groupaaist ga=new groupaaist();
		for(int i=0;i<grouplist.size()/3;i++)
		{
		list.add(groupalist.get(i));
		//list.add(grouplist.get(i));
		}
		if(grouplist.size()==0)
		{
			out.print("<script language='javascript'>alert('暂无学生数据！');window.location='Notice.action';</script>");
		    out.flush();
		    out.close();
		    return SUCCESS;
		}				
		return SUCCESS;
		
	}
	//判断是否空值
			private boolean isInvalid(String value) {
				return (value == null || value.length() == 0);
			}

//测试
public static void main(String[] args) {
	System.out.println();
	String strWhere =" 1=1 and Subgect_Name='C语言'" ;
	List<groupBean> grouplist = new groupDao().Getlist(strWhere, "Subgect_Mark");
//	for (int i = 0; i < list.size(); i++) {
//	    System.out.println(i+"\t"+list.get(i));
//	}
//	List list=new ArrayList();

	grouplist=new groupDao().Getlist(strWhere, "Subgect_Mark");
	
	List groupalist=new groupaDao().GetList(null, null);
	List list=new ArrayList();
	 groupaaist ga=new groupaaist();
	for(int i=1;i<grouplist.size()/4;i++)
	{
	list.add(groupalist.get(i));
	System.out.println(list);
	//list.add(grouplist.get(i));
	}


}
}

