<%@page import="com.adp.data.Deduction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<script type="text/javascript">


function getDetails()
{
	var dedCode = document.getElementById("dedCode");

	var name= dedCode.options[dedCode.selectedIndex].text;

	window.location="GetDeductionDetailsController.do?name="+name;
	return true;

}
</script>
<title>Employee Deduction</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
	<% Deduction deduction = (Deduction)session.getAttribute("deduction");
	if(deduction == null)
	{
		deduction = new Deduction();
	}
%>
<br/>
<br/>
<form method="get" action="EmployeeDeductionController.do">
		<table class="center">
		
			<tr>
				<td class="padd"> Deduction Code:</td>
				<td class="padd">
					<select name="dedCode" id="dedCode" onchange="return getDetails()">
					<option>Select</option>	
					<adp:getDedCodes></adp:getDedCodes>
					</select>
				</td>
			</tr>
			<tr><td class="padd">Deduction Code</td><td class="padd"><input type="text" name="deductionCode" value="<%= deduction.getDedCode()%>"/></td></tr>
				<tr>
				<td class="padd">Employee Code:</td>
				<td class="padd">
					<select  name="empCode">
						<option>Select</option>		
						<adp:getEmpCodes></adp:getEmpCodes>
					</select>
				</td>
			</tr>
			<tr>
				<td class="padd">Start Date</td>
				<td class="padd"><input type="text" name="sDate" value="<%=deduction.getDedStartDate() %>" /><a href="#" onClick="setYears(1947, 2020);showCalender(this, 'sDate');">
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
				<td class="padd"><input type="text" name="eDate" value="<%= deduction.getDedEndDate() %>"/><a href="#" onClick="setYears(1947, 2020);showCalender(this, 'eDate');">
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
			<tr><td class="padd">Default Amount :</td> <td class="padd"><input type="text" name = "amount" value="<%= deduction.getDedDfltAmount()%>"></td></tr>
			<tr></tr>
			<tr><td colspan="2" class="centeralign"> <input type="submit" value="submit"> </td></tr>
		</table>
</form>
</body>
</html>