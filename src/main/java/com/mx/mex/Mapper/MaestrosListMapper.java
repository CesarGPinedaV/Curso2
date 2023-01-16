package com.mx.mex.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Dto.MaestrosDTO;

public class MaestrosListMapper<T> implements RowMapper<MaestrosDTO>  {

	
	@Override
	public MaestrosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MaestrosDTO objeto = new MaestrosDTO();
		objeto.setIdMaestro(rs.getBigDecimal("ID_MAESTRO"));
		 objeto.setNombreMaestro(rs.getString("NOMBRE"));
		 objeto.setEdad(rs.getInt("EDAD"));
	    objeto.setFechaCreacion(rs.getDate("FECHA_CREACION"));
		return objeto;
	}

}
