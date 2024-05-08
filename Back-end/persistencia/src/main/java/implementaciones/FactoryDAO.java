/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

import interfaces.IUsuariosDAO;
import interfaces.IListasDAO;
import interfaces.ITareasDAO;
import excepciones.PersistenciaException;
import interfaces.INotificacionesDAO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class FactoryDAO {
  /**
     * Constructor por default
     */
    public FactoryDAO() {

    }

    public static IListasDAO getListasDAO() throws PersistenciaException {
        return new ListasDAO();
    }

    public static ITareasDAO getTareasDAO() throws PersistenciaException {
        return new TareasDAO();
    }

    public static IUsuariosDAO getUsuariosDAO() throws PersistenciaException {
        return new UsuariosDAO();
    }

    public static INotificacionesDAO getNotificacionesDAO() throws PersistenciaException {
        return new NotificacionesDAO();
    }

}
