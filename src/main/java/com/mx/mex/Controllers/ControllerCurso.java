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

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Dto.CursoDTO;
import com.mx.mex.Services.CursoService;
import com.mx.mex.Services.IAspirantes;

@Controller
@RequestMapping(value="Curso")
public class ControllerCurso {

	@Autowired 
	private CursoService curso;
	
	
	//select
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getCurso", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<CursoDTO>> getCurso(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<CursoDTO> lista = curso.getCursoService();	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <List<CursoDTO>> (lista, httpHeaders, HttpStatus.OK);
    } 
	
	//insert
	@ResponseBody //NOS PERMITE MANDARLA RESPUESTA COMO VALORES
	@RequestMapping(value="/insertCurso", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> insertCurso(@RequestBody CursoDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = curso.insertCurso(p);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    
    }
	
	@ResponseBody
	@RequestMapping(value="/updateCurso", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> updateCurso(@RequestBody CursoDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = curso.updateCurso(p);//ACA ES DONDE SE EMPISA EL CAMINITO CON LA PRIMERA INTERFAZ DE SERVICIO
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    
    }
	
	@ResponseBody
	@RequestMapping(value="/deleteCurso", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> deleteCurso(@RequestBody CursoDTO p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = curso.deleteCurso(p);//ACA ES DONDE SE EMPISA EL CAMINITO CON LA PRIMERA INTERFAZ DE SERVICIO
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    
    }
	
	
	
	
}
