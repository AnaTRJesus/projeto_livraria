
<%@page import="br.uninove.model.Usuario"%>
<%@page import="br.uninove.model.Livro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.uninove.dao.LivroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%
   
   	//**** Criando um objeto AutorDAO
   	LivroDAO dao = new LivroDAO();
   
   	//**** Criando uma lista de autores
   	ArrayList<Livro> livros = new ArrayList<>();
   	
   	//**** A nossa lista recebe a lista
   	//**** do métod getAutores() do AutorDAO
   	livros = dao.getLivros();
   	
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
		<title>Livros</title>
		</head>
		<body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
				<div class="container">
					<a class="navbar-brand" href="index.jsp">
						Uninove Livros
					</a>
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="index.jsp">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link"  href="autores.jsp">Autores</a>
						</li>
						<li class="nav-item">
							<a class="nav-link"  href="#">Livros</a>
						</li>
					</ul>
				</div>
			</nav>
			
			<div class="container mt-3">
				<div class="alert alert-light" role="alert">
		  		<div class="row">
		  			<div class="col-md-9">
		  				<h2>Cadastro de Livros</h2>
		  				<%= usuario.getNome() %> <a href="SairServlet">Sair</a>
		  			</div>
		  			<div class="col-md-3 text-right">
		  				<a class="btn btn-success" href="novo_livro.jsp"><img src="imagens/novo32.png">&nbsp;Novo Livro</a>
		  			</div>
		  		</div>
				</div>	
				
				<div class="card shadow">
					<div class="card-body">
						<table class="table table-borderless table-hover table-sm">
							<thead>
								<tr>
									<th>Código</th>
									<th>Nome do Livro</th>
									<th>Edição</th>
									<th>Autor</th>
									<th></th>
									<th></th>
								<tr>
							</thead>
							<tbody>
							
								<% 
									for(Livro livro : livros){%>
									
									<tr>
										<th><%= String.format("%04d", livro.getCodigoLivro()) %></th>
										<td><%= livro.getTituloLivro() %></td>
										<td><%= livro.getAnoEdicao() %></td>
										<td><%= livro.getAutor().getNomeAutor() %></td>
										<td><a class="badge badge-info font-weight-normal" href="BuscaLivroServlet?codigo=<%= livro.getCodigoLivro() %>&operacao=editar">Editar</a></td>
										<td><a class="badge badge-danger font-weight-normal" href="BuscaLivroServlet?codigo=<%= livro.getCodigoLivro() %>&operacao=excluir">Excluir</a></td>
									</tr>
									
									<%}%>
								
							</tbody>
						</table>
					</div>
				</div>
				
			</div>
			
			
		</body>
		</html>


<% } %>


