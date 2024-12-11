package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Usuario;

public class DAOCliente {
	Connection con = DataBase.getConnexion();
   
public boolean registrarCliente(Cliente cliente) throws SQLException {
		
		String sql = "INSERT INTO Cliente(Nombre,Apellido,Nro_Documento,Dirección,Numero_Telf,Correo)"
				+ " VALUES ( ?, ?, ?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setInt(3, cliente.getNro_Documento());
		ps.setString(4, cliente.getDireccion());
		ps.setString(5, cliente.getTelefono());
		ps.setString(6, cliente.getCorreo());

		if(ps.executeUpdate()>0){
			
            DAOUsuario usuariodao = new DAOUsuario();
			Usuario usuario = new Usuario(cliente.getCorreo(), cliente.getClave(),"cliente");
			boolean usuarioRegistrado = usuariodao.registrarUsuario(usuario);
			return usuarioRegistrado;
			}
		return false;
		

	}
	
}
