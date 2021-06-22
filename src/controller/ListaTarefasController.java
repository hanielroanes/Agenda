package controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ValidaSessao;
import dao.SubTarefaDao;
import dao.TarefaDao;
import model.Cliente;
import model.SubTarefa;
import model.Tarefa;


@WebServlet("/tarefas")
public class ListaTarefasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TarefaDao dao = new TarefaDao();
	private SubTarefaDao subTarefaDao = new SubTarefaDao();
	
    public ListaTarefasController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			Long idCliente = cliente.get().getId();
			
			List<Tarefa> tarefas = dao.listaTodasAsTarefasPorId(idCliente).stream().map(tarefa ->{
				if(verificaSubTarefas(tarefa)) {
					tarefa.setConcluida("S");
				}
				return tarefa;
			}).collect(Collectors.toList());
			
			request.setAttribute("tarefas", tarefas);
			request.setAttribute("cliente", cliente.get());
			
			RequestDispatcher rd = request.getRequestDispatcher("listaTarefas.jsp");
			rd.forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private boolean verificaSubTarefas(Tarefa tarefa) {
		List<SubTarefa> subTarefas = subTarefaDao.buscasSubTarefasPorIdTarefa(tarefa.getId());
		boolean concluida[] = {true};
		subTarefas.forEach(subTarefa -> {
			if(subTarefa.getConcluida().equals("N")) {
				concluida[0] = false;
			}
			
		});
		
		return concluida[0];
	}

}
