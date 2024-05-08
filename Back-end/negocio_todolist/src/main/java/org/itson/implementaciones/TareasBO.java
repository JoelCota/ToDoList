/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.itson.implementaciones;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Tarea;
import implementaciones.FachadaPersistencia;
import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.ITareasBO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class TareasBO implements ITareasBO {
FachadaPersistencia persistencia;

    public TareasBO() {
        persistencia = new FachadaPersistencia();

    }
    @Override
    public Tarea registrarTarea(Tarea tarea) {
         try {
            this.validarCrearTarea(tarea);
            return this.persistencia.registrarTarea(tarea);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }
    }

    @Override
    public Tarea editarTarea(Tarea tarea) {
    try {
            this.validarCrearTarea(tarea);
            return this.persistencia.editarTarea(tarea);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }}

    @Override
    public boolean eliminarTarea(Tarea tarea) {
    try {
            return this.persistencia.eliminarTarea(tarea);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }}

    @Override
    public Tarea actualizarEstadoTarea(Tarea tarea, Estado estado) {
     try {
            return this.persistencia.actualizarEstadoTarea(tarea,estado);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
       try {
            return this.persistencia.obtenerTodasLasTareas();
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }  }

    @Override
    public List<Tarea> obtenerTareasPorLista(Lista lista) {
         try {
            return this.persistencia.obtenerTareasPorLista(lista);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }  }

    private void validarCrearTarea(Tarea tarea) {
        String validacionesIncorrectas = "";

        if (tarea == null) {
            //No hay datos del post
            throw new ValidacionException("No hay información del post.");
        }

        //Validar el título del post
        String tituloTarea = tarea.getTitulo();

        if (tituloTarea == null || tituloTarea.trim().isBlank()) {
            //No hay datos del titulo
            validacionesIncorrectas += "- No hay ningún título.\n";
        }

        //Validar el contenido del post
        String descripcion = tarea.getDescripcion();

        if (descripcion == null || descripcion.trim().isBlank()) {
            validacionesIncorrectas += "- No hay ningún contenido.\n";
        }
        
        if (!validacionesIncorrectas.trim().isBlank()) {
            //La cadena de validaciones es diferente de estar vacío
            throw new ValidacionException(validacionesIncorrectas);
        }  }

}
