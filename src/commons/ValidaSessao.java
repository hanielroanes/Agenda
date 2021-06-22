package commons;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

public class ValidaSessao {
		
	
	public static Cliente retornaClienteLogado(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Optional<Cliente> cliente = (Optional<Cliente>) session.getAttribute("cliente"); 
		if(cliente.isEmpty()) {
			redirecionaParaPaginaLogin(request, response);
			return null;
		}
		return cliente.get();
	}
	
	public static void redirecionaParaPaginaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("messageLoginFalied", "Faça login para acessar o aplicativo!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	public static void editarUserSessao(HttpServletRequest request, HttpServletResponse response,
			Cliente clienteEditar) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object cliente1 = session.getAttribute("cliente");
		session.removeAttribute("cliente");
		Optional<Cliente> cliente = Optional.ofNullable(clienteEditar);
		session.setAttribute("cliente", cliente);
		Object clienteseila = session.getAttribute("cliente");
		String nome = null;
		
	}
	
}
