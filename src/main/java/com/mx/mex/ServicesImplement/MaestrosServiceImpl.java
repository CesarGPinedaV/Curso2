package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.MaestrosDTO;
import com.mx.mex.Repository.MaestrosDAO;
import com.mx.mex.Services.MaestrosService;

@Service
public class MaestrosServiceImpl implements MaestrosService {
@Autowired
private MaestrosDAO maestros;
	
	@Override
	public List<MaestrosDTO> getMaestrosService() {
		return maestros.getMaestrosService();
	}

	@Override
	public String insertMaestro(MaestrosDTO nuevoMaestro) {
		Integer respuesta = maestros.insertMaestros(nuevoMaestro);
		String respuestaInsert;
		if (respuesta==0) 
			respuestaInsert = "No se inserto corectamente";
		
		else 
			respuestaInsert = "Se inserto corectamente";
		
				return respuestaInsert;
	}

	@Override
	public String updateMaestros(MaestrosDTO cambiarMaestro) {
		Integer respuesta = maestros.updateMaestros(cambiarMaestro);
		String respuestaInsert;
		if (respuesta==0) 
			respuestaInsert = "No se cambio corectamente";
		
		else 
			respuestaInsert = "Se cambio corectamente";
		
				return respuestaInsert;
	}

	@Override
	public String deleteMaestros(MaestrosDTO eliminarMaestro) {
		Integer respuesta = maestros.deleteMaestros(eliminarMaestro);
		String respuestaInsert;
		if (respuesta==0) 
			respuestaInsert = "No se elimino corectamente";
		
		else 
			respuestaInsert = "Se elimino corectamente";
		
				return respuestaInsert;
	}

}
