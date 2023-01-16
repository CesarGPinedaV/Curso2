package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.CursoDTO;

public interface CursoDAO {

	List<CursoDTO> getCursoService();

	Integer insertCurso(CursoDTO nuevoCurso);

	Integer updateCurso(CursoDTO modificarCurso);

	Integer deleteCurso(CursoDTO borrarCurso);

}

