/**
 * FachadaBO.java
 * Jun 24, 2023 10:45:43 AM
 */
package org.itson.implementaciones;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Notificacion;
import Dominio.Tarea;
import Dominio.Usuario;
import java.util.List;
import org.itson.excepciones.BOException;
import org.itson.interfaces.IFachadaBO;
import org.itson.interfaces.IListasBO;
import org.itson.interfaces.INotificacionesBO;
import org.itson.interfaces.ITareasBO;
import org.itson.interfaces.IUsuariosBO;


public class FachadaBO implements IFachadaBO {
    ITareasBO tareasBO;
    IListasBO listasBO;
    IUsuariosBO usuariosBO;
    INotificacionesBO notificacionesBO;
    public FachadaBO() {
         tareasBO = BOFactory.getTareasBOInstance();
        listasBO = BOFactory.getListasBOInstance();
        usuariosBO = BOFactory.getUsuariosBOInstance();
        notificacionesBO = BOFactory.getNotificacionesBOInstance();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws BOException {
        try {
            return usuariosBO.registrarUsuario(usuario);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(int id) throws BOException {
        try {
            return usuariosBO.consultarUsuarioPorId(id);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario consultarCrendenciales(String correo, String password) throws BOException {
        try {
            return usuariosBO.consultarCrendenciales(correo, password);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Tarea registrarTarea(Tarea tarea) throws BOException {
        try {
            return tareasBO.registrarTarea(tarea);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Tarea editarTarea(Tarea tarea) throws BOException {
        try {
            return tareasBO.editarTarea(tarea);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public boolean eliminarTarea(Tarea tarea) throws BOException {
        try {
            return tareasBO.eliminarTarea(tarea);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

      @Override
    public Tarea actualizarEstadoTarea(Tarea tarea, Estado estado) throws BOException {
        try {
            return tareasBO.actualizarEstadoTarea(tarea, estado);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() throws BOException {
        try {
            return tareasBO.obtenerTodasLasTareas();
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Tarea> obtenerTareasPorLista(Lista lista) throws BOException {
        try {
            return tareasBO.obtenerTareasPorLista(lista);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Lista crearLista(Lista lista) throws BOException {
        try {
            return listasBO.crearLista(lista);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public boolean eliminarLista(Lista lista) throws BOException {
        try {
            return listasBO.eliminarLista(lista);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Lista editarNombreLista(Lista lista) throws BOException {
        try {
            return listasBO.editarNombreLista(lista);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Lista editarDescripcionLista(Lista lista) throws BOException {
        try {
            return listasBO.editarDescripcionLista(lista);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Lista agregarTarea(Lista lista, Tarea tarea) throws BOException {
        try {
            return listasBO.agregarTarea(lista, tarea);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Lista eliminarTarea(Lista lista, Tarea tarea) throws BOException {
        try {
            return listasBO.eliminarTarea(lista, tarea);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Lista> obtenerTodasLasListas() throws BOException {
        try {
            return listasBO.obtenerTodasLasListas();
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Notificacion crearNotificacion(Notificacion notificacion) throws BOException {
        try {
            return notificacionesBO.crearNotificacion(notificacion);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }
  
}
