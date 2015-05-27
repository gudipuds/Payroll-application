
<%@page import="com.adp.data.Earning"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
<script type="text/javascript">

function getDetails()
{
	var earnCode = document.getElementById("earnCode");

	var name= earnCode.options[earnCode.selectedIndex].text;

	window.location="GetEarningDetailsController.do?name="+name;
	return true;
}
</script>
<link href="calendar/calendar.css" rel="stylesheet" type="text/css">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<%@ taglib uri="/WEB-INF/tlds/EarnCodes.tld" prefix="earn"%>

<title>Insert title here</title>
<title>Employee Earnings</title>
</head>
<body>
<% Earning earning = (Earning)session.getAttribute("earning");
	if(earning == null)
	{
		earning = new Earning();
	}
%>
<%@include file="/login/links.html" %>
	
<br/>
<br/>
<form method="get" action="EmployeeEarningController.do" name="empEarn">
		<table class="center">
		
			<tr>
				<td class="padd"> Earning Code:</td>
				<td class="padd">
					<select name="earnCode" id="earnCode" onchange="return getDetails()">
						<option>Select</option>	
					<earn:GetEarnCodes></earn:GetEarnCodes>
					</select>
				</td>
			</tr>
			<tr>
				<td class="padd">Employee Code:</td>
				<td class="padd">
					<select  name="empCode" id="ecode" >
						<option>Select</option>		
						<adp:getEmpCodes></adp:getEmpCodes>
					</select>
				</td>
			</tr>
			<tr> <td class="padd"> Earning Code : </td> <td class="padd"> <input type="text" name="earningCode" value="<%=earning.getEarnCode() %>" readonly="readonly"></td> </tr>
			<tr>
				<td class="padd">Start Date</td>
				<td class="padd"><input type="text" name="sDate" value="<%= earning.getEarnStartDate() %>" /><a href="#" onClick="setYears(1947, 2020);showCalender(this, 'sDate');">
      				<img src="calendar/calender.png"></a>

			    <table id="calenderTable">
			        <tbody id="calenderTableHead">
			          <tr>
			            <th colspan="4" align="center">
				          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
				           this.selectedIndex, false));" id="selectMonth">
				              <option value="0">Jan</option>
				              <option value="1">Feb</option>
				              <option value="2">Mar</option>
				              <option value="3">Apr</option>
				              <option value="4">May</option>
				              <option value="5">Jun</option>
				              <option value="6">Jul</option>
				              <option value="7">Aug</option>
				              <option value="8">Sep</option>
				              <option value="9">Oct</option>
				              <option value="10">Nov</option>
				              <option value="11">Dec</option>
				          </select>
			            </th>
			            <th colspan="2" align="center">
						    <select onChange="showCalenderBody(createCalender(this.value, 
							document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
							</select>
						</th>
			            <th align="center">
						    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
						</th>
					  </tr>
			       </tbody>
			       <tbody id="calenderTableDays">
			         <tr style="">
			           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
			         </tr>
			       </tbody>
			       <tbody id="calender"></tbody>
			    </table>
		</td>
			</tr>
			<tr>
				<td class="padd">End Date</td>
				<td class="padd"><input type="text" name="eDate" value="<%= earning.getEarnEndDate() %>"/><a href="#" onClick="setYears(1947, 2020);showCalender(this, 'eDate');">
      <img src="calendar/calender.png"></a>

			    <table id="calenderTable">
			        <tbody id="calenderTableHead">
			          <tr>
			            <th colspan="4" align="center">
				          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
				           this.selectedIndex, false));" id="selectMonth">
				              <option value="0">Jan</option>
				              <option value="1">Feb</option>
				              <option value="2">Mar</option>
				              <option value="3">Apr</option>
				              <option value="4">May</option>
				              <option value="5">Jun</option>
				              <option value="6">Jul</option>
				              <option value="7">Aug</option>
				              <option value="8">Sep</option>
				              <option value="9">Oct</option>
				              <option value="10">Nov</option>
				              <option value="11">Dec</option>
				          </select>
			            </th>
			            <th colspan="2" align="center">
						    <select onChange="showCalenderBody(createCalender(this.value, 
							document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
							</select>
						</th>
			            <th align="center">
						    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
						</th>
					  </tr>
			       </tbody>
			       <tbody id="calenderTableDays">
			         <tr style="">
			           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
			         </tr>
			       </tbody>
			       <tbody id="calender"></tbody>
			    </table>
		</td>
			</tr>
			<tr><td class="padd">Status :</td> <td class="padd">
			<select name="status">
				<option>Select</option>
				<option>Active</option>
				<option>InActive</option>
			</select>
			</td></tr>
			<tr><td class="padd">Default Amount :</td> <td class="padd"><input type="text" name = "amount" value="<%= earning.getEarnDfltAmount()%>"></td></tr>
			<tr><td></td></tr>
			<tr><td colspan="2" class="centeralign"> <input type="submit" value="submit"> </td></tr>
		</table>
</form>
</body>
</html>