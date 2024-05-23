package modelo;

/**
 *  En esta seccion importamos las librerias necesarias
 */

import java.sql.SQLException;
import java.text.ParseException;
import dao.DaoEmpleado;
import dao.DaoFichaje;

/** 
 * Definicion de la clase Fichaje con sus atributos y metodos 
 * */

public class Fichaje {

	private String id_fichaje;
	private String descripcion;
	private int id_empleado;
	private String fecha_hora_fichaje;
	
	/**
     * Constructor de la clase Fichaje 
     * 
     * @param id_fichaje de tipo String
     * @param descripcion de tipo String
     * @param  id_empleado de tipo int
     * @param fecha_hora_fichaje  de tipo String
     */
	public Fichaje(String id_fichaje, String descripcion, int id_empleado, String fecha_hora_fichaje) {
		super();
		this.id_fichaje = id_fichaje;
		this.descripcion = descripcion;
		this.id_empleado = id_empleado;
		this.fecha_hora_fichaje = fecha_hora_fichaje;
	}
	
	/**
     * Constructor de la clase Fichaje 
     * 
     * @param id_fichaje de tipo String
     * @param descripcion de tipo String
     * @param fecha_hora_fichaje  de tipo String 
     */
	public Fichaje(String id_fichaje, String descripcion, String fecha_hora_fichaje) {
		super();
		this.id_fichaje = id_fichaje;
		this.descripcion = descripcion;
		this.fecha_hora_fichaje = fecha_hora_fichaje;
	}
	
	/**
     * Constructor de la clase Fichaje 
     * 
     * @param descripcion de tipo String
     * @param fecha_hora_fichaje  de tipo String 
     */
	public Fichaje(String descripcion, String fecha_hora_fichaje) {
		super();
		this.descripcion = descripcion;
		this.fecha_hora_fichaje = fecha_hora_fichaje;
	}


	/**
     * Constructor de la clase Fichaje 
     */
	public Fichaje() {
			
	}
	
	/**
     * Metodo para obtener el id_fichaje
     * 
     * @return id_fichaje de tipo String
     */

	public String getId_fichaje() {
		return id_fichaje;
	}
	
	  /**
     * Metodo para almacenar el id_fichaje al objeto de la clase Fichaje
     * 
     * @param id_fichaje de tipo String
     */

	public void setId_fichaje(String id_fichaje) {
		this.id_fichaje = id_fichaje;
	}
	
	/**
     * Metodo para obtener el descripcion
     * 
     * @return descripcion de tipo String
     */

	public String getDescripcion() {
		return descripcion;
	}
	
	/**
     * Metodo para almacenar el descripcion al objeto de la clase Fichaje
     * 
     * @param descripcion de tipo String
     */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
     * Metodo para obtener el id_empleado
     * 
     * @return id_empleado de tipo int
     */

	public int getId_empleado() {
		return id_empleado;
	}
	
	/**
     * Metodo para almacenar el id_empleado al objeto de la clase Fichaje
     * 
     * @param id_empleado de tipo entero
     */

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	/**
     * Metodo para obtener el fecha_hora_fichaje
     * 
     * @return fecha_hora_fichaje de tipo String
     */

	public String getFecha_hora_fichaje() {
		return fecha_hora_fichaje;
	}
	
	/**
     * Metodo para almacenar el fecha_hora_fichaje al objeto de la clase Fichaje
     * 
     * @param fecha_hora_fichaje de tipo String
     */

	public void setFecha_hora_fichaje(String fecha_hora_fichaje) {
		this.fecha_hora_fichaje = fecha_hora_fichaje;
	}
	
	
	 /**
     * Metodo para insertar un objeto de tipo fichaje
     * 
     * Se crea un objeto de tipo DaoFichaje y se llama al metodo fichar del DaoFichaje
     * 
     * @throws SQLException excepcion
     * @throws ParseException excepcion
     */
	public void fichar() throws SQLException, ParseException {
		DaoFichaje dao = new DaoFichaje();
		dao.fichar(this);
		
	}
	
}
