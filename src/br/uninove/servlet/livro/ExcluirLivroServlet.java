package br.uninove.servlet.livro;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.LivroDAO;
import br.uninove.model.Livro;

@WebServlet("/ExcluirLivroServlet")
public class ExcluirLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirLivroServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livro livro = new Livro();

		livro.setCodigoLivro(Integer.parseInt(request.getParameter("txt_codigo_livro")));
		
		LivroDAO dao = new LivroDAO(livro);
		dao.excluirLivro();
		
		response.sendRedirect("livros.jsp");
	}

}
