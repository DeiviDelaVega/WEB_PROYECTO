package controlador;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		
		
		DAOUsuario dao = new DAOUsuario();
		
		try {
			Usuario usuario = dao.validarUsuario(correo, clave);
			
			System.out.print("usuario"+usuario.getRol());
			if (usuario != null) {
				
				HttpSession sn = request.getSession();
				
				sn.setAttribute("usuario", usuario);
				sn.setAttribute("correoUsuario", usuario.getCorreo());

				switch (usuario.getRol()) {
		
				case "admin":
					response.sendRedirect("RegistroEmpleado.jsp");
					break;
				case "empleado":
					response.sendRedirect("inicioEmpleado.jsp");
					break;
				case "cliente":
					response.sendRedirect("inicioCliente.jsp");
					break;
				
			    } 
			 } else {
				
				response.sendRedirect("login.jsp");
			
			
			 }
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
		
	}

}
