package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Fichaje;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

/**
 * Servlet implementation class GestionFichaje
 */
public class GestionFichaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionFichaje() {
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
	 * Recogemos del request la información del fichaje. 
	 * A traves de la libreria LocalDateTime obtenemos la fecha y hora, lo formateamos
	 * en DD/MM/YYYY HH:mm:ss.
	 * Asignamos a id_fichaje el valor correspondiente a su descripcion
	 * con todos los parametros creados se crea el objeto fichaje que se inserta en la base de datos a traves
	 * del metodo fichar del objeto fichaje.	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request de tipo HttpServletRequest
	 * @param response de tipo HttpServletResponse
	 * @throws ServletException excepcion
	 * @throws IOException excepcion
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id_fichaje=null;
		String descripcionFichaje = request.getParameter("descripcionFichaje");
		int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
		String cargo = request.getParameter("id_cargo");
		String email = request.getParameter("mail");
		
		LocalDateTime fechaHora = LocalDateTime.now();
		
		String fecha_hora_fichaje=String.format("%0" + 2 + "d", fechaHora.getDayOfMonth())
				+'/'+String.format("%0" + 2 + "d", fechaHora.getMonthValue())
				+'/'+String.format("%0" + 4 + "d", fechaHora.getYear())
				+' '+String.format("%0" + 2 + "d", fechaHora.getHour())
				+':'+String.format("%0" + 2 + "d", fechaHora.getMinute())
				+':'+String.format("%0" + 2 + "d", fechaHora.getSecond());
	
		// Segun sea la descripcion de fichaje, el identificador de fichaje tendrá valores del 1 al 4
		if (descripcionFichaje.equals("Inicio Jornada Laboral")) {
			id_fichaje="00001";
		}
		if (descripcionFichaje.equals("Salida Comida")) {
			id_fichaje="00002";
		}
		if (descripcionFichaje.equals("Entrada Comida")) {
			id_fichaje="00003";
		}
		if (descripcionFichaje.equals("Fin Jornada laboral")) {
			id_fichaje="00004";
		}
		
		Fichaje fi= new Fichaje(id_fichaje,descripcionFichaje,id_empleado,fecha_hora_fichaje);
		
		try {
			fi.fichar();
			JOptionPane.showMessageDialog(null, "Fichaje realizado correctamente en fecha y hora: "+fecha_hora_fichaje, "Fichaje correcto", JOptionPane.INFORMATION_MESSAGE);
			response.sendRedirect("Fichaje.jsp?id_empleado="+id_empleado+"&mail="+email+"&id_cargo="+cargo);
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
