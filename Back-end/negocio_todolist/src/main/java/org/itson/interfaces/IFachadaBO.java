/**
 * IFachadaBO.java
 * Jun 24, 2023 10:40:47 AM
 */
package org.itson.interfaces;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Notificacion;
import Dominio.Tarea;
import Dominio.Usuario;
import java.util.List;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IFachadaBO {

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
