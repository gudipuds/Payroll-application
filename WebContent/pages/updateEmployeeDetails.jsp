<%@page import="com.adp.data.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Update Employee Details</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<% EmployeeInfo einfo  = (EmployeeInfo)session.getAttribute("einfo"); %>
<table class="center">
<tr><td class="padd">Employee code</td><td class="padd"><input type = "text" value = "<%= einfo.getEmployeeCode() %>"/></td></tr>
<tr><td class="padd">Last name</td><td class="padd"><input type = "text" value = "<%= einfo.getLastName() %>"/></td></tr>
<tr><td class="padd">Middle name</td><td class="padd"><input type = "text" value = "<%= einfo.getMiddleName() %>"/> </td></tr>
<tr><td class="padd">First name</td><td class="padd"><input type = "text"  value = "<%= einfo.getFirstName() %>"/></td></tr>
<tr><td class="padd">Title </td><td class="padd"><input type = "text"  value = "<%= einfo.getTitle() %>"/></td></tr>
<tr><td class="padd">Birth date</td><td class="padd"><input type = "text"  value = "<%= einfo.getBirthDate() %>"/></td></tr>
<tr><td class="padd">Gender</td><td class="padd"><input type = "text"  value = "<%= einfo.getGender() %>"/></td></tr>
<tr><td class="padd"> Marital status</td><td class="padd"><input type = "text"  value = "<%= einfo.getMaritalStatus() %>"/></td></tr>
<tr><td class="padd">Nationality</td><td class="padd"><input type = "text"  value = "<%= einfo.getNationality() %>"/></td></tr>
<tr><td class="padd">Address line 1</td><td class="padd"><input type = "text"  value = "<%= einfo.getAddLn1() %>"/></td></tr>
<tr><td class="padd">Address line 2</td><td class="padd"><input type = "text"  value = "<%= einfo.getAddLn2() %>"/></td></tr>
<tr><td class="padd">Town</td><td class="padd"><input type = "text"  value = "<%= einfo.getTown() %>"/></td></tr>
<tr><td class="padd">State</td><td class="padd"><input type = "text"  value = "<%= einfo.getState() %>"/></td></tr>
<tr><td class="padd">Post code</td><td class="padd"><input type = "text"  value = "<%= einfo.getPostCode() %>"/></td></tr>
<tr><td class="padd">Phone</td><td class="padd"><input type = "text"  value = "<%= einfo.getPhone()%>"/></td></tr>
</table>
</body>
</html>