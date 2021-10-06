<%@page import="java.util.List"%>
<%@page import="com.entity.Client"%>
<%@page import="com.BD.DBconnect"%>
<%@page import="com.dao.ClientDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="css.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
 	<h3 class="text-center">Hello admin</h3> 
 	<h3 class="text-center">Liste Fournisseur</h3> 
 								<c:if test="${not empty SuccMsg }">
							 	<p class="text-center text-success">${SuccMsg }</p>
							 	<c:remove var="succMsg" scope="session"/>
							 	</c:if>
							 	<c:if test="${not empty failedMsg }">
							 	<p class="text-center text-danger">${failedMsg }</p>
							 	<c:remove var="failedMsg" scope="session"/>
							 	</c:if>
 	
 	<table class="table table-striped">
  <thead class="bg-primary text-white  ">
    <tr>
     <th scope="col">CODE</th>
      <th scope="col">NAME</th>
      <th scope="col">MATRICULE</th>
      <th scope="col">ADDRESSE</th>
      <th scope="col">PHONE</th>
      <th scope="col">EMAIL</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>	
  <%
  ClientDaoImpl dao=new ClientDaoImpl(DBconnect.getConn());
  List< Client >list=dao.getAllClient();
  for(Client c: list){
	  %>
	  <tr>
      <td><%=c.getCode() %></td>
      <td><%=c.getName() %></td>
      <td><%=c.getMatricule() %></td>
      <td><%=c.getAdresse() %></td>
      <td><%=c.getPhone() %></td>
      <td><%=c.getEmail_fc() %></td>
      <td>
      <a href="edit_cl.jsp?id=<%=c.getId() %>" class="btn btn-sm btn-primary">Edit</a>
      <a href="../deletc?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Delete</a>
      </td>
      
    </tr>
	  
	  <% 
  
  }  
	  %>  

  </tbody>
</table>

<div style="margin-top: 320px">
<%@include file="footer.jsp"%>
</div>
</body>
</html>