package com.mx.mex.ServicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.CatEstadosDTO;
import com.mx.mex.Dto.EmpleadosDTO;
import com.mx.mex.Entities.CatEstados;
import com.mx.mex.Entities.EmpleadosEntities;
import com.mx.mex.Repository.EmpleadosDAO;
import com.mx.mex.Services.EmpleadosService;

@Service
public class EmpleadosServiceImpl implements EmpleadosService{

	@Autowired
	private EmpleadosDAO empleadosDAO;
	
	@Override
	public String consultarEmpleadoPorId(EmpleadosDTO id) {
		String resp = null;
		// SELECT * FROM CAT_ESTADOS WHERE ID_ESTADOS = 1
		EmpleadosEntities empleado = empleadosDAO.read(id.getIdEmpleados()); //select consultar por hibernete
		

	
	if (empleado != null || !empleado.toString().isEmpty()) {// diferente de null es have !=
	resp = "si existe el estado";
	
	System.out.println("Nombre"+empleado.getNombreCompleto()+
			"rfc"+empleado.getRfc()+
			"Edad"+empleado.getEdad()+
			"Sexo"+empleado.getSexo()+
			"Direccion"+empleado.getDireccion()+
			"Telefono"+empleado.getTelefono()+
			"Activo"+empleado.getActivo()
			);
	
	}
	else {
		resp = "no existe el registro";
		
	}
		return resp;
	}

	@Override
	public String insertEmpleado(EmpleadosDTO empleado) {
		EmpleadosEntities empleados = new EmpleadosEntities();
		empleados.setIdEmpleados(Long.valueOf(empleadosDAO.obtenerSecuenciaEmpleados()));
		//empleados.setIdEmpleados(empleado.getIdEmpleados());
		empleados.setNombreCompleto(empleado.getNombreCompleto());
		empleados.setRfc(empleado.getRfc());
		empleados.setEdad(empleado.getEdad());
		empleados.setSexo(empleado.getSexo());
		empleados.setDireccion(empleado.getDireccion());
		empleados.setTelefono(empleado.getTelefono());
		empleados.setActivo(empleado.getActivo());
		
		
		Long agregoReg = empleadosDAO.create(empleados);
		 if (agregoReg!=0) {
			 return "INSERTO DE FORMA CORRECTA";
		 }
		 else {
			 return "no se pudo insertar";
		 }
		 
		
	}

	@Override
	public String eliminarEmpleados(EmpleadosDTO id) {
		empleadosDAO.delete(id.getIdEmpleados());//espicificar el id 
		
		return "se elimino el registro";
	}
	
	
	

}
