package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Cliente;
import modelo.Departamento;
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

public Cliente obtenerPorId(int id) throws SQLException {
	Cliente cliente = null; // Inicializa el objeto departamento
	String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?"; // Consulta SQL
	 // Obtiene la conexión a la base de datos

	try (PreparedStatement statement = con.prepareStatement(sql)) {
		statement.setInt(1, id); // Configura el parámetro ID en la consulta

		try (ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) { // Si encuentra un resultado
				cliente = new Cliente(); // Crea una instancia del modelo Departamento
				cliente.setId_Cliente(resultSet.getInt("ID_Cliente"));
			
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw e; // Re-lanza la excepción para que sea manejada por el servlet
	} finally {
		if (con != null) {
			con.close(); // Cierra la conexión
		}
	}
	return cliente; // Devuelve el objeto departamento o null si no se encuentra
}
	
}
