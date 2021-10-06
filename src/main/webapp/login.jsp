<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Comm:Login</title>
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
 <H4 class="text-center"> Login Page</H4>
 	<c:if test="${not empty faildMsg }">
 		<h5 class="text-center text-danger">${faildMsg }</h5>
 		<c:remove var="failedMsg" scope="session"/>
 		</c:if>
 
 	<form action="login" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="lemail"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email" required="required">
 	<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="lpassword" class="form-control" id="exampleInputPassword1" placeholder="password" required="required">
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <div class="text-center">
   <button  type="submit" class="btn btn-primary">Submit</button>
  </div>
 
</form>
 </div>
 </div>
 </div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


<%@include file="component/footer.jsp" %>
</body>
</html>