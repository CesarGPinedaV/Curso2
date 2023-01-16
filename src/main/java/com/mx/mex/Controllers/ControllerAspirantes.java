package com.mx.mex.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.mex.Dto.Aspirantes;
import com.mx.mex.Dto.ResponseDto;
import com.mx.mex.Services.IAspirantes;


@Controller
@RequestMapping(value="Aspirantes")
public class ControllerAspirantes {

	
	@Autowired 
	private IAspirantes aspirantes;
	
	//@Autowired
	//private IAspirantes uaspirantes;
	
	
	// UN METODO SE COMPONE POR
	// TIPO DE IDENTIFICADOR (PUBLIC, PRIVATE O PROTECTED)
	//
	
	/*{	
		alumno: "Alumno",
		edad: 12,
		nombre: "Jorge"		
	}*/
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMETE DATOS Y NO UNA VISTA
	@RequestMapping(value="/getAspirantes", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<Aspirantes>> getAspirantes(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Aspirantes> lista = aspirantes.getAspirantes();
		//for(Aspirantes run : lista) {
			
			//System.out.println("ID_ALUMNO: "+run.getIdAlumno());
	    	
			
			//System.out.println("Nombe Alumno: "+run.getNombreAlumno());
	    	//System.out.println("Edad: "+run.getEdad());
	    	//System.out.println("Fecha: "+run.getFechaInscripcion());
	    	//System.out.println("Materia: "+run.getCurso());
	    //	System.out.println("Mestro: "+run.getMaestro());
			//}
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <List<Aspirantes>> (lista, httpHeaders, HttpStatus.OK);
    } 
		// CODIGOS DERESPUESTA HTTP DE LAS PAGINAS
		// 202 = OK
		//404 = LA PAGINA O RTA NO SE ENCUENTRA
		//500 = ES UNA EXCEPCION INTERNA EN NUESTRO CODIGO
	//503 = NO TE ENCUENTRAS AUTORIZADO
	
	@ResponseBody //NOS PERMITE MANDARLA RESPUESTA COMO VALORES
	@RequestMapping(value="/insertAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> insertAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto obj = new ResponseDto();		//Aspirantes objeto = new Aspirantes();
//		objeto.setNombreAlumno("MATIAS");
//		objeto.setEdad(3);
//		objeto.setFechaInscripcion(new Date());
//		objeto.setCurso("1");
//		objeto.setMaestro("1");
		obj.setMessage(aspirantes.insertAspirantes(p));
		obj.setCode(0);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;
		return new ResponseEntity <ResponseDto> (obj, httpHeaders, HttpStatus.OK);
    
    }
		
	
	@ResponseBody
	@RequestMapping(value="/updateAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> updateAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto obj = new ResponseDto();		//Aspirantes objeto = new Aspirantes();
		
		obj.setMessage(aspirantes.updateAspirantes(p));
		obj.setCode(0);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
		return new ResponseEntity <ResponseDto> (obj, httpHeaders, HttpStatus.OK);
    
    }
	
	@ResponseBody
	@RequestMapping(value="/deleteAspirantes", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> deleteAspirantes(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		ResponseDto obj = new ResponseDto();		
		
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
		
		obj.setMessage(aspirantes.deleteAspirantes(p));
		obj.setCode(0);//indicar si uvo error o fue exitoso
		
		return new ResponseEntity <ResponseDto> (obj, httpHeaders, HttpStatus.OK);
		
    }
	
	
	@ResponseBody
	@RequestMapping(value="/getAspiranteById", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <Aspirantes> getAspiranteById(@RequestBody Aspirantes p){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		Aspirantes aspirante = aspirantes.getAspirantesById(p);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);;//NOS PERMITE RECIBIR UNICAMENTE DATOS EN FORMATO JASON
		return new ResponseEntity <Aspirantes> (aspirante, httpHeaders, HttpStatus.OK);
    
    }
	
//		List<Aspirantes> listaAspirantes = new ArrayList<>();
//		Aspirantes objeto = new Aspirantes(); // puede contener un registro
//		objeto.setCurso("1");
//	    objeto.setEdad(12);
//	    objeto.setFechaInscripcion(new Date());
//	    objeto.setIdAlumno(new BigDecimal(1));
//	    objeto.setMasestro("Jacinto");
//	    objeto.setNombreAlumno("Taboada");
//	    
//	 
//	  
//	    listaAspirantes.add(objeto); //PUEDES ASIGNAR UN OBJETO  , alexis
//		   
//	    objeto.setCurso("0001");
//		objeto.setEdad(12);
//		objeto.setFechaInscripcion(new Date());
//		objeto.setIdAlumno(new BigDecimal(1));
//		objeto.setMasestro("Jacinto");
//		objeto.setNombreAlumno("Taboada");
//		   
//		listaAspirantes.add(objeto); //PUEDES ASIGNAR UN OBJETO ,, arturo 
//		
//		// de los 1000 registros, solamente vas a ver el ultimo en el objeto
		
	

}
