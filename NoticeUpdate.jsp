<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <title>智能宿舍管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

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
		      <td width="709" align="center" valign="top" bgcolor="#F6F9FE"> 
		       <!-- 页面内容 -->
		        <table width="709" border="0" cellspacing="0" cellpadding="0" >
		          <!-- 此处插入页面代码 -->
		          <form action="NoticeUpdateSave.action" method="post">
		          	<input name="ID" type="hidden" value="<s:property value="nobean.ID"/>" />
		          	<table border="1px">
		          		<tr>
		          			<td width="100" style="text-align:center;">标题</td>
		          			<td width="500"><input name="title" type="text" value="<s:property value="nobean.title"/>"/></td>
		          		</tr>
		          		<tr>
		          			<td width="100" style="text-align:center;">发布者</td>
		          			<td width="500"><input name="author" type="text" value="<%= session.getAttribute("username") %>"/></td>
		          		</tr>
		          		<tr>
		          			<td width="100" style="text-align:center;">内容</td>
		          			<td width="500"><textarea name="content" rows="5" cols="20"><s:property value="nobean.content"/></textarea></td>
		          		</tr>
		          		<tr>
		          			<td width="100" style="text-align:center;">发布时间</td>
		          			<td width="500"><input name="re_data" type="text" value="<%=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date()) %>"/></td>
		          		</tr>
		          	</table>
		          	<input type="submit" value="修改" />
					<input type="button" value="返回上页" onClick="javascript:history.back(-1);">
		          </form>
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