package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DataBase;
import modelo.Usuario;

public class DAOUsuario {
	
	
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
	public void modificarUsuario(String correo, String clave, String correoAnterior) throws SQLException{
		
		String sql = null;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "UPDATE Usuario SET Correo=?, Clave=? WHERE Correo=?";
			ps = con.prepareStatement(sql);


			ps.setString(1, correo);
			ps.setString(2, clave);
			ps.setString(3, correoAnterior);
            ps.executeUpdate();
				
			con.commit();
			ps.close();
			con.close();
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(String correo) throws SQLException{
	
		String sql = null;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "DELETE FROM USUARIO WHERE Correo=?";
			ps = con.prepareStatement(sql);
		    
			ps.setString(1, correo);
            ps.executeUpdate();

			con.commit();
			ps.close();
			con.close();

		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		
	}

	public Usuario obtenerUsuario(String correo) throws SQLException{
		
        String sql = "SELECT * FROM Usuario WHERE Correo =?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, correo);
        
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
	
}
	
