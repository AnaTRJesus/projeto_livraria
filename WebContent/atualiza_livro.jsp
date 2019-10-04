<%@page import="br.uninove.model.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.uninove.dao.AutorDAO"%>
<%@ page import="br.uninove.model.Livro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	//**** Criando um objeto AutorDAO
	AutorDAO dao = new AutorDAO();

	//**** Criando uma lista de autores
	ArrayList<Autor> autores = new ArrayList<>();
	
	//**** A nossa lista recebe a lista
	//**** do métod getAutores() do AutorDAO
	autores = dao.getAutores();
	
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
		<div class="alert alert-warning" role="alert">
  		<div class="row">
  			<div class="col-md-9">
  				<h2>Atualização de Livros</h2>
  				<h6>Mantenha os dados do livro atualizados.</h6>
  			</div>
  			<div class="col-md-3 text-right">
  			</div>
  		</div>
		</div>	
		
		<div class="card shadow">
			<div class="card-body">
				<form method="POST" action="AtualizaLivroServlet">
					<input type="hidden" name="txt_codigo_livro" value="<%= livro.getCodigoLivro() %>"/>
				  	<div class="form-group">
				    <label for="txt_nome_autor">Nome do Livro:</label>
				    <input type="text" class="form-control" name="txt_nome_livro" id="txt_nome_livro" value="<%= livro.getTituloLivro() %>">
				  </div>
				  <div class="form-group">
				    <label for="txt_cidade_autor">Ediçao:</label>
				    <input type="text" class="form-control" name="txt_edicao_livro" id="txt_edicao_livro" value="<%= livro.getAnoEdicao() %>">
				  </div>
				  <div class="form-group">
				    <label for="txt_cidade_autor">Autores:</label>
				    <br>
					<select  id="autorSelecionado" name="autorSelecionado">
					
						<% 
							for(Autor autor : autores){%>
									
								<option  value="<%= autor.getCodigoAutor() %>"><%= autor.getNomeAutor()%></option>
									
							<%}%>

					</select>
				  </div>				  			  	
				  <div class="form-group">
				    <input type="submit" class="btn btn-success" id="formGroupExampleInput2" value="Atualizar livro">
				   	<a class="btn btn-warning" href="livros.jsp">Cancelar</a>
				  </div>				  
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
        