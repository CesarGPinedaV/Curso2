package com.mx.mex.RepositoryImplement;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Dto.MaestrosDTO;
import com.mx.mex.Mapper.CursoListMapper;
import com.mx.mex.Mapper.MaestrosListMapper;
import com.mx.mex.Repository.MaestrosDAO;

@Repository
public class MaestrosDAOImpl implements MaestrosDAO {

	@Autowired
	DataSource dataSource;
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Override
	public List<MaestrosDTO> getMaestrosService() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM MAESTROS ",
				new MaestrosListMapper<MaestrosDTO>());
	}

	
	@Override
	public Integer insertMaestros(MaestrosDTO nuevoMaestro) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO MAESTROS(NOMBRE,EDAD,FECHA_CREACION)"
				+ "VALUES(?,?,?)",nuevoMaestro.getNombreMaestro(),nuevoMaestro.getEdad(),nuevoMaestro.getFechaCreacion());

	}
	
	@Override
	public Integer updateMaestros(MaestrosDTO cambiarMaestro) {
jdbcTemplate.setDataSource(getDataSource());
		
		return jdbcTemplate.update("UPDATE MAESTROS SET NOMBRE = ?, EDAD = ? WHERE ID_MAESTRO = ?"
				,cambiarMaestro.getNombreMaestro(),cambiarMaestro.getEdad(),cambiarMaestro.getIdMaestro());
	
	}
	
	@Override
	public Integer deleteMaestros(MaestrosDTO eliminarMaestro) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM MAESTROS WHERE ID_MAESTRO = ?"
				,eliminarMaestro.getIdMaestro());
	}

	
	
	//------------------------
	
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
