package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

/**
 * Definimos la clase DaoUsuario que obtiene una instancia de la conexion con la base de datos
 * y comprueba la existencia de un usuario en la base de datos
 * Como atributos tendrá la conexion 
 * @see Connection
 * @see Properties
 * @see ResultSet
 * @see PreparedStatement
 * @author David Moreno
 */


public class DaoUsuario {
	
	/**
	 * Atributo de la conexion del objeto
	 */
	public static Connection con = null;
	
	
	/**
	 * Constructor de la clase DaoUsuario para crear la instancia de la conexion 
	 * @throws SQLException exepcion
	 */
	public DaoUsuario() throws SQLException{
		
		this.con = DBConexion.getConexion();
				
	}
	
	/**
	 * Este metodo comprueba que un usuario existe en la BBDD.
	 * Para ello, cuenta el total de ocurrencias existentes en la tabla usuarios donde el mail y pwd
	 * se corresponda con el usuario que se pretende comprobar. 
	 * 
	 * Ejecutamos la query y guardamos el total de resultados obtenidos
	 * Si las credenciales son correctas nos devolvera un registro
	 * Si son incorrectas nos devuelve 0 registros
	 * 
	 * Si el total de registros es uno, existe, de lo contrario, no existe, y este sera el valor logico devuelto
	 * por la funcion.
	 * 
	 * @param u de tipo Usuario
	 * @return existe de tipo boolean
	 * @throws SQLException excepcion
	 */
	public boolean comprobar (Usuario u) throws SQLException {
		
		boolean existe = false;
		ResultSet rs=null;
		
		String sql = "SELECT count(*) as total, id_cargo FROM usuarios WHERE mail =? and pwd=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getMail());
		ps.setString(2, u.getPwd());
		
		rs = ps.executeQuery();
		// Lo que hacemos con el next es posicionarnos en el primer elemento
		//ya que el primero y el ultimo son nulos
		rs.next();
		int totalregistros = rs.getInt("total");
		u.setId_Cargo(rs.getNString("id_cargo")); // Asignamos al objeto usuario el cargo que tiene
		rs.close();
		
		// Si se encuentra el usuario logueado (total>0), 
		// devolvemos true y en caso contrario false (inicializado)
		if (totalregistros==1) {
			existe=true;
		}
		ps.close();
		return existe;
	}
	
	/**
	 * Este metodo sirve para actualizar la contrasegna de un usuario.
	 * update actualiza la tabla usuarios con el valor pwd pasado por el objeto usuario cuando el mail
	 * se corresponda con el mail pasado por el objeto usuario
	 * @param u de tipo Usuario
	 * @throws SQLException excepcion
	 */
	public void updpwd (Usuario u) throws SQLException {
		
		ResultSet rs=null;
		
		String sql = "update usuarios set pwd=? where mail=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getPwd());
		ps.setString(2, u.getMail());
		
		// Asignamos el resultado de la actualizacion a un entero pero sin que nos devuelva la funcion
		// updpwd, ya que solo interesa que actualice la fila sin devolver el total de filas actualizadas.
		 
		int filasActualizadas = ps.executeUpdate();
		
		
		ps.close();
	}

}
