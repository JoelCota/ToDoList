/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Notificacion;
import Dominio.Tarea;
import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public interface IFachadaPersistencia {

    public Usuario registrarUsuario(Usuario usuario);

    public Usuario consultarUsuarioPorId(int id);

    public Usuario consultarCrendenciales(String correo, String password);

    public Tarea registrarTarea(Tarea tarea);

    public Tarea editarTarea(Tarea tarea);

    public boolean eliminarTarea(Tarea tarea);

    public Tarea actualizarEstadoTarea(Tarea tarea, Estado estado);

    public List<Tarea> obtenerTodasLasTareas();

    public List<Tarea> obtenerTareasPorLista(Lista lista);

    public Lista crearLista(Lista lista);

    public boolean eliminarLista(Lista lista);

    public Lista editarNombreLista(Lista lista);

    public Lista editarDescripcionLista(Lista lista);

    public Lista agregarTarea(Lista lista, Tarea tarea);

    public Lista eliminarTarea(Lista lista, Tarea tarea);

    public List<Lista> obtenerTodasLasListas();
    
    public Notificacion crearNotificacion(Notificacion notificacion);
}
