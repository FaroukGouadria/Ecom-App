<%@page import="com.BD.DBconnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecom</title>
<%@include file="component/css.jsp" %>
<style type="text/css">
.back-img{
background: url("img/background");
height: 60vh;
width: 100%;
background-size: cover;
background-repeat: no-repeat;
}
.crd-ho:hover{
background-color: #f7f7f7
}
</style>
</head>
<body style="background-color: #f7f7f7">
<%@include file="component/navbar.jsp" %>
<div class="container-fluid back-img">
<h2 class="text-center text-danger">Gestion de Vente et Achat</h2>
</div>

<%@include file="component/footer.jsp" %>
</body>
</html>