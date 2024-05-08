/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package implementaciones;

import Dominio.Usuario;
import conexion.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IUsuariosDAO;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class UsuariosDAO implements IUsuariosDAO {

   private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public  UsuariosDAO() {
        emf = ConexionBD.getConection();
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        EntityManager em = emf.createEntityManager();
try {
    if (usuario == null) {
        throw new PersistenciaException("No hay información del usuario");
    }

    // Verificar si ya hay una transacción activa
    if (!em.getTransaction().isActive()) {
        em.getTransaction().begin();
    }

    em.persist(usuario);
    em.getTransaction().commit();
} catch (EntityExistsException e) {
    em.getTransaction().rollback();
    throw new PersistenciaException("No se pudo insertar el usuario en la base de datos.", e.getCause());
} catch (RollbackException e) {
    em.getTransaction().rollback();
    throw new PersistenciaException("Hubo un error de commit.", e.getCause());
} catch (IllegalStateException e) {
    em.getTransaction().rollback();
    throw new PersistenciaException(e.getMessage());
} finally {
    em.close();
}

return usuario;

    }

    @Override
    public Usuario consultarUsuarioPorId(int id) {
      EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            em.refresh(usuario);
            em.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
     }

    @Override
    public Usuario consultarCrendenciales(String correo, String password) {
       EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);

            Root<Usuario> usuario = criteria.from(Usuario.class);
            
            List<Predicate> filtros = new LinkedList<>();
            
            filtros.add(builder.equal(usuario.get("correo"), correo));
            filtros.add(builder.equal(usuario.get("contrasena"), password));
            
            criteria.select(usuario).where(builder.and(filtros.toArray(new Predicate[0])));
            
            TypedQuery<Usuario> query = em.createQuery(criteria);

            Usuario usuarioEncontrado = query.getSingleResult();
                        em.getTransaction().commit();

            return usuarioEncontrado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        }
        finally {
            em.close();
        }
    }

}
