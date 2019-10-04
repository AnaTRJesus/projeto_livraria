package br.uninove.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.uninove.model.Usuario;

public class UsuarioDAO {
	
	private Usuario usuario;
	
	public UsuarioDAO() {} 
	
	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario autenticar(String login, String senha) {
		
		String sql = "SELECT * FROM tbl_usuario "
				+ "WHERE login = ? AND CAST(AES_DECRYPT(senha, 'uni') as CHAR) = ?";
		
		ResultSet rs;
		
		try {
			PreparedStatement stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, login);
			stm.setString(2, senha);
			
			rs = stm.executeQuery();
			
			this.usuario = null;
			
			if (rs.next()) {
				this.usuario = new Usuario();
				this.usuario.setCodigo(rs.getInt("cod_usuario"));
				this.usuario.setNome(rs.getString("nome"));
				this.usuario.setLogin(rs.getString("login"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.usuario;
	}

}
