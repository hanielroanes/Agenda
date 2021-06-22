package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.DateUtils;
import commons.ValidaSessao;
import dao.TarefaDao;
import model.Cliente;
import model.Tarefa;

@WebServlet("/cadastrarTarefa")
public class CadastrarTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TarefaDao tarefaDao = new TarefaDao();
    
    public CadastrarTarefaController() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Long idCliente = cliente.get().getId();
			String dataLimite = request.getParameter("dataLimite");
			Tarefa tarefa = new Tarefa();
			tarefa.setIdCliente(idCliente);
			tarefa.setNome(request.getParameter("nome"));
			tarefa.setDataInicio(new Date());
			if(!dataLimite.isEmpty() && !dataLimite.isBlank()) {
				tarefa.setDataLimite(DateUtils.transformarStringEmDate(dataLimite));
			}
			tarefa.setConcluida("N");
			tarefaDao.cadastrarTarefa(tarefa);
			
			request.setAttribute("cliente", cliente.get());
			request.setAttribute("id", idCliente);
			RequestDispatcher rd = request.getRequestDispatcher("/tarefas");
			rd.forward(request, response);
			
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
		
	
		
	}
}
