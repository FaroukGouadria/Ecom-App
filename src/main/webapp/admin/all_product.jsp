<%@page import="java.util.List"%>
<%@page import="com.entity.Product"%>
<%@page import="com.BD.DBconnect"%>
<%@page import="com.dao.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: All product</title>
<%@include file="css.jsp" %>
</head>
<body>
 	<%@include file="navbar.jsp" %>
 	<h3 class="text-center">Hello admin</h3> 
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
     <th scope="col">ID</th>
      <th scope="col">IMAGE</th>
      <th scope="col">NAME</th>
      <th scope="col">Price</th>
      <th scope="col">QUANTITE</th>
      <th scope="col">CATEGORY</th>
       <th scope="col">FOURNISSEUR</th>
      <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  <%
  ProductDaoImpl dao=new ProductDaoImpl(DBconnect.getConn());
  List<Product>list=dao.getAllproducts();
  for(Product p: list){
	  %>
	  <tr>
      <th><%=p.getId() %></th>
      <td><img src="../product/<%=p.getPhoto()%>" style="width: 50px";height="50px;"></td>
      <td><%=p.getName() %></td>
      <td><%=p.getPrice() %></td>
      <td><%=p.getQuantite() %></td>
      <td><%=p.getCategory() %></td>
      <td><%=p.getFornisseur() %></td>
      <td>
      <a href="edit_prod.jsp?id=<%=p.getId()%>" class="btn btn-sm btn-primary">Edit</a>
      <a href="../delete?id=<%=p.getId() %>" class="btn btn-sm btn-danger">Delete</a>
      </td>
      
    </tr>
	  
	  <% 
  
  }  
	  %>  

  </tbody>
</table>

<div style="margin-top: 320px">
<%@include file="footer.jsp" %>
</div>
</body>
</html>