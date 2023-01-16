package com.mx.mex.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "CAT_ESTADOS", schema= "CESAR")//indicas el nombre de la tabla y el esquema en el que se enuentra

public class CatEstados {
	private Long idEstados;
	private String nombre;
	private String abreviatura;
	
	@Id
	@Column(name="ID_ESTADO", unique = true, nullable = false, precision = 11)
	public Long getIdEstados() {
		return idEstados;
	}
	public void setIdEstados(Long idEstados) {
		this.idEstados = idEstados;
	}
	
	@Column(name="NOMBRE")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="ABREVIATURA")
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	
}
