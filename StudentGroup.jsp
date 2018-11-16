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
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">大连东软寢室智能化管理系统</td>
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
		            <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">动态学习小组</td>
		          </tr>
		          <!-- 此处插入页面代码 -->
		     	  <tr>
					<td>
						<form name="form1" method="post" action="StudentGroup.action" style="padding-left:15%;" >			                
			                	科目:<select name="SubgectName">
			                			<option value=null>请选择科目</option>		
			                			<option value="計算機導論">计算机导论</option>
                                        <option value="C語言">C语言</option>
                                        <option value="python">Python</option>
                                        <option value="高等數學">高等数学</option>
                                        <option value="商務基礎日語">商务基础日语</option>
                                    </select>			               
			                	选择:<select name="SearchRow" id="SearchRow">
                                         <option value="Subgect_Name">科目</option>
                                         <option value="className">班级</option>
                                         </select>
			                 <input name="SearchKey" type="text" class="text1" id="SearchKey">                             
                             <input type="submit" name="button" id="button" value="点击查询">
                             </td>                    
                  </tr>
                  </form>	
                  </table>			                            	             
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