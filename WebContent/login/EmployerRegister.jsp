<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employer Signup</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
function isValid() {
	var unm = document.forms["frmEmpRegister"]["nm"].value;
	var pwd1 = document.forms["frmEmpRegister"]["pwd"].value;
	var pwd2 = document.forms["frmEmpRegister"]["cpwd"].value;

	if( unm == "" || pwd1 == "" || pwd2 == "" ) {
		alert("Do not leave any field empty");
		document.forms["frmEmpRegister"]["unm"].focus();
		return false;
	}
	else if(pwd1 != pwd2){
		alert("Enter same value in password, Confirm Password fields");
		document.forms["frmEmpRegister"]["cpwd"].value = "";
		document.forms["frmEmpRegister"]["pwd"].select();
		document.forms["frmEmpRegister"]["pwd"].focus();
		return false;
		}
	
	else
		return true;
	
}

function unmvalidate(){
	var unm = document.forms["frmEmpRegister"]["nm"].value;

	if(unm == "")
		return true;
	else if( unm.length > 16 ){
		alert("Username should not have more than 16 characters");
		document.forms["frmEmpRegister"]["nm"].focus();
		return false;
	}	
	else
		return true;
}

function pwdvalidate(){
	var pwd = document.forms["frmEmpRegister"]["pwd"].value;
	if(pwd == "")
		return true;
	else if(pwd.length < 6) {
		alert("Password should have atleast 6 characters");
		document.forms["frmEmpRegister"]["pwd"].focus();
		return false;
	}
	else if( pwd.length > 16){
		alert("Password should not have more than 16 characters");
		document.forms["frmEmpRegister"]["pwd"].focus();
		return false;
	}
	else
		return true;
}
</script>
</head>
<body>
<%@include file="/login/Indexlinks.html" %>
<br/>
<br/>
<form name="frmEmpRegister" action="EmployerRegisterController" onsubmit="return isValid()" >
<table class="center">
<tr>
<td class="padd">User Name:</td>
<td class="padd"> <input type="text" name="nm" onblur = "return unmvalidate()"></td>
</tr>
<tr>
<td class="padd">Password:</td>
<td class="padd"><input type="password" name = "pwd" onblur = "return pwdvalidate()"></td>
</tr>
<tr>
<td class="padd">Confirm Password:</td>
<td class="padd"><input type="password" name = "cpwd"></td>
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