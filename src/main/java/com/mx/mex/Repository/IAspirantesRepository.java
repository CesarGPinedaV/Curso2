package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.Aspirantes;

public interface IAspirantesRepository {
	List<Aspirantes> getAspirantes();
	
	Integer insertAspirantes(Aspirantes nuevoAspirante);
	Integer updateAspirantes(Aspirantes cambioAspirante);
	Integer deleteAspirantes(Aspirantes deleteAspirante);
	Aspirantes getAspirantesById (Aspirantes aspirante);



}
