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
a{
color: #FF0000;
}
</style>
<script type="text/javascript">
function Validate(){


	var inputs = document.getElementsByTagName('input');
    var flag = false;

    for(var i = 0; i < inputs.length; i++) {
        if(inputs[i].checked) {
            flag = true;
        }
    }

    if(!flag){
        alert("Please Select Food Items To Proceed");
        return false;
    } 
}
</script>
</head>
<body background="${pageContext.request.contextPath}/images/menu.jpg">
<center>
<b><H1>FOOD DELIVERY SYSTEM</H1></b>

<form:form method = "POST" action = "${pageContext.request.contextPath}/orderItems" modelAttribute="Resturant">
	<c:if test="${not empty foodItems}">
		<div id="restList">
			<table width="50%">
				<tr>
					<th>Serial no.</th>
					<th>Food Items</th>
					<th>Price</th>
				</tr>
				<c:forEach var="mList" items="${foodItems}" varStatus="status">
					<tr>
						<td align="center"><b>${status.count}</b></td>
						<td><b>${mList.key}</b></td>
						<td><b>${mList.value}</b></td>
						<td><form:checkbox class="checkbox" path = "orderItems" value = "${mList.key}"/></td>
					</tr>
				</c:forEach>
			<input type="hidden" id="typee" name="typee" value="${resturantType.typee}"/>
			</table>
		</div>
		</br>
		</br>
		</br>
		</br>
		</br>
		<input type="submit" name="submit" value="Continue" onclick="return Validate();"/>
	</c:if>
	</form:form>
 
</center>
</body>
</html>