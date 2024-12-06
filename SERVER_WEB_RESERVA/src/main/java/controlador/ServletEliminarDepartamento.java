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

/**
 * Servlet implementation class ServletEliminarDepartamento
 */
@WebServlet("/eliminarDepartamento")
public class ServletEliminarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletEliminarDepartamento() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAODepartamento productoDAO = new DAODepartamento();
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			productoDAO.eliminar(id);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListadoDepartamento.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
