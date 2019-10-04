<%@ page import="br.uninove.model.Autor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	Autor autor = new Autor();
	autor = (Autor) request.getAttribute("autor");
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Autores</title>
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
  				<h2>Excluir Autor</h2>
  				<h6>ATENÇÃO! Ao confirmar a exclusão esta ação não poderá ser desfeita.</h6>
  			</div>
  			<div class="col-md-3 text-right">
  			</div>
  		</div>
		</div>	
		
		<div class="card shadow">
			<div class="card-body">
				<form method="POST" action="ExcluirAutorServlet">
					<input type="hidden" name="txt_codigo_autor" value="<%= autor.getCodigoAutor() %>"/>
				  <div class="form-group">
				    <label for="txt_nome_autor">Nome do autor:</label>
				    <input type="text" class="form-control" name="txt_nome_autor" id="txt_nome_autor" value="<%= autor.getNomeAutor() %>">
				  </div>
				  <div class="form-group">
				    <label for="txt_cidade_autor">Cidade do Autor:</label>
				    <input type="text" class="form-control" name="txt_cidade_autor" id="txt_cidade_autor" value="<%= autor.getCidadeAutor() %>">
				  </div>	
				  <div class="form-group">
				    <input type="submit" class="btn btn-danger" id="formGroupExampleInput2" value="Excluir autor">
				   	<a class="btn btn-warning" href="autores.jsp">Cancelar</a>
				  </div>			  
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
        