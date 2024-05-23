package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import modelo.Empleado;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class GestionFichaEmpleado
 */
public class GestionFichaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionFichaEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	 /**
	 * Recogemos del request el email para formar un objeto de tipo empleado con ese email y llamar
	 * a la funcion FichaEmpleado del objeto empleado, devolviendo en el response el objeto 
	 * en formato JSON llamandose al metodo toJSON del objeto empleado.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request de tipo HttpServletRequest
	 * @param response de tipo HttpServletResponse
	 * @throws ServletException excepcion
	 * @throws IOException excepcion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");


		Empleado emp = new Empleado(email);
		
		try {
			emp.fichaempleado();
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(emp.toJSON()); 
	    
			}
		catch (SQLException | ParseException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
