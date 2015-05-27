<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Position Details</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form method="get" action="PositionDetailsController.do">
<table class="center">
	<tr><td class="padd">Business Unit Name :</td> <td>
		 <select name="buName">
		 	<option>Select</option>
		 	<option>Administration</option>
		 	<option>Finance</option>
		 	<option> Human resources</option>
		 	<option>Payroll</option>
		 	<option>Technical</option>
		 	<option>Sales and Marketing</option>
		 	<option>Production</option>
		 	<option>Packaging</option>
		 	<option>Quality Assurance</option>
		 	<option>Warehouse</option>
		 	<option>Transport</option>
		 </select> </td>
	</tr>
	<tr><td class="padd">Job Title</td> <td class="padd">
		 <select name="jobTitle">
		 	<option>Select</option>
		 </select> </td>
	</tr>
	<tr><td class="padd">Positin ID :</td> <td class="padd"> <input type="text" name="posId"></td></tr>
	<tr><td class="padd">Position Title :</td> <td class="padd"> <input type="text" name="posTitle"></td></tr>
	<tr><td class="padd">Start Date :</td> <td class="padd"> <input type="text" name="startDate"></td></tr>
	<tr><td class="padd">End Date :</td> <td class="padd"> <input type="text" name="endDate"></td></tr>
	<tr><td class="padd">Position Status:</td> <td class="padd">
		 <select name="posStatus">
		   	<option>Select</option>
		   	<option>Closed</option>
		 	<option>Frozen</option>
		 	<option>Open</option>
		 </select> </td>
	</tr>	
	<tr></tr>
	<tr><td class="centeralign" colspan="2"><input type="submit" value="submit"></td></tr>
	
</table>
</form>
</body>
</html>