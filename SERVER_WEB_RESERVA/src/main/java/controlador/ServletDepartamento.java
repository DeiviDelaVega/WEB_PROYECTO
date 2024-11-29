package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import data.DataBase;

/**
 * Servlet implementation class ServletDepartamento
 */
@WebServlet("/departamento")
public class ServletDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletDepartamento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Para registrar datos
		// 1. Leer datos de formulario (con el name)
	    String nombre = request.getParameter("nombre");
	    int capacidad =  Integer.parseInt(request.getParameter("capacidad"));
	    int nroHabitaciones =  Integer.parseInt(request.getParameter("nroHabitaciones"));
	    String descripcion = request.getParameter("descripcion");
	    String serviciosIncluidos = request.getParameter("serviciosIncluidos");
	    String disponibilidad = request.getParameter("disponibilidad");
	    String precioPorNoche = request.getParameter("precioPorNoche");
	    // Obtener el archivo de imagen cargado en el formulario
	//    Part imagenPart = request.getPart("imagenHabitacion"); // "imagenHabitacion" es el name del input de tipo file

	    // Convertir el archivo de imagen a un arreglo de bytes
	   // byte[] imagenBytes = null;
	    //if (imagenPart != null) {
	        // Leer el archivo como un arreglo de bytes
	      //  imagenBytes = new byte[(int) imagenPart.getSize()];
	       // imagenPart.getInputStream().read(imagenBytes);
	    
		
	    // 2. Procesar datos: Registrar
			// 2.1. Crear conexion a la BD
		Connection cnx = DataBase.getConnexion();
		String sql ="INSERT INTO Departamento(Nombre,Capacidad,Número_Habitaciones,Descripción,Servicios_Incluidos,Disponibilidad,Precio_Por_Noche)"+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
				// 2.2. Completar la sentencia INSERT
			ps.setString(1, nombre);
			ps.setInt(2,capacidad);
			ps.setInt(3,nroHabitaciones);
			ps.setString(4, descripcion);
			ps.setString(5, serviciosIncluidos);
			ps.setString(6, disponibilidad);
			ps.setDouble(7, Double.parseDouble(precioPorNoche));
			
			// Aquí es donde hemos cambiado a setBytes para almacenar los datos binarios de la imagen
	        //if (imagenBytes != null) {
	        // ps.setBytes(8, imagenBytes); // Establecer la imagen como un arreglo de bytes
	        //}
					
			// 2.3. Ejecutar INSERT
			int resultado = ps.executeUpdate(); // 1 si se registro, de lo contrario es 0
			
			if (resultado > 0) {
	            response.getWriter().append("Departamento registrado correctamente.");
	        } else {
	            response.getWriter().append("Error al registrar el departamento.");
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
