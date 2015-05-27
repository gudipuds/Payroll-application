<%@page import="com.adp.data.Deduction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<script language="javaScript" type="text/javascript" src="calendar/calendar.js"></script>
   <link href="calendar/calendar.css" rel="stylesheet" type="text/css">
    <link href="style.css" rel="stylesheet" type="text/css">
<title>Update Deduction</title>
<script type="text/javascript">
function getDetails() {
	var ecode = document.getElementById("dCode");
	var name= ecode.options[ecode.selectedIndex].text;
	window.location = "getDeductionController.do?name="+name;

	return true;
}
</script>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
	<form action = "updateDeductionController.do">
		<% Deduction ded = (Deduction)request.getAttribute("obj");
					if(ded == null)
					{
						ded = new Deduction();
					}
			%>
		<table class="center">
			<tr>
				<td class="padd">Deduction Code:</td>
				<td class="padd">
					<select id="dCode" name="dCode" onchange="return getDetails()">
						<option>Select</option>		
						<adp:getDedCodes></adp:getDedCodes>
					</select>
				</td>
			</tr>
			<tr><td>Deduction Code :</td> <td> <input type="text" name= "dedCode" value ="<%= ded.getDedCode() %>" readonly="readonly"> </td></tr>
			<tr><td class="padd">DED_DESC</td><td class="padd"><input type="text" name ="deddesc" value="<%= ded.getDedDesc()%>" /></td></tr>
			<tr><td class="padd">DedStartDate</td><td class="padd"><input type = "text" name = "sdate" value="<%=ded.getDedStartDate()%>"/>
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
<tr><td class="padd">DedEndDate</td><td class="padd"><input type = "text" name = "edate" value="<%=ded.getDedEndDate()%>" />
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
			<tr><td class="padd">DEFAULT AMOUNT</td><td class="padd"><input type="text" name = "dfltamt" value="<%= ded.getDedDfltAmount()%>"></td></tr>
			<tr><td></td></tr>
			<tr><td class="center" colspan="2"><input type="submit" value = "Update Ded Code"/></td></tr>
		</table>
	</form>
</body>
</html>