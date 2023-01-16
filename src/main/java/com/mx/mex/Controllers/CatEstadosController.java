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

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.MensajeDTO;
import com.mx.mex.Dto.UsuariosAdminDTO;
import com.mx.mex.Entities.CatEstados;
import com.mx.mex.Services.CatEstadosService;
import com.mx.mex.Services.UsuariosAdminService;

@Controller
@RequestMapping (value = "CatalogoEstados")
public class CatEstadosController {
//inyeccon de depenencia es la union de una o mas clases
	
	@Autowired
	private CatEstadosService catEstadosService;

	/**
	 * obtener todos los estados admin - JDBCTEMPLATE
	 */
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getAllEstados", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<CatEstados>> getAllEstados(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<CatEstados> lista = catEstadosService.getAllEstados();
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <List<CatEstados>> (lista, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	//obtemner el Estado por ID
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getEstadoPrId", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public String obtenerEstadoId(@RequestBody CatEstadosDTO id) {
		String respuesta = catEstadosService.consultarEstadoPorId(id);	

		return  respuesta;
    } //FIN DE METODO

//insertar estado hiberate
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/insertEstado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	public String agrearEstado(@RequestBody CatEstadosDTO estado) {
		String respuesta = catEstadosService.agrearEstado(estado);	

		return  respuesta;
    } //FIN DE METODO

	//eliminar los estados hibernate
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/eliminarEstados", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <String> elimnarEstadosPorId(@RequestBody CatEstadosDTO id){
		final HttpHeaders httpHeaders = new HttpHeaders();
		String respuesta = catEstadosService.eliminarEstados(id);
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
    } //FIN DE METODO
	
	//eliminar los estados con Mensajedto hibernate
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/eliminarEstadosDTO", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		public MensajeDTO elimnarEstados(@RequestBody CatEstadosDTO id){
			final HttpHeaders httpHeaders = new HttpHeaders();
			return catEstadosService.eliminarEstadosPorMensajeDTO(id);
				
	 } //FIN DE METODO

		
		//UPDATE estado hiberate
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/updateEstado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		public String updateEstado(@RequestBody CatEstadosDTO estado) {
			String respuesta = catEstadosService.updateEstado(estado);	

			return  respuesta;
	    } //FIN DE METODO

}
