package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ValidaSessao;
import dao.SubTarefaDao;
import model.Cliente;

/**
 * Servlet implementation class DeletarSubTarefaController
 */
@WebServlet("/deletarSubTarefa")
public class DeletarSubTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	SubTarefaDao dao = new SubTarefaDao();
	
    public DeletarSubTarefaController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Long idTarefa = Long.valueOf(request.getParameter("idTarefa"));
			String nomeTarefa = request.getParameter("nomeTarefa");
			Long idSubTarefa = Long.valueOf(request.getParameter("idSubTarefa"));
			
			dao.deletarSubTarefa(idSubTarefa);
			
			request.setAttribute("idTarefa", idTarefa );
			request.setAttribute("nomeTarefa", nomeTarefa );
			request.getRequestDispatcher("/subTarefas").forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}	
	}

}
