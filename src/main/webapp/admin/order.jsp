<%@page import="com.BD.DBconnect"%>
<%@page import="com.entity.Fournisseur"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.FournisseurDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All Orders</title>
<%@include file="css.jsp" %>
</head>
<body>
 	<%@include file="navbar.jsp" %>
 	<h3 class="text-center">Hello admin</h3> 
 	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
 	<canvas id="myChart" width="400" height="400"></canvas>
 	 
      
     
   
    

 	
 	

<div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>