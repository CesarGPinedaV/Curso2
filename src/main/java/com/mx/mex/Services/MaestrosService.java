package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.MaestrosDTO;

public interface MaestrosService {

	List<MaestrosDTO> getMaestrosService();

	String insertMaestro(MaestrosDTO nuevoMaestro);

	String updateMaestros(MaestrosDTO cambiarMaestro);

	String deleteMaestros(MaestrosDTO eliminarMaestro);

}
