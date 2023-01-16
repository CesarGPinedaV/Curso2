package com.mx.mex.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "EMPLEADOS", schema= "CESAR")//indicas el nombre de la tabla y el esquema en el que se enuentra
public class EmpleadosEntities {
	private Long idEmpleados;
	private String nombreCompleto;
	private String rfc;
	private int edad;
	private String sexo;
	private String direccion;
	private int telefono;
	private int activo;
	
	
	@Id
	@Column(name="ID_EMPLEADOS", unique = true, nullable = false, precision = 10)
	public Long getIdEmpleados() {
		return idEmpleados;
	}
	public void setIdEmpleados(Long idEmpleados) {
		this.idEmpleados = idEmpleados;
	}
	
	@Column(name="NOMBRE_COMPLETO")
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	@Column(name="RFC")
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	@Column(name="EDAD")
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Column(name="SEXO")
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Column(name="DIRECCION")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name="TELEFONO")
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	@Column(name="ACTIVO")
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
	
}
