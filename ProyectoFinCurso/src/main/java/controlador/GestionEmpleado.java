package controlador;
/**
 * importamos las librerias necesarias
 */
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
public class GestionEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEmpleado() {
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
	 * insertarlo en la base de datos.
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
		String id_cargo = request.getParameter("cargo");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido1 = request.getParameter("apellido1");
		String apellido2 = request.getParameter("apellido2");
		String f_nacimiento = request.getParameter("f_nacimiento");
		String direccion = request.getParameter("direccion");
		String n_cuenta = request.getParameter("n_cuenta");
		String departamento = request.getParameter("departamento");
		String contrato = request.getParameter("contrato");
		String salario = request.getParameter("salario");
		String f_incorporacion = request.getParameter("f_incorporacion");
		String email = request.getParameter("email");
		
		Empleado emp = new Empleado (id_cargo, dni, nombre, apellido1, apellido2, f_nacimiento,direccion,n_cuenta,departamento,contrato, salario, f_incorporacion,email);
		try {
			emp.insertar();
			JOptionPane.showMessageDialog(null, "El empleado se ha dado de alta correctamente.", "Alta correcta", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("AltaEmpleado.jsp?id_empleado="+id_empleado+"&mail="+Pmail+"&id_cargo="+Pcargo);
		}catch (SQLException | ParseException e) {
			
			e.printStackTrace();
		}
		
	}
}
