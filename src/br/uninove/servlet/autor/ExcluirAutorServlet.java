package br.uninove.servlet.autor;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.AutorDAO;
import br.uninove.model.Autor;

@WebServlet("/ExcluirAutorServlet")
public class ExcluirAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirAutorServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Autor autor = new Autor();
		autor.setCodigoAutor(Integer.parseInt(request.getParameter("txt_codigo_autor")));
		
		AutorDAO dao = new AutorDAO(autor);
		dao.excluirAutor();
		
		response.sendRedirect("autores.jsp");
	}

}
