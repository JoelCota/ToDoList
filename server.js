const express = require('express');
const app = express();
const PORT = 3000;
const bodyParser = require('body-parser');

app.use(express.static('public')); // Suponiendo que tus archivos HTML y CSS están en una carpeta llamada 'public'
app.use(express.urlencoded({ extended: true })); // Para procesar datos del formulario

app.post('/login', (req, res) => {
    const { username, password } = req.body;
    console.log(`Username: ${username}, Password: ${password}`);
    // Aquí añadirías la lógica para verificar las credenciales
    res.redirect('/'); // Redirigir al usuario después del login
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});

app.use(express.static('public')); // Servir archivos estáticos
app.use(bodyParser.json()); // Middleware para parsear JSON

let tasks = []; // Almacenar tareas en memoria (simplificado)

app.get('/tasks', (req, res) => {
    res.json(tasks);
});

app.post('/tasks', (req, res) => {
    const task = req.body;
    tasks.push(task); // Añadir la tarea a la lista
    res.status(201).send(task);
});

app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
