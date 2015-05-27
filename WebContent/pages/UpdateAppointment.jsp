<%@page import="com.adp.data.Appointment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee Details</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<% Appointment appt = (Appointment)session.getAttribute("appt"); %>
<table class="center">
<tr><td class="padd">Employee code</td><td class="padd"><input type = "text" value = "<%= appt.getEmployeeCode() %>"/></td></tr>
<tr><td class="padd">Appt No</td><td class="padd"><input type = "text" value = "<%= appt.getapptNo() %>"/></td></tr>
<tr><td class="padd">Appt Start Date</td><td class="padd"><input type = "text" value = "<%= appt.getApptStartDate() %>"/> </td></tr>
<tr><td class="padd">Appt End Date</td><td class="padd"><input type = "text"  value = "<%= appt.getApptEndDate() %>"/></td></tr>
<tr><td class="padd">BU Code</td><td class="padd"><input type = "text"  value = "<%= appt.getBuCode() %>"/></td></tr>
<tr><td class="padd">Job Code</td><td class="padd"><input type = "text"  value = "<%= appt.getJobCode() %>"/></td></tr>
<tr><td class="padd">Position ID</td><td class="padd"><input type = "text"  value = "<%= appt.getPosnId() %>"/></td></tr>
<tr><td class="padd"> Reports To</td><td class="padd"><input type = "text"  value = "<%= appt.getReportsTo() %>"/></td></tr>

</table>
</body>
</html>