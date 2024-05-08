/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Joel Antonio Lopez Cota - 00000228926
 */
@Entity
@Table(name = "Tareas")
public class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(name = "fecha_crea",nullable=true)
    @Temporal(TemporalType.DATE)
    private Date fechaCrea;
    @Column(name = "fecha_termina",nullable=false)
    @Temporal(TemporalType.DATE)
    private Date fechaTermina;
    @JoinColumn(name = "idLista", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Lista lista;
    @JoinColumn(name = "idUsuario", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Notificacion> notificaciones;
    


    public Tarea() {
    }

    public Tarea(Integer idtarea) {
        this.id = idtarea;
    }

    public Tarea(Integer idtarea, String titulo, Estado estado) {
        this.id = idtarea;
        this.titulo = titulo;
        this.estado = estado;
    }

    public Tarea(String titulo, Estado estado, Date fechaCrea, Date fechaTermina, Lista idLista, Usuario idUsuario) {
        this.titulo = titulo;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaTermina = fechaTermina;
        this.lista = idLista;
        this.usuario = idUsuario;
    }

    public Tarea(String titulo, Estado estado, Date fechaCrea, Date fechaTermina, Usuario idUsuario) {
        this.titulo = titulo;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaTermina = fechaTermina;
        this.usuario = idUsuario;
    }

    
    public Integer getIdtarea() {
        return id;
    }

    public void setIdtarea(Integer idtarea) {
        this.id = idtarea;
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

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaTermina() {
        return fechaTermina;
    }

    public void setFechaTermina(Date fechaTermina) {
        this.fechaTermina = fechaTermina;
    }

    public Lista getIdLista() {
        return lista;
    }

    public void setIdLista(Lista idLista) {
        this.lista = idLista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tareas{" + "idtarea=" + id + ", titulo=" + titulo + ", estado=" + estado + ", fechaCrea=" + fechaCrea + ", fechaTermina=" + fechaTermina + ", idLista=" + lista + ", idUsuario=" + usuario + '}';
    }



}
