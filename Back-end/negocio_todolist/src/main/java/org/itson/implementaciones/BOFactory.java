/**
* BOFactory.java
* Jun 24, 2023 10:46:12 AM
*/ 

package org.itson.implementaciones;

import org.itson.interfaces.IListasBO;
import org.itson.interfaces.INotificacionesBO;
import org.itson.interfaces.ITareasBO;
import org.itson.interfaces.IUsuariosBO;

/**
 * Descripción de la clase: 
 * 
 */
public class BOFactory {
    
    public static IUsuariosBO getUsuariosBOInstance(){
        return new UsuariosBO();
    }
    
    public static IListasBO getListasBOInstance(){
        return new ListasBO();
    }
    
    public static ITareasBO getTareasBOInstance(){
        return new TareasBO();
    }
    
  public static INotificacionesBO getNotificacionesBOInstance(){
        return new NotificacionesBO();
    }
  
}
