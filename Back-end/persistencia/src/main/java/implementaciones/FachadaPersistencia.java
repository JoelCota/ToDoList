/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Notificacion;
import Dominio.Tarea;
import Dominio.Usuario;
import excepciones.PersistenciaException;
import interfaces.IFachadaPersistencia;
import interfaces.IListasDAO;
import interfaces.INotificacionesDAO;
import interfaces.ITareasDAO;
import interfaces.IUsuariosDAO;
import java.util.List;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class FachadaPersistencia implements IFachadaPersistencia {

    private IUsuariosDAO usuariosDAO;
    private ITareasDAO tareasDAO;
    private IListasDAO listasDAO;
    private INotificacionesDAO notificacionesDAO;

    public FachadaPersistencia() {
        this.usuariosDAO = FactoryDAO.getUsuariosDAO();
        this.tareasDAO = FactoryDAO.getTareasDAO();
        this.listasDAO = FactoryDAO.getListasDAO();
        this.notificacionesDAO = FactoryDAO.getNotificacionesDAO();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws PersistenciaException {
        try {
            return usuariosDAO.registrarUsuario(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(int id) throws PersistenciaException {
        try {
            return usuariosDAO.consultarUsuarioPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Tarea registrarTarea(Tarea tarea) throws PersistenciaException {
        try {
            return tareasDAO.registrarTarea(tarea);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public boolean eliminarTarea(Tarea tarea) {
        try {
            return tareasDAO.eliminarTarea(tarea);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarCrendenciales(String correo, String password) throws PersistenciaException {
        try {
            return usuariosDAO.consultarCrendenciales(correo, password);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Tarea editarTarea(Tarea tarea) throws PersistenciaException {
        try {
            return tareasDAO.editarTarea(tarea);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Tarea actualizarEstadoTarea(Tarea tarea, Estado estado) throws PersistenciaException {
        try {
            return tareasDAO.actualizarEstadoTarea(tarea, estado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() throws PersistenciaException {
        try {
            return tareasDAO.obtenerTodasLasTareas();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Tarea> obtenerTareasPorLista(Lista lista) throws PersistenciaException {
        try {
            return tareasDAO.obtenerTareasPorLista(lista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Lista crearLista(Lista lista) throws PersistenciaException {
        try {
            return listasDAO.crearLista(lista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public boolean eliminarLista(Lista lista) throws PersistenciaException {
        try {
            return listasDAO.eliminarLista(lista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Lista editarNombreLista(Lista lista) throws PersistenciaException {
        try {
            return listasDAO.editarNombreLista(lista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Lista editarDescripcionLista(Lista lista) throws PersistenciaException {
        try {
            return listasDAO.editarDescripcionLista(lista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Lista agregarTarea(Lista lista, Tarea tarea) throws PersistenciaException {
        try {
            return listasDAO.agregarTarea(lista, tarea);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Lista eliminarTarea(Lista lista, Tarea tarea) throws PersistenciaException {
        try {
            return listasDAO.eliminarTarea(lista, tarea);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Lista> obtenerTodasLasListas() throws PersistenciaException {
        try {
            return listasDAO.obtenerTodasLasListas();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Notificacion crearNotificacion(Notificacion notificacion) throws PersistenciaException {
        try {
            return notificacionesDAO.crearNotificacion(notificacion);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

}
