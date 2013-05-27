package br.poo2013.projeto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
 
public class UsuarioDAO {
 
	public Connection conectarDB() throws SQLException {
		System.out.println("Conectando no PostgreSQL.....");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(" PostgreSQL JDBC Driver não encontrado.");
			e.printStackTrace();
			throw new SQLException(e);
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
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
			return connection;
		} else {
			throw new SQLException();
		}
	}
	
	public int cadastrar(UsuarioModel user) {
		try{
			Connection connection = conectarDB();
			String sql = "INSERT INTO tb_usuario("
					+ "login, senha)"   
		            + " VALUES ("+user.getLogin()+","+user.getSenha()+");";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.executeQuery(sql);
			//int retorno = Integer.parseInt(sql, pstm.executeUpdate());
		} catch (SQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return 1;
		
	}
 
}
