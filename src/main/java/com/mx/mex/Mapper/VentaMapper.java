package com.mx.mex.Mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.mex.Dto.Venta;

public class VentaMapper <T> implements RowMapper<Venta> {

	private int idVenta;
	private int usuario;
	private int descuento;
	private int total;
	private int pago;
	private int cambio;
	private String estadoVenta;
	private Date fechaVenta;
	
	public Venta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Venta objeto = new Venta();
		objeto.setIdVenta(rs.getInt("ID_VENTA"));
		objeto.setUsuario(rs.getString("NOMBRE_USUARIO"));
		objeto.setDescuento(rs.getInt("DESCUENTO"));
		objeto.setTotal(rs.getInt("TOTAL"));
		objeto.setPago(rs.getInt("PAGO"));
		objeto.setCambio(rs.getInt("CAMBIO"));
		objeto.setEstadoVenta(rs.getString("ESTADO_VENTA"));
		objeto.setFechaVenta(rs.getDate("FECHA_VENTA"));
		
		
		return objeto;
	}
}
