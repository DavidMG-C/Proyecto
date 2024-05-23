package controlador;

import javax.swing.JOptionPane;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class GestionEmpleado
 */
@WebServlet(name = "GestionModificarContrasegna", urlPatterns = "/GestionModificarContrasegna")
public class GestionModificarContrasegna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionModificarContrasegna() {
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
	 * Recogemos del request la información del usuario, junto con la contrasegna antigua
	 * y actual. Con esta información se crea un nuevo objeto usuario y se hace llamada
	 * al metodo updpwd del objeto usuario.
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
		String pwdactual = request.getParameter("pwdactual");
		String pwdnueva = request.getParameter("pwdnueva");
		
		
		Usuario u = new Usuario (Pmail, pwdnueva, Pcargo);
		try {
			u.updpwd();
			JOptionPane.showMessageDialog(null, "Contraseña modificada correctamente.", "Modificacion correcta", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("ModificarContrasegna.jsp?id_empleado="+id_empleado+"&mail="+Pmail+"&id_cargo="+Pcargo);
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}