<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/PlantillaNE.css">
</head>
<body>

    <header>
        <h1>Portal del Empleado</h1>
    </header>

   
        <div class="ruta">
    <% 
    String idCargo = request.getParameter("id_cargo");
    if (idCargo != null && idCargo.equals("00001")) {
    %>
        <a href="PrincipalResponsable.jsp?email=<%= request.getParameter("mail") %>">Inicio >></a>
    <% } else { %>
        <a href="Principal.jsp?email=<%= request.getParameter("mail") %>">Inicio >></a>
    <% } %>
    <span>Gestion de Ausencias</span>
    </div>
	
    

    
    <div class="container">
    	<!-- Aqui habría que meter la funcionalidad de la gestion de ausencias  --> 
    	
    	        <h2>Gestion de Ausencias</h2>
        <nav>
        	<ul> 
        		<li><a onclick="irASolicitarAusencias()">Solicitar Ausencias</a></li>
        		<li><a onclick="irAConsultarAusencias()">Consultar Ausencias</a></li>	
        	</ul>
        </nav>
        
    </div>
    
            <script>
        	// Funcion para obtener parametros de la URL
				function getParameterByName(name, url) {
    				if (!url) url = window.location.href;
    				name = name.replace(/[\[\]]/g, "\\$&");
    				var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        			results = regex.exec(url);
    				if (!results) return null;
    				if (!results[2]) return '';
    				return decodeURIComponent(results[2].replace(/\+/g, " "));
				}

			// Asignamos el valor de los parametros de la URL
				var id_empleado = getParameterByName("id_empleado");
				var id_cargo = getParameterByName("id_cargo");
				var mail = getParameterByName("mail");
				document.getElementById("id_empleado").value = id_empleado;
				document.getElementById("id_cargo").value = id_cargo;
				document.getElementById("mail").value = mail;
		
					function irASolicitarAusencias() {
				 		window.location.href = "SolicitarAusencias.jsp?id_empleado="+idEmpleado+"&mail="+email+"&id_cargo="+cargo;
				        }	
					
					function irAConsultarAusencias() {
				 		window.location.href = "ConsultarAusencias.jsp?id_empleado="+idEmpleado+"&mail="+email+"&id_cargo="+cargo;
				        }
				
		</script>
		
</body>
</html>