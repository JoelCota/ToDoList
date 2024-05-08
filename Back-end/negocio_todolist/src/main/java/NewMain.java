
import Dominio.Estado;
import Dominio.Lista;
import Dominio.Notificacion;
import Dominio.Tarea;
import Dominio.TipoNotificacion;
import Dominio.Usuario;
import java.util.Calendar;
import java.util.Date;
import org.itson.implementaciones.FachadaBO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FachadaBO fac=new FachadaBO();
        fac.registrarUsuario(new Usuario("Joel", "Lopez Cota", "asddf", "holi",Calendar.getInstance().getTime() ,null,null));
        Usuario usuario = new Usuario();
        usuario.setNombres("Juan");
        usuario.setApellidos("Pérez");
        usuario.setCorreo("juan@example.com");
        usuario.setContrasena("password");
        usuario.setFechaNacimiento(new Date());
        fac.registrarUsuario(usuario);
        // Crear una lista
        Lista lista = new Lista();
        lista.setId(1);
        lista.setTitulo("Lista de compras");
        lista.setDescripcion("Lista de productos para comprar en el supermercado");
        lista.setUsuario(usuario);
        fac.crearLista(lista);
        // Crear una tarea
        Tarea tarea = new Tarea();
        tarea.setId(1);
        tarea.setTitulo("Comprar leche");
        tarea.setDescripcion("Comprar una botella de leche desnatada");
        tarea.setEstado(Estado.Pendiente);
        tarea.setFechaCrea(new Date());
        tarea.setFechaTermina(new Date());
        tarea.setUsuario(usuario);
        tarea.setLista(lista);
        fac.registrarTarea(tarea);

        Notificacion notificacion = new Notificacion();
        notificacion.setTipoNotificacion(TipoNotificacion.FELICITACION);
        notificacion.setDescripcion("Recuerda comprar la leche");
        notificacion.setTitulo("Recordatorio de tarea");
        notificacion.setUsuario(usuario);
        notificacion.setLista(lista);
        notificacion.setTarea(tarea);
        fac.crearNotificacion(notificacion);
     
       
    


    }
    
}
