package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Entities.CatEstados;
import com.mx.mex.Entities.UsuariosAdmin;
import com.mx.mex.Repository.CatEstadosDAO;
import com.mx.mex.Services.CatEstadosService;

@Service
public class CatEstadosImpl implements CatEstadosService{

	@Autowired 
    private CatEstadosDAO catEstadosDAO;
	
	@Override
	public List<CatEstados> getAllEstados() {
		List<CatEstados> estados = catEstadosDAO.obtieneEstados();
		
		return estados;
	}

	@Override
	public String consultarEstadoPorId(CatEstadosDTO id) {
	String resp = null;
	System.out.println("hola"+id.getIdEstados());
		// SELECT * FROM CAT_ESTADOS WHERE ID_ESTADOS = 1
	com.mx.mex.Entities.CatEstados estado = catEstadosDAO.read(id.getIdEstados()); //select consultar por hibernete
		
	System.out.println("Nombre"+estado.getNombre()+ "abreviatura"+estado.getAbreviatura());
	// == igual
	//!= diferente
	//operadores relacionales
	//|| OR se cumple una o otra
	//&& AND se debe de cumplir las dos 
	//!negar la condicion
	if (estado != null || !estado.toString().isEmpty()) {// diferente de null es have !=
	resp = "si existe el estado";
	}
	else {
		resp = "no existe el registro";
		
	}
		return resp;
	}
//agregar nuevo estado hibernate
	@Override
	public String agrearEstado(CatEstadosDTO estado) {
		CatEstados catEstados = new CatEstados();
		catEstados.setIdEstados(estado.getIdEstados());
		catEstados.setNombre(estado.getNombre());
		catEstados.setAbreviatura(estado.getAbreviatura());
		
		Long agregoReg = catEstadosDAO.create(catEstados);
		 if (agregoReg!=0) {
			 return "INSERTO DE FORMA CORRECTA";
		 }
		 else {
			 return "no se pudo insertar";
		 }
		 
		
	}

	//elimnar estado por id  po hibernate
	@Override
	public String eliminarEstados(CatEstadosDTO id) {
	
		catEstadosDAO.delete(id.getIdEstados());//espicificar el id 
		
		return "se elimino el registro";
	}

	
	//Mestodo para eliminar estado por MENSAJEDTO
	//1 verificar si el id que se manda no sea null o cero (incorecto)
	//2.-verifica/consulta si existe el estado con ese id
	//3.- evaluar si existe el estado consultad por id
	@Override
	public MensajeDTO eliminarEstadosPorMensajeDTO(CatEstadosDTO id) {
		MensajeDTO mensajeDTO = new MensajeDTO();
		
		try {
			if(id.getIdEstados() != null || id.getIdEstados() !=0 ) {//se cumople la 1.- regla
				
				CatEstados estado = catEstadosDAO.read(id.getIdEstados()); //2-.select consultar por hibernete para ver si existe el estado
				
				if (estado !=null) {//3.- verificar si si existe el registto
					catEstadosDAO.delete(id.getIdEstados());
					mensajeDTO.setMensaje("El esado hasido eliminado correctamente");
					
				}else {
					mensajeDTO.setMensaje("el estado no existe en labase de datos");
				}

				
			}else {
				mensajeDTO.setMensaje("Los datos enviados para la consulta son Erroneos");
			}
			
		} catch (Exception e) {
			mensajeDTO.setMensaje("Ocurrio un error al intentar eliminar informacion");
		}
		

		
		return mensajeDTO;
	}

	@Override
	public String updateEstado(CatEstadosDTO estado) {
		CatEstados catEstados = new CatEstados();
		catEstados.setIdEstados(estado.getIdEstados());
		catEstados.setNombre(estado.getNombre());
		catEstados.setAbreviatura(estado.getAbreviatura());
		catEstadosDAO.update(catEstados);
		 if (estado.getIdEstados()!=catEstados.getIdEstados()) {
			 return "NO SE PUDO ACTUALIZAR";
		 }
		 else {
			 return "SE ACTUALIZO DE FORMA CORRECTA";
		 }

}

}