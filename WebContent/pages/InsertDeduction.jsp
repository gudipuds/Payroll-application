<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
    <link href="style.css" rel="stylesheet" type="text/css">
<title>Insert Deduction</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form action = "insertDeductionController.do">
<h1 class="centeralign">Deduction Details</h1>
<table class="center">
<tr><td class="padd">DedCode</td><td class="padd"><input type = "text" name = "dedcode" /></td></tr>
<tr><td class="padd">DedDesc</td><td class="padd"><input type = "text" name = "deddesc" /></td></tr>
<tr><td class="padd">DedStartDate</td><td class="padd"><input type = "text" name = "sdate" />
<a href="#" onClick="setYears(1901, 2020);
       showCalender(this, 'sdate');">
      <img src="calendar/calender.png"></a>

			    <table id="calenderTable">
			        <tbody id="calenderTableHead">
			          <tr>
			            <td colspan="4" align="center">
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
			            </td>
			            <td colspan="2" align="center">
						    <select onChange="showCalenderBody(createCalender(this.value, 
							document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
							</select>
						</td>
			            <td align="center">
						    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
						</td>
					  </tr>
			       </tbody>
			       <tbody id="calenderTableDays">
			         <tr style="">
			           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
			         </tr>
			       </tbody>
			       <tbody id="calender"></tbody>
			    </table></td></tr>
<tr><td class="padd">DedEndDate</td><td class="padd"><input type = "text" name = "edate" />
<a href="#" onClick="setYears(1901, 2020);
       showCalender(this, 'edate');">
      <img src="calendar/calender.png"></a>

			    <table id="calenderTable">
			        <tbody id="calenderTableHead">
			          <tr>
			            <td colspan="4" align="center">
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
			            </td>
			            <td colspan="2" align="center">
						    <select onChange="showCalenderBody(createCalender(this.value, 
							document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
							</select>
						</td>
			            <td align="center">
						    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
						</td>
					  </tr>
			       </tbody>
			       <tbody id="calenderTableDays">
			         <tr style="">
			           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
			         </tr>
			       </tbody>
			       <tbody id="calender"></tbody>
			    </table></td></tr>
<tr><td class="padd">Type ee er code:</td>
	<td class="padd">
		<select name="type" > 
				<option>Employee deduction</option> 
				<option>Employer contribution</option>
		</select>		
		</td>
	</tr>
<tr><td class="padd">Taxability*:</td>
		<td class="padd"> 
			<select name="taxability" > 
				<option>Pre Tax</option> 
				<option>Post Tax</option>
			</select>
		</td>
	</tr>
 <tr><td class="padd">Default Amount</td><td class="padd"><input type = "text" name = "amt" /></td></tr>
<tr><td colspan="2" class="centeralign"><input type = "submit" value = "INSERT"></td></tr>
</table>
</form>
</body>
</html>