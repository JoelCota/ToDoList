/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import Dominio.Lista;
import Dominio.Tarea;
import java.util.List;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public interface IListasBO {
      public Lista crearLista(Lista lista);

    public boolean eliminarLista(Lista lista);

    public Lista editarNombreLista(Lista lista);

    public Lista editarDescripcionLista(Lista lista);

    public Lista agregarTarea(Lista lista, Tarea tarea);

    public Lista eliminarTarea(Lista lista, Tarea tarea);

    public List<Lista> obtenerTodasLasListas();
}
