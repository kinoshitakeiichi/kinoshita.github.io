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
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Domitory_BuildingID.value)){  
   alert("请选择楼宇！"); 
   return false;
   }
   if(isNull(form1.Domitory_Name.value)){
   alert("请输入寝室号！");
   return false;
   }
   if(isNull(form1.Domitory_Type.value)){
   alert("请输入寝室类型！");
   return false;
   }
   if(isNull(form1.Domitory_Tel.value)){
   alert("请输入电话！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改宿舍</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="DomitoryUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Domitory_ID" type="text" class="noshow" id="Domitory_ID" value="<s:property value='cnbean.Domitory_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇：</td>
                    <td><select name="Domitory_BuildingID" id="Domitory_BuildingID">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="list">
                      	<s:if test="cnbean.Domitory_BuildingID!=Building_ID">
                        	<option value="${Building_ID}">${Building_Name}</option>
                        </s:if>
                      </s:iterator>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>寝室号：</td>
                    <td><input name="Domitory_Name" type="text" class="text2" id="Domitory_Name" value="<s:property value='cnbean.Domitory_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>寝室类型：</td>
                    <td><input name="Domitory_Type" type="text" class="text2" id="Domitory_Type" value="<s:property value='cnbean.Domitory_Type'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right">宿舍成员:</td>
                    <td>
                    	<s:if test="cnbean.Domitory_Number!=0">
	                    	<table style="border:0px solid;width:400px;text-align:center;margin-left:30px">
	                    		<tr>
				          			<th>姓名</th>
				          			<th>性别</th>
				          			<th>班级</th>
				          		 	<th>操作</th>
				          		</tr>
	                    		<s:iterator value="studentList">
	                    			<tr>
							          	<td><s:property value="Student_Name" /></td>
							          	<td><s:property value="Student_Sex" /></td>
							          	<td><s:property value="className" /></td>
							          	<td><a href="DomitoryStudentdel.action?ID=${Student_ID}" style="color:red;">移除</a></td>
						          	</tr>
	                    		</s:iterator>
	                    		<tr><span style="color:red;">注意:点击‘移除’立即移除！！！</span></tr>
	                    	</table>
                    	</s:if>
                    	<s:else>
                    		<span style="color:red;">该宿舍暂无学生！</span>
                    	</s:else>
                    	</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>电话：</td>
                    <td><input name="Domitory_Tel" type="text" class="text2" id="Domitory_Tel" value="<s:property value='cnbean.Domitory_Tel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改宿舍">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:window.location='DomitoryManager.action'"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
