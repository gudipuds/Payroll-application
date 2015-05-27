<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function validate() {
	var unm = document.forms["frmEmpLogin"]["nm"].value;
	var pwd = document.forms["frmEmpLogin"]["pwd"].value;
	if( unm == "" ){
		alert("Please enter username");
		document.forms["frmEmpLogin"]["nm"].focus();
		return false;
	}
	else if( pwd == "" ){
		alert("Please enter password");
		document.forms["frmEmpLogin"]["pwd"].focus();
		return false;
	}
	else
		return true;
}
</script>
<title>Employee Login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/login/Indexlinks.html" %>
<br/>
<br/>
<form name="frmEmpLogin" action="EmpLoginCheck" onsubmit = "return validate()" >
<table class="center">
<tr>
<td class="padd">Employee Code:</td>
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
</form>
</body>
</html>