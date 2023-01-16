package com.mx.mex.Dto;

public class EmpleadosDTO {
	
	private Long idEmpleados;
	private String nombreCompleto;
	private String rfc;
	private int edad;
	private String sexo;
	private String direccion;
	private int telefono;
	private int activo;
	
	
	public Long getIdEmpleados() {
		return idEmpleados;
	}
	public void setIdEmpleados(Long idEmpleados) {
		this.idEmpleados = idEmpleados;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
	
}
