package br.poo2013.projeto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class UsuarioDAO {
	private Connection connection;
	private boolean isConnected = false;

	public void conectarDB() throws SQLException {
		System.out.println("Conectando no PostgreSQL.....");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(" PostgreSQL JDBC Driver não encontrado.");
			e.printStackTrace();
			throw new SQLException(e);
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		// Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres", "batalha",
					"mudar123");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			throw new SQLException(e);
		}
		if (connection != null) {
			System.out.println("Conectado com sucesso!");
			isConnected = true;
		} else {
			throw new SQLException();
		}
	}

	public boolean isConnected() {
		return isConnected;
	}

	public int cadastrar(UsuarioModel user) throws SQLException {
		try {
			String sql = "INSERT INTO tb_usuario(" + "login, senha)"
					+ " VALUES ('" + user.getLogin() + "','" + user.getSenha()
					+ "');";
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			// pstm.executeQuery(sql);
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não foi possível inserir!");
			e.printStackTrace();
			throw new SQLException();
		}
		return 1;

	}

	public void desconectarDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Não foi possível desconectar!");
			e.printStackTrace();
		}

	}
//
	public UsuarioModel efetuaLogin(String login, String senha) throws SQLException {
		try{
			String sql = "SELECT id, login, senha, pontos " 
					+ "FROM tb_usuario "
					+ "where login = ? " 
					+ "AND senha = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, login);
			statement.setString(2, senha);
			ResultSet result = statement.executeQuery(); 
			result.next();
			UsuarioModel user = new UsuarioModel(login, senha, result.getLong("id") , result.getInt("pontos"));
			return user;
		} catch(SQLException notUser){
			notUser.printStackTrace();
			throw new SQLException(notUser);
		}
		
	}
	
	public void alteraSenha(String nova_senha) throws SQLException {
		try{
			String sql = "UPDATE tb_usuario "
					+ "SET senha = ? "
					+ "WHERE login = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nova_senha);
			statement.setString(2, Tela.getUser().getLogin());
			statement.executeUpdate(); 
		} catch(SQLException notUser){
			notUser.printStackTrace();
			throw new SQLException(notUser);
		}
	}

}
