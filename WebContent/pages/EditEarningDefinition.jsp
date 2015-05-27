<%@page import="com.adp.data.Earning"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
<title>Edit Earning Definition</title>
 <link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function selectOption()
{
	var ddlcodes = document.getElementById("ddlcodes");
	var selectedCode = ddlcodes.options[ddlcodes.selectedIndex].text;
	window.location="SelectController.do?name="+selectedCode;
}
</script>    
<%@ taglib uri="/WEB-INF/tlds/EarnCodes.tld" prefix="adp"%>        
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<table class="center">
<tr><td class="padd">
Select Earning's code which you want to update:
</td>
<td class="padd">
<select id="ddlcodes" name="ddlcodes" onchange="selectOption()">
  <option>select</option>
  <adp:GetEarnCodes></adp:GetEarnCodes>
</select>
</td>
</table>
<%
 Earning eobj = (Earning)request.getAttribute("earning");
 if(eobj==null){
	eobj=new Earning();
}%>
<form method="get" action="EditEarningDefinitionController.do">
<table class="center">	
	<tr><td class="padd">Earnings Code:<font color="red" size="2">* </font></td><td class="padd"><input type="text" name="earnCode" value="<%=eobj.getEarnCode()%>"></td></tr>
	<tr><td class="padd">Earnings Description:<font color="red" size="2">* </font></td><td class="padd"><input type="text" name="earnDesc" value="<%=eobj.getEarnDesc()%>"></td></tr>
	<tr><td class="padd">Earnings Start Date:<font color="red" size="2">* </font></td><td class="padd"><input type="text" name="earnStartDate" value="<%=eobj.getEarnStartDate()%>"></td></tr>
	
	<tr><td class="padd">Earnings End Date:</td><td class="padd"><input type="text" name="earnEndDate" value="<%=eobj.getEarnEndDate()%>"></td></tr>
	
	<tr><td class="padd">Taxability:<font color="red" size="2">* </font></td><td class="padd"><select name="earnTaxability">
	 <% if(eobj.getEarnTaxability().equals("Pre Tax")) {%>
	<option>Pre Tax </option>
	<option>Post Tax</option> 
	<%} 
	else {
		%> <option>Post Tax </option>
	<option>Pre Tax</option> 
	<% }
	%>
	</select>
	</td></tr>
	<tr><td class="padd">Earnings Default Amount:</td><td class="padd"><input type="text" name="earnDfltAmount" value="<%=eobj.getEarnDfltAmount()%>" ></td></tr>
<tr><td colspan="2" class="centeralign">
<input type="submit" value="Update"/>
</td></tr>
</table>
</form>
</body>

</html>