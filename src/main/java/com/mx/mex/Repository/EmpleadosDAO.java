package com.mx.mex.Repository;

import com.mx.mex.Entities.EmpleadosEntities;

public interface EmpleadosDAO extends DAO<EmpleadosEntities,Long>  {
	int obtenerSecuenciaEmpleados();
}
