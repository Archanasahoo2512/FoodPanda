<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FOOD DELIVERY SYSTEM</title>
<script>
	function Validate() {

		
		    var mob = /^[1-9]{1}[0-9]{9}$/;
		    var txtMobile = document.getElementById("mobileNumber");
		      if (mob.test(txtMobile.value) == false) {
		        alert("Please enter valid mobile number.");
		        txtMobile.focus();
		        document.getElementById("mobileNumber").value="";
		        return false;
		    }
		    return true;
		
	}
</script>
</head>
<body background="${pageContext.request.contextPath}/images/food1.jpg">
 
	<center>
		<b><H1 style="color:#FFFFFF";>FOOD DELIVERY SYSTEM</H1></b>
	
	<H2 style="color:#FFFFFF";>Login to Order</H2>
	<form action="/FoodDeliverySystem/loginSubmit" method="post">
		<table>
			<tr>
				<td><b><label style="color:#FFFFFF";>Mobile Number</label></b></td>
				<td><input type="text" id="mobileNumber" name="mobileNumber" maxlength="10"/></td>
			</tr>
			<td><b><label style="color:#FFFFFF";>Login</label></b></td>
			<td><input type="submit" name="submit" onclick="return Validate();"/></td>
		</table>
	</form>
	</center>
</body>
</html>