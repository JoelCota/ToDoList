/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.itson.implementaciones;

import Dominio.Usuario;
import excepciones.PersistenciaException;
import implementaciones.FachadaPersistencia;
import org.itson.excepciones.BOException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IUsuariosBO;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class UsuariosBO implements IUsuariosBO{
 /**
     * Fchada de la persitencia
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor que instancia la fachada
     */
    public UsuariosBO() {
        persistencia = new FachadaPersistencia();
    }
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
     try {
            
            if(usuario == null){
                throw new ValidacionException("No hay información del usuario");
            }
            
            return persistencia.registrarUsuario(usuario);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
    
    }

    @Override
    public Usuario consultarUsuarioPorId(int id) {
       try {

            if (id < 1) {
                //No hay id para buscar
                throw new ValidacionException("No hay información del "
                        + "id");
            }
            //Regresa un objeto usuario
            return persistencia.consultarUsuarioPorId(id);

        } catch (PersistenciaException e) {
            //Error en la persistencia
            throw new BOException(e);
        }  }

    @Override
    public Usuario consultarCrendenciales(String correo, String password) {
       try {

            if (correo == null) {
                throw new ValidacionException("No hay información del correo");
            }
            if (password == null) {
                throw new ValidacionException("No hay información del correo");
            }
            return persistencia.consultarCrendenciales(correo, password);

        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
     }

}
