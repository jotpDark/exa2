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
@Table(name = "materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idm;
	private String sigla;
	private String descripcion;
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "idMateria",targetEntity =Cursada.class )
	private Set cursada;
	public Materia() {
		
	}
	
	public int getIdm() {
		return idm;
	}

	public void setIdm(int idm) {
		this.idm = idm;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set getCursada() {
		return cursada;
	}
	public void setCursada(Set cursada) {
		this.cursada = cursada;
	}
	
	

}
