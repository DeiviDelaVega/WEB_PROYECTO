package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAOCliente;
import data.DAODepartamento;
import data.DAOReserva;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Reserva;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservaServlet() {
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

		if (opcion != null && opcion.equals("editarEstado")) {

			int idReserva = Integer.parseInt(request.getParameter("id"));

			// Aquí puedes llamar a tu DAO para obtener más detalles de la reserva si es
			// necesario
			DAOReserva reservaDAO = new DAOReserva();
			Reserva reserva;
			try {
				reserva = reservaDAO.obtenerPorId(idReserva);

				request.setAttribute("reserva", reserva);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Método que implementas en tu DAO

			// Pasar la reserva como atributo al JSP

			// Redirigir al JSP del formulario para editar el estado
			request.getRequestDispatcher("editarEstadoReserva.jsp").forward(request, response);

		} else if (opcion != null && opcion.equals("buscarReservas")) {

			DAOReserva daoReserva = new DAOReserva();
			List<Reserva> listaReservas = daoReserva.buscarPorId(-1); // Búsqueda sin filtro
			request.setAttribute("listaReservas", listaReservas);
			// Marcar que no se realizó una búsqueda específica
			request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listaReservas.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
		}
		
		// Para eliminar departamento
				else if (opcion != null && opcion.equals("eliminar")) {
					DAOReserva reservaDAO = new DAOReserva();
					int id = Integer.parseInt(request.getParameter("id"));
					try {
						reservaDAO.eliminar(id);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaReservas.jsp");
						requestDispatcher.forward(request, response);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

		else {
			// Obtener la sesión del usuario
			HttpSession session = request.getSession();
			String correoUsuario = (String) session.getAttribute("correoUsuario");

			DAOCliente daoCliente = new DAOCliente();
			DAOReserva daoReserva = new DAOReserva();

			// Obtener el cliente por correo
			Cliente cliente;
			try {
				cliente = daoCliente.obtenerPorCorreo(correoUsuario);

				if (cliente != null) {

					List<Reserva> reservas = daoReserva.obtenerReservasPorCliente(cliente.getId_Cliente());

					request.setAttribute("reservas", reservas);

					request.getRequestDispatcher("misReservas.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion != null && opcion.equals("registrar")) {

			Date fechaInicioReserva;
			Date fechaFinReserva;

			try {
				// Parseo de las fechas
				fechaInicioReserva = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaInicio"));
				fechaFinReserva = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaFin"));
				String metodoPago = request.getParameter("metodoPago");
				String totalPagoStr = request.getParameter("totalPago");

				int idDepartamento = Integer.parseInt(request.getParameter("idDepartamento"));

				// Elimina todo lo que no sea un número o punto decimal en el totalPagoStr
				totalPagoStr = totalPagoStr.replaceAll("[^0-9.-]", "");

				// Obtener el cliente a través del correo de sesión
				HttpSession session = request.getSession();
				String correoUsuario = (String) session.getAttribute("correoUsuario");

				DAOCliente daoCliente = new DAOCliente();
				DAODepartamento daoDepartamento = new DAODepartamento();

				Cliente cliente = daoCliente.obtenerPorCorreo(correoUsuario);
				Departamento departamento = daoDepartamento.buscarId(idDepartamento);

				System.out.println(correoUsuario);
				System.out.println("ID_Departamento: " + departamento);

				// Crear la reserva en la base de datos
				DAOReserva daoReserva = new DAOReserva();
				boolean reservaCreada = daoReserva.insertarReserva(cliente.getId_Cliente(),
						departamento.getIdDepartamento(), fechaInicioReserva, fechaFinReserva, metodoPago,
						totalPagoStr);

				if (reservaCreada) {
					// Pasar el ID del cliente al JSP como atributo
					request.setAttribute("clienteId", cliente.getId_Cliente());
					request.setAttribute("departamento", departamento);

					request.getRequestDispatcher("inicioCliente.jsp").forward(request, response);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion != null && opcion.equals("irConfirmar")) {
			// Obtener el ID del departamento desde la solicitud
			int departamentoId = Integer.parseInt(request.getParameter("departamentoId"));

			DAODepartamento DAODepartamento = new DAODepartamento();
			// Buscar el departamento en la base de datos (simulado aquí)
			Departamento departamento;
			try {
				departamento = DAODepartamento.obtenerPorId(departamentoId);
				request.setAttribute("departamento", departamento);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Guardar el departamento en el request para pasarlo a la página JSP de
			// confirmación

			// Redirigir a la página de confirmación
			RequestDispatcher dispatcher = request.getRequestDispatcher("ConfirmarReserva.jsp");
			dispatcher.forward(request, response);

		} else if (opcion != null && opcion.equals("actualizarEstado")) {

			int idReserva = Integer.parseInt(request.getParameter("idReserva"));
			String nuevoEstado = request.getParameter("estadoReserva");

			// Validar que el estado esté dentro de los permitidos (opcional si la base de
			// datos ya tiene un CHECK)
			if (!nuevoEstado.equals("Solicitado") && !nuevoEstado.equals("Aprobado") && !nuevoEstado.equals("Cancelado")
					&& !nuevoEstado.equals("Finalizado")) {
				request.setAttribute("mensaje", "Estado no válido.");
				request.getRequestDispatcher("ReservaServlet?opcion=buscarReservas").forward(request, response);
				return;
			}

			// Actualizar el estado en la base de datos
			DAOReserva reservaDAO = new DAOReserva();
			boolean actualizado = reservaDAO.actualizarEstado(idReserva, nuevoEstado);

			if (actualizado) {
				request.setAttribute("mensaje", "Estado actualizado correctamente.");
			} else {
				request.setAttribute("mensaje", "Error al actualizar el estado.");
			}

			// Redirigir de vuelta a la lista de reservas
			request.getRequestDispatcher("listaReservas.jsp").forward(request, response);
		} else if (opcion != null && opcion.equals("buscarReservas")) {
			String idBuscarStr = request.getParameter("txtIdBuscar");
			boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
			List<Reserva> listaReserva;
			// Instanciar DAODepartamento
			DAOReserva daoReserva= new DAOReserva();
			// Verificar si el parámetro está vacío
			if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
				// Si el ID está vacío, buscar todos los departamentos
				listaReserva = daoReserva.buscarPorId(-1); // Búsqueda sin filtro
				esBusqueda = false; // No es una búsqueda específica
			} else {
				// Convertir el parámetro a un entero y buscar por ID:
				// Intentar convertir el parámetro a un número entero
				int idBuscar = Integer.parseInt(idBuscarStr);
				// Ejecutar método de búsqueda y recoger resultados
				listaReserva = daoReserva.buscarPorId(idBuscar);
			}
			// Enviar la lista de departamentos a la página correspondiente
			request.setAttribute("listaReservas", listaReserva);
			// Indicar si se trata de una búsqueda específica o no
			request.setAttribute("esBusqueda", esBusqueda);
			// Redirigir a la JSP:
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("listaReservas.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
			
		}

		else {

			HttpSession session = request.getSession();
			String correoUsuario = (String) session.getAttribute("correoUsuario");

			DAOCliente daoCliente = new DAOCliente();
			DAOReserva daoReserva = new DAOReserva();

			// Obtener el cliente por correo
			Cliente cliente;
			try {
				cliente = daoCliente.obtenerPorCorreo(correoUsuario);

				if (cliente != null) {

					List<Reserva> reservas = daoReserva.obtenerReservasPorCliente(cliente.getId_Cliente());

					request.setAttribute("reservas", reservas);

					request.getRequestDispatcher("misReservas.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
