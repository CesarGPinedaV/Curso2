package com.mx.mex.Entities;
//esta clase esuna entidad/entity estos son los campos de nuestra tabla oracle

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "USUARIOS_ADMIN", schema= "CESAR")//indicas el nombre de la tabla y el esquema en el que se enuentra
public class UsuariosAdmin {

	/**esta clase es la tabla tal cual de la BD
	 */
	
	private Long idUser;// SE GENERAGTTERS Y SETTER, CLIC DERECHO SOURCE 
	private String nombreCompleto;
	private String edad;
	private String direccion;
	private int estado;
	private int rol;
	
	
	
	@Id
	@Column(name="ID_USER", unique = true, nullable = false, precision = 11)
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	@Column(name="NOMBRE_COMPLETO", length = 100)
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	@Column(name="EDAD", length = 50)
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	@Column(name="DIRECCION", length = 100)
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column(name="ESTADO")
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@Column(name="ROL")
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
	
	
	
}
