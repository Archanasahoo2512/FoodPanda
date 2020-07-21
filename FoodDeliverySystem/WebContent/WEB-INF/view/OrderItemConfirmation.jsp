<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.foodDeliverySystem.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FOOD DELIVERY SYSTEM</title>

<script>
	
</script>
<style>
a {
	color: #FF0000;
}
</style>
<script type="text/javascript">
	function showForm() {
		var val = document.getElementById("susscess").value;
		if (val) {
			document.getElementById("contacts").style.display = "none";
		}
	}


function Validate(){
	var name = document.getElementById("name").value;
	var address = document.getElementById("address").value;
	
	if(name==""){
		alert("Please Enter name to Place Order");
		return false;
	}

	if(address==""){
		alert("Please Enter address to Place Order");
		return false;
	}
	return true;
}
</script>
</head>
<body background="${pageContext.request.contextPath}/images/ordered.jpg"
	onload="showForm();">
	<center>
		<b><H1>FOOD DELIVERY SYSTEM</H1></b> <b><H3>Confirm and Place
				order</H3></b>

		<c:if test="${not empty SuccesfullMsg}">
			<div id="SuccesfullMsg"><h3>${SuccesfullMsg}</h3></div>
			<input type="hidden" id="susscess" value=${SuccesfullMsg } />
		</c:if>

		<c:if test="${not empty orderFood}">
			<div id="restList">
				<table width="50%">
					<tr>
						<th>Serial no.</th>
						<th>Food Items</th>
						<th>Price</th>
					</tr>
					<c:forEach var="mList" items="${orderFood}" varStatus="status">
						<tr>
							<td align="center"><b>${status.count}</b></td>
							<td><b>${mList.key}</b></td>
							<td><b>${mList.value}</b></td>
						</tr>
					</c:forEach>

				</table>
			</div>

		</c:if>
		<form action="${pageContext.request.contextPath}/orderFinalItems"
			method="post" id="contacts">
			<div id="custList">
				<table>
					<tr>
						<td><b><label>Mobile</label></b></td>
						<td><label>${MobileNumber}</label></td>
					</tr>
					<tr>
						<td><b><label>Name</label></b></td>
						<td><input type="text" id="name" name="name" maxlength="10" /></td>
					</tr>
					<tr>
						<td><b><label>Address</label></b></td>
						<td><textarea id="address" name="address" rows="4" cols="50"
								maxlength="100"></textarea></td>
					</tr>
					<tr>
						<td><b><label>Total Price</label></b></td>
						<td><label>${TotalPrice}</label></td>
					</tr>
					<tr>

						<td><input type="Submit" value="Place Order" onclick="return Validate();"/></td>
					</tr>
				</table>
			</div>
		</form>

	</center>
</body>
</html>