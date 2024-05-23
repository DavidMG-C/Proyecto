document.addEventListener('DOMContentLoaded', function() {
    const solicitudBody = document.getElementById('solicitud-body');

    // Datos de ejemplo de las solicitudes de ausencia
    const solicitudes = [
        { estado: 'Pendiente', usuario: 'Usuario1', fechaSolicitud: '2024-03-18', tipo: 'Vacaciones', fechaInicio: '2024-04-01', diasAusencia: 5, responsable: 'Responsable1' },
        { estado: 'Aprobada', usuario: 'Usuario2', fechaSolicitud: '2024-03-20', tipo: 'Enfermedad', fechaInicio: '2024-03-25', diasAusencia: 3, responsable: 'Responsable2' },
        { estado: 'Rechazada', usuario: 'Usuario3', fechaSolicitud: '2024-03-22', tipo: 'Asuntos personales', fechaInicio: '2024-03-27', diasAusencia: 2, responsable: 'Responsable3' }
    ];

    // Generar filas de la tabla con los datos de las solicitudes
    solicitudes.forEach(solicitud => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${solicitud.estado}</td>
            <td>${solicitud.usuario}</td>
            <td>${solicitud.fechaSolicitud}</td>
            <td>${solicitud.tipo}</td>
            <td>${solicitud.fechaInicio}</td>
            <td>${solicitud.diasAusencia}</td>
            <td>${solicitud.responsable}</td>
        `;
        solicitudBody.appendChild(row);
    });
});