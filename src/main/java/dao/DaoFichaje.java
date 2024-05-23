package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import modelo.Fichaje;

/**
 * Definimos la clase DaoFichaje que obtiene una instancia de la conexion con la base de datos
 * e introduce el objeto fichaje en la base de datos
 * Como atributos tendrá la conexion 
 * @see Connection
 * @see Properties
 * @see ResultSet
 * @see PreparedStatement
 * @author David Moreno
 */


public class DaoFichaje {

	/**
	 * Atributo que define la conexion del objeto
	 */
	public static Connection con = null;
	/**
	 * Constuctor de la clase DaoFichaje donde se inicializa la isntancia de la conexion
	 * 
	 * @throws SQLException excepcion
	 */
	public DaoFichaje()throws SQLException {
		
		//this.con = DBCConexionLogin.getConexion();
		this.con= DBConexion.getConexion();
	}
	/**
	 * Este metodo se utiliza para insertar un fichaje en la tabla fichaje_empleado pasandole el objeto fichaje
	 * El objeto fichaje esta definido por id_fichaje,descripcion,id_empleado,fecha_hora_fichaje
	 * @param fi de tipo Fichaje
	 * @throws SQLException excepcion
	 * @throws ParseException excepcion
	 */
	public void fichar (Fichaje fi) throws SQLException, ParseException {
		
		
		String sql = "INSERT INTO fichaje_empleado (id_fichaje,descripcion,id_empleado,fecha_hora_fichaje) VALUES (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, fi.getId_fichaje());
		ps.setString(2, fi.getDescripcion());
		ps.setInt(3, fi.getId_empleado());
		ps.setString(4, fi.getFecha_hora_fichaje());
		
		// Asignamos el resultado de la ejecucion a un entero (auxiliar) pero sin que nos devuelva la funcion
		// fichar, ya que solo interesa que inserte la fila sin devolver el total de filas insertadas.
		int auxiliar = ps.executeUpdate();
		ps.close();
		
	}
	
}
