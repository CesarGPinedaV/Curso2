package com.mx.mex.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Dto.CursoDTO;

public class CursoListMapper<T> implements RowMapper<CursoDTO> {
	public CursoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CursoDTO objeto = new CursoDTO();
		objeto.setIdCurso(rs.getBigDecimal("ID_CURSO"));
		 objeto.setNombreMateria(rs.getString("NOMBRE_MATERIA"));
		 objeto.setDescripcion(rs.getString("DESCRIPCION"));
	    objeto.setFechaCreacion(rs.getDate("FECHA_CREACION"));
		return objeto;
	}
	
}
