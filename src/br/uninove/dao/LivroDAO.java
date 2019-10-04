package br.uninove.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.uninove.model.Autor;
import br.uninove.model.Livro;

public class LivroDAO {

	private Livro livro;
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroDAO() {}
	
	public LivroDAO(Livro livro) {
		this.livro = livro;
	}
	
	public ArrayList<Livro> getLivros() {
		
		//*** Consulta sql no banco
		String consulta = "SELECT * FROM tbl_livro AS a JOIN tbl_autor AS b ON a.codigo_autor = b.codigo_autor";
		
		//*** Objeto que recebe o resultado da consulta
		ResultSet rs = null;
		
		try {
			
			//*** Preparando para enviar 
			//*** o comando para o banco
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			rs = stm.executeQuery();
			
			//*** Criar uma lista de autores
			ArrayList<Livro> livros = new ArrayList<>();
			Autor autor;
			Livro livro;
			
			while (rs.next()) {
				livro = new Livro();
				autor = new Autor();
				livro.setCodigoLivro(rs.getInt("codigo_livro"));
				livro.setTituloLivro(rs.getString("titulo_livro"));
				livro.setAnoEdicao(rs.getString("ano_edicao"));
				autor.setCodigoAutor(rs.getInt("codigo_autor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
				autor.setCidadeAutor(rs.getString("cidade_autor"));
				livro.setAutor(autor);

				livros.add(livro);
			}
			
			return livros;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	public Livro getLivro(int codigoLivro) {
		
		//*** Consulta sql no banco
		String consulta = "SELECT * FROM tbl_livro AS a JOIN tbl_autor AS b ON a.codigo_autor = b.codigo_autor WHERE codigo_livro = ?";
		
		//*** Objeto que recebe o resultado da consulta
		ResultSet rs = null;
		
		try {
			
			//*** Preparando para enviar 
			//*** o comando para o banco
			
			PreparedStatement stm = Conexao.getConexao().prepareStatement(consulta);
			stm.setInt(1, codigoLivro);
			rs = stm.executeQuery();
			
			//*** Criar uma lista de autores
			Autor autor;
			Livro livro = null;
			
			while (rs.next()) {
				livro = new Livro();
				autor = new Autor();
				livro.setCodigoLivro(rs.getInt("codigo_livro"));
				livro.setTituloLivro(rs.getString("titulo_livro"));
				livro.setAnoEdicao(rs.getString("ano_edicao"));
				autor.setCodigoAutor(rs.getInt("codigo_autor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
				autor.setCidadeAutor(rs.getString("cidade_autor"));
				livro.setAutor(autor);
			}
			
			return livro;
			
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
	
	
	public void gravarLivro() {
		
		String sql = "INSERT INTO tbl_livro"
				+ "(titulo_livro, ano_edicao,codigo_autor) "
				+ "VALUES (?, ?, ?)";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, livro.getTituloLivro());
			stm.setString(2, livro.getAnoEdicao());
			stm.setInt(3, livro.getAutor().getCodigoAutor());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizarLivro() {
		
		String sql = "UPDATE tbl_livro "
				+ "SET titulo_livro = ?, ano_edicao = ?, codigo_autor = ? "
				+ "WHERE codigo_livro = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, livro.getTituloLivro());
			stm.setString(2, livro.getAnoEdicao());
			stm.setInt(3, livro.getAutor().getCodigoAutor());
			stm.setInt(4, livro.getCodigoLivro());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excluirLivro() {
		
		String sql = "DELETE FROM tbl_livro "
				+ "WHERE codigo_livro = ?";
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, livro.getCodigoLivro());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}











