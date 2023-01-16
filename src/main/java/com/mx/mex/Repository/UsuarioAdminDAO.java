package com.mx.mex.Repository;

import java.util.List;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.UsuariosAdmin;

public interface UsuarioAdminDAO {

	List<UsuariosAdminDTO> obtenerAllUsuariosAdmin();

	
	//consultas HIBERNATE
	List<UsuariosAdmin> obtenerAllUsuariosAdmin_hibernate();


	Integer insertarUsarios(UsuariosAdmin usuariosAdmin);


	Integer eliminarUsarios(Long idUser);


	Integer actualizarUsarios(UsuariosAdmin datosUser);


}
