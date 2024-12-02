package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Departamento;

@WebServlet("/buscarDepartamento")
public class ServletBuscarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Buscar todos los departamentos al cargar la página
	    Departamento departamento = new Departamento();
	    List<Departamento> listaDepartamentos = departamento.buscarPorId(-1); // Búsqueda sin filtro
	    request.setAttribute("listaDeDepartamentos", listaDepartamentos);
		// Crear el despachador con la ruta de la página
		RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
		// Ejecutar despachador
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener el parámetro de búsqueda del ID del departamento
	    String idBuscarStr = request.getParameter("txtIdBuscar");

	    // Verificar si el parámetro está vacío
	    if (idBuscarStr == null || idBuscarStr.trim().isEmpty()) {
	    	// Si el ID está vacío, buscar todos los departamentos
	        Departamento departamento = new Departamento();
	        List<Departamento> listaDepartamentos = departamento.buscarPorId(-1); // Búsqueda sin filtro
	        request.setAttribute("listaDeDepartamentos", listaDepartamentos);
	    } else {
            // Convertir el parámetro a un entero y buscar por ID:
	    	// Intentar convertir el parámetro a un número entero
            int idBuscar = Integer.parseInt(idBuscarStr);
            // Instanciar clase Departamento
            Departamento departamento = new Departamento();
            // Ejecutar método de búsqueda y recoger resultados
            List<Departamento> listaDepartamentos = departamento.buscarPorId(idBuscar);
            // Enviar la lista de departamentos a la página correspondiente
            request.setAttribute("listaDeDepartamentos", listaDepartamentos);
        }
	    // Redirigir a la JSP:
		// Crear el despachador con la ruta de la página
		RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
		// Ejecutar despachador
		rd.forward(request, response);
	}

}
