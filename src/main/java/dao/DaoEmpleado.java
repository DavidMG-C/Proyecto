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
 * Definimos la clase DaoEmpleado que obtiene una instancia  de la conexion con la base de datos
 * e inserta y elimina empleados de la base de datos
 * Como atributos tendrá la conexión 
 * @see Connection
 * @see Properties
 * @see ResultSet
 * @see PreparedStatement
 * @author David Moreno
 */

public class DaoEmpleado {
	
	/**
	 * Definicion del atributo de conexion
	 */
	
	public static Connection con = null;
	
	/**
	 * Constructor de la clase DaoEmpleado que crea la instancia de la conexion
	 * @throws SQLException excepcion en la ejecucion
	 */
	public DaoEmpleado()throws SQLException {
		
		//this.con = DBCConexionLogin.getConexion();
		this.con= DBConexion.getConexion();
	}
	
	/**
	 * Este metodo realiza dos inserciones en la BBDD:
	 * 
	 * 1.- Inserta en la tabla empleado un nuevo elemento a traves de los siguientes campos
	 * (id_cargo,dni, nombre, apellido1, apellido2, fecha_nacimiento,direccion, numero_cuenta_bancaria,
	 * departamento, contrato, salario, fecha_incorporacion, mail)
	 * 
	 * 2.- Inserta en la tabla usuario un nuevo elemento con el mail y cargo pasado en el objeto empleado
	 * y como pwd por defecto 1111
	 * 
	 * @param e de tipo Empleado
	 * @throws SQLException excepcion
	 * @throws ParseException excepcion
	 */
	
	public void insertar (Empleado e) throws SQLException, ParseException {
		
		
		String sql1 = "INSERT INTO empleado (id_cargo,dni, nombre, apellido1, apellido2, fecha_nacimiento,direccion, numero_cuenta_bancaria, departamento, contrato, salario, fecha_incorporacion, mail) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// Por defecto para los nuevos empleados se asigna una contrasegna '1111'
		String sql2 = "INSERT INTO usuarios (mail,pwd,id_cargo) values (?,1111,?);";
		
		PreparedStatement ps1 = con.prepareStatement(sql1);
		PreparedStatement ps2 = con.prepareStatement(sql2);
		
		ps1.setString(1, e.getId_cargo());
		ps1.setString(2, e.getDni());
		ps1.setString(3, e.getNombre());
		ps1.setString(4, e.getApellido1());
		ps1.setString(5, e.getApellido2());
		ps1.setString(6, e.getFecha_nacimiento());
		ps1.setString(7, e.getDireccion());
		ps1.setString(8, e.getNumero_cuenta_bancaria());
		ps1.setString(9, e.getDepartamento());
		ps1.setString(10, e.getContrato());
		ps1.setDouble(11, Double.parseDouble(e.getSalario()));
		ps1.setString(12, e.getFecha_incorporacion());
		ps1.setString(13, e.getMail());
		
		ps2.setString(1, e.getMail());
		ps2.setString(2, e.getId_cargo());
		
		try {
			int auxiliar1 = ps1.executeUpdate();
		} catch (SQLException ex1) {
		    ex1.printStackTrace();
		}
		
		try {
			int auxiliar2 = ps2.executeUpdate();
		} catch (SQLException ex2) {
		    ex2.printStackTrace();
		}
		
		
		ps1.close();
		ps2.close();
		
	}
	
	
	/**
	 * Metodo para dar de baja empleados de la base de datos: al eliminar un empleado se da de baja
	 * tanto en la tabla empleado como de la tabla usuarios
	 * 
	 * @param e de tipo Empleado
	 * @throws SQLException excepcion
	 * @throws ParseException excepcion
	 */
	public void eliminar(Empleado e) throws SQLException, ParseException {
	    ResultSet rs = null;

	    // Primero recuperamos el mail del empleado
	    String sql1_mail = "select mail from empleado where id_empleado=?";
	    PreparedStatement ps1_mail = con.prepareStatement(sql1_mail);
	    ps1_mail.setInt(1, e.getId_empleado());

	    try {
	        rs = ps1_mail.executeQuery();
	        if (rs.next()) {
	            e.setMail(rs.getNString("mail")); // Asignamos al objeto empleado el mail que tiene
	        } else {
	            throw new SQLException("No se encontró el empleado con id: " + e.getId_empleado());
	        }
	        rs.close();
	    } catch (SQLException ex1_mail) {
	        ex1_mail.printStackTrace();
	        // Cerrar ps1_mail en caso de error
	        ps1_mail.close();
	        return;
	    }

	    // Luego eliminamos el registro en la tabla empleado
	    String sql1 = "delete from empleado where id_empleado=?";
	    PreparedStatement ps1 = con.prepareStatement(sql1);
	    ps1.setInt(1, e.getId_empleado());

	    try {
	        int auxiliar1 = ps1.executeUpdate();
	    } catch (SQLException ex1) {
	        ex1.printStackTrace();
	        // Cerrar ps1 en caso de error
	        ps1.close();
	        return;
	    }

	    // Finalmente, eliminamos de la tabla usuarios usando el correo electrónico recuperado
	    String sql2 = "delete from usuarios where mail=?";
	    PreparedStatement ps2 = con.prepareStatement(sql2);
	    ps2.setString(1, e.getMail());

	    try {
	        int auxiliar2 = ps2.executeUpdate();
	    } catch (SQLException ex2) {
	        ex2.printStackTrace();
	        // Cerrar ps2 en caso de error
	        ps2.close();
	        return;
	    }

	    // Cerramos las ps
	    ps1.close();
	    ps1_mail.close();
	    ps2.close();
	}
	

}
