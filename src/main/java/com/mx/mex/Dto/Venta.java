package com.mx.mex.Dto;

import java.sql.Date;

public class Venta {

	
	private int idVenta;
	private String usuario;
	private int descuento;
	private int total;
	private int pago;
	private int cambio;
	private String estadoVenta;
	private Date fechaVenta;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPago() {
		return pago;
	}
	public void setPago(int pago) {
		this.pago = pago;
	}
	public int getCambio() {
		return cambio;
	}
	public void setCambio(int cambio) {
		this.cambio = cambio;
	}
	public String getEstadoVenta() {
		return estadoVenta;
	}
	public void setEstadoVenta(String estadoVenta) {
		this.estadoVenta = estadoVenta;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

}
