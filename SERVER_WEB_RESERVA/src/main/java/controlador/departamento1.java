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
import data.DAODepartamento;
import data.DAOReserva;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Reserva;

/**
 * Servlet implementation class departamento1
 */
@WebServlet("/departamento1")
public class departamento1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public departamento1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String opcion = request.getParameter("opcion");
		 
		if (opcion != null && opcion.equals("ReservaDepartamento"))  {
			DAODepartamento daoDepartamento = new DAODepartamento();
		    List<Departamento> listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
		    request.setAttribute("listaDeDepartamentos", listaDepartamentos);
		    // Marcar que no se realizó una búsqueda específica
	        request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ReservaHabitaciones.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
	    } 
		
		
		
		
		else {
	    	DAODepartamento daoDepartamento = new DAODepartamento();
		    List<Departamento> listaDepartamentos = daoDepartamento.buscarPorId(-1); // Búsqueda sin filtro
		    request.setAttribute("listaDeDepartamentos", listaDepartamentos);
		    // Marcar que no se realizó una búsqueda específica
	        request.setAttribute("esBusqueda", false);
			// Crear el despachador con la ruta de la página
			RequestDispatcher rd = request.getRequestDispatcher("ReservaHabitaciones.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
	    }
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String opcion = request.getParameter("opcion");
		
		if (opcion != null && opcion.equals("ReservaDepartamento")) {
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
			RequestDispatcher rd = request.getRequestDispatcher("ReservaHabitaciones.jsp");
			// Ejecutar despachador
			rd.forward(request, response);
	      } else {
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
				RequestDispatcher rd = request.getRequestDispatcher("ReservaHabitaciones.jsp");
				// Ejecutar despachador
				rd.forward(request, response);
	      }
		
	}

}
