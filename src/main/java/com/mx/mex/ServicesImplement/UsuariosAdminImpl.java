package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.UsuariosAdmin;
import com.mx.mex.Repository.UsuarioAdminDAO;
import com.mx.mex.Services.UsuariosAdminService;

@Service
public class UsuariosAdminImpl implements UsuariosAdminService{
	
	@Autowired
	private UsuarioAdminDAO usuarioAdminDAO;

	//obtener todos los usuario admin con jdbctemplate
	@Override
	public List<UsuariosAdminDTO> getAllUsariosAdmin() {
		
		
		return usuarioAdminDAO.obtenerAllUsuariosAdmin();
	}

	
	
	//consulta por hibernate
	@Override
	public List<UsuariosAdmin> getUsuariosAdmin_hibernate() {
		List<UsuariosAdmin> listaUsuarioAdmin = usuarioAdminDAO.obtenerAllUsuariosAdmin_hibernate();
		return listaUsuarioAdmin;
	}


//INSERTAR POR HIBERNET
	@Override
	public String insertarUsAdmin_hibernate(UsuariosAdminDTO datos) {
		//UsuariosAdminDTO es para transporta la infomacion en ste cas la info viene en el obj "datos"
		
		UsuariosAdmin usuariosAdmin = new UsuariosAdmin();//inicalizamos el obj (UsuariosAdmin) en vacio
		usuariosAdmin.setIdUser(datos.getIdUser());
		usuariosAdmin.setNombreCompleto(datos.getNombreCompleto());
		usuariosAdmin.setEdad(datos.getEdad());
		usuariosAdmin.setDireccion(datos.getDireccion());
		usuariosAdmin.setEstado(datos.getEstado());
		usuariosAdmin.setRol(datos.getRol());
		Integer respuesta = usuarioAdminDAO.insertarUsarios(usuariosAdmin);
		String respuestaInsert;
		if(respuesta ==0)
			respuestaInsert= "no se puedo insertar los datos";
		else respuestaInsert = "si inserto los datos";
		
		
		
		return respuestaInsert;
	}


//ELIMINARPOR HIBERNETE
	@Override
	public String eliminarUsAdmin_hibernate(UsuariosAdminDTO datos) {
		Integer respuesta = usuarioAdminDAO.eliminarUsarios(datos.getIdUser());
		String respuestaInsert;
		if(respuesta ==0)
			respuestaInsert= "no se puedo eliminar los datos";
		else respuestaInsert = "si se elimino los datos";
		
		
		
		return respuestaInsert;
	}


//ACTUALIZAR POR HIBERNETE
	@Override
	public String actualizarUsAdmin_hibernate(UsuariosAdmin datosUser) {
		Integer respuesta = usuarioAdminDAO.actualizarUsarios(datosUser);
		String respuestaInsert;
		if(respuesta ==0)
			respuestaInsert= "no se puedo actualizar los datos";
		else respuestaInsert = "si se actualizo";
		
		
		
		return respuestaInsert;
	}
}
