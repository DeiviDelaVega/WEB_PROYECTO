package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {

	public static Connection getConnexion() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			String conexion = "jdbc:mysql://localhost:3306/DB_Reserva_AlojamientoTemporal";
			String usuario = "root";
			String contrasena = "Madeley29.";

			
			con = DriverManager.getConnection(conexion, usuario, contrasena);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error: No se encontró el driver JDBC.");
			e.printStackTrace();
		} catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            //HOLA
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
