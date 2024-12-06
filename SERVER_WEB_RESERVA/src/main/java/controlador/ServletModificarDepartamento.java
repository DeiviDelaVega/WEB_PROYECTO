package controlador;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DAODepartamento;
import modelo.Departamento;

/**
 * Servlet implementation class ServletModificarDepartamento
 */
@WebServlet("/modificarDepartamento")
public class ServletModificarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModificarDepartamento() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener datos de la BD
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
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los datos del departamento.");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Modificar
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

	}

}
