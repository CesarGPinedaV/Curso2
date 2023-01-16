package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Repository.CursoDAO;
import com.mx.mex.Repository.IAspirantesRepository;
import com.mx.mex.Services.CursoService;

@Service
public class CursoImpl implements CursoService{

	@Autowired
	private CursoDAO curso;
	
	@Override
	public List<CursoDTO> getCursoService() {
		return curso.getCursoService();
	}

	@Override
	public String insertCurso(CursoDTO nuevoCurso) {
		Integer respuesta = curso.insertCurso(nuevoCurso);
		String respuestaInsert;
		if (respuesta==0) 
			respuestaInsert = "No se inserto corectamente";
		
		else 
			respuestaInsert = "Se inserto corectamente";
		
				return respuestaInsert;
	}

	@Override
	public String updateCurso(CursoDTO modificarCurso) {
		Integer respuesta = curso.updateCurso(modificarCurso);
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
	public String deleteCurso(CursoDTO borrarCurso) {
		Integer respuesta = curso.deleteCurso(borrarCurso);
		//String respuestaInsert;
		if (respuesta==0) 
			//respuestaInsert = "No se actualizo corectamente";
		return  "No se borro corectamente";
		else 
			//respuestaInsert = "Se actualizo corectamente";
		return "Se borro corectamente";
			//	return respuestaInsert;
	}
	

	

}
