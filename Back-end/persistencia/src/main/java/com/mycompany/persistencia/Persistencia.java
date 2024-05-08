/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia;

import Dominio.Estado;
import Dominio.Lista;
import Dominio.Tarea;
import Dominio.Usuario;
import implementaciones.FachadaPersistencia;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
public class Persistencia {

    public static void main(String[] args) {
        System.out.println("Hello World!");
                FachadaPersistencia persistencia = new FachadaPersistencia();
   Usuario usuario=new Usuario("Joel", "Lopez Cota", "joellopezc", "holi",Calendar.getInstance().getTime() ,null,null);
   persistencia.registrarUsuario(usuario);
//   Tarea tarea=new Tarea("Whiskey", Estado.Proceso, new Date(), new Date(),persistencia.consultarUsuarioPorId(1));
//   persistencia.registrarTarea(tarea);
    }
}
