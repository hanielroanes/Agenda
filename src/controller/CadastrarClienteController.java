package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;

@WebServlet("/cadastrarCliente")
public class CadastrarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastrarClienteController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		ClienteDao dao = new ClienteDao();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTel(request.getParameter("tel"));
		cliente.setSenha(request.getParameter("senha"));
		Long id = dao.cadastrarCliente(cliente);
		cliente.setId(id);
		doGet(request, response, cliente);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Cliente cliente) throws ServletException, IOException {
		request.setAttribute("menssagemCadastro", "Efetue o login para concluir o cadastro");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}

}
