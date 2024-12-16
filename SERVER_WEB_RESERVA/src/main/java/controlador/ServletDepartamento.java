package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import data.DAODepartamento;
import modelo.Departamento;
import modelo.ReporteDepartamento;

/**
 * Servlet implementation class ServletDepartamento
 */
@WebServlet("/departamento")
@MultipartConfig
public class ServletDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDepartamento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Buscar todos los departamentos al cargar la página

		String opcion = request.getParameter("opcion");

		System.out.println("doget_opcion = " + opcion);

		// Buscar todos los departamentos al cargar la página
		if (opcion != null && opcion.equals("buscarDepartamento")) {
			DAODepartamento daoDepartamento = new DAODepartamento();
			List<Departamento> listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
			request.setAttribute("listaDeDepartamentos", listaDepartamentos);
			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		}

		// Para eliminar departamento
		else if (opcion != null && opcion.equals("eliminar")) {
			DAODepartamento productoDAO = new DAODepartamento();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				productoDAO.eliminar(id);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListadoDepartamento.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Obtener datos de la BD para llenar los input de modificar
		else if (opcion != null && opcion.equals("modificar")) {
			String idDepartamento = request.getParameter("id"); // Obtiene el parámetro 'id' del enlace
			DAODepartamento departamentoDAO = new DAODepartamento();
			try {
				// Obtiene los datos del departamento por su ID
				Departamento departamento = departamentoDAO.obtenerPorId(Integer.parseInt(idDepartamento));

				// Establece el departamento como atributo de la solicitud
				request.setAttribute("departamento", departamento);

				// Redirige al JSP del formulario de modificación
				RequestDispatcher dispatcher = request.getRequestDispatcher("ModificarDepartamento.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
						"Error al obtener los datos del departamento.");
			}
		}

		// Detalle de departamento
		else if (opcion != null && opcion.equals("detalle")) {
			int depaID = Integer.parseInt(request.getParameter("idDepartamento"));
			DAODepartamento depaDAO = new DAODepartamento();
			Departamento depaBuscado = depaDAO.buscarId(depaID);
			request.setAttribute("eDepartamento", depaBuscado);

			request.getRequestDispatcher("DetalleDepartamento.jsp").forward(request, response);
		} 
		
		// Reporte de los Departamentos mas reservados
		else if (opcion != null && opcion.equals("listarReporteDepartamento")) {
			DAODepartamento daoDepartamento = new DAODepartamento();
			List<ReporteDepartamento> listaReporteDepartamentos = daoDepartamento.ObtenerDepartamentosConMasReservas();
			request.setAttribute("listaDeReporte", listaReporteDepartamentos);
			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ReporteDepartarmento.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		} else {
			DAODepartamento daoDepartamento = new DAODepartamento();
			List<Departamento> listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
			request.setAttribute("listaDeDepartamentos", listaDepartamentos);
			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		System.out.println("depa_opcion = " + opcion);

		if (opcion != null && opcion.equals("buscarDepartamento")) {
			// Obtener el parámetro de búsqueda del ID del departamento
			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Departamento> listaDepartamentos;
			// Instanciar DAODepartamento
			DAODepartamento daoDepartamento = new DAODepartamento();
			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Ejecutar método de búsqueda y recoger resultados
				listaDepartamentos = daoDepartamento.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listaDeDepartamentos", listaDepartamentos);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		} else if (opcion != null && opcion.equals("AgregarDepartamento")) {

			String nombre = request.getParameter("nombre");
			int capacidad = Integer.parseInt(request.getParameter("capacidad"));
			int nroHabitaciones = Integer.parseInt(request.getParameter("nroHabitaciones"));
			String descripcion = request.getParameter("descripcion");
			String serviciosIncluidos = request.getParameter("serviciosIncluidos");
			String disponibilidad = request.getParameter("disponibilidad");
			double precioPorNoche = Double.parseDouble(request.getParameter("precioPorNoche"));
			Part part = request.getPart("imagenDepartamento");
			InputStream inputStream = part.getInputStream();

			String mensaje = null;

			try {
				// Subir imagen a Cloudinary y obtener URL

				// Registrar los datos en la base de datos utilizando el DAO
				DAODepartamento dao = new DAODepartamento();

				String imageUrl = dao.uploadToCloudinary(inputStream);

				int resultado = dao.insertDepartamento(nombre, capacidad, nroHabitaciones, descripcion,
						serviciosIncluidos, disponibilidad, precioPorNoche, imageUrl);

				if (resultado == 1) {
					mensaje = "Registro exitoso";
				} else {
					mensaje = "Error en el registro";
				}
			} catch (Exception e) {
				e.printStackTrace();
				mensaje = "Error: " + e.getMessage();
			} finally {
				inputStream.close();
			}
			// Enviar mensaje al JSP
			request.setAttribute("mensaje", mensaje);

			request.getRequestDispatcher("RegistrarDepartamento.jsp").forward(request, response);
		}

		// Modificar datos de departamento
		else if (opcion != null && opcion.equals("guardar")) {
			Departamento departamento = new Departamento();
			DAODepartamento departamentoDAO = new DAODepartamento();
			departamento.setIdDepartamento(Integer.parseInt(request.getParameter("idDepartamento")));
			departamento.setNombre(request.getParameter("nombre"));
			departamento.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
			departamento.setNroHabitaciones(Integer.parseInt(request.getParameter("nroHabitaciones")));
			departamento.setDescripcion(request.getParameter("descripcion"));
			departamento.setServiciosIncluidos(request.getParameter("serviciosIncluidos"));
			departamento.setDisponibilidad(request.getParameter("disponibilidad"));
			departamento.setPrecioPorNoche(Double.parseDouble(request.getParameter("precioPorNoche")));

			try {
				departamentoDAO.modificar(departamento);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListadoDepartamento.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Error al modificar el departamento.");
			}
		} else {
			// Obtener el parámetro de búsqueda del ID del departamento
			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Departamento> listaDepartamentos;
			// Instanciar DAODepartamento
			DAODepartamento daoDepartamento = new DAODepartamento();
			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Ejecutar método de búsqueda y recoger resultados
				listaDepartamentos = daoDepartamento.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listaDeDepartamentos", listaDepartamentos);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
			rd.forward(request, response);

		}

	}
}
