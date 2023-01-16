package com.mx.mex.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Mapper.AspirantesListMapper;
import com.mx.mex.Mapper.objectAspiranteMapper;
import com.mx.mex.Repository.IAspirantesRepository;

@Repository
public class AspirantesRepositoryImpl implements IAspirantesRepository {
	@Autowired
	DataSource dataSource;

	JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public List<Aspirantes> getAspirantes() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query(
				"SELECT A.*,C.NOMBRE_MATERIA AS NOMBRE_MATERIA\r\n" + ",M.NOMBRE AS NOMBRE\r\n"
						+ "FROM ASPIRANTES A\r\n" + "INNER JOIN CURSO C \r\n" + "ON A.CURSO=C.ID_CURSO\r\n"
						+ "INNER JOIN MAESTROS M \r\n" + "ON A.MAESTRO=M.ID_MAESTRO",
				new AspirantesListMapper<Aspirantes>());
	}

	@Override
	public Integer insertAspirantes(Aspirantes nuevoAspirante) {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO ASPIRANTES(NOMBRE_ALUMNO,EDAD,FECHA_INSCRIPCION,CURSO,MAESTRO)"
				+ "VALUES(?,?,?,?,?)",nuevoAspirante.getNombreAlumno(),nuevoAspirante.getEdad(),nuevoAspirante.getFechaInscripcion(),Integer.parseInt(nuevoAspirante.getCurso()),Integer.parseInt(nuevoAspirante.getMaestro()));
	}
	


	@Override
	public Integer updateAspirantes(Aspirantes cambioAspirante) {
		jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("UPDATE ASPIRANTES SET NOMBRE_ALUMNO = ?, EDAD = ?, FECHA_INSCRIPCION = ?, CURSO = ?, MAESTRO = ? WHERE ID_ALUMNO = ?"
				,cambioAspirante.getNombreAlumno(),cambioAspirante.getEdad(),cambioAspirante.getFechaInscripcion(),cambioAspirante.getCursoId(),cambioAspirante.getMaestroId(),cambioAspirante.getIdAlumno());
	}
	
	@Override
	public Integer deleteAspirantes(Aspirantes deleteAspirante) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM ASPIRANTES WHERE ID_ALUMNO = ?"
				,deleteAspirante.getIdAlumno());
	
	}
	
	@Override
	public Aspirantes getAspirantesById(Aspirantes aspirante) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject("SELECT * FROM ASPIRANTES WHERE ID_ALUMNO = ?", new Object[] {aspirante.getIdAlumno()}
		,new objectAspiranteMapper<Aspirantes>());
		
				
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
