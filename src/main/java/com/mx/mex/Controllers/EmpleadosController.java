package com.mx.mex.Controllers;

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
import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Services.EmpleadosService;

@Controller
@RequestMapping (value = "Empleados")
public class EmpleadosController {

	@Autowired
	private EmpleadosService empleadosService;
	
	
	//obtemner el empleado por ID
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/getEmpleadoId", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		public String obtenerEmpleadoId(@RequestBody EmpleadosDTO id) {
			String respuesta = empleadosService.consultarEmpleadoPorId(id);	

			return  respuesta;
	    } //FIN DE METODO

		//insertar estado hiberate
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/insertEmpleado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		public String insertEmpleado(@RequestBody EmpleadosDTO empleado) {
			String respuesta = empleadosService.insertEmpleado(empleado);	
			System.out.println("si paso"+respuesta);
			return  respuesta;
	    } //FIN DE METODO
		
		//eliminar los estados hibernate
		@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
		@RequestMapping(value="/eliminarEmpleados", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String> elimnarEmpleadosPorId(@RequestBody EmpleadosDTO id){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = empleadosService.eliminarEmpleados(id);
				
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);
	    } //FIN DE METODO
		
		
		
}
