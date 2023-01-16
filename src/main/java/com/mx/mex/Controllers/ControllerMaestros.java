package com.mx.mex.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Dto.MaestrosDTO;
import com.mx.mex.Services.MaestrosService;



@Controller
@RequestMapping(value="Maestros")
public class ControllerMaestros {
	
	@Autowired
	private MaestrosService maestros;
	
	//select
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/getMaestros", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <List<MaestrosDTO>> getMaestros(){
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<MaestrosDTO> lista = maestros.getMaestrosService();	
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
			return new ResponseEntity <List<MaestrosDTO>> (lista, httpHeaders, HttpStatus.OK);
	    } 
	
		@ResponseBody //NOS PERMITE MANDARLA RESPUESTA COMO VALORES
		@RequestMapping(value="/insertMaestro", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String> insertMaestro(@RequestBody MaestrosDTO p){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = maestros.insertMaestro(p);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
	    
	    }
		
		@ResponseBody
		@RequestMapping(value="/updateMaestro", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String> updateMaestro(@RequestBody MaestrosDTO p){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = maestros.updateMaestros(p);//ACA ES DONDE SE EMPISA EL CAMINITO CON LA PRIMERA INTERFAZ DE SERVICIO
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
	    
	    }

		
		@ResponseBody
		@RequestMapping(value="/deleteMaestros", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String> deleteMaestros(@RequestBody MaestrosDTO p){
			final HttpHeaders httpHeaders = new HttpHeaders();
			
			String respuesta = maestros.deleteMaestros(p);//ACA ES DONDE SE EMPISA EL CAMINITO CON LA PRIMERA INTERFAZ DE SERVICIO
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
	    
	    }
}
