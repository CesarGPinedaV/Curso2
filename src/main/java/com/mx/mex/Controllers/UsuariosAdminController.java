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
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.UsuariosAdmin;
import com.mx.mex.Services.UsuariosAdminService;

@Controller
@RequestMapping (value = "UsuariosAdmin")
public class UsuariosAdminController {

	@Autowired
	private UsuariosAdminService usuariosAdminService;

	/**
	 * obtener todos los usuarios admin - JDBCTEMPLATE
	 */
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getUsuariosAdmin", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<UsuariosAdminDTO>> getUsuariosAdmin(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdminDTO> lista = usuariosAdminService.getAllUsariosAdmin();
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <List<UsuariosAdminDTO>> (lista, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	
	/**
	 * obtener todos los usuarios admin - Hibernate
	 */
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getUsuariosAdmin_hibernate", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<UsuariosAdmin>> getUsuariosAdmin_hibernate(){//usariosadmin es laclase de entity
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosAdmin> lista = usuariosAdminService.getUsuariosAdmin_hibernate();
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <List<UsuariosAdmin>> (lista, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	/**
	 * insertar nuevo usuarios admin - Hibernate
	 */
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/insertUsuariosAdmin_hibernate", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> insertUsuariosAdmin_hibernate(@RequestBody UsuariosAdminDTO datos){//usariosadmin es laclase de entity
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = usuariosAdminService.insertarUsAdmin_hibernate(datos);
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/elimnarUsuariosAdmin_hibernate", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> elimnarUsuariosAdmin_hibernate(@RequestBody UsuariosAdminDTO datos){//usariosadmin es laclase de entity
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = usuariosAdminService.eliminarUsAdmin_hibernate(datos);
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/actualizarUsuariosAdmin_hibernate", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> actualizarUsuariosAdmin_hibernate(@RequestBody UsuariosAdmin datosUser){//usariosadmin es laclase de entity
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = usuariosAdminService.actualizarUsAdmin_hibernate(datosUser);
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
}
