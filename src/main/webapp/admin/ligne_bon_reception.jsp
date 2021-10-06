<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
<body style="background-color:#f0f2f2 ">
	<%@include file="navbar.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body ">
						<h4 class="text-center">Add LigneBon</h4>
						<c:if test="${not empty SuccMsg }">
							 	<p class="text-center text-success">${SuccMsg }</p>
							 	<c:remove var="succMsg" scope="session"/>
							 	</c:if>
							 	<c:if test="${not empty failedMsg }">
							 	<p class="text-center text-danger">${failedMsg }</p>
							 	<c:remove var="failedMsg" scope="session"/>
							 	</c:if>
							 	
							<form action="../ligne_bon_reception" method="post" enctype="multipart/form-data">
							<div class="mb-3">
   								 <label for="text" class="form-label"> code</label>
   										 <input type="text" class="form-control"
   										  name="fcodeligne" id="exampleInputEmail1"  placeholder="code" required="required">
							</div>
							 <br>
							  <div class="md-3">
							    <label for="inputState">Code Bon</label> 
							    <br>
							    <select
							    id="inputState" name="fcodebon" class="form-control text-center" onchange="showState(this.value)">
							    <option selected >---Select---</option>
							    <%
							   try{
								   
								   String Query="select * from bon_reception";
								   Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomjee","root","");
									Statement stm=conn.createStatement();
									ResultSet rs=stm.executeQuery(Query);
									System.out.println(rs);
									while(rs.next()){
	
									%>
										<option <%=rs.getString("id")%>><%=rs.getString("id") %> </option>
									
									<%
									
									}
									}
							  
							    catch(Exception e){
							    	
							    	e.printStackTrace();
							    	System.out.println("erreeer"+e.getMessage());
							    }
							    %> 
							  </select>
							</div>
							  <br>
							  <div class="mb-3">
   								 <label for="text" class="form-label"> Name</label>
   										 <input type="text" class="form-control"
   										  name="fname" id="exampleInputEmail1"  placeholder="name" required="required">
							</div>
							 
							  <div class="mb-3">
   								 <label for="number" class="form-label">prix</label>
   										 <input type="number" class="form-control"
   										  name="fprice" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="price" required="required">
							</div>
							 <div class="mb-3">
   								 <label for="number" class="form-label">Quantite</label>
   										 <input type="text" class="form-control"
   										  name="fquantite" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="quantite" required="required">
							</div>
							<div class="mb-3">
   								 <label for="number" class="form-label">TVA</label>
   										 <input type="text" class="form-control"
   										  name="ftva" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="tva" required="required">
							</div>
							<br>
							 <div class="md-3">
							    <label for="inputState">Category</label> 
							    <br>
							    <select
							    id="inputState" name="fcategory" class="form-control text-center">
							    <option selected>---Select---</option>
							    <option value="New"  style="text-center">New Product</option>
							    <option value="old"  style="text-center">Old Product</option>
							  </select>
							  </div>
							  <br>
							 
							  <button type="submit" class="btn btn-primary">Add</button>
							</form>
					    </div>
			        </div>		
				</div>
		</div>
</div>
<div style="margin-top: 50px">
<%@include file="footer.jsp" %>
</div>
</body>
</html>