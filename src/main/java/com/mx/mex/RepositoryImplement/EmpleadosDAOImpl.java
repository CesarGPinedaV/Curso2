package com.mx.mex.RepositoryImplement;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mx.mex.Entities.EmpleadosEntities;
import com.mx.mex.Repository.DAO;
import com.mx.mex.Repository.EmpleadosDAO;

@Repository
public class EmpleadosDAOImpl extends  GenericDAO<EmpleadosEntities,Long> implements EmpleadosDAO {

	@Override
	public int obtenerSecuenciaEmpleados() {
		//String sqlSequence = "SELECT SEQ_HISTORICO_CASOS.NEXTVAL AS SECUENCIAUSER FROM DUAL";
		String sqlSequence = "SELECT SC_EMPLEADOS.NEXTVAL AS SECUENCIAUSER FROM DUAL";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sqlSequence);
		List result = query.list();
		return ((BigDecimal) result.get(0)).intValue();
		
	}

	

}
