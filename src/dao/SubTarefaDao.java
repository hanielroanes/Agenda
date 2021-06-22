package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.ConnectionConfig;
import model.SubTarefa;

public class SubTarefaDao {
	private ConnectionConfig connection = new ConnectionConfig();

	public List<SubTarefa> buscasSubTarefasPorIdTarefa(Long idTarefa) {
		List<SubTarefa> subTarefas = new ArrayList<>();
		String sql = "SELECT * FROM sub_tarefa WHERE id_tarefa = ? ORDER BY descricao";

		try {
			Connection con = connection.connect();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, idTarefa);
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				subTarefas.add(new SubTarefa(rs.getLong(1), rs.getLong(2), rs.getString(3),
						rs.getString(4)));
			}

			con.close();

		} catch (SQLException e) {
			System.out.println("ERRO AO BUSCAR SUBTAREFAS: " + e.getMessage());
			return new ArrayList<>();

		}
		return subTarefas;
	}
	
	public void cadastrarSubTarefa(SubTarefa subTarefa) {
		String sql = "INSERT INTO sub_tarefa(id_tarefa, descricao, concluida ) values (?,?,?)";		
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setLong(1, subTarefa.getIdTarefa());
			pmt.setString(2, subTarefa.getDescricao());
			pmt.setString(3, subTarefa.getConcluida());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO INSERIR SUBTAREFA: " + e.getMessage());
		}
		
	}

	public void editarSubTarefa(SubTarefa subTarefa) {
		String sql = "UPDATE sub_tarefa SET descricao = ? WHERE id = ? ";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1, subTarefa.getDescricao());
			pmt.setLong(2, subTarefa.getId());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO ATUALIZAR SUBTAREFA: " + e.getMessage());
		}
	}
	
	public void alterarStatusSubTarefa(SubTarefa subTarefa) {
		String sql = "UPDATE sub_tarefa SET concluida = ? WHERE id = ? ";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1, subTarefa.getConcluida());
			pmt.setLong(2, subTarefa.getId());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO ALTERAR STATUS SUBTAREFA: " + e.getMessage());
		}
		
	}

	public void deletarSubTarefa(Long idSubTarefa) {
		String sql = "DELETE FROM sub_tarefa WHERE id = ? ";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setLong(1, idSubTarefa);
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO DELETAR SUBTAREFA: " + e.getMessage());
		}		
	}
}
