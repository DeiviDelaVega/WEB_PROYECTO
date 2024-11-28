package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
	
	
	public static Connection getConnexion() {
		
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String conexion = "jdbc:mysql//localhost:3306/DB_Reserva_Alojamiento_Temporal";
			String usuario = "root";
			String contrasena = "alomomola890.";
			
			con = DriverManager.getConnection(conexion, usuario, contrasena);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
}
