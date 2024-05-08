/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Dominio.Lista;
import Dominio.Tarea;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IListasDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class ListasDAO implements IListasDAO {

    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public ListasDAO() {
        emf = ConexionBD.getConection();
    }

    @Override
    public Lista crearLista(Lista lista) {
       EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(lista);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo crear la lista.", e);
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public boolean eliminarLista(Lista lista) {
          EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
                em.remove(lista);
                em.getTransaction().commit();
                return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar la lista.", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Lista editarNombreLista(Lista lista) {
      EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            lista.setTitulo(lista.getTitulo());
            em.merge(lista);
            em.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo editar el nombre de la lista.", e);
        } finally {
            em.close();
        }
      }

    @Override
    public Lista editarDescripcionLista(Lista lista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            lista.setDescripcion(lista.getDescripcion());
            em.merge(lista);
            em.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo editar la descripción de la lista.", e);
        } finally {
            em.close();
        }   }

    @Override
    public Lista agregarTarea(Lista lista, Tarea tarea) {
//       EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            tarea.setIdLista(lista);
//            em.persist(tarea);
//            lista.getTareaCollection().add(tarea);
//            em.merge(lista);
//            em.getTransaction().commit();
//            return lista;
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            throw new PersistenciaException("No se pudo agregar la tarea a la lista.", e);
//        } finally {
//            em.close();
//        } 
    return null;
    }

    @Override
    public Lista eliminarTarea(Lista lista, Tarea tarea) {
//     EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//                lista.getTareaCollection().remove(tarea);
//                em.remove(tarea);
//                em.merge(lista);
//                em.getTransaction().commit();
//                return lista;
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            throw new PersistenciaException("No se pudo eliminar la tarea de la lista.", e);
//        } finally {
//            em.close();
//        }
return null;
    }
 
    
    @Override
    public List<Lista> obtenerTodasLasListas() {
    EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<Lista> query = em.createQuery("SELECT l FROM Lista l", Lista.class);
        return query.getResultList();
    } finally {
        em.close();
    }
}
}
