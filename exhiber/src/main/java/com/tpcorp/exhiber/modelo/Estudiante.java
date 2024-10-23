package com.tpcorp.exhiber.modelo;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ide;
	private String nombre;
	private String apellido;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "est", targetEntity = Cursada.class)
	private Set cursada;

	public Estudiante() {

	}

	

	public int getIde() {
		return ide;
	}



	public void setIde(int ide) {
		this.ide = ide;
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

	public Set getCursada() {
		return cursada;
	}

	public void setCursada(Set cursada) {
		this.cursada = cursada;
	}

}
