<%@page import="com.entity.Bon_reception"%>
<%@page import="com.dao.BonreceptionDaoImpl"%>
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
      <th scope="col">ADDRESSE</th>
      <th scope="col">FOURNISSEUR</th>
      <th scope="col">DATE BON</th>
      <th scope="col">DATE RECEPTION</th>
      <th scope="col">MONTANT THT</th>
      <th scope="col">TVA</th>
      <th scope="col">MONTANT TTC</th>
    </tr>
  </thead>
  <tbody>
  <%
  BonreceptionDaoImpl dao=new BonreceptionDaoImpl(DBconnect.getConn());
  List< Bon_reception >list=dao.getAllbon();
  for(Bon_reception b: list){
	  %>
	  <tr>
      <td><%=b.getCodeBon() %></td>
      <td><%=b.getAdressereception() %></td>
      <td><%=b.getFornisseur() %></td>
      <td><%=b.getDatebon() %></td>
      <td><%=b.getDatereception() %></td>
      <td><%=b.getMontantHT() %></td>
      <td><%=b.getTva() %></td>
      <td><%=b.getMontantTTC() %></td>
      
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