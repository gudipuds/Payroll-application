<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function selectOption()
{
	var ddlcodes = document.getElementById("ddlcodes");
	var selectedCode = ddlcodes.options[ddlcodes.selectedIndex].text;
	window.location="DeleteEarningController.do"+selectedCode;
}
function validate() {
	var name = document.forms["delEarn"]["code"].value;
	if(name == "select") {
		alert("Please select an employee to delete Earning");
		return false ;
	}
	else
		return true;
}
</script>    
<title>Delete Earning</title>
<%@ taglib uri="/WEB-INF/tlds/EarnCodes.tld" prefix="adp"%> 
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form name="delEarn" action="DeleteEarningController.do" onsubmit="return validate()">
<table class="center">
<tr>
<td class="padd">Select Earning's code which you want to Delete:</td>
<td class="padd"><select name="code">
  <option>select</option>
  <adp:GetEarnCodes></adp:GetEarnCodes>	
</select>
</td>
</tr>
<tr><td></td></tr>
<tr>
<td class="centeralign" colspan="2">
<input type="submit" value="Delete Earning">
</td>
</tr>
</table>
</form>
</body>
</html>