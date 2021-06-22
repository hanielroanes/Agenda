package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import model.Cliente;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClienteDao dao = new ClienteDao();
	
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Optional<Cliente> cliente = dao.buscarClientePeloEmail(email);
		
		if(!cliente.isEmpty() && existeLogin(cliente.get().getSenha(), senha)) {
			HttpSession session = request.getSession();
			session.setAttribute("cliente", cliente);
			
			response.sendRedirect("tarefas");
		}else {
			request.setAttribute("message", "Usuario ou senha não encontrados");
			request.setAttribute("email", email);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	private boolean existeLogin(String senhaCliente, String senha) { 
		if(senhaCliente.equals(senha)) {
			return true;
		}
		
		return false;
	}

}
