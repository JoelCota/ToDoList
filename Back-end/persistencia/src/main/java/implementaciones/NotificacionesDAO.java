/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

import Dominio.Notificacion;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.INotificacionesDAO;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class NotificacionesDAO implements INotificacionesDAO {
private EntityManagerFactory emf;

    public NotificacionesDAO() {
        this.emf = ConexionBD.getConection();
    }

@Override
    public Notificacion crearNotificacion(Notificacion notificacion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(notificacion);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("La notificación ya existe en la base de datos.", e);
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error al intentar hacer commit de la transacción.", e);
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("El EntityManager se encontraba en un estado ilegal.", e);
        } finally {
            em.close();
        }
        return notificacion;
    }
}