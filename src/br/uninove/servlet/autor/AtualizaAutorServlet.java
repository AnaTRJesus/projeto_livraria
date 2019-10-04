package br.uninove.servlet.autor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.AutorDAO;
import br.uninove.model.Autor;


@WebServlet("/AtualizaAutorServlet")
public class AtualizaAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AtualizaAutorServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Autor autor = new Autor();
		autor.setCodigoAutor(Integer.parseInt(request.getParameter("txt_codigo_autor")));
		autor.setNomeAutor(request.getParameter("txt_nome_autor"));
		autor.setCidadeAutor(request.getParameter("txt_cidade_autor"));
		
		AutorDAO dao = new AutorDAO(autor);
		dao.atualizarAutor();
		
		response.sendRedirect("autores.jsp");
	
	}

}
