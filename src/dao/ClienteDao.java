package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

import commons.ConnectionConfig;
import model.Cliente;

public class ClienteDao {

	public Long cadastrarCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome, email, senha, tel) values (?,?,?,?)";
		ConnectionConfig connection = new ConnectionConfig();
		Long id = null;
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			pmt.setString(1, cliente.getNome());
			pmt.setString(2, cliente.getEmail());
			pmt.setString(3, cliente.getSenha());
			pmt.setString(4, cliente.getTel());

			pmt.executeUpdate();
			ResultSet rs = pmt.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO INSERIR CLIENTE: " + e.getMessage());
		}
		
		return id;
	}

	public Cliente buscarClientePorId(Long idCliente) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		ConnectionConfig connection = new ConnectionConfig();
		Cliente cliente = new Cliente();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setLong(1, idCliente);

			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				cliente.setId(rs.getLong(1));
				cliente.setNome(rs.getString(2));
				cliente.setTel(rs.getString(3));
				cliente.setEmail(rs.getString(4));
				cliente.setSenha(rs.getString(5));
			}
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO BUSCAR CLIENTE: " + e.getMessage());
		}
		
		return cliente;
	}

	public Optional<Cliente> buscarClientePeloEmail(String email) {
		
		String sql = "SELECT * FROM cliente WHERE email = ?";
		ConnectionConfig connection = new ConnectionConfig();
		Optional<Cliente> cliente = Optional.ofNullable(new Cliente());
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1, email);

			ResultSet rs = pmt.executeQuery();
			if(rs.next()) {
				cliente.get().setId(rs.getLong(1));
				cliente.get().setNome(rs.getString(2));
				cliente.get().setTel(rs.getString(3));
				cliente.get().setEmail(rs.getString(4));
				cliente.get().setSenha(rs.getString(5));
			}
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO BUSCAR CLIENTE PELO EMAIL: " + e.getMessage());
		}
		
		return cliente;
	}

	public void editarCliente(Cliente clienteEditar) {		
		String sql = "UPDATE cliente SET nome = ?, tel = ?, email = ?, senha= ? WHERE id = ? ";
		ConnectionConfig connection = new ConnectionConfig();
		try {
			Connection con = connection.connect();
			PreparedStatement pmt = con.prepareStatement(sql);

			pmt.setString(1,clienteEditar.getNome());
			pmt.setString(2, clienteEditar.getTel());
			pmt.setString(3, clienteEditar.getEmail());
			pmt.setString(4, clienteEditar.getSenha());
			pmt.setLong(5, clienteEditar.getId());
			pmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println("ERRO AO ATUALIZAR CLIENTE: " + e.getMessage());
		}	
	}

}
