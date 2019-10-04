<%@ page import="br.uninove.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) request.getSession().getAttribute("usuario");
	
	if (usuario == null){
		response.sendRedirect("login.html");
	} else {
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Uninove Livros</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">
				Uninove Livros
			</a>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="#">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link"  href="autores.jsp">Autores</a>
				</li>
				<li class="nav-item">
					<a class="nav-link"  href="livros.jsp">Livros</a>
				</li>
			</ul>
		</div>
	</nav>
	
			  				<%= usuario.getNome() %> <a href="SairServlet">Sair</a>
	
	
</body>
</html>

<% } %>