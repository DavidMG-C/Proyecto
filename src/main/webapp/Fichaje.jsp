<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/fichaje.css">
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
    <span>Fichaje</span>
    </div>
	
	
    <div class="container">
        <h1>Fichaje de Empleados</h1>
        	<form name="Fichaje" action="GestionFichaje" method="post" id="Fichaje">
                
       			 <ul>
            		<li><label>Tipo de Fichaje</label>
             		   <select id="descripcionFichaje" name="descripcionFichaje">
                		    <option value="Inicio Jornada Laboral">Inicio Jornada Laboral</option>
                 		    <option value="Salida Comida">Salida Comida</option>
                		    <option value="Entrada Comida">Entrada Comida</option>
                		    <option value="Fin Jornada laboral">Fin Jornada laboral</option>
              		   </select>
            		</li>
            		<li><input type="hidden" id="id_empleado" name="id_empleado"></li>
            		<li><input type="hidden" id="id_cargo" name="id_cargo"></li>
            		<li><input type="hidden" id="mail" name="mail"></li>
            		<li><button id="BotonFichaje">FICHAR</button></li>
        		</ul> 
       		 </form>      
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
		</script>	
    
</body>
</html>