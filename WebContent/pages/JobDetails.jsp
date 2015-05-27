<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Job details</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form method="get" action="JobDetailsController.do">
<table class="center">
	<tr><td class="padd">Job Code :</td> <td class="padd"> <input type="text" name="jobCode"></td></tr>
	<tr><td class="padd">Job Title :</td> <td class="padd"> <input type="text" name="jobTitle"></td></tr>
	<tr><td class="padd">Description :</td> <td class="padd"> <input type="text" name="desp"></td></tr>
	<tr></tr>
	<tr><td class="centeralign" colspan="2"><input type="submit" value="save"></td></tr>
</table>
</form>
</body>
</html>