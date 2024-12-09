package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DataBase;

public class UsuarioDao {
	
	
	Connection con = DataBase.getConnexion();
	
	
	public Usuario validarUsuario(String correo, String clave) throws SQLException{
		
        String sql = "SELECT * FROM Usuario WHERE Correo = ? AND Clave = ?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, correo);
        ps.setString(2, clave);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
        	
            return new Usuario(
            		
                rs.getString("Correo"),
                rs.getString("Clave"),
                rs.getString("Rol")
            );
        }
        return null;
    }
	
	public boolean registrarUsuario(Usuario usuario) throws SQLException {
		
		String sql = "INSERT INTO Usuario( Correo, Clave, Rol) VALUES ( ?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, usuario.getCorreo());
		ps.setString(2, usuario.getClave());
		ps.setString(3, usuario.getRol());
		
		return ps.executeUpdate() > 0;
		

	}

	
}
	
