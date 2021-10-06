<%@page import="com.BD.DBconnect"%>
<%@page import="com.dao.FournisseurDaoImpl"%>
<%@page import="com.entity.Fournisseur"%>
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
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body ">
						<h4 class="text-center">Update Fournisseur</h4>
						<c:if test="${not empty SuccMsg }">
							 	<p class="text-center text-success">${SuccMsg }</p>
							 	<c:remove var="succMsg" scope="session"/>
							 	</c:if>
							 	<c:if test="${not empty failedMsg }">
							 	<p class="text-center text-danger">${failedMsg }</p>
							 	<c:remove var="failedMsg" scope="session"/>
							 	</c:if>
							 	<%
							 	int id=Integer.parseInt(request.getParameter("id"));
							 	FournisseurDaoImpl dao=new FournisseurDaoImpl(DBconnect.getConn());
							 	Fournisseur f =dao.getFournisseurbyId(id);
							 	%>
							<form action="../edit_fr" method="post">
							<input type="hidden" name="id" value="<%=f.getId() %>">
							 <div class="mb-3">
   								 <label for="text" class="form-label"> Code</label>
   										 <input type="text" class="form-control"
   										  name="fcode" value="<%=f.getCode() %>" id="exampleInputEmail1"  placeholder="name" required="required">
							</div>
							  <div class="mb-3">
   								 <label for="text" class="form-label">Name</label>
   										 <input type="text" class="form-control"
   										  name="fname" value="<%=f.getName() %>" id="exampleInputEmail1"  placeholder="name" required="required">
							</div>
							 
							  <div class="mb-3">
   								 <label for="number" class="form-label">Matricule</label>
   										 <input type="text" class="form-control" value="<%=f.getMatricule_fiscale_fc() %>"
   										  name="fmatricule" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="price" required="required">
							</div>
							 <div class="mb-3">
   								 <label for="number" class="form-label">Adresse</label>
   										 <input type="text" class="form-control" value="<%=f.getAdresse() %>"
   										  name="faddresse" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="quantite" required="required">
							</div>
							
							 <div class="mb-3">
   								 <label for="number" class="form-label">Phone</label>
   										 <input type="text" class="form-control" value="<%=f.getPhone() %>"
   										  name="fphone" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="quantite" required="required">
							</div>
							
							 <div class="mb-3">
   								 <label for="number" class="form-label">Email></label>
   										 <input type="text" class="form-control" value="<%=f.getEmail_fc() %>"
   										  name="femail" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="quantite" required="required">
							</div>
							  <br>
							  
							  <button type="submit" style="" class="btn btn-primary">Udpate</button>
							</form>
					    </div>
			        </div>		
				</div>
		</div>
<div style="margin-top: 50px">
<%@include file="footer.jsp" %>
</div>
</body>
</html>