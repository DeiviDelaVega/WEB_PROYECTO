package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DataBase;

/**
 * Servlet implementation class servletUsuario
 */
@WebServlet("/usuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String Clave = request.getParameter("clave");
		 String Usuario =request.getParameter("usuario");
		 
		  // 2. Procesar datos: Registrar
			// 2.1. Crear conexion a la BD
			Connection cnx=DataBase.getConnexion();
			String sql = "select*from USUARIO where clave = ? and  usuario =?";
				
			try {
				PreparedStatement ps = cnx.prepareStatement(sql);
				// 2.2. Completar la sentencia INSERT
				ps.setString(1,Clave);
				ps.setString(2, Usuario);
			
				
				// 2.3. Ejecutar SELECT
				ResultSet resultado = ps.executeQuery(); // 1 si se registro, de lo contrario es 0
				if(resultado.next()) {
					
					response.sendRedirect("registroEmpleado.jsp");
				}else {
					response.sendRedirect("login.jsp?mensaje=" + "Credenciales incorrectas");
				}
				// 3. Respuesta del Servlet
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		 
		
		
	}


