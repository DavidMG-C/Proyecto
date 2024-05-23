package controlador;

import jakarta.servlet.ServletException;
import javax.swing.JOptionPane;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;



/**
 * Servlet implementation class GestionUsuario
 */
public class GestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * Recogemos del request los parametro del usuario, guardamos en la sesion el mail introducido
	 * en las credenciales y con ello creamos un objeto de tipo usuario.
	 * A continuacion comprobamos que este usuario existe en la base de datos a traves del metodo comprobar
	 * del objeto usuario. Si no existe el usuario se redirige  a la pagina del Login. En caso de que si exista
	 * el usuario y se trate de un responsable (codigo de cargo '00001') lo redirigimos a su menu principal de responsable
	 * y en caso de ser otro tipo de cargo al menu principal
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @param request de tipo HttpServletRequest
	 * @param response de tipo HttpServletResponse
	 * @throws ServletException excepcion
	 * @throws IOException excepcion
	 */
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		boolean comprobacion=false;
		
		//Guardamos en la sesion el email de las credenciales
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				//response.sendRedirect(mail);
				
		
		Usuario u = new Usuario(email, pwd);
		try {			
			
			if (u.comprobar()) {
				// Si se trata de un responsable (codigo de cargo '00001' lo redirigimos a su menu
				String cargo=u.getId_Cargo();
				if (cargo.equals("00001")) { 
					//response.sendRedirect() redirige al navegador a una nueva URL, 
					//pero no permite pasar parámetros directamente. 
					//Sin embargo, voy a incluir el mail en la URL de destino y luego 
					//recuperarla en la página destino.
					//response.sendRedirect("PrincipalResponsable.jsp?email="+email);
					response.sendRedirect("PrincipalResponsable.jsp?email="+email+"&id_cargo="+cargo);
				} else {
					response.sendRedirect("Principal.jsp?email="+email+"&id_cargo="+cargo);
				}
				
	        } else {
	        	JOptionPane.showMessageDialog(null, "El usuario '" + email + "' no existe o las credenciales son incorrectas.", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
	        	response.sendRedirect("logueo.html");
	        }
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
