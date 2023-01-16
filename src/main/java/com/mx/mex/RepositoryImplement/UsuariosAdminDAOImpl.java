package com.mx.mex.RepositoryImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.UsuariosAdmin;
import com.mx.mex.Repository.UsuarioAdminDAO;

@Repository
public class UsuariosAdminDAOImpl implements UsuarioAdminDAO {
//consultas con JdbcTemplate
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	//Consltas con hibernate
		@Autowired
		private SessionFactory sessionFactory; //esta s la sesion activa del usuario

	public UsuariosAdminDAOImpl() {
		
	}
	public UsuariosAdminDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	//Metodo para obtener todos los usarios admin por medio de jdbctemplate
	@SuppressWarnings("unchecked") // Esta anotacion es para -> @Suprimir advertencias (lineas amarillas - PUEDEN COMENTAR ESTA LINEA PARA QUE VEAN A QUE ME REFIERO)	
	@Override
	public List<UsuariosAdminDTO> obtenerAllUsuariosAdmin() {
jdbcTemplate.setDataSource(getDataSource()); //ASIGNAMOS LA CONEXIÓN AL OBJETO JDBCTEMPLATE
		
		StringBuilder sb = new StringBuilder("SELECT ID_USER, NOMBRE_COMPLETO, EDAD, DIRECCION FROM CURSOADMIN.USUARIOS_ADMIN");
		
		 return (List<UsuariosAdminDTO>) jdbcTemplate.query(sb.toString(), new Object[] {}, new RowMapper() {
			 
			 @Override
	         public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 UsuariosAdminDTO datos = new UsuariosAdminDTO();
			   
//	           datos.setIdUser(rs.getBigDecimal("ID_USER"));
	           datos.setIdUser(rs.getLong("ID_USER"));
			   datos.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
			   datos.setEdad(rs.getString("EDAD"));
			   datos.setDireccion(rs.getString("DIRECCION"));
			  
			   return datos;
		   }
	   });
	
	}//fin de metodo
	
	
	//getters and setter
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public JdbcTemplate getJdbvTemplate() {
		return jdbcTemplate;
	}
	public void setJdbvTemplate(JdbcTemplate jdbvTemplate) {
		this.jdbcTemplate = jdbvTemplate;
	}
	
	

//CONSLTA HIBERNATE esta es la consulta = Framework para desarrollo agil y seguro
	@SuppressWarnings("unchecked") // Esta anotacion es para -> @Suprimir advertencias (lineas amarillas - PUEDEN COMENTAR ESTA LINEA PARA QUE VEAN A QUE ME REFIERO)	
	@Transactional //es como un commit transaaccion (insert,update y delete)
	@Override
	public List<UsuariosAdmin> obtenerAllUsuariosAdmin_hibernate() {
		final Session session = sessionFactory.getCurrentSession();//obtener la sesion actual
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
		
		//2.- criteria.add(Restrictions.eq("ID_USUER", 1));//esto es el where id_user = 1
		//3.-criteria.add(Order.asc("EDAD"))/ CONSULTA POR ORDEN ASC
		return (List<UsuariosAdmin>)criteria.list();
	
	}

//1.- select * from esquema.tabla;
//2.- SELECT * FROM ESQEMA.TABLA WHERE ID_USER = 1
//3.- ORDEN BY ASC

	//insertar con hibernate
	@Override
	@Transactional //es como un commit transaaccion (insert,update y delete)
	public Integer insertarUsarios(UsuariosAdmin usuariosAdmin) {
		sessionFactory.getCurrentSession().save(usuariosAdmin);//Insertamos con hibernate
		return 1;
	}
	//elimnar con hibernate
	@Override
	@Transactional
	public Integer eliminarUsarios(Long idUser) {
		UsuariosAdmin idUserAdmin = new UsuariosAdmin();
		idUserAdmin.setIdUser(idUser);
		sessionFactory.getCurrentSession().delete(idUserAdmin);
		
		return 1;
	}
	
	//update
	@Override
	@Transactional
	public Integer actualizarUsarios(UsuariosAdmin datosUser) {
		sessionFactory.getCurrentSession().update(datosUser); //siempre va a actualizar
		sessionFactory.getCurrentSession().saveOrUpdate(datosUser);//si ya xiste el registro lo va actualizar/ si no existe lo crea
		return 1;
	}
	
	
	
}
