package modelo;
/**En esta seccion importamos las librerias necesarias*/
import java.sql.SQLException;

import dao.DaoUsuario;

/**
 * Definicion de la clase Usuario con sus atributos y metodos
 * 
 */
public class Usuario {
	
	private int id_usuario;
	private String mail;
	private String pwd;
	private String id_cargo;
	
	/**
	 * Constructor de la clase Usuario 
	 * @param id_usuario de tipo int
	 * @param mail de tipo String
	 * @param pwd de tipo String
	 * @param id_cargo de tipo String
	 */
	public Usuario(int id_usuario, String mail, String pwd, String id_cargo ) {
		super();
		this.id_usuario = id_usuario;
		this.mail = mail;
		this.pwd = pwd;
		this.id_cargo=id_cargo;
		
	}
	
	/**
	 * Constructor de la clase Usuario
	 * @param mail de tipo String
	 * @param pwd de tipo String
	 */
	public Usuario(String mail,String pwd) {
		super();
		this.mail = mail;
		this.pwd = pwd;
	}
	
	/**
	 * Constructor de la clase Usuario
	 * @param mail de tipo String
	 * @param pwd de tipo String
	 * @param cargo de tipo String
	 */
	public Usuario(String mail,String pwd ,String cargo) {
		super();
		this.mail = mail;
		this.pwd = pwd;
		this.id_cargo=cargo;
	}
	
	private Usuario() {
			
	}
	
	/**
     * Metodo para obtener el id_usuario
     * 
     * @return id_usuario de tipo int
     */
	public int getId_usuario() {
		return id_usuario;
	}
	
	/**
     * Metodo para almacenar el id_usuario al objeto de la clase Usuario
     * 
     * @param id_usuario de tipo int
     */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
		
	/**
     * Metodo para obtener el mail
     * 
     * @return mail de tipo String
     */
	public String getMail() {
		return mail;
	}
	
	/**
     * Metodo para almacenar el mail al objeto de la clase Usuario
     * 
     * @param mail de tipo String
     */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
     * Metodo para obtener el pwd
     * 
     * @return pwd de tipo String
     */
	public String getPwd() {
		return pwd;
	}
	
	/**
     * Metodo para almacenar el pwd al objeto de la clase Usuario
     * 
     * @param pwd de tipo String
     */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
     * Metodo para obtener el id_cargo
     * 
     * @return id_cargo de tipo String
     */
	public String getId_Cargo() {
		return id_cargo;
	}
	
	/**
     * Metodo para almacenar el id_cargo al objeto de la clase Usuario
     * 
     * @param id_cargo de tipo String
     */
	public void setId_Cargo(String id_cargo) {
		this.id_cargo = id_cargo;
	}
	
	 /**
     *  Metodo para comprobar que un usuario existe en la base de datos
     * 
     * Se crea un objeto de tipo DaoUsuario y se llama al metodo comprobar del DaoUsuario
     * 
     * @return boolean
     * @throws SQLException excepcion
     */
	public boolean comprobar() throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		return dao.comprobar(this);
		
	}
	 /**
     *  Metodo para actualizar la contrasegna de un usuario
     * 
     * Se crea un objeto de tipo DaoUsuario y se llama al metodo updpwd del DaoUsuario
     * 
     * @throws SQLException excepcion
     */
	public void updpwd() throws SQLException {
		DaoUsuario dao = new DaoUsuario();
		dao.updpwd(this);
	}
	
	
}
