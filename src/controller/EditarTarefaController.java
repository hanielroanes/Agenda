package controller;

import java.io.IOException;
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

@WebServlet("/editarTarefa")
public class EditarTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private TarefaDao tarefaDao = new TarefaDao();

    public EditarTarefaController() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setNome(request.getParameter("nome"));
			Long idTarefa = Long.valueOf(request.getParameter("idTarefa"));
			String dataLimite = request.getParameter("dataLimite");
			tarefa.setIdCliente(cliente.get().getId());
			if(!dataLimite.isEmpty() && !dataLimite.isBlank()) {
				tarefa.setDataLimite(DateUtils.transformarStringEmDate(dataLimite));
			}
			tarefaDao.editarTarefa(tarefa, idTarefa);

			request.setAttribute("cliente", cliente.get());
			RequestDispatcher rd = request.getRequestDispatcher("/tarefas");
			rd.forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
	}

}
