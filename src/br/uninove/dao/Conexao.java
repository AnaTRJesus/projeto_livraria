package br.uninove.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConexao(){
		
		String banco = "jdbc:mysql://localhost/db_livraria";
		String usuario = "root";
		String senha = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(banco, usuario, senha);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
