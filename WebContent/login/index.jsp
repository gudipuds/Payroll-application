<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate() {
	var unm = document.forms["frmLogin"]["nm"].value;
	var pwd = document.forms["frmLogin"]["pwd"].value;
	if( unm == "" ){
		alert("Please enter username");
		document.forms["frmLogin"]["nm"].focus();
		return false;
	}
	else if( pwd == "" ){
		alert("Please enter password");
		document.forms["frmLogin"]["pwd"].focus();
		return false;
	}
	else
		return true;
}

</script>
<link rel="stylesheet" type="text/css" href="style.css" />
<title>My Payroll</title>
</head>
<body>
<%@include file="/login/Indexlinks.html" %>
<br/>
<br/>
<form name="frmLogin" action="LoginCheck" onsubmit="return validate()" >
<table class="center">
<tr>
<td class="padd">User Name:</td>
<td class="padd"> <input type="text" name="nm" ></td>
</tr>
<tr>
<td class="padd">Password:</td>
<td class="padd"><input type="password" name = "pwd"></td>
</tr>
<tr></tr>
<tr>
<td colspan = "2" align = "right">
<input type="submit" value="Submit"/>
</td>
</tr>
</table>
<div class="centeralign">
<a href="EmployerCheck">Employer Signup</a>
</div>
</form>
</body>
</html>