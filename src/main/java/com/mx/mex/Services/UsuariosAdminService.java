package com.mx.mex.Services;

import java.util.List;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.UsuariosAdmin;

public interface UsuariosAdminService {
//consulta jdbc
	List<UsuariosAdminDTO> getAllUsariosAdmin();

	
	//consulta hibernate
	List<UsuariosAdmin> getUsuariosAdmin_hibernate();


	String insertarUsAdmin_hibernate(UsuariosAdminDTO datos);


	String eliminarUsAdmin_hibernate(UsuariosAdminDTO datos);


	String actualizarUsAdmin_hibernate(UsuariosAdmin datosUser);

	

}
