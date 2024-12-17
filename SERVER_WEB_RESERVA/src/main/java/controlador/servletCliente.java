package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOCliente;
import data.DAOEmpleado;
import modelo.Cliente;
import modelo.Empleado;
import modelo.ReporteCliente;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion != null && opcion.equals("eliminar")) {

			DAOCliente daocliente = new DAOCliente();

			int id = Integer.parseInt(request.getParameter("id"));

			String correo = request.getParameter("correo");
			try {
				daocliente.eliminar(id, correo);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("listadoCliente.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (opcion != null && opcion.equals("modificar"))

		{
			int idCliente = Integer.parseInt(request.getParameter("id"));
			DAOCliente daocliente = new DAOCliente();
			// Obtiene los datos del departamento por su ID
			Cliente Cliente;
			Cliente = daocliente.obtenerPorId(idCliente);

			request.setAttribute("cliente", Cliente);

			// Redirige al JSP del formulario de modificación
			RequestDispatcher dispatcher = request.getRequestDispatcher("modificarCliente.jsp");
			dispatcher.forward(request, response);

		} else if (opcion != null && opcion.equals("detalle")) {
			int clienteID = Integer.parseInt(request.getParameter("idCliente"));
			DAOCliente daocliente = new DAOCliente();
			Cliente clienteBuscado;
			clienteBuscado = daocliente.obtenerPorId(clienteID);
			request.setAttribute("eCliente", clienteBuscado);

			request.getRequestDispatcher("detalleCliente.jsp").forward(request, response);
			// TODO Auto-generated catch block

		} else if (opcion != null && opcion.equals("buscar")) {

			// Buscar todos los departamentos al cargar la página
			DAOCliente daocliente = new DAOCliente();
			List<Cliente> listaClientes = daocliente.buscarPorId(-1); // Búsqueda sin filtro
			request.setAttribute("listaClientes", listaClientes);

			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);

			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoCliente.jsp");
			// Ejecutar despachador
			rd.forward(request, response);

		} else if (opcion != null && opcion.equals("listarReporteCliente")) {
			DAOCliente daocliente = new DAOCliente();
			List<ReporteCliente> listaReporteClientes = daocliente.ObtenerClientesConMasReservas();
			request.setAttribute("listaDeReporte", listaReporteClientes);

			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);

			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("reporteClienteMasReservan.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion != null && opcion.equals("registrar")) {
			 HttpSession sesion= request.getSession(); 
			String rolUsuario = (String)sesion.getAttribute("rol");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			int nro_Documento = Integer.parseInt(request.getParameter("nro_documento"));
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String correoElectronico = request.getParameter("correo");
			String clave = request.getParameter("clave");

			DAOCliente dao = new DAOCliente();

			Cliente cliente = new Cliente(nombre, apellido, nro_Documento, direccion, telefono, correoElectronico,
					clave);

			try {
				boolean clienteRegistrado = dao.registrarCliente(cliente);
                   System.out.print(clienteRegistrado);
				if (!clienteRegistrado) {
				
					response.sendRedirect("RegistroCliente.jsp?mensaje="+"El correo ya existe");


				}else {
					System.out.print(rolUsuario+"hola");
					if(rolUsuario !=null || !rolUsuario.equals("")) {
						
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("cliente?opcion=buscar");
						requestDispatcher.forward(request, response);
						
					}else {
						
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
						requestDispatcher.forward(request, response);
						
					

				}}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("login.jsp");
			}

		}

		else if (opcion != null && opcion.equals("buscar")) {

			// Obtener el parámetro de búsqueda del ID del Empleado
			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Cliente> listaCliente;
			DAOCliente clientedao = new DAOCliente();

			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listaCliente = clientedao.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Instanciar clase Departamento
				// Ejecutar método de búsqueda y recoger resultados
				listaCliente = clientedao.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listaClientes", listaCliente);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoCliente.jsp");
			// Ejecutar despachador
			rd.forward(request, response);

		}

		// Modificar datos de departamento
		else if (opcion != null && opcion.equals("guardar")) {
			Cliente cliente = new Cliente();
			DAOCliente daocliente = new DAOCliente();
			cliente.setId_Cliente(Integer.parseInt(request.getParameter("idCliente")));
			cliente.setNombre(request.getParameter("nombre"));
			cliente.setApellido(request.getParameter("apellido"));
			cliente.setNro_Documento(Integer.parseInt(request.getParameter("nro_documento")));
			cliente.setTelefono(request.getParameter("telefono"));
			cliente.setDireccion(request.getParameter("direccion"));
			cliente.setCorreo(request.getParameter("correo"));
			cliente.setClave(request.getParameter("clave"));

			try {
				String correoAnterior = daocliente.obtenerPorId(cliente.getId_Cliente()).getCorreo();
				daocliente.modificar(cliente, correoAnterior);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("cliente?opcion=buscar");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Error al modificar el cliente.");
			}
		} else {

			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Cliente> listadoClientes;
			// Instanciar DAODepartamento
			DAOCliente daocliente = new DAOCliente();
			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listadoClientes = daocliente.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Ejecutar método de búsqueda y recoger resultados
				listadoClientes = daocliente.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listadoClientes", listadoClientes);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listadoCliente.jsp");
			rd.forward(request, response);

		}

	}

}
