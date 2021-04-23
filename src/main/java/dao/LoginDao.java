package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class LoginDao extends Banco{
	
	public Usuario entrar(String user, String password)   {
		 
		Usuario usuario=null;

		try {  
			PreparedStatement query = con.prepareStatement("Select * from Usuario where logon = ? and senha = ?");
			query.setString(1, user);
			query.setString(2, password);

			ResultSet resultSet = Consultar(query);

			while (resultSet.next()) {
				usuario= Prencher(resultSet); 
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return null;
		} 
		return usuario;
	}

	private  Usuario Prencher(ResultSet resultSet) {
		Usuario usuario=new Usuario();
		try {
			usuario.setIdUsuario(resultSet.getInt(resultSet.findColumn("idusuario")));
			usuario.setNome(resultSet.getString(resultSet.findColumn("nome"))); 
			usuario.setEmail(resultSet.getString(resultSet.findColumn("email"))); 
			usuario.setLogon(resultSet.getString(resultSet.findColumn("logon"))); 
			usuario.setSenha(resultSet.getString(resultSet.findColumn("senha"))); 
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return usuario;
	}

}
