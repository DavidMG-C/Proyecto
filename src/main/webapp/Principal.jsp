<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/Plantilla.css">
</head>
<body>
    <header>
        <h1>Portal del Empleado</h1>
    </header>

    <nav>
        <ul>
            <li><a onclick="irAFichaje()">Fichaje</a></li>
            <li><a onclick="irAModificarContrasegna()">Modificar Contraseña</a></li>
            <li><a onclick="irAAusencias()">Ausencias (No disponible)</a></li>
            <li><a href="logueo.html">Cerrar Sesión</a></li>
        </ul>
    </nav>

	<div class="container">
	
		<div class="employee-info">
          <input type="hidden" id="email" name="email" value="${param.email}">
          		        <!-- AquÃ­ se cargarÃ¡ el contenido de la pÃ¡gina -->
        		 <h2 id="bienvenida">Bienvenido al Portal ${param.email}</h2>
					
					<div class="contenedor-perfil">
						<h3>MI PERFIL DE EMPLEADO</h3>
						
						<div class="imagen-y-tabla">
							<img src="./imagenes/usuario.png" alt="usuario">
							
							<div id="tabla-container"></div>
  				       <script>
  				            var idEmpleado;// Variable global para almacenar el id_empleado
  				            var cargo;
  				            var email;
  				        	var xmlhttp = new XMLHttpRequest();
  				        	xmlhttp.onreadystatechange = function() {
  				              if (this.readyState == 4 && this.status == 200) {
  				                  var empleado = JSON.parse(this.responseText);
  				                  mostrarEmpleado(empleado);
  				              }
  				             };
       						 xmlhttp.open("GET", "GestionFichaEmpleado?email=${param.email}", true);
      						 xmlhttp.send();
 					        
      						 
      						function mostrarEmpleado(empleado) {
      						// Asignamos el id_empleado a la variable global dentro del contexto de mostrarEmpleado
      						    idEmpleado = empleado.id_empleado; 
      							cargo = empleado.id_cargo;
      							email = empleado.mail;
      						// Mostramos la información del empleado en la página
      					        var tablaHTML = "<table class='info-empleado' >" +
                    "<tr>" +
                        "<th>Nombre</th>" +
                        "<td>" + empleado.nombre + "</td>" +
                        "<th>Departamento</th>" +
                        "<td>" + empleado.departamento + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td></td>" +
                        "<td></td>" +
                        "<td></td>" +
                        "<td></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<th>Primer Apellido</th>" +
                        "<td>" + empleado.apellido1 + "</td>" +
                        "<th>ID Empleado</th>" +
                        "<td>" + empleado.id_empleado + "</td>" +
                    "</tr>" +
                    "<tr>" +
                        "<td></td>" +
                        "<td></td>" +
                        "<td></td>" +
                        "<td></td>" +
                    "</tr>" +
                    "<tr>" +
                        "<th>Segundo Apellido</th>" +
                        "<td>" + empleado.apellido2 + "</td>" +
                        "<th></th>" +
                        "<td></td>" +
                    "</tr>" +
                "</table>";
                var tablaContainer = document.getElementById("tabla-container");
                tablaContainer.innerHTML = tablaHTML;
    					   
      		}
      						function irAAusencias() {
	        				 		window.location.href = "Ausencias.jsp?id_empleado="+idEmpleado+"&mail="+email+"&id_cargo="+cargo;
	        				        }
      						
        				 	function irAFichaje() {
        				 		window.location.href = "Fichaje.jsp?id_empleado="+idEmpleado+"&mail="+email+"&id_cargo="+cargo;
        				        }
        				 	
        				 	function irAModificarContrasegna() {
        				 		window.location.href = "ModificarContrasegna.jsp?id_empleado="+idEmpleado+"&mail="+email+"&id_cargo="+cargo;
        				        }
        				 	
        				 	
    				 	</script>
					       </div>
 			            </div>
                    </div>
       </div>

</body>
</html>