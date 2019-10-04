package br.uninove.servlet.autor;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.AutorDAO;
import br.uninove.model.Autor;


@WebServlet("/BuscaAutorServlet")
public class BuscaAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscaAutorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String operacao = request.getParameter("operacao");
		String destino = "";
		
		if (operacao.equals("editar")) {
			destino = "atualiza_autor.jsp";
		} else {
			destino = "excluir_autor.jsp";
		}
		
		AutorDAO autorDAO = new AutorDAO();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		Autor autor = autorDAO.getAutor(codigo);
		
		request.setAttribute("autor", autor);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
		dispatcher.forward(request, response);
		
	}

}










