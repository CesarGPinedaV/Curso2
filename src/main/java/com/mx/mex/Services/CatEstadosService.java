package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Entities.CatEstados;

public interface CatEstadosService {

	List<CatEstados> getAllEstados();
//consulta por id hibernate
	String consultarEstadoPorId(CatEstadosDTO id);
//insertar por hibernate
	String agrearEstado(CatEstadosDTO estado);
	//eimnar por hibernate
	String eliminarEstados(CatEstadosDTO id);
	//eliminar por mensajeDTO hibernate
	MensajeDTO eliminarEstadosPorMensajeDTO(CatEstadosDTO id);
	//update hibernate hasta DAO
	String updateEstado(CatEstadosDTO estado);

}
