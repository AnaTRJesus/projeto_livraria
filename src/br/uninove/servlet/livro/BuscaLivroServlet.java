package br.uninove.servlet.livro;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.LivroDAO;
import br.uninove.model.Livro;


@WebServlet("/BuscaLivroServlet")
public class BuscaLivroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscaLivroServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String operacao = request.getParameter("operacao");
		String destino = "";
		
		if (operacao.equals("editar")) {
			destino = "atualiza_livro.jsp";
		} else {
			destino = "excluir_livro.jsp";
		}
		
		LivroDAO livroDAO = new LivroDAO();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		Livro livro = livroDAO.getLivro(codigo);
		
		request.setAttribute("livro", livro);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
	}

}










