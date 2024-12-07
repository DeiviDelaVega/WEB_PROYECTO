package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lib.DataBase;
import modelo.Departamento;

public class DAODepartamento {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	// Obtener conexion a la BD
	private Connection obtenerConexion() throws SQLException {
		return DataBase.getConnexion();
	}
	
	
	// Método para registrar un departamento en la base de datos
    public boolean registrarDepartamento(Departamento departamento) {
        String sql = "INSERT INTO Departamento(Nombre, Capacidad, Número_Habitaciones, Descripción, Servicios_Incluidos, Disponibilidad, Precio_Por_Noche)"
                   + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection cnx = DataBase.getConnexion();
             PreparedStatement ps = cnx.prepareStatement(sql)) {
            // Completar la sentencia SQL
            ps.setString(1, departamento.getNombre());
            ps.setInt(2, departamento.getCapacidad());
            ps.setInt(3, departamento.getNroHabitaciones());
            ps.setString(4, departamento.getDescripcion());
            ps.setString(5, departamento.getServiciosIncluidos());
            ps.setString(6, departamento.getDisponibilidad());
            ps.setDouble(7, departamento.getPrecioPorNoche());

            // Ejecutar la sentencia
            return ps.executeUpdate() == 1; // Retorna true si el registro fue exitoso
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // En caso de error, retorna false
        }
    }
	
    
	// Buscar por ID
	public List<Departamento> buscarPorId(int idBuscar) {
		// Establecer la conexión con la BD
	    Connection cnx = DataBase.getConnexion();
	    // Declarar la lista de Departamento
	    List<Departamento> listaDepartamentos = new ArrayList<>();
	    try {
	    	// Preparar la instruccion SQL:
	    	PreparedStatement ps;
	        if (idBuscar == -1) {
	        	// Buscar todos los departamentos
	            ps = cnx.prepareStatement("SELECT * FROM Departamento");
	        } else {
	             // Buscar por ID
	             ps = cnx.prepareStatement("SELECT * FROM Departamento WHERE ID_Departamento LIKE ?");
	             // Enviar el valor del parametro SQL
	             ps.setString(1, "%" + idBuscar + "%");
	        }
	        // Ejecuar la instruccion SQL y recoger los resultados		
	        ResultSet rs = ps.executeQuery(); // SELECT
	            		// ps.executeUpdate(); // INSERT - UPDATE - DELETE
	        while (rs.next()) {
	        	// Instanciar objeto departamento
	        	Departamento departamento = new Departamento();
	        	// Guardar los valores de la fila en el objeto
	        	departamento.setIdDepartamento(rs.getInt("ID_Departamento"));
	        	departamento.setNombre(rs.getString("Nombre"));
	        	departamento.setCapacidad(rs.getInt("capacidad"));
	        	departamento.setNroHabitaciones(rs.getInt("Número_Habitaciones"));
	        	departamento.setDescripcion(rs.getString("Descripción"));
	        	departamento.setServiciosIncluidos(rs.getString("Servicios_Incluidos"));
	        	departamento.setDisponibilidad(rs.getString("Disponibilidad"));
	        	departamento.setPrecioPorNoche(rs.getDouble("Precio_Por_Noche"));
	        	// Agregar el departamento a la lista de departamentos
	        	listaDepartamentos.add(departamento);
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
	    // Retornar la lista de departamentos
	    return listaDepartamentos;
	}
		
	
	// Eliminar departamento
	public boolean eliminar(int idDepartamento) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM Departamento WHERE ID_Departamento = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idDepartamento);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
	
	
	// Modificar departamento
	public boolean modificar(Departamento departamento) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		try {
			connection.setAutoCommit(false);
			sql = "UPDATE Departamento SET Nombre=?, Capacidad=?, Número_Habitaciones=?, Descripción=?, Servicios_Incluidos=?, Disponibilidad=?, Precio_Por_Noche=? WHERE ID_Departamento=?";
			statement = connection.prepareStatement(sql);
				
			statement.setString(1, departamento.getNombre());
			statement.setInt(2, departamento.getCapacidad());
			statement.setInt(3, departamento.getNroHabitaciones());
			statement.setString(4, departamento.getDescripcion());
			statement.setString(5, departamento.getServiciosIncluidos());
			statement.setString(6, departamento.getDisponibilidad());
			statement.setDouble(7, departamento.getPrecioPorNoche());
			statement.setInt(8, departamento.getIdDepartamento());

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}
		
	
	// Recuperar los datos de un departamento específico desde la BD
	public Departamento obtenerPorId(int id) throws SQLException {
		Departamento departamento = null; // Inicializa el objeto departamento
		String sql = "SELECT * FROM Departamento WHERE ID_Departamento = ?"; // Consulta SQL
		Connection connection = obtenerConexion(); // Obtiene la conexión a la base de datos

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id); // Configura el parámetro ID en la consulta

		    try (ResultSet resultSet = statement.executeQuery()) {
		    	if (resultSet.next()) { // Si encuentra un resultado
		        	departamento = new Departamento(); // Crea una instancia del modelo Departamento
		            departamento.setIdDepartamento(resultSet.getInt("ID_Departamento"));
		            departamento.setNombre(resultSet.getString("Nombre"));
		            departamento.setCapacidad(resultSet.getInt("Capacidad"));
		            departamento.setNroHabitaciones(resultSet.getInt("Número_Habitaciones"));
		            departamento.setDescripcion(resultSet.getString("Descripción"));
		            departamento.setServiciosIncluidos(resultSet.getString("Servicios_Incluidos"));
		            departamento.setDisponibilidad(resultSet.getString("Disponibilidad"));
		            departamento.setPrecioPorNoche(resultSet.getDouble("Precio_Por_Noche"));
		    	}
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Re-lanza la excepción para que sea manejada por el servlet
		} finally {
			if (connection != null) {
		    	connection.close(); // Cierra la conexión
			}
		}
		return departamento; // Devuelve el objeto departamento o null si no se encuentra
	}

}
