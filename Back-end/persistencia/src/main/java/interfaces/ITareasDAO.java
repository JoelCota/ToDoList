/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Tarea;
import java.util.List;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public interface ITareasDAO {

    public Tarea registrarTarea(Tarea tarea);

    public Tarea editarTarea(Tarea tarea);

    public boolean eliminarTarea(Tarea tarea);
    
    public Tarea actualizarEstadoTarea (Tarea tarea, Estado estado);
    
    public List<Tarea> obtenerTodasLasTareas();
    
    public List<Tarea> obtenerTareasPorLista(Lista lista);
    
}
