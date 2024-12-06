package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.DataBase;
import modelo.Departamento;

public class DAODepartamento {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	
	// Obtener conexion a la BD
	private Connection obtenerConexion() throws SQLException {
		return DataBase.getConnexion();
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
