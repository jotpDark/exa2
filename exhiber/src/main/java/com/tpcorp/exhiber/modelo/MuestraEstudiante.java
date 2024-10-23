package com.tpcorp.exhiber.modelo;

public class MuestraEstudiante {
	private String nombre;
	private String apellido;
	public MuestraEstudiante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MuestraEstudiante(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
	

}
