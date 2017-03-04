<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>游印管理系统</title>
<style type="text/css">
<!--
body {
	background-image: url(image/bg_002.gif);
}
body,td,th {
	color: #FFFFFF;
	font-weight: bold;
	font-size: 12px;
}
-->
</style></head>
<script language="javascript">
function loginclick()
{
	var name=loginform.username.value;
	var pass=loginform.userpass.value;
	if(name=="")alert("用户名不能为空");
	else if(pass=="")alert("密码不能为空");
	else loginform.submit();
}
</script>
<body>
<form name="loginform" method="post" action="login.jsp">
<br>
<br>
<br>
<br>
<table width="500" height="150" border="0" align="center">
  <tr>
    <td align="center"><font size="5" color="#FFFFFF">欢迎您使用游印管理系统</font></td>
    </tr>
  <tr>

</table>
<table width="294" border="0" align="center">
  <tr>
    <td colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td width="79">用户名：</td>
    <td width="148"><input name="username" type="text" size="20" size="20" maxlength="30"></td>
    <td width="53" rowspan="2"><img src="image/logo_img.gif" width="37" height="40" onClick="loginclick()"> </td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input name="userpass" type="password" size="20" size="20" maxlength="30">      </td>
    </tr>
  <tr>
    <td>用户类型：</td>
    <td>
      <select name="userselect">
        <option value="1" selected>管理员</option>
        <option value="2">教师</option>
        <option value="3">管理员</option>
      </select>    </td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>
