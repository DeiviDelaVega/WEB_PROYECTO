package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAODepartamento;
import data.DAOEmpleado;
import data.DataBase;
import modelo.Departamento;
import modelo.Empleado;
import modelo.Usuario;


/**
 * Servlet implementation class servletEmpleado
 */
@WebServlet("/Empleado")
public class servletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		
		
		

		String opcion = request.getParameter("opcion");
		
		
		if (opcion != null && opcion.equals("eliminar")) {

			DAOEmpleado empleado = new DAOEmpleado();

			int id = Integer.parseInt(request.getParameter("id"));

			String correo = request.getParameter("correo");
			try {
				empleado.eliminar(id, correo);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("listadoEmpleado.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (opcion != null && opcion.equals("modificar"))

		{
			int idEmpleado = Integer.parseInt(request.getParameter("id")); // Obtiene el parámetro 'id' del enlace
			DAOEmpleado empleadoDAO = new DAOEmpleado();
			// Obtiene los datos del departamento por su ID
			Empleado empleado = empleadoDAO.obtenerPorId(idEmpleado);
			System.out.print("servlet "+empleado.getClave());
			// Establece el departamento como atributo de la solicitud
			request.setAttribute("empleado", empleado);
			// Redirige al JSP del formulario de modificación
			RequestDispatcher dispatcher = request.getRequestDispatcher("modificarEmpleado.jsp");
			dispatcher.forward(request, response);

		} else if (opcion != null && opcion.equals("detalle")) {
			int empleadoID = Integer.parseInt(request.getParameter("idEmpleado"));
			DAOEmpleado empleDAO = new DAOEmpleado();
			Empleado empleadoBuscado = empleDAO.obtenerPorId(empleadoID);
			request.setAttribute("eEmpleado", empleadoBuscado);
			request.getRequestDispatcher("detalleEmpleado.jsp").forward(request, response);
			
		} else if (opcion != null && opcion.equals("buscar")) {

			// Buscar todos los departamentos al cargar la página
			DAOEmpleado empleado = new DAOEmpleado();
			List<Empleado> listaEmpleados = empleado.buscarPorId(-1); // Búsqueda sin filtro
			request.setAttribute("listaDeEmpleados", listaEmpleados);

			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);

			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoEmpleado.jsp");
			// Ejecutar despachador
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		if (opcion != null && opcion.equals("registrar")) {

			// Obtener el parámetro de búsqueda del ID del departamento
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String telefono = request.getParameter("telefono");
			int nro_Documento = Integer.parseInt(request.getParameter("nro_documento"));
			String correoElectronico = request.getParameter("correo");
			String clave = request.getParameter("clave");

			DAOEmpleado dao = new DAOEmpleado();

			Empleado empleado = new Empleado( nombre, apellido, nro_Documento, telefono, clave,
					correoElectronico);

			boolean empleadoRegistrado = dao.registrarEmpleado(empleado);

			if (empleadoRegistrado) {
				response.sendRedirect("RegistroEmpleado.jsp?mensaje=" + "REGISTRO EXITOSO");

			}

		}

		else if (opcion != null && opcion.equals("buscar")) {

			// Obtener el parámetro de búsqueda del ID del Empleado
			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Empleado> listaEmpleado;
			DAOEmpleado emple = new DAOEmpleado();

			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listaEmpleado = emple.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Instanciar clase Departamento
				// Ejecutar método de búsqueda y recoger resultados
				listaEmpleado = emple.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listadoEmpleados", listaEmpleado);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoEmpleado.jsp");
			// Ejecutar despachador
			rd.forward(request, response);

		}

		// Modificar datos de departamento
		else if (opcion != null && opcion.equals("guardar")) {
			Empleado empleado = new Empleado();
			DAOEmpleado empleadoDAO = new DAOEmpleado();
			empleado.setId_Empleado(Integer.parseInt(request.getParameter("idEmpleado")));
			empleado.setNombre(request.getParameter("nombre"));
			empleado.setApellido(request.getParameter("apellido"));
			empleado.setNro_Documento(Integer.parseInt(request.getParameter("nro_documento")));
			empleado.setTelefono(request.getParameter("telefono"));
			empleado.setCorreo_Electronico(request.getParameter("correo"));
			empleado.setClave(request.getParameter("clave"));
			
			try {
				String correoAnterior = empleadoDAO.obtenerPorId(empleado.getId_Empleado()).getCorreo_Electronico();
				empleadoDAO.modificar(empleado, correoAnterior);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("listadoEmpleado.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Error al modificar el empleado.");
			}
		} else {
			
			String idBuscarStr = request.getParameter("txtIdBuscar");
		    boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
	        List<Empleado> listadoEmpleados;
	        // Instanciar DAODepartamento
	        DAOEmpleado daoempleado = new DAOEmpleado();
		    // Verificar si el parámetro está vacío
		    if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
		    	// Si el ID está vacío, buscar todos los departamentos
		    	listadoEmpleados = daoempleado.buscarPorId(-1); // Búsqueda sin filtro
		        esBusqueda = false; // No es una búsqueda específica
		    } else {
	            // Convertir el parámetro a un entero y buscar por ID:
		    	// Intentar convertir el parámetro a un número entero
	            int idBuscar = Integer.parseInt(idBuscarStr);
	            // Ejecutar método de búsqueda y recoger resultados
	            listadoEmpleados = daoempleado.buscarPorId(idBuscar);
	        }
	        // Enviar la lista de departamentos a la página correspondiente
		    request.setAttribute("listadoEmpleados", listadoEmpleados);
		    // Indicar si se trata de una búsqueda específica o no
	        request.setAttribute("esBusqueda", esBusqueda);
		    // Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoEmpleado.jsp");
	    	rd.forward(request, response);
			
			
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
