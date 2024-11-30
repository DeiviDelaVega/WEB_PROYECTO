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
		  HttpSession session = request.getSession();
	        Usuario admin = (Usuario) session.getAttribute("usuario");

	        if (admin != null && "Admin".equals(admin.getRol())) {
	            String nombre = request.getParameter("nombre");
	            String correo = request.getParameter("correo");
	            String clave = request.getParameter("clave");

	            try {
	                UsuarioDao dao = new UsuarioDao();

	                Usuario empleado = new Usuario(nombre, correo, clave, "Empleado");

	                if (dao.registrarUsuario(empleado)) {
	                    response.sendRedirect("admin.jsp?success=Empleado creado con éxito");
	                } else {
	                    response.sendRedirect("admin.jsp?error=No se pudo crear el empleado.");
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                response.sendRedirect("admin.jsp?error=Error del servidor.");
	            }
	        } else {
	            response.sendRedirect("login.jsp?error=Acceso no autorizado");
	        }
	 
	}
	


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
