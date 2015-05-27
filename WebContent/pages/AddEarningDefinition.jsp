<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
    <link href="style.css" rel="stylesheet" type="text/css">
<title>Earning Definition</title>
<script type="text/javascript">
            
</script>            
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form name = "earnDef" method="get" action="AddEarningDefinitionController.do" onsubmit="return validate()">
<table class="center">	
	<tr><td class="padd">Earnings Code:<font color="red" size="2">*</font></td><td class="padd"><input type="text" name="earnCode"></td></tr>
	<tr><td class="padd">Earnings Description:<font color="red" size="2">*</font></td><td class="padd"><input type="text" name="earnDesc"></td></tr>
	<tr><td class="padd">Earnings Start Date:<font color="red" size="2">*</font></td><td class="padd"><input type="text" name="earnStartDate">
	<a href="#" onClick="setYears(1901, 2020);
       showCalender(this, 'earnStartDate');">
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
			    </table>
	</td></tr>
	
	<tr><td class="padd">Earnings End Date:</td><td class="padd"><input type="text" name="earnEndDate">
	<a href="#" onClick="setYears(1901, 2020);
       showCalender(this, 'earnEndDate');">
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
			    </table>
	</td></tr>
	<tr><td class="padd">Taxability:<font color="red" size="2">*</font></td><td class="padd"><select name="earnTaxability"> <option>Pre Tax</option> <option>Post Tax</option></select></td></tr>
	<tr><td class="padd">Earnings Default Amount:</td><td class="padd"><input type="text" name="earnDfltAmount"></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td colspan="2" class="centeralign"><input type="submit" value="Add Earning"></td></tr>
</table>
</form>
</body>
</html>