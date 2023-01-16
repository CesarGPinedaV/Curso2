package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.MaestrosDTO;

public interface MaestrosDAO {

	List<MaestrosDTO> getMaestrosService();

	Integer insertMaestros(MaestrosDTO nuevoMaestro);

	Integer updateMaestros(MaestrosDTO cambiarMaestro);

	Integer deleteMaestros(MaestrosDTO eliminarMaestro);

}
