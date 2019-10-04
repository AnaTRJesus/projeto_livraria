package br.uninove.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uninove.dao.UsuarioDAO;
import br.uninove.model.Usuario;


@WebServlet("/AutenticarServlet")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AutenticarServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("txt_login");
		String senha = request.getParameter("txt_senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		
		usuario = dao.autenticar(login, senha);
		
		if (usuario != null) {
			request.getSession().setAttribute("usuario", usuario);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
		
		
		
	}

}
