<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
      <link href="style.css" rel="stylesheet" type="text/css">
<title>Business Unit Details</title>
</head>
<body>

<%@include file="/login/links.html" %>
<br/>
<br/>
<form name = "frm25" method="post" action="BusinessUnitDetailsController.do">
<table class="center">
<tr>
<td class="padd"> BU Code:<font color="red" size="2">* </font> </td>
<td class="padd"> <input type="text" name="bu"/></td>
</tr>
<tr>
<td class="padd">Name:<font color="red" size="2">* </font> </td>
<td class="padd"><input type="text" name="nm" size="50"/></td>
</tr>
<tr>
<td class="padd">Effective From:<font color="red" size="2">* </font> </td>
<td class="padd"><input type="text" name="wef"> <a href="#" onClick="setYears(1947, 2020);
       showCalender(this, 'wef');">
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
			    </table></td>
</tr>
<tr>
<tr>
<td class="padd">Effective To: </td>
<td class="padd"><input type="text" name="wet" size="6"><a href="#" onClick="setYears(1947, 2020);
       showCalender(this, 'wet');">
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
			    </table></td>
</tr>
<tr>
<td class="padd">Type:<font color="red" size="2">* </font> </td>
<td class="padd"><select name="type">
	<option>Select</option>
	<option>Administration</option>
	<option>Finance</option>
	<option>Human Resources</option>
	<option>Payroll</option>
	<option>Technical</option>
	<option>Sales and Marketing</option>
	<option>Production</option>
	<option>Packaging</option>
	<option>Quality Assurance</option>
	<option>Warehouse</option>
	<option>Transport</option>
</select></td>
</tr>

<tr>
<td class="padd">BU Parent:<font color="red" size="2">* </font> </td>
<td class="padd"><select name="buparent">
	<option>Select</option>
	
</select>
</td>
</tr>
<tr><td></td><td></td></tr>
<tr>
<td colspan="2" align = "center">
<input type="submit" value="Submit"/>
</td>
</tr>
</table>
</form>
<div class="centeralign"><font color="red" size="2">* </font> - Mandatory Fields</div>





</body>
</html>