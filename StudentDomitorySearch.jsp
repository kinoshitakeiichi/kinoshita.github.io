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
						<form name="form1" method="post" action="StudentDomitory.action" style="padding-left:35%;">
			               		               
			                	性别:<select name="sex">
			                			<option value=null>请选择..</option>
			                			<option value="男">男</option>
			                			<option value="女">女</option>
			                		</select>			                			                
			                	系别:<select name="department">
			                			<option value=null>请选择..</option>
			                			<option value="计算机科学">计算机科学</option>
			                			<option value="信息管理系">信息管理系</option>
			                			<option value="外语">外语</option>
			                		</select>			               			                 
			                	爱好:<select name="hobby">
			                			<option value=null>请选择..</option>
			                			<option value="Sport">体育</option>
			                			<option value="Esport">电竞</option>
			                			<option value="Letter">文艺</option>
			                		</select>			                
			                <input type="submit" value="查询"/>      
			                </table>         
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