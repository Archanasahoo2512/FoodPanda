<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FOOD DELIVERY SYSTEM</title>
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

marquee {
	font-size: 30px;
	font-weight: 800;
	color: #FF0000;
	font-family: sans-serif;
}

a {
	color: #FF0000;
}
</style>
</head>
<body
	background="${pageContext.request.contextPath}/images/dashboard.jpg">
	<center>
		<b><H1>FOOD DELIVERY SYSTEM</H1></b>
		



		<marquee>10% discount valid till July 20Th</marquee>


		<div class="tab">
			<button class="tablinks" onclick="openCity(event, 'Searchcriteria')">Browse
				Food</button>

		</div>

		<div id="Searchcriteria" class="tabcontent">
			<div>
				<b><a href="${pageContext.request.contextPath}/orderFoodLocation">Location Wise</a></b><br>
				 <b><a href="${pageContext.request.contextPath}/orderFoodRating">Rating Wise</a></b><br>
				  <b><a href="#">Price Range Wise</a></b><br>
				   <input type="hidden" id="mobileNumber" name="mobileNumber" value="${mobile}" />
	

			</div>
		</div>






		<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}


</script>
		<br> <br> <br> <br> <b><a
			href="/FoodDeliverySystem/">Back</a></b>

	</center>
</body>
</html>