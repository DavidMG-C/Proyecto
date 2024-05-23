package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Definimos la clase DBConexion que permitira realizar la conexion con la Base da Datos.
 * Como atributos tendra la URL del servidor LocalHost ("jdbc:mysql://localhost:3306/proyecto")
 * y la instancia de la conexion.
 * @see Connection
 * @see Properties
 * @author David Moreno
 */
public class DBConexion {

	/**
	 * Definicion del atributo de la clase url de la conexion
	 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/proyecto";

	/**
	 * Definicion del atributo de la clase instancia de la conexion
	 */
	public static Connection instance = null;
	
	/**
	 * Este metodo es para crear una instancia de la conexion a la base de datos.
	 * La instancia se crea con el usuario password y charset
	 * @return instance de tipo Connection
	 * @throws SQLException excepcion
	 * 
	 */
	
	public static Connection getConexion() throws SQLException {
		
		if(instance == null) {
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");
			props.put("charset", "UTF-8");
			
			instance = DriverManager.getConnection(JDBC_URL, props);	
		}
		return instance;
		
	}
	
}


