<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="/WEB-INF/tlds/empCodes.tld" prefix="adp"%>
<link href="style.css" rel="stylesheet" type="text/css">
<title>Deduction Delete</title>
</head>
<body>
<%@include file="/login/links.html" %>
<br/>
<br/>
	<form method="get"  action = "deleteDeductionController.do">
		<table class="center">
			<tr>
				<td class="padd">Employee Code:</td>
				<td class="padd">
					<select name="eCode">
						<option>Select</option>		
						<adp:getDedCodes></adp:getDedCodes>
					</select>
				</td>
			</tr>
			<tr><td></td></tr>
		<tr><td class="centeralign" colspan="2">
		<input type="submit" value = "Delete Ded Code"/>
		</td>
		</tr>
		</table>
	</form>
</body>
</html>