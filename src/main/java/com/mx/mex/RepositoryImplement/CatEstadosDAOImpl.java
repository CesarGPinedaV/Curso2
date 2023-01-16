package com.mx.mex.RepositoryImplement;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import com.mx.mex.Entities.CatEstados;
import com.mx.mex.Repository.CatEstadosDAO;

@Repository
public class CatEstadosDAOImpl extends GenericDAO <com.mx.mex.Entities.CatEstados,Long> implements CatEstadosDAO {

	@SuppressWarnings ("unchecked")
	@Override
	@Transactional
	public List<com.mx.mex.Entities.CatEstados> obtieneEstados() {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(com.mx.mex.Entities.CatEstados.class);
		return  (List<com.mx.mex.Entities.CatEstados>) criteria.list() ;
		
	}

}
