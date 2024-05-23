document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // Aquí deberías enviar los datos del formulario a tu servidor para verificar las credenciales.
    // En este ejemplo, solo mostramos las credenciales en la consola.
    console.log('Nombre de usuario:', username);
    console.log('Contraseña:', password);
});