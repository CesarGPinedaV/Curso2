package com.mx.mex.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.AlumnosNoviembre;
import com.mx.mex.Dto.Venta;
import com.mx.mex.Mapper.AlumnosNoviembreMapper;
import com.mx.mex.Mapper.VentaMapper;
import com.mx.mex.Repository.IVentaRepository;
@Repository
public class VentaRepository implements IVentaRepository{

	@Autowired
	private  DataSource dataSource;  //NUESTRA CONEXION A BASE DE DATOS
	
	private  JdbcTemplate jdbcTemplate = new JdbcTemplate(); //PARA EJECUTAR LAS CONSULTAS
	
	@Override
	public List<Venta> venta() {
		jdbcTemplate.setDataSource(getDataSource()); //ASIGNAMOS LA CONEXIÓN AL OBJETO JDBCTEMPLATE
		return jdbcTemplate.query("SELECT v.ID_VENTA AS ID_VENTA, u.NOMBRE_USUARIO AS NOMBRE_USUARIO, v.DESCUENTO AS DESCUENTO, v.TOTAL AS TOTAL, v.PAGO AS PAGO, v.ESTADO_VENTA AS ESTADO_VENTA,v.CAMBIO AS CAMBIO,v.FECHA_VENTA AS FECHA_VENTA FROM VENTA v INNER JOIN USUARIOS u on v.USUARIO = u.ID_USUARIO",
				new VentaMapper<Venta>());
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
