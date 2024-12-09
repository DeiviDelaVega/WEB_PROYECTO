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
import javax.servlet.http.HttpSession;

import data.DataBase;
import modelo.DAOEmpleado;
import modelo.Empleado;
import modelo.Usuario;
import modelo.UsuarioDao;


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
		     String telefono = request.getParameter("telefono");
		     int nro_Documento =Integer.parseInt(request.getParameter("nro_documento"));
		     String correoElectronico =  request.getParameter("correo");
		     String clave = request.getParameter("clave");
		     

				DAOEmpleado dao = new DAOEmpleado();
				
				Empleado empleado= new Empleado(idAsignacion,nombre,apellido,nro_Documento,telefono, clave,correoElectronico);
				
				try {
					boolean empleadoRegistrado = dao.registrarEmpleado(empleado);
					
					if (empleadoRegistrado ) {
						response.sendRedirect("RegistroEmpleado.jsp?mensaje=" + "REGISTRO EXITOSO");	
						
					 } else {
						
						
							response.sendRedirect("RegistroEmpleado.jsp?mensaje=" + "ERROR EN EL REGISTRO RATA");					
					
					 }
					
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response.sendRedirect("login.jsp");
				}
				
			}
			
		
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
