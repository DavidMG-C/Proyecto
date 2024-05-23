<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GRUPO MORENO</title>
    <link rel="stylesheet" href="./css/PlantillaNE.css">

    <script type="text/javascript">
    
    	function validadFormulario(){
            let dni=document.getElementById('dni').value.trim();
            let dniPatron = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$/;
            let nombre=document.getElementById('nombre').value;
            let apellido1=document.getElementById('apellido1').value;
            let apellido2=document.getElementById('apellido2').value;
            let f_nacimiento=document.getElementById('f_nacimiento').value;
            let fechaPatron = /^(\d{2})\/(\d{2})\/(\d{4})$/;
            let direccion=document.getElementById('direccion').value;
            let n_cuenta=document.getElementById('n_cuenta').value;
            let departamento=document.getElementById('departamento').value;
            let contrato=document.getElementById('contrato').value;
            let salario=document.getElementById('salario').value;
            let f_incorporacion=document.getElementById('f_incorporacion').value;
            let email=document.getElementById('email').value;
            let emailPatron=/^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            
            

            let ok=true;
            
            // Si la caja de texto del dni esta vacia o el valor introducido es distinto del patron 
            //de dni (8 digitos seguido de una letra)
            if(dni ==="" || !dniPatron.test(dni)){
                ok = false;
                document.getElementById('dni').style.background = "red";
            } else {
                document.getElementById('dni').style.background = ""; // Restablecer el color de fondo si el dni es válido
            }
            
             if(nombre ==""){
                ok = false;
                document.getElementById('nombre').style.background = "red";
            }
            if(apellido1 ==""){
                ok = false;
                document.getElementById('apellido1').style.background = "red";
            }
            if(apellido2 ==""){
                ok = false;
                document.getElementById('apellido2').style.background = "red";
            }
            
            if(f_nacimiento ==="" || !fechaPatron.test(f_nacimiento)){
                ok = false;
                document.getElementById('f_nacimiento').style.background = "red";
            } else {
                document.getElementById('f_nacimiento').style.background = ""; // Restablecer el color de fondo si el dni es válido
            }
            
            if(direccion ==""){
                ok = false;
                document.getElementById('direccion').style.background = "red";
            }
            
            if(n_cuenta ==""){
                ok = false;
                document.getElementById('n_cuenta').style.background = "red";
            }
            
            if(departamento ==""){
                ok = false;
                document.getElementById('departamento').style.background = "red";
            }
            
            if(contrato ==""){
                ok = false;
                document.getElementById('contrato').style.background = "red";
            }
            
            if(salario ==""){
                ok = false;
                document.getElementById('salario').style.background = "red";
            }
            
            if(f_incorporacion ==="" || !fechaPatron.test(f_incorporacion)){
                ok = false;
                document.getElementById('f_incorporacion').style.background = "red";
            } else {
                document.getElementById('f_incorporacion').style.background = ""; // Restablecer el color de fondo si el dni es válido
            }
            
            if(email ==="" || !emailPatron.test(email)){
                ok = false;
                document.getElementById('email').style.background = "red";
            } else {
                document.getElementById('email').style.background = ""; // Restablecer el color de fondo si el dni es válido
            }
            
            if (ok == true){
                document.getElementById("AltaEmpleado").submit();
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
    <span>Alta Empleado</span>
    </div>

    <div class="container">

        <h1>Nuevo Empleado</h1>
        <form name="AltaEmpleado" action="GestionEmpleado" method="post" id="AltaEmpleado">

            <ul>
                <li><label>id_cargo</label><input id="cargo" type="text" name="cargo"></li>
                <li><label>DNI</label><input id="dni" type="text" name="dni"></li>
                <li><label>Nombre</label><input id="nombre" type="text" name="nombre"></li>
                <li><label>Apellido1</label><input id="apellido1" type="text" name="apellido1"></li>
                <li><label>Apellido2</label><input id="apellido2" type="text" name="apellido2"></li>
                <li><label>F_nacimiento (DD/MM/YYYY)</label><input id="f_nacimiento" type="text" name="f_nacimiento"></li>
                <li><label>Direccion</label><input id="direccion" type="text" name="dirección"></li>
                <li><label>Numero de cuenta</label><input id="n_cuenta" type="text" name="n_cuenta"></li>
                <li><label>Departamento</label><select id="departamento" name="departamento"><option value="Informatica">Informatica</option><option value="Contabilidad">Contabilidad</option><option value="Recursos Humanos">Recursos Humanos</option><option value="Laboral">Laboral</option></select></li>
                <li><label>Contrato</label><select id="contrato" name="contrato"><option value="Indefinido">Indefinido</option><option value="Temporal">Temporal</option><option value="Practicas">Practicas</option><option value="Formacion">Formacion</option></select></li>
                <li><label>Salario</label><input id="salario" type="text" name="salario"></li>
                <li><label>Fecha de incorporacion (DD/MM/YYYY)</label><input id="f_incorporacion" type="text" name="f_incorporacion"></li>
                <li><label>Email</label><input id="email" type="text" name="email"></li>        
                <li><input type="hidden" id="id_empleado" name="id_empleado"></li>
                <li><input type="hidden" id="id_cargo" name="id_cargo"></li>
            	<li><input type="hidden" id="mail" name="mail"></li>
                <li><input type="button" onclick="validadFormulario()" value="Generar nuevo empleado"></li>
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