package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.DataBase;

public class DAOEmpleado {

	
	Connection con = DataBase.getConnexion();

public boolean registrarEmpleado(Empleado empleado) throws SQLException {
		
		String sql = "INSERT INTO Empleado(ID_Asignación,Nombre,Apellido,Nro_Documento,Teléfono,Correo_Electrónico)"
				+ " VALUES ( ?, ?, ?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, empleado.getId_Asignacion());
		ps.setString(2, empleado.getNombre());
		ps.setString(3, empleado.getApellido());
		ps.setInt(4, empleado.getNro_Documento());
		ps.setString(5, empleado.getTelefono());
		ps.setString(6, empleado.getCorreo_Electronico());

		if(ps.executeUpdate()>0){
			
            UsuarioDao usuariodao = new UsuarioDao();
			Usuario usuario = new Usuario(empleado.getCorreo_Electronico(), empleado.getClave(),"empleado");
			boolean usuarioRegistrado = usuariodao.registrarUsuario(usuario);
			return usuarioRegistrado;
			}
		return false;
		

	}
}
