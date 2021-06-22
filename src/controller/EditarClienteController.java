package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ValidaSessao;
import dao.ClienteDao;
import model.Cliente;


@WebServlet("/editarCliente")
public class EditarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDao dao = new ClienteDao();
    public EditarClienteController() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			request.setAttribute("cliente", cliente.get());
			request.getRequestDispatcher("editaCliente.jsp").forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Cliente clienteEditar = new Cliente();
			clienteEditar.setId(cliente.get().getId());
			clienteEditar.setNome(request.getParameter("nome"));
			clienteEditar.setEmail(request.getParameter("email"));
			clienteEditar.setTel(request.getParameter("tel"));
			String senha = request.getParameter("senha");
			String confirmaSenha = request.getParameter("confirmaSenha");
			if(senha != "") {
				clienteEditar.setSenha(senha);
				if(validaSenha(confirmaSenha, clienteEditar.getSenha())) {
					dao.editarCliente(clienteEditar);
				}else {
					request.setAttribute("menssagemSenha", "Senha de confirmação esta incorreta");
					request.setAttribute("cliente", clienteEditar);
					request.getRequestDispatcher("editaCliente.jsp").forward(request, response);
				}
			}else {
				clienteEditar.setSenha(cliente.get().getSenha());
			}
			dao.editarCliente(clienteEditar);
			ValidaSessao.editarUserSessao(request, response, clienteEditar);
			response.sendRedirect("tarefas");
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
		
	}


	private boolean validaSenha(String confirmaSenha, String senha) {
		if(confirmaSenha == null) {
			return false;
		}
		return confirmaSenha.equals(senha);
	}

}
