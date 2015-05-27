<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel ="stylesheet" type ="text/css" href="style.css"/>
<title>Calculate Payrun</title>
</head>
<body>
<form action="PayrunEmployeeController.do">
<table class="center">

 <tr><td class="padd">Pay Frequency:</td><td class="padd"><select name="payFrequency">
	                                  <option>Select</option>
	                                   <option> Monthly</option>
	                                    
	                                 </select>
	                                 </td></tr>
<tr><td class="padd">Tax Year</td><td class="padd"><input type="text" name="taxYear">
<tr><td class="padd">Pay Period:</td><td class="padd"><select name="payPeriod">
	                                  <option>1</option>
	                                   <option> 2</option>
	                                    <option>3</option>
	                                    <option>4</option>
	                                   <option> 5</option>
	                                    <option>6</option>
	                                    <option>7</option>
	                                   <option> 8</option>
	                                    <option>9</option>
	                                    <option>10</option>
	                                   <option> 11</option>
	                                    <option>12</option>
	                                 </select>
	                                 </td></tr>
   
   <tr></tr>
   <tr><td colspan="2" class="centeralign"><input type="submit" value="Calculate Payrun"></td></tr>
</table>                                 
</form>                                 
</body>
</html>