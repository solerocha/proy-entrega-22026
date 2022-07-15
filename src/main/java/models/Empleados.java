package models;

public class Empleados {
	
	private int id_emp;
	private int dni;
	private String nombre;
	private String apellido;
	private int nroDep;
	
	
	public Empleados(int id_emp, int dni, String nombre, String apellido, int nroDep) {
		super();
		this.id_emp = id_emp;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroDep = nroDep;
	}
	
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNroDep() {
		return nroDep;
	}
	public void setNroDep(int nroDep) {
		this.nroDep = nroDep;
	}
	
}
