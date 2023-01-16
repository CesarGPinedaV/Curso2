package com.mx.mex.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Mapper.AspirantesListMapper;
import com.mx.mex.Mapper.CursoListMapper;
import com.mx.mex.Repository.CursoDAO;

@Repository
public class CursoDAOImpl implements CursoDAO{
	@Autowired
	DataSource dataSource;
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Override
	public List<CursoDTO> getCursoService() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM CURSO ",
				new CursoListMapper<CursoDTO>());
	}

	@Override
	public Integer insertCurso(CursoDTO nuevoCurso) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO CURSO(NOMBRE_MATERIA,DESCRIPCION,FECHA_CREACION)"
				+ "VALUES(?,?,?)",nuevoCurso.getNombreMateria(),nuevoCurso.getDescripcion(),nuevoCurso.getFechaCreacion());
	}
	
	@Override
	public Integer updateCurso(CursoDTO modificarCurso) {
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("UPDATE CURSO SET NOMBRE_MATERIA = ? WHERE ID_CURSO = ?"
				,modificarCurso.getNombreMateria(),modificarCurso.getIdCurso());
	}
	
	@Override
	public Integer deleteCurso(CursoDTO borrarCurso) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM CURSO WHERE ID_CURSO = ?"
				,borrarCurso.getIdCurso());
	
	}
	
	//-------------------------
	
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
