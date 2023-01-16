package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.CursoDTO;

public interface CursoService {

	List<CursoDTO> getCursoService();

	String insertCurso(CursoDTO nuevoCurso);

	String updateCurso(CursoDTO modificarCurso);

	String deleteCurso(CursoDTO borrarCurso);

}
