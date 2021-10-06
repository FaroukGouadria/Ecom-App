<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
             <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Home</title>
<%@include file="css.jsp" %>
<style type="text/css">
a{
text-decoration: none;

}
a:hover{
text-decoration: none;

}

</style>
</head>
<body>
<%@include file="navbar.jsp" %>
<h1></h1>

<div class="container">
	<div class="row p-5">
		<div class="col-md-3">
		<a href="add_product.jsp">
			<div class="card">
				<div class="card-body text-center text-primary">
					<i class="fas fa-plus-square fa-3x"></i><br>
					<h4 >Add Product</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
		
		<div class="col-md-3">
			<a href="all_product.jsp">
			<div class="card">
				<div class="card-body text-center text-danger">
					<i class="fab fa-product-hunt fa-3x"></i></i><br>
					<h4 >All Products</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
		<div class="col-md-3">
		<a href="add_fournisseur.jsp">
			<div class="card">
				<div class="card-body text-center text-pink" style="color:purple; ">
				<i class="far fa-address-card fa-3x"></i>
					<br>
					<h4 >FOURNISSEUR</h4>
					---------------
				</div>
			</div>
			</a>
		</div>

		<div class="col-md-3">
		<a href="add_client.jsp">
			<div class="card">
				<div class="card-body text-center text-orange " style="color:orange; ">
					<i class="fas fa-user-plus fa-3x"></i><br>
					<h4 >CLIENT</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
				<hr>
		<div class="col-md-3">
		<a href="add_facture.jsp">
			<div class="card">
				<div class="card-body text-center text-purple" style="color:fuchsia; ">
				<i class="fas fa-file-invoice-dollar fa-3x"></i>
					<br>
					<h4 >FACTURE</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
		
		<div class="col-md-3">
		<a href="bon_reception.jsp">
			<div class="card">
				<div class="card-body text-center text-secondary">
				<i class="fas fa-notes-medical fa-3x"></i><br>
					<h4 >BON RECEPTION</h4>
					---------------
				</div>
			</div>
			</a>
		</div>	

	<div class="col-md-3">
		<a href="all_client.jsp">
			<div class="card">
				<div class="card-body text-center text-cyan" style="color:lime; ">
				<i class="fas fa-user-friends fa-3x"></i><br>
				
					<h4 >All Client</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
		
		<div class="col-md-3">
		<a href="all_fournisseur.jsp">
			<div class="card">
				<div class="card-body text-center text-info ">
					<i class="fas fa-users fa-3x"></i><br>
					<h4 >All fornisseur</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
				<hr>
		<div class="col-md-3">
		<a href="ligne_bon_reception.jsp">
			<div class="card">
				<div class="card-body text-center text-maroon" style="color:maroon;">
					<i class="fas fa-receipt fa-3x"></i><br>
					<h4 >ligne bon</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
		<div class="col-md-3">
		<a href="ligne_facture_client.jsp">
			<div class="card">
				<div class="card-body text-center text-navy" style="color:navy;">
					<i class="fas fa-keyboard fa-3x	"></i><br>
					<h4 >ligne Facture</h4>
					---------------
				</div>
			</div>
			</a>
		</div>

			<div class="col-md-3">
		<a href="allfacture.jsp">
			<div class="card">
				<div class="card-body text-center text-teal" style="color:teal;">
					<i class="fas fa-file-alt fa-3x"></i><br>
					<h4 >All Facture</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
			<div class="col-md-3">
		<a href="allbon.jsp">
			<div class="card">
				<div class="card-body text-center text-silver" style="color:silver;">
					<i class="fas fa-calculator fa-3x"></i><br>
					<h4 >All Bon</h4>
					---------------
				</div>
			</div>
			</a>
		</div>
	</div>
</div>


	
</body>
<div style="margin-top: 250px"">
<%@include file="footer.jsp" %>
</div>

</html>