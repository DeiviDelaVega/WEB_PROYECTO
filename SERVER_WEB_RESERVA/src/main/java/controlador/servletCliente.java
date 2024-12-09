package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.DAOCliente;

/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/cliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombre = request.getParameter("nombre");
		 String apellido = request.getParameter("apellido");
	     int nro_Documento =Integer.parseInt(request.getParameter("nro_documento"));
	     String direccion =request.getParameter("direccion");
	     String telefono = request.getParameter("telefono");
	     String correoElectronico =  request.getParameter("correo");
	     String clave = request.getParameter("clave");
	     
	     DAOCliente dao = new DAOCliente();
	     
	   
	     Cliente cliente =new Cliente(nombre, apellido,  nro_Documento,  direccion,  telefono,correoElectronico,clave);
	     
	     
	 	try {
			boolean clienteRegistrado = dao.registrarCliente(cliente);
			
			if (clienteRegistrado ) {
				response.sendRedirect("inicioCliente.jsp");

				
			 } else {
				
				
					response.sendRedirect("RegistroCliente.jsp?mensaje=" + "ERROR EN EL REGISTRO RATA");					
			
			 }
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("login.jsp");
		}
	}
	

}
