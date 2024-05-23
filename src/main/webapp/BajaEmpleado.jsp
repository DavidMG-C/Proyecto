<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/PlantillaNE.css">

    <script type="text/javascript">
    
    	function validadFormulario(){
            let id_empleadobaja=document.getElementById('id_empleadobaja').value.trim();
                        
            let ok=true;
            
            // Si la caja de texto del dni esta vacia o el valor introducido es distinto del patron 
            //de dni (8 digitos seguido de una letra)
            if(id_empleadobaja ===""){
                ok = false;
                document.getElementById('id_empleadobaja').style.background = "red";
            } else {
                document.getElementById('id_empleadobaja').style.background = ""; // Restablecer el color de fondo si el dni es válido
            }
                        
            if (ok == true){
                document.getElementById("BajaEmpleado").submit();
            }
        }
    </script>
</head>
<body>
    <div class="ruta">
    <% 
    String idCargo = request.getParameter("id_cargo");
    if (idCargo != null && idCargo.equals("00001")) {
    %>
        <a href="PrincipalResponsable.jsp?email=<%= request.getParameter("mail") %>">Inicio >></a>
    <% } else { %>
        <a href="Principal.jsp?email=<%= request.getParameter("mail") %>">Inicio >></a>
    <% } %>
    <span>Baja Empleado</span>
    </div>

    <div class="container">

        <h1>Baja Empleado</h1>
        <form name="BajaEmpleado" action="GestionEmpleadoBaja" method="post" id="BajaEmpleado">

            <ul>
                <li><label>Id del empleado a dar de baja</label><input id="id_empleadobaja" type="text" name="id_empleadobaja"></li>
                <li><input type="hidden" id="id_empleado" name="id_empleado"></li>
                <li><input type="hidden" id="id_cargo" name="id_cargo"></li>
            	<li><input type="hidden" id="mail" name="mail"></li>
                <li><input type="button" onclick="validadFormulario()" value="Dar de baja"></li>
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