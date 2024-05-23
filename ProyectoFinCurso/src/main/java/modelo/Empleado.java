package modelo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import com.google.gson.Gson;

import dao.DaoEmpleado;
import dao.DaoFichaEmpleado;
import dao.DaoUsuario;

/**
 * Construccion de la clase Empleado con sus atributos y metodos
 * @author David Moreno Garcia-Caro
 * @see Usuario Fichaje
 */

public class Empleado {
	
	private int id_empleado;
	private String id_cargo;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2; 
	private String fecha_nacimiento; 
	private String direccion;
	private String numero_cuenta_bancaria;
	private String departamento;
	private String contrato;
	private String salario;
	private String fecha_incorporacion;
	private int vacacionestotales;
	private int vacacionespendientes;
	private int vacacionesdisfrutadas;
	private String mail;
	
    /**
     * Constructor de la clase empleado 
     * 
     * @param id_empleado de tipo entero
     * @param vacacionestotales de tipo entero
     * @param vacacionespendientes de tipo entero
     * @param vacacionesdisfrutadas de tipo entero
     * @param id_cargo de tipo String
     * @param dni de tipo String
     * @param nombre de tipo String
     * @param apellido1 de tipo String
     * @param apellido2 de tipo String
     * @param fecha_nacimiento de tipo String
     * @param direccion de tipo String
     * @param numero_cuenta_bancaria de tipo String
     * @param departamento de tipo String
     * @param contrato de tipo String
     * @param salario de tipo String
     * @param fecha_incorporacion de tipo String 
     */
	
	public Empleado(int id_empleado, String id_cargo, String dni, String nombre, String apellido1, String apellido2,
			String fecha_nacimiento, String direccion, String numero_cuenta_bancaria, String departamento,
			String contrato, String salario, String fecha_incorporacion, int vacacionestotales, int vacacionespendientes,
			int vacacionesdisfrutadas) {
		super();
		this.id_empleado = id_empleado;
		this.id_cargo = id_cargo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.numero_cuenta_bancaria = numero_cuenta_bancaria;
		this.departamento = departamento;
		this.contrato = contrato;
		this.salario = salario;
		this.fecha_incorporacion = fecha_incorporacion;
		this.vacacionestotales = vacacionestotales;
		this.vacacionespendientes = vacacionespendientes;
		this.vacacionesdisfrutadas = vacacionesdisfrutadas;
	}
	
    /**
     * Constructor de la clase empleado 
     * 
     * @param id_cargo de tipo String
     * @param dni de tipo String
     * @param nombre de tipo String
     * @param apellido1 de tipo String
     * @param apellido2 de tipo String
     * @param fecha_nacimiento de tipo String
     * @param direccion de tipo String
     * @param numero_cuenta_bancaria de tipo String
     * @param departamento de tipo String
     * @param contrato de tipo String
     * @param salario de tipo String
     * @param fecha_incorporacion de tipo String 
     * @param mail de tipo String 
     */
	public Empleado(String id_cargo, String dni, String nombre, String apellido1, String apellido2,
			String fecha_nacimiento, String direccion, String numero_cuenta_bancaria, String departamento,
			String contrato, String salario, String fecha_incorporacion, String mail) {
		super();
		this.id_cargo = id_cargo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.numero_cuenta_bancaria = numero_cuenta_bancaria;
		this.departamento = departamento;
		this.contrato = contrato;
		this.salario = salario;
		this.fecha_incorporacion = fecha_incorporacion;
		this.mail = mail;
	}
	
	/**
	 * Constructor de la clase empleado 
	 * 
	 * @param mail de tipo String
	 */
	
	public Empleado (String mail) {
		this.mail = mail;
	}
	
	/**
	 * Constructor de la clase empleado 
	 * 
	 * @param id_empleado de tipo int
	 */
	
	public Empleado (int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	/**
	 * Constructor de la clase empleado 
	 * 
	 * @param dni de tipo String
	 * @param mail de tipo String
	 */
	
	public Empleado (String dni,String mail) {
		this.dni = dni;
		this.mail = mail;
	}
	
	/**
	 * Constructor de la clase empleado sin argumentos.
	 * 
	 */
	public Empleado () {
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
     * Metodo para almacenar el id_empleado al objeto de la clase empleado
     * 
     * @param id_empleado de tipo entero
     */
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	/**
     * Metodo para obtener el id_cargo
     * 
     * @return id_cargo de tipo String
     */
	
	public String getId_cargo() {
		return id_cargo;
	}

    /**
     * Metodo para almacenar el id_cargo al objeto de la clase empleado
     * 
     * @param id_cargo de tipo String
     */
	
	public void setId_cargo(String id_cargo) {
		this.id_cargo = id_cargo;
	}

	/**
     * Metodo para obtener el Dni
     * 
     * @return Dni de tipo String
     */
	
	public String getDni() {
		return dni;
	}

    /**
     * Metodo para almacenar el Dni al objeto de la clase empleado
     * 
     * @param dni de tipo String
     */
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
     * Metodo para obtener el Nombre
     * 
     * @return Nombre de tipo String
     */
	
	public String getNombre() {
		return nombre;
	}

    /**
     * Metodo para almacenar el Nombre al objeto de la clase empleado
     * 
     * @param nombre de tipo String
     */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
     * Metodo para obtener el apellido1
     * 
     * @return apellido1 de tipo String
     */
	
	public String getApellido1() {
		return apellido1;
	}

    /**
     * Metodo para almacenar el apellido1 al objeto de la clase empleado
     * 
     * @param apellido1 de tipo String
     */
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
     * Metodo para obtener el apellido2
     * 
     * @return apellido2 de tipo String
     */
	
	public String getApellido2() {
		return apellido2;
	}

    /**
     * Metodo para almacenar el apellido2 al objeto de la clase empleado
     * 
     * @param apellido2 de tipo String
     */
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
     * Metodo para obtener la fecha_nacimiento
     * 
     * @return fecha_nacimiento de tipo String
     */
	
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

    /**
     * Metodo para almacenar la fecha_nacimiento al objeto de la clase empleado
     * 
     * @param fecha_nacimiento de tipo String
     */
	
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/**
     * Metodo para obtener la direccion
     * 
     * @return direccion de tipo String
     */
	
	public String getDireccion() {
		return direccion;
	}

    /**
     * Metodo para almacenar la direccion al objeto de la clase empleado
     * 
     * @param direccion de tipo String
     */
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
     * Metodo para obtener el Numero_cuenta_bancaria
     * 
     * @return Numero_cuenta_bancaria de tipo String
     */
	
	public String getNumero_cuenta_bancaria() {
		return numero_cuenta_bancaria;
	}

    /**
     * Metodo para almacenar el numero_cuenta_bancaria al objeto de la clase empleado
     * 
     * @param numero_cuenta_bancaria de tipo String
     */
	
	public void setNumero_cuenta_bancaria(String numero_cuenta_bancaria) {
		this.numero_cuenta_bancaria = numero_cuenta_bancaria;
	}

	/**
     * Metodo para obtener el Departamento
     * 
     * @return Departamento de tipo String
     */
	
	public String getDepartamento() {
		return departamento;
	}

    /**
     * Metodo para almacenar el departamento al objeto de la clase empleado
     * 
     * @param departamento de tipo String
     */
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
     * Metodo para obtener el Contrato
     * 
     * @return Contrato de tipo String
     */
	
	public String getContrato() {
		return contrato;
	}

    /**
     * Metodo para almacenar el contrato al objeto de la clase empleado
     * 
     * @param contrato de tipo String
     */
	
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
     * Metodo para obtener el Salario
     * 
     * @return Salario de tipo String
     */
	
	public String getSalario() {
		return salario;
	}

    /**
     * Metodo para almacenar el salario al objeto de la clase empleado
     * 
     * @param salario de tipo String
     */
	
	public void setSalario(String salario) {
		this.salario = salario;
	}

	/**
     * Metodo para obtener la Fecha_incorporacion
     * 
     * @return Fecha_incorporacion de tipo String
     */
	
	public String getFecha_incorporacion() {
		return fecha_incorporacion;
	}

    /**
     * Metodo para almacenar la fecha_incorporacion al objeto de la clase empleado
     * 
     * @param fecha_incorporacion de tipo String
     */
	
	public void setFecha_incorporacion(String fecha_incorporacion) {
		this.fecha_incorporacion = fecha_incorporacion;
	}

	/**
     * Metodo para obtener las Vacacionestotales
     * 
     * @return Vacacionestotales de tipo int
     */
	
	public int getVacacionestotales() {
		return vacacionestotales;
	}

    /**
     * Metodo para almacenar las vacacionestotales al objeto de la clase empleado
     * 
     * @param vacacionestotales de tipo int
     */
	
	public void setVacacionestotales(int vacacionestotales) {
		this.vacacionestotales = vacacionestotales;
	}

	/**
     * Metodo para obtener las Vacacionespendientes
     * 
     * @return Vacacionespendientes de tipo int
     */
	
	public int getVacacionespendientes() {
		return vacacionespendientes;
	}

    /**
     * Metodo para almacenar las vacacionespendientes al objeto de la clase empleado
     * 
     * @param vacacionespendientes de tipo int
     */
	
	public void setVacacionespendientes(int vacacionespendientes) {
		this.vacacionespendientes = vacacionespendientes;
	}

	/**
     * Metodo para obtener las Vacacionesdisfrutadas
     * 
     * @return Vacacionesdisfrutadas de tipo int
     */
	
	public int getVacacionesdisfrutadas() {
		return vacacionesdisfrutadas;
	}

    /**
     * Metodo para almacenar las vacacionesdisfrutadas al objeto de la clase empleado
     * 
     * @param vacacionesdisfrutadas de tipo int
     */
	
	public void setVacacionesdisfrutadas(int vacacionesdisfrutadas) {
		this.vacacionesdisfrutadas = vacacionesdisfrutadas;
	}	
	
	/**
     * Metodo para obtener el Mail
     * 
     * @return Mail de tipo String
     */
	
	public String getMail() {
		return mail;
	}

    /**
     * Metodo para almacenar el mail al objeto de la clase empleado
     * 
     * @param mail de tipo String
     */
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
    /**
     * Metodo para insertar un objeto de tipo empleado
     * 
     * Se crea un objeto de tipo DaoEmpleado y se llama al metodo insertar del DaoEmpleado
     *@throws SQLException excepcion 
     *@throws ParseException excepcion
     */
	
	public void insertar() throws SQLException, ParseException {
		DaoEmpleado dao = new DaoEmpleado();
		dao.insertar(this);
		
	}
	
    /**
     *  Metodo para eliminar un objeto de tipo empleado
     * 
     * Se crea un objeto de tipo DaoEmpleado y se llama al metodo eliminar del DaoEmpleado
     * @throws SQLException excepcion
     * @throws ParseException excepcion
     */
	
	public void eliminar() throws SQLException, ParseException {
		DaoEmpleado dao = new DaoEmpleado();
		dao.eliminar(this);
		
	}
	
    /**
     * Metodo para mostrar la fichaempleado
     * 
     * Se crea un objeto de tipo DaoFichaEmpleado y se llama al metodo FichaEmpleado del DaoFichaEmpleado
     * 
     * @throws SQLException excepcion
     * @throws ParseException excepcion
     */
	
	public void fichaempleado() throws SQLException, ParseException {
		DaoFichaEmpleado dao = new DaoFichaEmpleado();
		dao.fichaempleado(this);
	}
	
    /**
     * Metodo para convertir el empleado a JSON
     * 
     * @return String con el empleado en formato JSON
     */
    
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
	
}
