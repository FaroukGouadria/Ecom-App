<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
<title>Admin:Facture Client</title>
<%@include file="css.jsp" %>
</head>
<body>
	<body style="background-color:#f0f2f2 ">
	<%@include file="navbar.jsp" %>
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body ">
						<h4 class="text-center">Facture Client</h4>
						<c:if test="${not empty SuccMsg }">
							 	<p class="text-center text-success">${SuccMsg }</p>
							 	<c:remove var="succMsg" scope="session"/>
							 	</c:if>
							 	<c:if test="${not empty failedMsg }">
							 	<p class="text-center text-danger">${failedMsg }</p>
							 	<c:remove var="failedMsg" scope="session"/>
							 	</c:if>
							 	
							<form action="../add_facture" method="post" enctype="multipart/form-data">
							  <div class="mb-3">
   								 <label for="text" class="form-label"> Code Facture</label>
   										 <input type="text" class="form-control"
   										  name="fcode" id="exampleInputEmail1"  placeholder="Code" required="required">
							</div>
							 <div class="md-3">
							    <label for="inputState">Client</label> 
							    <br>
							    <select
							    id="inputState" name="fclient" class="form-control text-center" onchange="showState(this.value)">
							    <option selected >---Select---</option>
							    <%
							   try{
								   
								   String Query="select * from client";
								   Class.forName("com.mysql.cj.jdbc.Driver");
									Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomjee","root","");
									Statement stm=conn.createStatement();
									ResultSet rs=stm.executeQuery(Query);
									System.out.println(rs);
									while(rs.next()){
	
									%>
										<option value="<%=rs.getString("name") %>"><%=rs.getString("name") %> </option>
									
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
							  <label for="inputState">Date Facture</label> 
							  <br>
							  <div class="input-group date md-3" data-provide="datepicker">
  								<input type="date" class="form-control" name="fdate">
								    <div class="input-group-addon">
								        <span class="glyphicon glyphicon-th"></span>
								    </div>
								</div>
								<br>
							  <div class="mb-3">
   								 <label for="text" class="form-label">Addresse</label>
   										 <input type="text" class="form-control"
   										  name="faddresse" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Addresse" required="required">
							</div>
							 <div class="mb-3">
   								 <label for="number" class="form-label">Montant HT</label>
   										 <input type="text" class="form-control"
   										  name="fmtht" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mttc" required="required">
							</div>
							  <div class="mb-3">
   								 <label for="number" class="form-label">TVA</label>
   										 <input type="text" class="form-control"
   										  name="ftva" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Tva" required="required">
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