<%@page import="com.entity.Facture"%>
<%@page import="com.dao.FactureDAOImpl"%>
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
 	<h3 class="text-center">Liste Facture Client</h3> 
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
      <th scope="col">CLIENT</th>
      <th scope="col">ADDRESSE</th>
      <th scope="col">DATE</th>
      <th scope="col">MONTANT THT</th>
      <th scope="col">TVA</th>
      <th scope="col">MONTANT TTC</th>
    </tr>
  </thead>
  <tbody>
  <%
  FactureDAOImpl dao=new FactureDAOImpl(DBconnect.getConn());
  List< Facture >list=dao.getAllfacture();
  for(Facture f: list){
	  %>
	  <tr>
      <td><%=f.getCodefacture() %></td>
      <td><%=f.getClient() %></td>
      <td><%=f.getAdresse() %></td>
      <td><%=f.getDate() %></td>
      <td><%=f.getMontantHT() %></td>
      <td><%=f.getTva() %></td>
      <td><%=f.getMontantTTC() %></td>
      
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