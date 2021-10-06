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
<title>Admin:edit product</title>
<%@include file="css.jsp" %>

</head>
<body style="background-color:#f0f2f2 ">
	<%@include file="navbar.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body ">
						<h4 class="text-center">Update Product</h4>
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
							 	ProductDaoImpl dao=new ProductDaoImpl(DBconnect.getConn());
							 	Product p =dao.getBookbyId(id);
							 	%>	
							<form action="../edit_prod" method="post" >
								<input type="hidden" name="id" value="<%=p.getId() %>">
							  <div class="mb-3">
   								 <label for="text" class="form-label"> Name</label>
   										 <input type="text" class="form-control"
   										  name="fname" id="exampleInputEmail1"  placeholder="name" required="required" value="<%=p.getName()%>">
							</div>
							 
							  <div class="mb-3">
   								 <label for="number" class="form-label">Price</label>
   										 <input type="number" class="form-control"
   										  name="fprice" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="price" required="required" value="<%=p.getPrice()%>">
							</div>
							 <div class="mb-3">
   								 <label for="number" class="form-label">Quantite</label>
   										 <input type="text" class="form-control"
   										  name="fquantite" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="quantite" required="required" value="<%=p.getQuantite()%>">
							</div>
							 <div class="md-3">
							    <label for="inputState">Category</label> <select
							    id="inputState" name="fcategory" class="form_control">
							    <%
							    if("new".equals(p.getCategory())){
							    	%>
							    	
							    	<option value="New">New</option>
							    	<option value="old">old</option>
							    	<%
							    }else{
							    	%>
							    	<option value="old">old</option>
							    	<option value="New">New</option>
							    	<%
							    }
							    	%>
							  </select>
							  </div>
							  <br>
							  <button type="submit" class="btn btn-primary">Update</button>
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