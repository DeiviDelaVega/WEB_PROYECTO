package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.DataBase;

public class UsuarioDao {

	
	public Usuario validarUsuario(String usuario, String clave) {
		
		 // 2. Procesar datos: Registrar
		// 2.1. Crear conexion a la BD
		Connection cnx=DataBase.getConnexion();
		String sql = "select*from USUARIO where clave = ? and  usuario =?";
			
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			// 2.2. Completar la sentencia INSERT
			ps.setString(1,clave);
			ps.setString(2, usuario);
			//PARA EJECUTAR LA CONSULTA executeQuery
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				//DATOS OBTENIDOS DE LA BD
				return new Usuario(
				rs.getString("nombre"),		
				rs.getString("apellido"),		
				rs.getString("correo"),		
				rs.getString("clave"),	
				rs.getString("usuario"),		
				rs.getString("rol"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	public boolean registrarUsuario(Usuario usuario) {
		Connection cnx=DataBase.getConnexion();
		String sql = "insert into Empleado(ID_Asignación,Nombre,Apellido,Fecha_Contratación,Teléfono,Correo_Electrónico)"+
				"values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			// 2.2. Completar la sentencia INSERT
		
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(2, usuario.getCorreo());
			ps.setString(2, usuario.getUsuario());
			ps.setString(2, usuario.getClave());
			ps.setString(2, usuario.getRol());

			// 2.3. Ejecutar INSERT
			int resultado = ps.executeUpdate(); // 1 si se registro, de lo contrario es 0
	        if(resultado==1) {
	        	return true;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	}
	
