/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dominio.Usuario;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public interface IUsuariosDAO {

    public Usuario registrarUsuario(Usuario usuario);

    public Usuario consultarUsuarioPorId(int id);

    public Usuario consultarCrendenciales(String correo, String password);
    
}
