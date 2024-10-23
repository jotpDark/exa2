package com.tpcorp.exhiber.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursada")
public class Cursada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ide")
	private Estudiante est;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idm")
	private Materia idMateria;
	private int calificacion;
	//////////////////
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public Estudiante getEst() {
		return est;
	}
	public void setEst(Estudiante est) {
		this.est = est;
	}
	public Materia getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(Materia idMateria) {
		this.idMateria = idMateria;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	

}
