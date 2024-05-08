/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Tarea;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.ITareasDAO;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class TareasDAO implements ITareasDAO {

    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public TareasDAO() {
        emf = ConexionBD.getConection();
    }

    @Override
    public Tarea registrarTarea(Tarea tarea) {
        EntityManager em = emf.createEntityManager();

        try {
            if (tarea == null) {
                throw new PersistenciaException("No hay información de la tarea");
            }
            em.getTransaction().begin();
            em.persist(tarea);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar la tarea a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return tarea;
    }

    @Override
    public Tarea editarTarea(Tarea tarea) {
       EntityManager em = emf.createEntityManager();

        try {
            if (tarea == null) {
                throw new PersistenciaException("No existe una tarea a actualizar");
            }

            em.getTransaction().begin();
            em.merge(tarea);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar la tarea.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo en error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return tarea;
    }

    @Override
    public boolean eliminarTarea(Tarea tarea) {
         EntityManager em = emf.createEntityManager();
        try {
            if (tarea == null) {
                throw new PersistenceException("No hay información del post");
            }
            em.getTransaction().begin();
            Tarea tareaMerge = em.merge(tarea);
            em.remove(tareaMerge);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public Tarea actualizarEstadoTarea(Tarea tarea,Estado estado) {
       // Iniciar una transacción
      EntityManager em = emf.createEntityManager();
        
        try {
            
            // Verificar si la tarea existe
            if (tarea != null) {
                // Actualizar el estado de la tarea
                tarea.setEstado(estado);
                
                // Persistir los cambios
                em.merge(tarea);
                
                // Confirmar la transacción
                em.getTransaction().commit();
            } else {
                // Si la tarea no existe, manejar la situación (p.ej., lanzar una excepción)
                throw new EntityNotFoundException("Tarea no encontrada");
            }
        } catch (Exception e) {
            // Si hay un error, revertir la transacción
            em.getTransaction().rollback();
            // Manejar la excepción (p.ej., lanzarla de nuevo o registrarla en un log)
            throw e;
        } finally {
            em.close();
        }
        return tarea;
    }

    @Override
    public List<Tarea> obtenerTodasLasTareas() {
    EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<Tarea> query = em.createQuery("SELECT t FROM Tarea t", Tarea.class);
        return query.getResultList();
    } finally {
        em.close();
    }
}
    @Override
    public List<Tarea> obtenerTareasPorLista(Lista lista) {
    EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<Tarea> query = em.createQuery("SELECT t FROM Tarea t WHERE t.lista = :lista", Tarea.class);
        query.setParameter("lista", lista);
        return query.getResultList();
    } finally {
        em.close();
    }
}
}
