package controlador;

import javax.swing.JOptionPane;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleado;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class GestionEmpleado
 */
@WebServlet(name = "GestionEmpleadoBaja", urlPatterns = "/GestionEmpleadoBaja")
public class GestionEmpleadoBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEmpleadoBaja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Recogemos del request la informacion del empleado para formar el objeto empleado y posteriormente
	 * llamar a la funcion eliminar del objeto empleado
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request de tipo HttpServletRequest
	 * @param response de tipo HttpServletResponse
	 * @throws ServletException excepcion
	 * @throws IOException excepcion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
		String Pcargo = request.getParameter("id_cargo");
		String Pmail = request.getParameter("mail");
		
		int id_empleadobaja = Integer.parseInt(request.getParameter("id_empleadobaja"));
		
		Empleado emp = new Empleado (id_empleadobaja);
		try {
			emp.eliminar();
			JOptionPane.showMessageDialog(null, "El empleado se ha dado de baja correctamente.", "Baja correcta", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("BajaEmpleado.jsp?id_empleado="+id_empleado+"&mail="+Pmail+"&id_cargo="+Pcargo);
		}catch (SQLException | ParseException e) {
			
			e.printStackTrace();
		}
		
	}
}
