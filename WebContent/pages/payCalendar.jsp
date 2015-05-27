<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/300824.css" />
<link href="style.css" rel="stylesheet" type="text/css">
<title>Pay Calendar</title>
</head>
<body>
 <%@include file="/login/links.html" %>
 <br/>
<form action="PayCalculatorController.do">
<table class="center">
<tr>
	<td class="padd">Tax Year (YYYY) </td>
	<td class="padd"><input type="text" name="taxYear" /></td>
</tr>

<tr>
	<td class="padd"> Pay Frequency </td>
	<td class="padd"> <select name="payFrequency">
			<option>select</option>
			<option>Monthly</option>
			<option>Weekly</option>
	 </select>
	</td>
</tr>
<tr></tr>
<tr>
<td class="centeralign" colspan="2"><input type="submit" value="Generate Paycalander" /></td>
</tr>
</table>
</form>
</body>
</html>