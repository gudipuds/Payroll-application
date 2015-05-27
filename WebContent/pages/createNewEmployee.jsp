<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Employee</title>
<script type="text/javascript" src = "validate.js">

</script>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
<form name = "empform" action = "AddEmployeeController.do">
<table class="center">
		<tr> <td class="padd">Employee Code :</td> <td> <input type="text" name="empCode" onblur = " return validatecode()" > </td><td><span id="empcode"></span></td></tr>
		<tr><td class="padd">Last Name :</td> <td> <input type="text" name="lastName" onblur = " return validatelname()" > </td><td><span id="lnamecode"></span></td></tr>
		<tr><td class="padd">Middle Name :</td> <td> <input type="text" name="middleName" onblur = "return middlename()"> </td><td><span id="mnamecode"></span></td></tr>
		<tr><td class="padd">First Name :</td> <td> <input type="text" name="firstName" onblur = "return firstname()"> </td><td><span id="fnamecode"></span></td></tr>
		<tr><td class="padd"> Title : </td> <td> <input type="text" name="title" onblur = "return title()"> </td><td><span id="titlecode"></span></td></tr>
		<tr><td class="padd">Birth Date :</td> <td> <input type="text" name="birthDate" onblur = "return birth()"> 
		<a href="#" onClick="setYears(1901, 2020);
       showCalender(this, 'birthDate');">
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
		</td><td><span id="birthcode"></span></td></tr>
		<tr> <td class="padd"> Gender :</td><td><input type="radio" name="gender" value="M" />  Male</td> </tr>
		<tr><td></td> <td><input type="radio" name="gender" value="F" /> Female </td></tr>
		<tr> <td class="padd"> Marital Status :</td><td><input type="radio" name="maritalStatus" value="single" />  Single</td> </tr>
		<tr><td></td> <td><input type="radio" name="maritalStatus" value="married" /> Married </td></tr>
		<tr><td class="padd">Nationality :</td> <td> <input type="text" name="nationality" onblur = "return nationality()"> </td><td><span id="nation"></span></td></tr>
		<tr><td class="padd">Address Line1 :</td> <td> <input type="text" name="addln1" onblur = "return addln1()"></td><td><span id="adress1"></span></td></tr>
		<tr><td class="padd">Address Line2 :</td> <td> <input type="text" name="addln2" onblur = "return addln2()"></td><td><span id="adress2"></span></td></tr>
		<tr><td class="padd">Town :</td> <td> <input type="text" name="town" onblur = "return town()"></td><td><span id="town"></span></td></tr>
		<tr><td class="padd">State :</td> <td> <input type="text" name="state" onblur = "return state()"></td><td><span id="state"></span></td></tr>
		<tr><td class="padd">Post Code :</td> <td> <input type="text" name="postcode" onblur = "return postcode()"></td><td><span id="postcode"></span></td></tr>
		<tr><td class="padd">Phone :</td> <td> <input type="text" name="phone" onblur = "return phone()"></td><td><span id="phone"></span></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td colspan="2" class="centeralign"><input type="submit" value="create Employee"></td></tr>
</table>
</form>		
</body>
</html>