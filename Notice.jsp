<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>智能舍务管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
  
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
   	 <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">智能舍务管理系统</td>
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
	          <td width="709" align="center" valign="top" bgcolor="#F6F9FE">
	          		<h1>欢迎使用智能舍务管理系统</h1>
		          		<table width="700" border="1">
		          			<caption><strong>公告栏</strong></caption>
		          			<tr>
		          				<td align="center"><b>标题</b></td>
		          				<td align="center"><b>时间</b></td>
		          				<td align="center"><b>发布者</b></td>
		          				<td align="center"><b>操作</b></td>
		          			</tr>
		          			<s:iterator value="Noticelist" status="st">
		          			<tr>
		          				<td align="center">${title}</td>
		          				<td align="center">${re_data}</td>
		          				<td align="center">${author}</td>
		          				<td align="center"><a href="NoticeCheck.action?ID=${ID}">查看</a>
		          				<%if(session.getAttribute("type").toString().equals("1")||session.getAttribute("type").toString().equals("2")){%>
		          					<a href="NoticeUpdate.action?ID=${ID}">修改</a>
		          				<%}%>
		          				</td>
		          			<tr>
		          			</s:iterator>
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
