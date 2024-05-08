/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
@Entity
@Table(name = "Listas")
public class Lista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
;    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
   @JoinColumn(name = "idUsuario", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarea> tareaCollection;
@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)    
private List<Notificacion> notificaciones;

    public Lista() {
    }

    public Lista(Integer idlistaTareas) {
        this.id = idlistaTareas;
    }

    public Lista(Integer idlistaTareas, String titulo) {
        this.id = idlistaTareas;
        this.titulo = titulo;
    }

    public Lista(String titulo, String descripcion, Usuario idUsuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = idUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(List<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getIdUsuario() {
        return usuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.usuario = idUsuario;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.ListaTareas[ idlistaTareas=" + id + " ]";
    }

}
