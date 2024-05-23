document.addEventListener('DOMContentLoaded', function() {
    const fileListDiv = document.getElementById('listaficheros');

    // Ruta de la carpeta
    const rutacarpeta = 'C:/xampp/htdocs'; 
    
    fetch(`/list-files?path=${encodeURIComponent(rutacarpeta)}`)
        .then(response => response.json())
        .then(files => {
            const fileList = document.createElement('ul');
            files.forEach(file => {
                const listItem = document.createElement('li');
                const link = document.createElement('a');
                link.textContent = file;
                link.href = `${rutacarpeta}/${encodeURIComponent(file)}`;
                link.classList.add('file-link');
                listItem.appendChild(link);
                fileList.appendChild(listItem);
            });
            fileListDiv.appendChild(fileList);
        })
        .catch(error => console.error('Error al obtener la lista de archivos:', error));
});