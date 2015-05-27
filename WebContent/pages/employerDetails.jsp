<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
      <link href="style.css" rel="stylesheet" type="text/css">
   
<title>Employer Details</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form method="get" action="EmployerDetailsController.do">
	<table class="center">
		<tr><td class="padd">Employer Code :</td> <td class="padd"> <input type="text" name="erCode"> </td></tr>
		<tr><td class="padd">Employer Name :</td> <td class="padd"> <input type="text" name="erName"></td></tr>
		<tr><td class="padd">Start Date :</td> <td class="padd"> <input type="text" name="startDate">
		<a href="#" onClick="setYears(1947, 2020);
       showCalender(this, 'startDate');">
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
		</td></tr>
		<tr><td class="padd">End Date :</td> <td class="padd"> <input type="text" name="endDate">
		<a href="#" onClick="setYears(1947, 2020);
       showCalender(this, 'endDate');">
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
						    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">x</font></a>
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
		<tr><td class="padd">Address Line1 :</td> <td class="padd"> <input type="text" name="addrline1"></td></tr>
		<tr><td class="padd">Address Line2 :</td> <td class="padd"> <input type="text" name="addrline2"></td></tr>
		<tr><td class="padd">Address Line3 :</td> <td class="padd"> <input type="text" name="addrline3"></td></tr>
		<tr><td class="padd">Town :</td> <td class="padd"> <input type="text" name="town"></td></tr>
		<tr><td class="padd">State :</td> <td class="padd"> <input type="text" name="state"></td></tr>
		<tr><td class="padd">Country :</td> <td class="padd"> <input type="text" name="country"></td></tr>
		<tr><td class="padd">Post Code :</td> <td class="padd"> <input type="text" name="postcode"></td></tr>
		<tr><td class="padd">Phone :</td> <td class="padd"> <input type="text" name="phone"></td></tr>
		<tr><td/></tr>
		<tr><td colspan="2" class="centeralign"><input type="submit" value="submit"></td></tr>
	</table>
</form>
</body>
</html>