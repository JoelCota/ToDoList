document.getElementById('new-task-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const taskInput = document.getElementById('new-task');
    const taskText = taskInput.value.trim();
    if (taskText === "") {
        alert("Por favor, ingrese una tarea.");
        return;
    }
    addTask(taskText);
    taskInput.value = ""; // Limpiar el input después de añadir
});

function addTask(taskText) {
    const li = document.createElement('li');
    li.textContent = taskText;
    document.getElementById('tasks-list').appendChild(li);
}
