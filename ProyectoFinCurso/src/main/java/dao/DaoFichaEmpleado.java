package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import modelo.Empleado;

/**
 * Definimos la clase DaoFichaEmpleado que obtiene una instancia de la conexion con la base de datos
 * y muestra informacion del empleado
 * Como atributos tendrá la conexion 
 * @see Connection
 * @see Properties
 * @see ResultSet
 * @see PreparedStatement
 * @see Date
 * @author David Moreno
 */
public class DaoFichaEmpleado {
	
	/**
	 * Declaracion del atributo de conexion
	 */
	public static Connection con = null;
	
	/**
	 * Constuctor de la clase DaoFichaEmpleado que crea la instancia de la conexion
	 * @throws SQLException excepcion
	 */
	public DaoFichaEmpleado()throws SQLException {
		
		//this.con = DBCConexionLogin.getConexion();
		this.con= DBConexion.getConexion();
	}
	
	/**
	 * Este metodo muestra la informacion del empleado cuyo mail se le pasa en el objeto empleado
	 * los campos del objeto empleado se obtienen del resultado de la consulta
	 * @param emp de tipo Empleado
	 * @throws SQLException excepcion
	 * @throws ParseException excepcion
	 */
	public void fichaempleado (Empleado emp) throws SQLException, ParseException {
		
		ResultSet rs=null;
		
		String sql = "SELECT nombre, apellido1, apellido2, departamento, id_empleado, id_cargo, mail FROM empleado WHERE mail=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, emp.getMail());
		
		rs = ps.executeQuery();
		// Lo que hacemos con el next es posicionarnos en el primer elemento
		//ya que el primero y el ultimo son nulos
		rs.next();
		
		emp.setNombre(rs.getNString("nombre"));
		emp.setApellido1(rs.getNString("apellido1"));
		emp.setApellido2(rs.getNString("apellido2"));
		emp.setDepartamento(rs.getNString("departamento"));
		emp.setId_empleado(rs.getInt("id_empleado"));
		emp.setId_cargo(rs.getNString("id_cargo"));
		emp.setMail(rs.getNString("mail"));
		rs.close();
		ps.close();
		
	}
	

}
