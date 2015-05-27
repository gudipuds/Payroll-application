<%@page import="com.adp.data.Employer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="style.css" rel="stylesheet" type="text/css">
<title>Show Employer</title>
</head>

<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<% Employer emp = (Employer)session.getAttribute("emp"); %>
<table class="center">
<tr><td class="padd">Employer Code : </td><td class="padd"> <%= emp.getEmployerCode() %> </td></tr>
<tr><td class="padd">Employer name : </td><td class="padd"><%=emp.getEmployerName() %></td></tr>
<tr><td class="padd">Start date : </td><td class="padd"><%=emp.getErStartDate() %></td></tr>
<tr><td class="padd">End date : </td><td class="padd"><%=emp.getErEndDate() %></td></tr>
<tr><td class="padd">Address line 1 : </td><td class="padd"><%=emp.getErAddLn1() %></td></tr>
<tr><td class="padd">Address line 2 : </td><td class="padd"><%=emp.getErAddLn2() %></td></tr>
<tr><td class="padd">Address line 3: </td><td class="padd"><%=emp.getErAddLn3() %></td></tr>
<tr><td class="padd">Town: </td><td class="padd"><%=emp.getErTown() %></td></tr>
<tr><td class="padd">State: </td><td class="padd"><%=emp.getErState() %></td></tr>
<tr><td class="padd">Country : </td><td class="padd"><%=emp.getErCountry() %></td></tr>
<tr><td class="padd">Post code: </td><td class="padd"><%=emp.getErPostCode() %></td></tr>
<tr><td class="padd">Phone: </td><td class="padd"><%=emp.getErPhone() %></td></tr>

</table>

</body>
</html>