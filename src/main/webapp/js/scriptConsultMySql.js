document.addEventListener("DOMContentLoaded", function() {
    // Realizar la solicitud AJAX
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "../php/consultaMySql.php", true);
    xhr.onload = function() {
        if (xhr.status == 200) {
            // Parsear la respuesta JSON
            var data = JSON.parse(xhr.responseText);

            // Mostrar los resultados en la página
            var resultsList = document.getElementById("results");
            data.forEach(function(item) {
                var listItem = document.createElement("li");
                listItem.textContent = item.nombre + " - " + item.edad + " años";
                resultsList.appendChild(listItem);
            });
        }
    };
    xhr.send();
});