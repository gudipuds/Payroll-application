<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="style.css" rel="stylesheet" type="text/css">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<title>Delete Employee</title>
<script type="text/javascript">
function validate() {
	var name = document.forms["delEmp"]["ecode"].value;
	if(name == "select") {
		alert("Please select an employee to delete");
		return false ;
	}
	else
		return true;
}
</script>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form name="delEmp" method="get" action="deleteEmployeeController.do">
<table class="center">
<tr><td class="padd">Select Employee:</td> <td>
		 <select name="ecode" >
		   	<option>Select</option>
		   	<adp:getEmpCodes></adp:getEmpCodes>
		 </select> </td>
	</tr>
<tr><td></td></tr>
<tr><td class="centeralign" colspan="2"><input type="submit" value="delete"></td></tr>	
</table>

</form>
</body>
</html>