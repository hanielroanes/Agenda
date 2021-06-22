package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ValidaSessao;
import dao.TarefaDao;
import model.Cliente;

/**
 * Servlet implementation class DeletarTarefaController
 */
@WebServlet("/deletarTarefa")
public class DeletarTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TarefaDao dao = new TarefaDao();
	
    public DeletarTarefaController() {
 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Long idTarefa = Long.valueOf(request.getParameter("idTarefa"));
			
			dao.deletarTarefa(idTarefa);
			
			response.sendRedirect("tarefas");
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}	
	}

}
