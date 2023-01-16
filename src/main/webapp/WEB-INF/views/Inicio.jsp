<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema webs</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"
	type="text/css">

<script lenguaje="JavaScript" type="text/javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script>
	alert("Hola");

	$(document).ready(function() {
		
		llenartabla()
		
		
		
		$('#btnGuardar').on('click', function(){

			document.getElementById('modalAgregar').style.display='block'
			
			
		});
		
		$('#cerrarBtn').on('click', function(){

			document.getElementById('modalAgregar').style.display='none'
			
			
		});
		
		
		$('#cerrarBtnUpdate').on('click', function(){

			document.getElementById('modalActualizar').style.display='none'
			
			
		});
		
		$('#btnGuardarAspirante').on('click', function(){//inicio onclic

			
			debugger;
			
		/* 	var nombre=$('#inputNombre').val()
				var edad=$('#inputEdad').val()
				var fecha=$('#inputFecha').val()
				var curso=$('#inputCurso').val()
				var maestro=$('#inputMaestro').val()
			contro shift 7  */ 
			
			var aspirante = {
					nombreAlumno:$('#inputNombre').val(),
					edad:$('#inputEdad').val(),
					fechaInscripcion:$('#inputFecha').val(),
					curso:$('#inputCurso').val(),
					maestro:$('#inputMaestro').val()
		        }

			
			console.log(aspirante.nombre)
			console.log(aspirante.edad)
			console.log(aspirante.fecha)
			console.log(aspirante.curso)
			console.log(aspirante.maestro)
			
			$.ajax({ //AJAX SE ENCARGA DE HACER LA PETICI�N AL SERVICIO GETASPIRANTES Y DE CREAR LA DATA TABLE CON EL JSON DE LA RESPUESTA
			type : "post", //TIPO DE PETICI�N (DEBE DE COINCIDIR CON EL TIPO EN EL CONTROLADOR - GETASPIRANTES)
			url : '/Curso2/Aspirantes/insertAspirantes',
			
			/* data:{
			nombreAlumno:nombre,
			edad:edad,
			fechaInscripcion:fecha,
			curso:curso,
			maestro:maestro
			}, */
			
			 data:JSON.stringify(aspirante),
				 // URL COMPLETA DEL SERVICIO - ESTA SE ENCUENTRA EN SU NAVEGADOR
			dataType : "json", //EL FORMATO DE LA RESPUESTA - DEBE DE COINCIDIR CON EL FORMATO EN SU SERVICIO GET ASPIRANTES
			contentType: 'application/json',
			success : function(response) { // FUNCI�N DE EXITO CUANDO SE EJECUTA LA PETICI�N AL SERVICIO GET ASPIRANTES MEDIANTE AJAX
				alert(response.message);
				llenartabla()
				document.getElementById('modalAgregar').style.display='none'
					
			},
			
		});
		
	});
		$(document).on("click", "#deleteBtn", function(e){
		e.preventDefault();
		var edit_id= $(this).attr("value");
		alert(edit_id)
		
		var aspirante ={
			idAlumno:edit_id
			}
		
		$.ajax({ //AJAX SE ENCARGA DE HACER LA PETICI�N AL SERVICIO GETASPIRANTES Y DE CREAR LA DATA TABLE CON EL JSON DE LA RESPUESTA
			type : "post", //TIPO DE PETICI�N (DEBE DE COINCIDIR CON EL TIPO EN EL CONTROLADOR - GETASPIRANTES)
			url : '/Curso2/Aspirantes/deleteAspirantes',
			
			
			 data:JSON.stringify(aspirante),
				 // URL COMPLETA DEL SERVICIO - ESTA SE ENCUENTRA EN SU NAVEGADOR
			dataType : "json", //EL FORMATO DE LA RESPUESTA - DEBE DE COINCIDIR CON EL FORMATO EN SU SERVICIO GET ASPIRANTES
			contentType: 'application/json',
			success : function(response) { // FUNCI�N DE EXITO CUANDO SE EJECUTA LA PETICI�N AL SERVICIO GET ASPIRANTES MEDIANTE AJAX
				alert(response.message);
				llenartabla()
			},
			
		});
		
		});
		
		$(document).on("click", "#updateBtn", function(e){
			e.preventDefault();
			var edit_id= $(this).attr("value");
			alert(edit_id)
			
			var aspirante ={
				idAlumno:edit_id
				}
			
			$.ajax({ //AJAX SE ENCARGA DE HACER LA PETICI�N AL SERVICIO GETASPIRANTES Y DE CREAR LA DATA TABLE CON EL JSON DE LA RESPUESTA
				type : "post", //TIPO DE PETICI�N (DEBE DE COINCIDIR CON EL TIPO EN EL CONTROLADOR - GETASPIRANTES)
				url : '/Curso2/Aspirantes/getAspiranteById',
				 data:JSON.stringify(aspirante),//seconvi3erte en json para qu lo pueda recivir el controlador
				dataType : "json", //EL FORMATO DE LA RESPUESTA - DEBE DE COINCIDIR CON EL FORMATO EN SU SERVICIO GET ASPIRANTES
				contentType: 'application/json',
				success : function(response) { // FUNCI�N DE EXITO CUANDO SE EJECUTA LA PETICI�N AL SERVICIO GET ASPIRANTES MEDIANTE AJAX
					document.getElementById('modalActualizar').style.display='block'
				$('#inputIdUpdate').val(response.idAlumno)
				$('#inputNombreUpdate').val(response.nombreAlumno)
				$('#inputEdadUpdate').val(response.edad)
				$('#inputFechaUpdate').val(response.fechaInscripcion)
				$('#inputCursoUpdate').val(response.cursoId)
				$('#inputMaestroUpdate').val(response.maestroId)
				
				},
				
			});
			
			});
		
$('#btnUpdateAspirante').on('click', function(){//inicio onclic

			
			debugger;
			
		/* 	var nombre=$('#inputNombre').val()
				var edad=$('#inputEdad').val()
				var fecha=$('#inputFecha').val()
				var curso=$('#inputCurso').val()
				var maestro=$('#inputMaestro').val()
			contro shift 7  */ 
			
			var aspirante = {
					
					idAlumno:$('#inputIdUpdate').val(),
					nombreAlumno:$('#inputNombreUpdate').val(),
					edad:$('#inputEdadUpdate').val(),
					fechaInscripcion:$('#inputFechaUpdate').val(),
					cursoId:$('#inputCursoUpdate').val(),
					maestroId:$('#inputMaestroUpdate').val()
		        }

			
			console.log(aspirante.IdAlumno)
			console.log(aspirante.nombreAlumno)
			console.log(aspirante.edad)
			console.log(aspirante.fechaInscripcion)
			console.log(aspirante.cursoId)
			console.log(aspirante.maestroId)
			
			$.ajax({ //AJAX SE ENCARGA DE HACER LA PETICI�N AL SERVICIO GETASPIRANTES Y DE CREAR LA DATA TABLE CON EL JSON DE LA RESPUESTA
			type : "post", //TIPO DE PETICI�N (DEBE DE COINCIDIR CON EL TIPO EN EL CONTROLADOR - GETASPIRANTES)
			url : '/Curso2/Aspirantes/updateAspirantes',
			
			/* data:{
			nombreAlumno:nombre,
			edad:edad,
			fechaInscripcion:fecha,
			curso:curso,
			maestro:maestro
			}, */
			
			 data:JSON.stringify(aspirante),
				 // URL COMPLETA DEL SERVICIO - ESTA SE ENCUENTRA EN SU NAVEGADOR
			dataType : "json", //EL FORMATO DE LA RESPUESTA - DEBE DE COINCIDIR CON EL FORMATO EN SU SERVICIO GET ASPIRANTES
			contentType: 'application/json',
			success : function(response) { // FUNCI�N DE EXITO CUANDO SE EJECUTA LA PETICI�N AL SERVICIO GET ASPIRANTES MEDIANTE AJAX
				alert(response.message);
				llenartabla()
				document.getElementById('modalActualizar').style.display='none'
					
			},
			
		});
		
	});
		
	});
		
	
	
	//get
	function llenartabla(){
		$.ajax({ //AJAX SE ENCARGA DE HACER LA PETICI�N AL SERVICIO GETASPIRANTES Y DE CREAR LA DATA TABLE CON EL JSON DE LA RESPUESTA
			type : "get", //TIPO DE PETICI�N (DEBE DE COINCIDIR CON EL TIPO EN EL CONTROLADOR - GETASPIRANTES)
			url : '/Curso2/Aspirantes/getAspirantes', // URL COMPLETA DEL SERVICIO - ESTA SE ENCUENTRA EN SU NAVEGADOR
			dataType : "json", //EL FORMATO DE LA RESPUESTA - DEBE DE COINCIDIR CON EL FORMATO EN SU SERVICIO GET ASPIRANTES
			success : function(response) { // FUNCI�N DE EXITO CUANDO SE EJECUTA LA PETICI�N AL SERVICIO GET ASPIRANTES MEDIANTE AJAX
				
				var table = $('#tablaSimple').DataTable();//se crea una variable, se le asigna la datetable
				table.destroy();//se destruye la tabla 
				
				$('#tablaSimple').DataTable({
					data : response,
					responsive : true,
					columns : [ // CADA NOMBRE DE CADA COLUMNA SON DE ACUERDO A SU RESPUESTA EN EL JSON DEL SERVICIO Y ESTOS DEBEN DE COINCIDIR CON SUS VARIABLES DE SU DTO
					{
						data : "idAlumno",
						"visible" : false,
						"searchable" : false
					}, {
						data : "nombreAlumno",
					}, {
						data : "edad",
					}, {
						data : "fechaInscripcion",
					}, {
						data : "curso",
					}, {
						data : "maestro",
					},
					
					{
						orderable: false,
						searchable: false,
						className: "text-center",
						data: function (row, type, set){
							return '<a href="" id="deleteBtn" class="btn btn-outline-danger" value="' + row.idAlumno + '" ><i class="fas fa-trash-edit"> </a>';
                                       
							
						}
						
					},
					
					
					{
						orderable: false,
						searchable: false,
						className: "text-center",
						data: function (row, type, set){
							return '<a href="" id="updateBtn" class="btn btn-outline-success" value="' + row.idAlumno + '" ><i class="fas fa-trash-edit"> </a>';
                                       
							
						}
						
					},
					
					
					],
				});
			},
		});
		
		
	}
	
	
</script>

</head>

<body>
	<h1>Bienvenido</h1>


	<div class="container">

		<div class="row">

			<div class="col">
				<button id="btnGuardar" type="button" class="btn btn-success">Guardar</button>
			<button type="button" class="btn btn-success">HOLA</button>
			</div>

		</div>

		<div class="row">

			<div class="col">

				<table id="tablaSimple"
					class="table table-striped table-hover dt-responsive display nowrap"
					cellspacing="0">

					<thead>
						<tr>
							<th>id</th>
							<th>Nombre</th>
							<th>Edad</th>
							<th>Fecha de Inscripcion 3</th>
							<th>Curso</th>
							<th>Maestro</th>
							<th>Eliminar</th>
							<th>Actualizar</th>
						</tr>
					</thead>
				</table>

			</div>

		</div>



	</div>

<div class="modal" tabindex="-1" id="modalAgregar">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Agregar Aspirante</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">
       <div class="input-group mb-3">
  <span class="input-group-text">Nombre</span>
  <input id="inputNombre" type="text" class="form-control" placeholder="Nombre Completo" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" >Edad</span>
  <input id="inputEdad" type="text" class="form-control" placeholder="Edad" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text">Fecha de Inscripcion</span>
  <input  id="inputFecha" type="text" class="form-control" placeholder="Fecha" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text">Curso</span>
  <input  id="inputCurso" type="text" class="form-control" placeholder="Curso" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" >Maestro</span>
  <input  id="inputMaestro" type="text" class="form-control" placeholder="Mestro" aria-label="Username" aria-describedby="basic-addon1">
</div>

</div>
      <div class="modal-footer">
        <button id="cerrarBtn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button id="btnGuardarAspirante"  type="button" class="btn btn-primary">Guardar</button>
      </div>
    </div>
  </div>
</div>



<!-- modal para btnupdate -->
<div class="modal" tabindex="-1" id="modalActualizar">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Actualizar Aspirante</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      
      <div class="modal-body">
      
       <input id="inputIdUpdate" type="hidden" >
      
       <div class="input-group mb-3">
  
  <span class="input-group-text">Nombre</span>
  <input id="inputNombreUpdate" type="text" class="form-control" placeholder="Nombre Completo" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" >Edad</span>
  <input id="inputEdadUpdate" type="text" class="form-control" placeholder="Edad" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text">Fecha de Inscripcion</span>
  <input  id="inputFechaUpdate" type="text" class="form-control" placeholder="Fecha" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text">Curso</span>
  <input  id="inputCursoUpdate" type="text" class="form-control" placeholder="Curso" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <span class="input-group-text" >Maestro</span>
  <input  id="inputMaestroUpdate" type="text" class="form-control" placeholder="Mestro" aria-label="Username" aria-describedby="basic-addon1">
</div>

</div>
      <div class="modal-footer">
        <button id="cerrarBtnUpdate" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
        <button id="btnUpdateAspirante"  type="button" class="btn btn-primary">Actualizar</button>
      </div>
    </div>
  </div>
</div>

</body>



</html>