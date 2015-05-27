<%@page import="com.adp.data.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<script type="text/javascript">
function getvalue()
{
	var ecode = document.getElementById("ecode");

	var name= ecode.options[ecode.selectedIndex].text;

	window.location="EditEmpGetDetailsController.do?name="+name;

	return true;
}
</script>
<title>Edit Employee Details</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form method="get" action="UpdateEmpDetailsController.do">
<table class="center">
<tr><td class="padd">Select Employee:</td> <td class="padd">
		 <select id="ecode" name="editEmployee" onchange="return getvalue()">
		 <option>Select</option>
		 <adp:getEmpCodes></adp:getEmpCodes>  	
		 </select> </td>
	</tr>
</table>
	 
	<% 			
		EmployeeInfo employee = (EmployeeInfo)session.getAttribute("employee");
		if(employee == null)
		{
			employee = new EmployeeInfo();
		}
		
 %><table class="center">
		<tr> <td class="padd">Employee Code :</td> <td class="padd"> <input type="text"  name="eeCode" value="<%= employee.getEmployeeCode() %>"readonly="readonly"> </td></tr>
		<tr><td class="padd">Last Name :</td> <td class="padd"> <input type="text" name="lastName" value="<%= employee.getLastName() %>" readonly="readonly"> </td></tr>
		<tr><td class="padd">Middle Name :</td> <td class="padd"> <input type="text" name="middleName" value="<%= employee.getMiddleName() %>" readonly="readonly"> </td></tr>
		<tr><td class="padd">First Name :</td> <td class="padd"> <input type="text" name="firstName" value="<%= employee.getFirstName() %>" readonly="readonly"> </td></tr>
		<tr><td class="padd"> Title : </td> <td class="padd"> <input type="text" name="title" value="<%= employee.getTitle() %>"> </td></tr>
		<tr><td class="padd">Birth Date :</td> <td class="padd"> <input type="text" name="birthDate" value="<%= employee.getBirthDate() %>" readonly="readonly"> </td></tr>
		
		<%if(employee.getGender().equals("M")) { %>
		<tr> <td class="padd"> Gender :</td><td class="padd"><input type="radio" name="gender" value="M"  readonly="readonly" checked="checked"/>  Male</td> </tr>
		<tr><td></td> <td><input type="radio" name="gender" value="F" readonly="readonly" /> Female </td></tr>
		<% } else {%>
		<tr> <td class="padd"> Gender :</td><td class="padd"><input type="radio" name="gender" value="M"  readonly="readonly" />  Male</td> </tr>
		<tr><td></td> <td><input type="radio" name="gender" value="F" readonly="readonly" checked="checked"/> Female </td></tr>
		<%} %>
		
		<%if(employee.getMaritalStatus().equals("single")) {%>
		<tr> <td class="padd"> Marital Status :</td><td class="padd"><input type="radio" name="maritalStatus"  value="single" checked="checked"/>  Single</td> </tr>
				<tr><td></td> <td><input type="radio" name="maritalStatus" value="married"  /> Married </td></tr>
		
		<%} else { %>
		<tr> <td class="padd"> Marital Status :</td><td class="padd"><input type="radio" name="maritalStatus"  value="single" />  Single</td> </tr>
		<tr><td></td> <td><input type="radio" name="maritalStatus" value="married"  checked="checked"/> Married </td></tr>
		<% } %>
		<tr><td class="padd">Nationality :</td> <td class="padd"> <input type="text" name="nationality" value="<%= employee.getNationality() %>" readonly="readonly"> </td></tr>
		<tr><td class="padd">Address Line1 :</td> <td class="padd"> <input type="text" name="addrline1" value="<%= employee.getAddLn1() %>"></td></tr>
		<tr><td class="padd">Address Line2 :</td> <td class="padd"> <input type="text" name="addrline2" value="<%= employee.getAddLn2() %>"></td></tr>
		<tr><td class="padd">Town :</td> <td class="padd"> <input type="text" name="town" value="<%= employee.getTown() %>"></td></tr>
		<tr><td class="padd">State :</td> <td class="padd"> <input type="text" name="state" value="<%= employee.getState() %>"></td></tr>
		<tr><td class="padd">Post Code :</td> <td class="padd"> <input type="text" name="postcode" value="<%= employee.getPostCode() %>"></td></tr>
		<tr><td class="padd">Phone :</td> <td class="padd"> <input type="text" name="phone" value="<%= employee.getPhone() %>"></td></tr>
		<tr><td></td></tr>
		<tr>
		<td class="centeralign" colspan="2">
		<input type="submit" value="Edit">
		</td>
		</tr>
</table>
</form>		
</body>
</html>