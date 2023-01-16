package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Repository.IAspirantesRepository;
import com.mx.mex.Services.IAspirantes;

@Service
public class AspirantesServiceImpl implements IAspirantes{

	@Autowired
	private IAspirantesRepository aspirantesRepo;
	//select
	@Override
	public List<Aspirantes> getAspirantes() {
		return aspirantesRepo.getAspirantes();
	}

	//insert
	@Override
	public String insertAspirantes(Aspirantes nuevoAspirantes) {
		Integer respuesta = aspirantesRepo.insertAspirantes(nuevoAspirantes);
		String respuestaInsert;
		if (respuesta==0) 
			respuestaInsert = "No se inserto corectamente";
		
		else 
			respuestaInsert = "Se inserto corectamente";
		
				return respuestaInsert;
	}
	
//update
	@Override
	public String updateAspirantes(Aspirantes cambioAspirante) {
		Integer respuesta = aspirantesRepo.updateAspirantes(cambioAspirante);
		//String respuestaInsert;
		if (respuesta==0) 
			//respuestaInsert = "No se actualizo corectamente";
		return  "No se actualizo corectamente";
		else 
			//respuestaInsert = "Se actualizo corectamente";
		return "Se actualizo corectamente";
			//	return respuestaInsert;
	}

	@Override
	public String deleteAspirantes(Aspirantes deleteAspirante) {
		Integer respuesta = aspirantesRepo.deleteAspirantes(deleteAspirante);
		//String respuestaInsert;
		if (respuesta==0) 
			//respuestaInsert = "No se actualizo corectamente";
		return  "No se elimino corectamente";
		else 
			//respuestaInsert = "Se actualizo corectamente";
		return "Se elimino corectamente";
	}

	@Override
	public Aspirantes getAspirantesById(Aspirantes aspirante) {
		
		return aspirantesRepo.getAspirantesById(aspirante);
	}

}
