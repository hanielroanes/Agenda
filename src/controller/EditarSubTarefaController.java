package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.ValidaSessao;
import dao.SubTarefaDao;
import model.Cliente;
import model.SubTarefa;

@WebServlet("/editarSubTarefa")
public class EditarSubTarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SubTarefaDao dao = new SubTarefaDao();
	
    public EditarSubTarefaController() {
    }
    
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			SubTarefa subTarefa = new SubTarefa();
			Long idTarefa = Long.valueOf(request.getParameter("idTarefa"));
			String nomeTarefa = request.getParameter("nomeTarefa");
			String status = request.getParameter("concluida");
			Long idSubTarefa = Long.valueOf(request.getParameter("idSubTarefa"));
			
			subTarefa.setId(idSubTarefa);
			if(status.equals("S")) {
				subTarefa.setConcluida("N");
			}else {
				subTarefa.setConcluida("S");
			}
			
			
			dao.alterarStatusSubTarefa(subTarefa);
			
			request.setAttribute("nomeTarefa", nomeTarefa );
			request.setAttribute("idTarefa", idTarefa);
			request.setAttribute("cliente", cliente.get());
			RequestDispatcher rd = request.getRequestDispatcher("/subTarefas");
			rd.forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Optional<Cliente> cliente = Optional.ofNullable(ValidaSessao.retornaClienteLogado(request, response));
		if(!cliente.isEmpty()) {
			SubTarefa subTarefa = new SubTarefa();
			Long idTarefa = Long.valueOf(request.getParameter("idTarefa"));
			String nomeTarefa = request.getParameter("nomeTarefa");
			Long idSubTarefa = Long.valueOf(request.getParameter("idSubTarefa"));
			
			subTarefa.setId(idSubTarefa);
			subTarefa.setDescricao(request.getParameter("descricao"));
			
			dao.editarSubTarefa(subTarefa);
			
			request.setAttribute("nomeTarefa", nomeTarefa );
			request.setAttribute("idTarefa", idTarefa);
			request.setAttribute("cliente", cliente.get());
			RequestDispatcher rd = request.getRequestDispatcher("/subTarefas");
			rd.forward(request, response);
		}else {
			ValidaSessao.redirecionaParaPaginaLogin(request, response);
		}
	}

}
