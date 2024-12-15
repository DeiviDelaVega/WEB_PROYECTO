package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DataBase;
import modelo.Empleado;
import modelo.Usuario;

public class DAOEmpleado {
	private boolean estadoOperacion;
	Connection con = DataBase.getConnexion();

	public boolean registrarEmpleado(Empleado empleado) {

		String sql = "INSERT INTO Empleado(Nombre,Apellido,Nro_Documento,Teléfono,Correo_Electrónico)"
				+ " VALUES (?, ?,?,?,?)";
		try (Connection cnx = DataBase.getConnexion(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setInt(3, empleado.getNro_Documento());
			ps.setString(4, empleado.getTelefono());
			ps.setString(5, empleado.getCorreo_Electronico());

			if (ps.executeUpdate() > 0) {

				DAOUsuario usuariodao = new DAOUsuario();
				Usuario usuario = new Usuario(empleado.getCorreo_Electronico(), empleado.getClave(), "empleado");
				boolean usuarioRegistrado = usuariodao.registrarUsuario(usuario);
				return usuarioRegistrado;
			}

			// Ejecutar la sentencia
			return ps.executeUpdate() == 1; // Retorna true si el registro fue exitoso
		} catch (SQLException e) {
			e.printStackTrace();
			return false; // En caso de error, retorna false
		}

	}

	public List<Empleado> buscarPorId(int idBuscar) {
		// Establecer la conexión con la BD
		Connection cnx = DataBase.getConnexion();
		// Declarar la lista de Departamento
		List<Empleado> listaEmpleados = new ArrayList<>();
		try {
			// Preparar la instruccion SQL:
			PreparedStatement ps;
			if (idBuscar == -1) {
				// Buscar todos los departamentos
				ps = cnx.prepareStatement("SELECT * FROM Empleado");
			} else {
				// Buscar por ID
				ps = cnx.prepareStatement("SELECT * FROM Empleado WHERE ID_Empleado LIKE ?");
				// Enviar el valor del parametro SQL
				ps.setString(1, "%" + idBuscar + "%");
			}
			// Ejecuar la instruccion SQL y recoger los resultados
			ResultSet rs = ps.executeQuery(); // SELECT
			// ps.executeUpdate(); // INSERT - UPDATE - DELETE
			while (rs.next()) {
				// Instanciar objeto departamento
				Empleado empleado = new Empleado();
				// Guardar los valores de la fila en el objeto
				empleado.setId_Empleado(rs.getInt("ID_Empleado"));

				empleado.setNombre(rs.getString("Nombre"));
				empleado.setApellido(rs.getString("Apellido"));
				empleado.setNro_Documento(rs.getInt("Nro_Documento"));
				empleado.setFecha_Contratacion(rs.getDate("Fecha_Contratación"));
				empleado.setTelefono(rs.getString("Teléfono"));
				empleado.setCorreo_Electronico(rs.getString("Correo_Electrónico"));

				// Agregar el departamento a la lista de departamentos
				listaEmpleados.add(empleado);
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
		System.out.println("listaEmpleados " + listaEmpleados);
		// Retornar la lista de departamentos
		return listaEmpleados;
	}

	public boolean eliminar(int idEmpleado, String correo) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "DELETE FROM Empleado WHERE ID_Empleado = ?";
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

	// Modificar departamento
	public boolean modificar(Empleado empleado, String correoAnterior) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		PreparedStatement ps;

		try {
			con.setAutoCommit(false);
			sql = "UPDATE Empleado SET  Nombre=?, Apellido=?, Nro_Documento=?, Teléfono=?, Correo_Electrónico=? WHERE ID_Empleado=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setInt(3, empleado.getNro_Documento());
			ps.setString(4, empleado.getTelefono());
			ps.setString(5, empleado.getCorreo_Electronico());
          
			ps.setInt(6, empleado.getId_Empleado());
			
		
			System.out.print(correoAnterior);
			DAOUsuario usuariodao = new DAOUsuario();
			usuariodao.modificarUsuario(empleado.getCorreo_Electronico(), empleado.getClave(),correoAnterior);
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

	public Empleado obtenerPorId(int id)  {
		Empleado empleado = null; // Inicializa el objeto departamento
		String sql = "SELECT * FROM Empleado WHERE ID_Empleado = ?"; // Consulta SQL

		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id); // Configura el parámetro ID en la consulta

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) { // Si encuentra un resultado
					empleado = new Empleado(); // Crea una instancia del modelo Departamento
					empleado.setId_Empleado(resultSet.getInt("ID_Empleado"));
					empleado.setNombre(resultSet.getString("Nombre"));
					empleado.setApellido(resultSet.getString("Apellido"));
					empleado.setNro_Documento(resultSet.getInt("Nro_Documento"));
					empleado.setFecha_Contratacion(resultSet.getDate("Fecha_Contratación"));
				
					empleado.setTelefono(resultSet.getString("Teléfono"));
					
					empleado.setCorreo_Electronico(resultSet.getString("Correo_Electrónico"));
					DAOUsuario usuarioDao = new DAOUsuario();
					Usuario usuario = usuarioDao.obtenerUsuario(empleado.getCorreo_Electronico());
					empleado.setClave(usuario.getClave());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		return empleado; // Devuelve el objeto departamento o null si no se encuentra
	}

}
