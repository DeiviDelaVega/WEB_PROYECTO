package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ReporteCliente;
import modelo.Usuario;

public class DAOCliente {
	
	
	private boolean estadoOperacion;
	
	Connection con = DataBase.getConnexion();

	public boolean registrarCliente(Cliente cliente) throws SQLException {

		boolean informacionRegistrada =false;
		try {
			String sql = "INSERT INTO Cliente(Nombre,Apellido,Nro_Documento,Dirección,Numero_Telf,Correo)"
					+ " VALUES ( ?, ?, ?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setInt(3, cliente.getNro_Documento());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getTelefono());
			ps.setString(6, cliente.getCorreo());

			if (ps.executeUpdate() > 0) {

				DAOUsuario usuariodao = new DAOUsuario();
				Usuario usuario = new Usuario(cliente.getCorreo(), cliente.getClave(), "cliente");
				informacionRegistrada = usuariodao.registrarUsuario(usuario);
			}

		} catch (Exception e) {
			informacionRegistrada = false;
		}
			
			return informacionRegistrada;

	}

	public List<Cliente> buscarPorId(int idBuscar) {
		// Establecer la conexión con la BD
		Connection cnx = DataBase.getConnexion();
		// Declarar la lista de Departamento
		List<Cliente> listaCliente = new ArrayList<>();
		try {
			// Preparar la instruccion SQL:
			PreparedStatement ps;
			if (idBuscar == -1) {
				// Buscar todos los departamentos
				ps = cnx.prepareStatement("SELECT * FROM Cliente");
			} else {
				// Buscar por ID
				ps = cnx.prepareStatement("SELECT * FROM Cliente WHERE ID_Cliente =?");
				// Enviar el valor del parametro SQL
				ps.setInt(1,idBuscar );
			}
			// Ejecuar la instruccion SQL y recoger los resultados
			ResultSet rs = ps.executeQuery(); // SELECT
			// ps.executeUpdate(); // INSERT - UPDATE - DELETE
			while (rs.next()) {
				// Instanciar objeto departamento
				Cliente cliente = new Cliente();
				// Guardar los valores de la fila en el objeto
				cliente.setId_Cliente(rs.getInt("ID_Cliente"));

				cliente.setNombre(rs.getString("Nombre"));
				cliente.setApellido(rs.getString("Apellido"));
				cliente.setNro_Documento(rs.getInt("Nro_Documento"));
				cliente.setDireccion(rs.getString("Dirección"));
				cliente.setTelefono(rs.getString("Numero_Telf"));
				cliente.setCorreo(rs.getString("Correo"));
				// Agregar el departamento a la lista de departamentos
				listaCliente.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión con la BD (importante para evitar fugas de recursos)
			try {
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("listaEmpleados " + listaCliente);
		// Retornar la lista de departamentos
		return listaCliente;
	}
	
	public boolean eliminar(int idEmpleado, String correo) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "DELETE FROM Cliente WHERE ID_Cliente = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idEmpleado);

			estadoOperacion = ps.executeUpdate() > 0;

			DAOUsuario usuariodao = new DAOUsuario();
			usuariodao.eliminarUsuario(correo);
			
			con.commit();
			ps.close();
			ps.close();

		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	public boolean modificar(Cliente cliente, String correoAnterior) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "UPDATE Cliente SET  Nombre=?, Apellido=?, Nro_Documento=?, Dirección=?, Numero_Telf=?, Correo=? WHERE ID_Cliente=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setInt(3, cliente.getNro_Documento());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getTelefono());
			ps.setString(6, cliente.getCorreo());
          
			ps.setInt(7, cliente.getId_Cliente());
			
		
			System.out.print(correoAnterior);
			DAOUsuario usuariodao = new DAOUsuario();
			usuariodao.modificarUsuario(cliente.getCorreo(), cliente.getClave(),correoAnterior);
			estadoOperacion = ps.executeUpdate() > 0;

			con.commit();
			ps.close();
			con.close();

		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	public Cliente obtenerPorId(int id)  {
		Cliente cliente = null; // Inicializa el objeto departamento
		String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ?"; // Consulta SQL
		// Obtiene la conexión a la base de datos

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id); // Configura el parámetro ID en la consulta

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) { // Si encuentra un resultado
					cliente = new Cliente(); // Crea una instancia del modelo Departamento
					cliente.setId_Cliente(resultSet.getInt("ID_Cliente"));
					cliente.setNombre(resultSet.getString("Nombre"));
					cliente.setApellido(resultSet.getString("Apellido"));
					cliente.setNro_Documento(resultSet.getInt("Nro_Documento"));
					cliente.setDireccion(resultSet.getString("Dirección"));
					cliente.setTelefono(resultSet.getString("Numero_Telf"));
					cliente.setCorreo(resultSet.getString("Correo"));
					
					
					DAOUsuario usuarioDao = new DAOUsuario();
					Usuario usuario = usuarioDao.obtenerUsuario(cliente.getCorreo());
					cliente.setClave(usuario.getClave());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cliente; // Devuelve el objeto departamento o null si no se encuentra
	}
	
	public Cliente obtenerPorCorreo(String correo ) throws SQLException {
		Cliente cliente = null; // Inicializa el objeto departamento
		String sql = "SELECT * FROM Cliente WHERE Correo = ?"; // Consulta SQL
		// Obtiene la conexión a la base de datos

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, correo); // Configura el parámetro ID en la consulta

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) { // Si encuentra un resultado
					cliente = new Cliente(); // Crea una instancia del modelo Departamento
					cliente.setId_Cliente(resultSet.getInt("ID_Cliente"));
					cliente.setNombre(resultSet.getString("Nombre"));
					cliente.setApellido(resultSet.getString("Apellido"));
					cliente.setNro_Documento(resultSet.getInt("Nro_Documento"));
					cliente.setDireccion(resultSet.getString("Dirección"));
					cliente.setTelefono(resultSet.getString("Numero_Telf"));
					cliente.setCorreo(resultSet.getString("Correo"));
					
					
					DAOUsuario usuarioDao = new DAOUsuario();
					Usuario usuario = usuarioDao.obtenerUsuario(cliente.getCorreo());
					cliente.setClave(usuario.getClave());
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
	
	public List<ReporteCliente> ObtenerClientesConMasReservas() {
		String sql = "{Call ObtenerClientesConMasReservas()}";
				// Declarar la lista de Departamento
		List<ReporteCliente> listaReporteCliente = new ArrayList<>();
		try {
			// Preparar la instruccion SQL:
			CallableStatement cstmt = con.prepareCall(sql);
	        
			//ResultSet OBTIENE EL RESULTADO DEL PROCEDIMIENTO
			ResultSet rs = cstmt.executeQuery();
			while (rs.next()) {
				listaReporteCliente.add(new ReporteCliente(rs.getInt("ID_Cliente"),rs.getString("Nombre"), rs.getString("Apellido"),
						rs.getInt("Total_Reservas")));
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaReporteCliente;
	}

}
