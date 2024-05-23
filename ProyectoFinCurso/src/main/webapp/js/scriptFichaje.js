document.addEventListener('DOMContentLoaded', function() {
    const clockButtonEntradaJornada = document.getElementById('clockButton1');
	const clockButtonSalidaJornada = document.getElementById('clockButton2');
	const clockButtonEntradaComida = document.getElementById('clockButton3');
	const clockButtonSalidaComida = document.getElementById('clockButton4');
    const clockTime = document.getElementById('clockTime');

    Button1.addEventListener('click', function() {
        const now = new Date();
        const formattedTime = formatTime(now);
        clockTime.textContent = `Registrado fichaje de entrada de jornada laboral: ${formattedTime}`;
    });
	
	Button2.addEventListener('click', function() {
        const now = new Date();
        const formattedTime = formatTime(now);
        clockTime.textContent = `Registrado fichaje de salida de jornada laboral: ${formattedTime}`;
    });
	
	Button3.addEventListener('click', function() {
        const now = new Date();
        const formattedTime = formatTime(now);
        clockTime.textContent = `Registrado fichaje de entrada de comida: ${formattedTime}`;
    });
	
	Button4.addEventListener('click', function() {
        const now = new Date();
        const formattedTime = formatTime(now);
        clockTime.textContent = `Registrado fichaje de salida de comida: ${formattedTime}`;
    });

    function formatTime(date) {
        const dia = date.getDay().toString().padStart(2, '0');
		const mes = date.getMonth().toString().padStart(2, '0');
		const hours = date.getHours().toString().padStart(2, '0');
        const minutes = date.getMinutes().toString().padStart(2, '0');
        const seconds = date.getSeconds().toString().padStart(2, '0');
        return `${dia} de ${mes} a las ${hours}:${minutes}:${seconds}`;
    }
});