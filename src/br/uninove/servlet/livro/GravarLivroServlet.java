package br.uninove.servlet.livro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.uninove.dao.LivroDAO;
import br.uninove.model.Autor;
import br.uninove.model.Livro;

/**
 * Servlet implementation class GravarLivroServlet
 */
@WebServlet("/GravarLivroServlet")
public class GravarLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GravarLivroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livro livro = new Livro();
		Autor autor = new Autor();

		livro.setTituloLivro(request.getParameter("txt_nome_livro"));
		livro.setAnoEdicao(request.getParameter("txt_edicao_livro"));
		autor.setCodigoAutor(Integer.parseInt(request.getParameter("autorSelecionado")));
		livro.setAutor(autor);
		
		LivroDAO dao = new LivroDAO(livro);
		dao.gravarLivro();
		
		response.sendRedirect("livros.jsp");
	}

}
