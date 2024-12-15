package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Departamento;
import modelo.Reserva;

public class DAOReserva {

    // Constructor, pasando la conexión
	Connection con = DataBase.getConnexion();

    // Método para insertar una nueva reserva en la base de datos
	public boolean insertarReserva(int idCliente, int idDepartamento, Date fechaInicioReserva, Date fechaFinReserva, String metodoPago, String totalPagoStr) {
	    String sql = "INSERT INTO Reserva (ID_Cliente, ID_Departamento, Fecha_Inicio_Reserva, Fecha_Fin_Reserva, Metodo_Pago, Monto_Total) VALUES (?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        // Conversión de java.util.Date a java.sql.Date
	        statement.setInt(1, idCliente);
	        statement.setInt(2, idDepartamento);
	        statement.setDate(3, new java.sql.Date(fechaInicioReserva.getTime()));
	        statement.setDate(4, new java.sql.Date(fechaFinReserva.getTime()));
	        statement.setString(5, metodoPago);
	        statement.setString(6, totalPagoStr);

	        // Ejecuta la consulta y retorna true si afectó alguna fila
	        return statement.executeUpdate() > 0;

	    } catch (SQLException e) {
	        // Imprime el error en consola para depuración
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	 public List<Reserva> buscarPorId(int idBuscar) {
	        // Declarar la lista de Reserva
	        List<Reserva> listaReservas = new ArrayList<>();
	        try {
	            // Preparar la instrucción SQL
	            PreparedStatement ps;
	            if (idBuscar == -1) {
	                // Buscar todas las reservas
	                ps = con.prepareStatement("SELECT * FROM Reserva");
	            } else {
	                // Buscar por ID
	                ps = con.prepareStatement("SELECT * FROM Reserva WHERE ID_Solicitud = ?");
	                ps.setInt(1, idBuscar); // Asignar el parámetro
	            }

	            // Ejecutar la instrucción SQL y recoger los resultados
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                // Instanciar objeto reserva
	                Reserva reserva = new Reserva();
	                // Guardar los valores de la fila en el objeto
	                reserva.setIdSolicitud((rs.getInt("ID_Solicitud")));
	                reserva.setIdCliente(rs.getInt("ID_Cliente"));
	                reserva.setIdDepartamento(rs.getInt("ID_Departamento"));
	                reserva.setFechaInicioReserva(rs.getDate("Fecha_Inicio_Reserva"));
	                reserva.setFechaFinReserva(rs.getDate("Fecha_Fin_Reserva"));
	                reserva.setMetodoPago(rs.getString("Metodo_Pago"));
	                reserva.setMontoTotal(rs.getDouble("Monto_Total"));
	                reserva.setEstadoReserva(rs.getString("Estado_Reserva"));

	                // Agregar la reserva a la lista de reservas
	                listaReservas.add(reserva);
	            }
	        } catch (SQLException e) {
	            // Imprimir error en caso de excepción
	            e.printStackTrace();
	        } finally {
	            // Cerrar la conexión con la BD
	            try {
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        // Retornar la lista de reservas
	        return listaReservas;
	    }
	
	 public boolean actualizarEstado(int idReserva, String nuevoEstado) {
		    String sql = "UPDATE Reserva SET Estado_Reserva = ? WHERE ID_Solicitud = ?";

		    try ( Connection con = DataBase.getConnexion();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		        ps.setString(1, nuevoEstado);
		        ps.setInt(2, idReserva);

		        int rowsAffected = ps.executeUpdate();
		        return rowsAffected > 0; // Retorna true si se actualizó al menos una fila
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
	 
	 public Reserva obtenerPorId(int idBuscar) throws SQLException {
		    // Declarar la instancia de Reserva
		    Reserva reserva = null;

		    // Consulta SQL para buscar por ID
		    String sql = "SELECT * FROM Reserva WHERE ID_Solicitud = ?";

		    // Obtener la conexión a la base de datos
		    Connection connection = DataBase.getConnexion();

		    try (PreparedStatement ps = connection.prepareStatement(sql)) {
		        // Configurar el parámetro ID en la consulta
		        ps.setInt(1, idBuscar);

		        // Ejecutar la consulta
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                // Crear una nueva instancia de Reserva y asignar valores
		                reserva = new Reserva();
		                reserva.setIdSolicitud(rs.getInt("ID_Solicitud"));
		                reserva.setIdCliente(rs.getInt("ID_Cliente"));
		                reserva.setIdDepartamento(rs.getInt("ID_Departamento"));
		                reserva.setFechaInicioReserva(rs.getDate("Fecha_Inicio_Reserva"));
		                reserva.setFechaFinReserva(rs.getDate("Fecha_Fin_Reserva"));
		                reserva.setMetodoPago(rs.getString("Metodo_Pago"));
		                reserva.setMontoTotal(rs.getDouble("Monto_Total"));
		                reserva.setEstadoReserva(rs.getString("Estado_Reserva"));
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        throw e; // Re-lanzar la excepción para manejo fuera del método
		    } finally {
		        // Cerrar la conexión
		        if (connection != null) {
		            connection.close();
		        }
		    }

		    // Retornar la reserva o null si no se encontró
		    return reserva;
		}
	 
	 public List<Reserva> obtenerReservasPorCliente(int idCliente) {
		    List<Reserva> reservas = new ArrayList<>();
		    String sql = "SELECT r.ID_Solicitud, r.Fecha_Inicio_Reserva, r.Fecha_Fin_Reserva, " +
		                 "r.Metodo_Pago, r.Monto_Total, r.Estado_Reserva, d.Nombre AS Departamento " +
		                 "FROM Reserva r " +
		                 "JOIN Departamento d ON r.ID_Departamento = d.ID_Departamento " +
		                 "WHERE r.ID_Cliente = ?";

		    try ( Connection connection = DataBase.getConnexion();
		         PreparedStatement stmt = connection.prepareStatement(sql)) {
		        stmt.setInt(1, idCliente);
		        try (ResultSet rs = stmt.executeQuery()) {
		            while (rs.next()) {
		                Reserva reserva = new Reserva();
		                reserva.setIdSolicitud(rs.getInt("ID_Solicitud"));
		                reserva.setFechaInicioReserva(rs.getDate("Fecha_Inicio_Reserva"));
		                reserva.setFechaFinReserva(rs.getDate("Fecha_Fin_Reserva"));
		                reserva.setMetodoPago(rs.getString("Metodo_Pago"));
		                reserva.setMontoTotal(rs.getDouble("Monto_Total"));
		                reserva.setEstadoReserva(rs.getString("Estado_Reserva"));

		                Departamento departamento = new Departamento();
		                departamento.setNombre(rs.getString("Departamento"));
		                reserva.setIdDepartamento(idCliente);

		                reservas.add(reserva);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return reservas;
		}

	 
	

}
