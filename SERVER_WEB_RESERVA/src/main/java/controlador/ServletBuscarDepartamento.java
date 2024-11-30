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
	        // Si el parámetro está vacío, puedes redirigir con un mensaje de error o mostrar un mensaje en la JSP
	        request.setAttribute("error", "El campo ID no puede estar vacío.");
	        RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
	        rd.forward(request, response);
	        return; // Salir del método si no se recibe un valor válido
	    }
	    
		// Intentar convertir el parámetro a un número entero
        int idBuscar = Integer.parseInt(idBuscarStr);
		// Instanciar clase Departamento
		Departamento departamento = new Departamento();
		// Ejecutar método de búsqueda y recoger resultados
		List<Departamento> listaDepartamentos = departamento.buscarPorId(idBuscar);
		// Enviar la lista de departamentos a la página correspondiente
		request.setAttribute("listaDeDepartamentos", listaDepartamentos);
		// Crear el despachador con la ruta de la página
		RequestDispatcher rd = request.getRequestDispatcher("ListadoDepartamento.jsp");
		// Ejecutar despachador
		rd.forward(request, response);
	}

}
