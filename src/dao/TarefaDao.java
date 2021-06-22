package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import commons.ConnectionConfig;
import commons.DateUtils;
import model.Tarefa;

public class TarefaDao {

	private ConnectionConfig connection = new ConnectionConfig();

	public List<Tarefa> listaTodasAsTarefasPorId(Long id) {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "SELECT * FROM TAREFA WHERE id_cliente = ? ORDER BY data_criacao";

		try {
			Connection con = connection.connect();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, id);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				tarefas.add(new Tarefa(rs.getLong(1), rs.getLong(3), rs.getString(2),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getString(6)));
			}

			con.close();

		} catch (SQLException e) {
			System.out.println("ERRO AO BUSCAR TAREFAS: " + e.getMessage());
			return new ArrayList<Tarefa>();

		}
		return tarefas;
	}
	
	public void cadastrarTarefa(Tarefa tarefa) {
		String sql = "INSERT INTO tarefa(nome, id_cliente, data_criacao, data_limite, concluida ) values (?,?,?,?,?)";		
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1, tarefa.getNome());
			pmt.setLong(2, tarefa.getIdCliente());
			pmt.setTimestamp(3, DateUtils.transformarDateEmTimeStampSQL(tarefa.getDataInicio()));
			if(tarefa.getDataLimite() != null) {
				pmt.setTimestamp(4, DateUtils.transformarDateEmTimeStampSQL(tarefa.getDataLimite()));

			}else {
				pmt.setNull(4, Types.TIMESTAMP);
			}
			pmt.setString(5, tarefa.getConcluida());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO INSERIR TAREFA: " + e.getMessage());
		}
		
	}

	public void editarTarefa(Tarefa tarefa, Long idTarefa) {
		String sql = "UPDATE tarefa SET nome = ?, data_limite = ? WHERE id = ? AND id_cliente = ?";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1, tarefa.getNome());
			if(tarefa.getDataLimite() != null) {
				pmt.setTimestamp(2, DateUtils.transformarDateEmTimeStampSQL(tarefa.getDataLimite()));

			}else {
				pmt.setNull(2, Types.TIMESTAMP);
			}
			
			pmt.setLong(3, idTarefa);
			pmt.setLong(4, tarefa.getIdCliente());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO ATUALIZAR TAREFA: " + e.getMessage());
		}
		
	}

	public void deletarTarefa(Long idTarefa) {
		String sql = "DELETE FROM tarefa WHERE id = ? ";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setLong(1, idTarefa);
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO DELETAR TAREFA: " + e.getMessage());
		}	
		
	}
}
