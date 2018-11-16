<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <title>智能宿舍管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<% int begin=0,end=4;
   request.setAttribute("begin",begin);
   request.setAttribute("end",end);%>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">智能宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
	  <tr>
	    <td height="500" align="center" valign="top">
	      <table width="900" border="0" cellspacing="0" cellpadding="0">
	        <tr>
	          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
	            <%@ include file="Left.jsp"%>
	          </td>
		      <td width="709" align="center" valign="top" bgcolor="#F6F9FE">  <!-- 页面内容 -->
		        <table width="709" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">宿舍分配</td>
		          </tr>
		          <!-- 此处插入页面代码 -->
		     	  <tr>
					<td>
						<form id="form1" name="form1" method="post" action="StudentDomitorySave.action" style="text-align:center">
							  <s:iterator value="Domitorylist" status="dst" id="dl">
				          		<table style="border:1px solid;width:600;text-align:center;margin-left:60px">
				          			<caption><strong><s:property value="Domitory_Name"/></strong></caption>
				          			<tr>
				      					<th>宿舍号</th>
				      					<th>楼号</th>
				      					<th>宿舍类型</th>
				          			</tr>
				          			<tr>
				          				<td><s:property value="Domitory_Name"/></td>
				          				<td><s:property value="Building_Name"/></td>
				          				<td><s:property value="Domitory_Type"/></td>
				          			</tr>
				          			<tr>
				          				<th>姓名</th>
				          				<th>性别</th>
				          				<th>班级</th>
				          			</tr>
				          			
				          			  <s:iterator value="StudentinfoList" status="st" begin="#attr['begin']" end="#attr['end']-1">
						          		<tr>
							          		<td><s:property value="Student_Name" /></td>
							          		<td><s:property value="Student_Sex" /></td>
							          		<td><s:property value="className" /></td>
						          		</tr>
					          		</s:iterator>
									<%	begin+=4;
										end+=4;
										request.setAttribute("begin",begin);
									    request.setAttribute("end",end); %>
			          		</table>
		          			</s:iterator>
		          			<%-- <s:debug></s:debug> --%>
		          			<input type="submit" value="提交"/>
		          			<input type="hidden" value=${sex} name="sex"/>
		          			<input type="hidden" value=${department} name="department"/>
		          			<input type="hidden" value=${hobby} name="hobby"/>
		             	</form>
					</td>
		     	  </tr>
		          <!-- 此处插入页面代码 -->						
		        </table>
		      </td>
	        </tr>
	      </table>
	    </td>
	   </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>
</center>
</body>

</html>