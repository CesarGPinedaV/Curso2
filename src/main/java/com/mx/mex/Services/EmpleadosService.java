package com.mx.mex.Services;

import com.mx.mex.Dto.EmpleadosDTO;

public interface EmpleadosService {

	//consultar por hibernate
	String consultarEmpleadoPorId(EmpleadosDTO id);

	String insertEmpleado(EmpleadosDTO empleado);

	String eliminarEmpleados(EmpleadosDTO id);

}
