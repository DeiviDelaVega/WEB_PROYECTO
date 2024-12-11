package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAOEmpleado;
import modelo.Empleado;

/**
 * Servlet implementation class ServletBuscarEmpleado
 */
@WebServlet("/buscarEmpleado")
public class ServletBuscarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBuscarEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener el parámetro de búsqueda del ID del departamento
	    String idBuscarStr = request.getParameter("txtIdBuscar");
	    boolean esBusqueda = true; // Indica que se realizó una búsqueda específica
        List<Empleado> listaEmpleado;
        
     
	    // Verificar si el parámetro está vacío
	    if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
	    	// Si el ID está vacío, buscar todos los departamentos
	    	   DAOEmpleado empleado = new DAOEmpleado();
	        listaEmpleado = empleado.buscarPorId(-1); // Búsqueda sin filtro
	        esBusqueda = false; // No es una búsqueda específica
	    } else {
            // Convertir el parámetro a un entero y buscar por ID:
	    	// Intentar convertir el parámetro a un número entero
            int idBuscar = Integer.parseInt(idBuscarStr);
            // Instanciar clase Departamento
            DAOEmpleado empleado = new DAOEmpleado();
            // Ejecutar método de búsqueda y recoger resultados
            listaEmpleado = empleado.buscarPorId(idBuscar);
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
	}


