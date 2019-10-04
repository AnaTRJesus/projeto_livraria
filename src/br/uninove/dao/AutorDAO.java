package br.uninove.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.uninove.model.Autor;

public class AutorDAO {

	private Autor autor;
	
	public AutorDAO() {}
	
	public AutorDAO(Autor autor) {
		this.autor = autor;
	}
	
	public ArrayList<Autor> getAutores() {
		
		//*** Consulta sql no banco
		String consulta = "SELECT * FROM tbl_autor";
		
		//*** Objeto que recebe o resultado da consulta
		ResultSet rs = null;
		
		try {
			
			//*** Preparando para enviar 
			//*** o comando para o banco
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			rs = stm.executeQuery();
			
			//*** Criar uma lista de autores
			ArrayList<Autor> autores = new ArrayList<>();
			Autor autor;
			
			while (rs.next()) {
				autor = new Autor();
				autor.setCodigoAutor(rs.getInt("codigo_autor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
				autor.setCidadeAutor(rs.getString("cidade_autor"));
				autores.add(autor);
			}
			
			return autores;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Autor getAutor(int codigoAutor) {
		
		//*** Consulta sql no banco
		String consulta = "SELECT * FROM tbl_autor WHERE codigo_autor = ?";
		
		//*** Objeto que recebe o resultado da consulta
		ResultSet rs = null;
		
		try {
			
			//*** Preparando para enviar 
			//*** o comando para o banco
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codigoAutor);
			rs = stm.executeQuery();
			
			//*** Criar um autor
			Autor autor = null;
			
			if (rs.next()) {
				autor = new Autor();
				autor.setCodigoAutor(rs.getInt("codigo_autor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
				autor.setCidadeAutor(rs.getString("cidade_autor"));
			}
			
			return autor;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void gravarAutor() {
		
		String sql = "INSERT INTO tbl_autor "
				+ "(nome_autor, cidade_autor) "
				+ "VALUES (?, ?)";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, autor.getNomeAutor());
			stm.setString(2, autor.getCidadeAutor());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizarAutor() {
		
		String sql = "UPDATE tbl_autor "
				+ "SET nome_autor = ?, cidade_autor = ? "
				+ "WHERE codigo_autor = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, autor.getNomeAutor());
			stm.setString(2, autor.getCidadeAutor());
			stm.setInt(3, autor.getCodigoAutor());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluirAutor() {
		
		String sql = "DELETE FROM tbl_autor "
				+ "WHERE codigo_autor = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, autor.getCodigoAutor());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}











