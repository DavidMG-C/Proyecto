<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/PlantillaNE.css">

    <script type="text/javascript">
    
    	function validarFormulario(){
            let pwdactual=document.getElementById('pwdactual').value;
            let pwdnueva = document.getElementById('pwdnueva').value;

            let ok=true;
            
            if(pwdactual ==="" ){
                ok = false;
                document.getElementById('pwdactual').style.background = "red";
            } else {
                document.getElementById('pwdactual').style.background = ""; // Restablecer el color de fondo 
            }
            
             if(pwdnueva ===""){
                ok = false;
                document.getElementById('pwdnueva').style.background = "red";
             } else {
                document.getElementById('pwdnueva').style.background = ""; // Restablecer el color de fondo 
            }
                        
            if (ok == true){
                document.getElementById("ModificarContrasegna").submit();
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
    <span>Modificar Contraseña</span>
    </div>

    <div class="container">

        <h1>Modificar Contraseña</h1>
        <form name="ModificarContrasegna" action="GestionModificarContrasegna" method="post" id="ModificarContrasegna">

            <ul>
                <li><label>Contraseña actual</label><input id="pwdactual" type="password" name="pwdactual"></li>
                <li><label>Nueva contraseña</label><input id="pwdnueva" type="password" name="pwdnueva"></li>
                <li><input type="hidden" id="id_empleado" name="id_empleado"></li>
                <li><input type="hidden" id="id_cargo" name="id_cargo"></li>
            	<li><input type="hidden" id="mail" name="mail"></li>
                <li><input type="button" onclick="validarFormulario()" value="Actualizar contraseña"></li>
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