/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import Dominio.Lista;
import Dominio.Tarea;
import excepciones.PersistenciaException;
import implementaciones.FachadaPersistencia;
import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.BOException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IListasBO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class ListasBO implements IListasBO {

    FachadaPersistencia persistencia;

    public ListasBO() {
        persistencia = new FachadaPersistencia();

    }

    @Override
    public Lista crearLista(Lista lista) {
        try {
            this.validarCrearLista(lista);
            return this.persistencia.crearLista(lista);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }
    }

    private void validarCrearLista(Lista lista) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (lista == null) {
            //No hay datos del post
            throw new ValidacionException("No hay información del post.");
        }

        //Validar el título del post
        String tituloLista = lista.getTitulo();

        if (tituloLista == null || tituloLista.trim().isBlank()) {
            //No hay datos del titulo
            validacionesIncorrectas += "- No hay ningún título.\n";
        }

        //Validar el contenido del post
        String descripcion = lista.getDescripcion();

        if (descripcion == null || descripcion.trim().isBlank()) {
            validacionesIncorrectas += "- No hay ningún contenido.\n";
        }
        
        if (!validacionesIncorrectas.trim().isBlank()) {
            //La cadena de validaciones es diferente de estar vacío
            throw new ValidacionException(validacionesIncorrectas);
        }
    }

    @Override
    public boolean eliminarLista(Lista lista) {
        try {

            if (lista == null) {
                throw new ValidacionException("No hay información de la lista");
            }

            return persistencia.eliminarLista(lista);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }

    }

    @Override
    public Lista editarNombreLista(Lista lista) {
          try {

            if (lista == null) {
                throw new ValidacionException("No hay información de la lista");
            }

            return persistencia.editarNombreLista(lista);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }}

    @Override
    public Lista editarDescripcionLista(Lista lista) {
    try {

            if (lista == null) {
                throw new ValidacionException("No hay información de la lista");
            }

            return persistencia.editarDescripcionLista(lista);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        } }

    @Override
    public Lista agregarTarea(Lista lista, Tarea tarea) {
     try {

            if (lista == null) {
                throw new ValidacionException("No hay información de la lista");
            }

            return persistencia.agregarTarea(lista,tarea);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        } }

    @Override
    public Lista eliminarTarea(Lista lista, Tarea tarea) {
       try {

            if (lista == null) {
                throw new ValidacionException("No hay información de la lista");
            }

            return persistencia.eliminarTarea(lista,tarea);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        } 
}

    @Override
    public List<Lista> obtenerTodasLasListas() {
         try {
            return persistencia.obtenerTodasLasListas();
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        } }

}
