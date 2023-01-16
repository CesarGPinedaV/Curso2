package com.mx.mex.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "USUARIOS_ADMIN", schema= "CESAR")//indicas el nombre de la tabla y el esquema en el que se enuentra

public class CatRolesEntities {
	
	private Long idRol;
	private String nombre;
	private String descripcion;
	@Id
	@Column(name="ID_ROL", unique = true, nullable = false, precision = 11)
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	@Column(name="NOMBRE", length = 100)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="DESCRIPCION", length = 100)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
