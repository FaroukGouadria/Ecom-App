<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Comm:Register</title>
<%@include file="component/css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="component/navbar.jsp" %>
<div class="container p-2">
<div class="row">
 <div class="col-md-4 offset-md-4">
 <div class="card">
 </div>
 <div class="card-body">
 <H4 class="text-center"> Registartion Page</H4>
 
 	<c:if test="${not empty succMsg }">
 	<p class="text-center text-success">${succMsg }</p>
 	<c:remove var="succMsg" scope="session"/>
 	</c:if>
 	<c:if test="${not empty failedMsg }">
 	<p class="text-center text-danger">${failedMsg }</p>
 	<c:remove var="failedMsg" scope="session"/>
 	</c:if>

 	<form action="register" method="post" >
 	<div class="mb-3">
    <label for="text" class="form-label">Enter Full name</label>
    <input type="text" class="form-control" name="fname" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="name" required="required">
    
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="femail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"required="required">
 	<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter your Phone Number </label>
    <input type="number" name="fphone" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="phone"required="required">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password"  name="fpassword" class="form-control" id="exampleInputPassword1" placeholder="password"required="required">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="fcheck">
    <label class="form-check-label"  for="exampleCheck1">Agree terme & Condition</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
 </div>
 </div>
 </div>
</div>
<%@include file="component/footer.jsp" %>
</body>
</html>