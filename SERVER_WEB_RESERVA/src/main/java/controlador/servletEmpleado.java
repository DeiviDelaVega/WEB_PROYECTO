package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataBase;


/**
 * Servlet implementation class servletEmpleado
 */
@WebServlet("/Empleado")
public class servletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	     int idAsignacion =Integer.parseInt(request.getParameter("rol")) ;
		 String nombre = request.getParameter("nombre");
		 String apellido = request.getParameter("apellido");
	     String fechaContratación = request.getParameter("fechaContrato");
	     String telefono = request.getParameter("telefono");
	     String correoElectrónico =  request.getParameter("correo");;
	     
	     
	  // 2. Procesar datos: Registrar
			// 2.1. Crear conexion a la BD
			Connection cnx=DataBase.getConnexion();
			String sql = "insert into Empleado(ID_Asignación,Nombre,Apellido,Fecha_Contratación,Teléfono,Correo_Electrónico)"+
					"values(?,?,?,?,?,?)";
			try {
				PreparedStatement ps = cnx.prepareStatement(sql);
				// 2.2. Completar la sentencia INSERT
			
				ps.setInt(1, idAsignacion);
				ps.setString(2, nombre);
				ps.setString(3, apellido);
				ps.setString(4, fechaContratación);
				ps.setString(5, telefono);
				ps.setString(6, correoElectrónico);
				
				
				// 2.3. Ejecutar INSERT
				int resultado = ps.executeUpdate(); // 1 si se registro, de lo contrario es 0
				String mensaje = (resultado==1)? "Registro satisfactorio":"Error en el registro";
				// 3. Respuesta del Servlet
				response.sendRedirect("registroEmpleado.jsp?mensaje=" + mensaje);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
