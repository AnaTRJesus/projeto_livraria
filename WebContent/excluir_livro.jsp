<%@page import="br.uninove.model.Livro"%>
<%@ page import="br.uninove.model.Autor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Livro livro = new Livro();
	livro = (Livro) request.getAttribute("livro");
		
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
					<a class="nav-link"  href="livros.jsp">Livros</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<div class="container mt-3">
		<div class="alert alert-danger" role="alert">
  		<div class="row">
  			<div class="col-md-9">
  				<h2>Excluir Livro</h2>
  				<h6>ATENÇÃO! Ao confirmar a exclusão esta ação não poderá ser desfeita.</h6>
  			</div>
  			<div class="col-md-3 text-right">
  			</div>
  		</div>
		</div>	
		
		<div class="card shadow">
			<div class="card-body">
				<form method="POST" action="ExcluirLivroServlet">
					<input type="hidden" name="txt_codigo_livro" value="<%= livro.getCodigoLivro() %>"/>
					<input type="hidden" name="txt_codigo_autor" value="<%= livro.getAutor().getCodigoAutor() %>"/>
				  <div class="form-group">
				    <label for="txt_nome_autor">Nome do Livro:</label>
				    <input type="text" class="form-control" name="txt_nome_livro" id="txt_nome_livro" value="<%= livro.getTituloLivro() %>">
				  </div>
				  <div class="form-group">
				    <label for="txt_cidade_autor">Ediçao:</label>
				    <input type="text" class="form-control" name="txt_edicao_livro" id="txt_edicao_livro" value="<%= livro.getAnoEdicao() %>">
				  </div>
				  <div class="form-group">
				    <label for="txt_cidade_autor">Autor:</label>
				    <input type="text" class="form-control" name="txt_edicao_livro" id="txt_edicao_livro" value="<%= livro.getAutor().getNomeAutor() %>">
				  </div>		
				  <div class="form-group">
				    <input type="submit" class="btn btn-danger" id="formGroupExampleInput2" value="Excluir livro">
				   	<a class="btn btn-warning" href="autores.jsp">Cancelar</a>
				  </div>			  
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
        