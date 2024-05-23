/*
 Script: calendario.js
 Lenguaje: JavaScript
 Autor: David Moreno Garcia-Caro
 Version: 1.0
*/

// Declaramos una variable con los nombres de los meses del año
let NombreMes = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];

// Declaramos una variable con la fecha actual
let currentDate = new Date();

// A partir d ela fecha actual recogemos en variables los valores del dia actual, mes actual y año actual
let currentDay = currentDate.getDay();
let monthNumber = currentDate.getMonth(); // Los meses van de 0 a 11, siendo 0 enero y 11 diciembre
let currentYear = currentDate.getFullYear();

// Declaramos las variables de html para la seccion de fechas mes y año
let dates = document.getElementById('dates');
let month = document.getElementById('month');
let year = document.getElementById('year');

// Declaramos las variables de las flechitas para pasar a meses anterior y siguiente
let prevMonthDOM = document.getElementById('prev-month');
let nextMonthDOM = document.getElementById('next-month');

// Mostramos el mes y año actual
month.textContent = NombreMes[monthNumber];
year.textContent = currentYear.toString();

// Le añadimos funcionalidad al hacer click en las flechitas de previo mes y siguiente mes
prevMonthDOM.addEventListener('click', ()=>previoMes());
nextMonthDOM.addEventListener('click', ()=>siguienteMes());

escribeMes(monthNumber);



// FUNCIONES
//-----------

// Vamos a necesitar las siguientes funciones para el manejo del calendario:
// - esBisiesto: Función que nos dice si el año es bisiesto o no
// - comienzoSemana: Función que indica en qué día de la semana cae el dia 1 del mes
// - obtenerTotalDiasMes: Función que dado un mes calcula el número de días que tiene ese mes
// - escribeMes: Funcion para mostrar los días del mes en el calendario
// - previoMes: Función encargada de dibujar el mes anterior
// - siguienteMes: Función encargada de dibujar el mes siguiente
// - estableceNuevaFecha: Función que va a fijar la nueva fecha cuando se mueva el calendario


function esBisiesto() {
	return ((currentYear % 100 !== 0) && (currentYear % 4 ===0) || (currentYear % 400 === 0));
}


function comienzoSemana () {
	let comienzo = new Date(currentYear,monthNumber,1); // Crea una nueva fecha en la que vendrá en que sía cae el dia 61 del mes
	
	// Como las fechas están basadas en el calendario anglosajón (de domingo a sábado), le voy a hacer una pequeña modificación
	// para que me devuelva un valor anterior (de lunes a domingo) y en en caso de que sea domingo éste tendrá la ultima 
	// posicion del array. Para ello usaré un operador ternario
	
	return((comienzo.getDay()-1)===-1) ? 6 : comienzo.getDay()-1; // Devuelve 6 si el dia es domingo y el valor anterior en otro caso
}


function obtenerTotalDiasMes (mes) {
	if (mes===-1) monthNumber=11;
	
	let dias=0;
	
	switch (mes) {
		case 0:
		case 2:
		case 4:
		case 6:
		case 7:
		case 9:
		case 11:  	// Si es enero, marzo, mayo, julio, agosto, octubre o diciembre los dias son 31
			dias=31;
			break;
		case 3:
		case 5:
		case 8:
		case 10:			// Si es abril, junio, septiembre o noviembre los dias son 30
			dias=30;
			break;
		default:
			dias=esBisiesto() ? 29:28;  // Si no se dieron los casos anteriores es que estamos en febrero, por lo que devolvemos 29 si el año es bisiesto y 28 si el año no es bisiesto.
			break;
	}
	return dias;
}

function startDay () {

	let start = new Date (currentYear, monthNumber, 1);
	return ((start.getDay()-1) === -1) ? 6 : start.getDay()-1;
	
}


function escribeMes(mes) {
	
	for (let i=startDay(); i>0;i--) {  // Con esto conseguimos que los días del mes anterior se marquen en el comienzo del mes que se muestra
		dates.innerHTML += `<div class="calendar__date calendar__item">	${obtenerTotalDiasMes(monthNumber-1)-(i-1)} </div>`;
	}
	
	
	for (let i=1; i<=obtenerTotalDiasMes(mes); i++) {
		
		if(i===currentDay) {
			dates.innerHTML += `<div class="calendar__date calendar__item calendar__today">${i}</div>`;
		}
		else {
			dates.innerHTML += `<div class="calendar__date calendar__item">${i}</div>`;
		}
	}
	
}



function estableceNuevaFecha () {

	currentDate.setFullYear(currentYear,monthNumber,currentDay);
	month.textContent = NombreMes[monthNumber];
	year.textContent = currentYear.toString(); 
	dates.textContent='';
	escribeMes(monthNumber);

}


function previoMes () {

	// Comprobamos que no estamos en enero
	if (monthNumber!==0) {
		monthNumber--;
	}
	else {
		monthNumber=11; // Si estamos en enero asignamos el valor del ultimo mes que sería diciembre (mes 11 si empezamos desde 0)
		currentYear--; // Como estamos en enero, el mes previo corresponde al año anterior, por eso debe restarse el valor del año actual
	}
	
	estableceNuevaFecha(); // Funcion encargada de establecer la nueva fecha
}


function siguienteMes () {
	
	// Comprobamos que no estamos en diciembre
	if (monthNumber!==11) {
		monthNumber++;
	}
	else {
		monthNumber=0; // Si estamos en diciembre asignamos el valor del primer mes que sería enero (mes 0 si empezamos desde 0)
		currentYear++; // Como estamos en diciembre, el mes siguiente corresponde al año siguiente, por eso debe sumarse el valor del año actual
	}
	
	estableceNuevaFecha(); // Funcion encargada de establecer la nueva fecha
	
}

