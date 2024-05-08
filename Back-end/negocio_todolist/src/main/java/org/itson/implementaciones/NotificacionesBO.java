/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import Dominio.Notificacion;
import implementaciones.FachadaPersistencia;
import javax.persistence.PersistenceException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.INotificacionesBO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class NotificacionesBO implements INotificacionesBO {

    FachadaPersistencia persistencia;

    public NotificacionesBO() {
        persistencia = new FachadaPersistencia();

    }

    @Override
    public Notificacion crearNotificacion(Notificacion notificacion) {
        try {
            return this.persistencia.crearNotificacion(notificacion);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }
    }

}
