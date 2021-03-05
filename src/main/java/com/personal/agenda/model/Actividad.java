/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.agenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.lang.NonNull;

/**
 *
 * @author FIGTE
 */
@Entity
@Table(name = "ACTIVIDADES")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByNombre", query = "SELECT a FROM Actividad a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actividad.findByFecha", query = "SELECT a FROM Actividad a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Actividad.findByObservacion", query = "SELECT a FROM Actividad a WHERE a.observacion = :observacion")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NonNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NonNull
  
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NonNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "OBSERVACION")
    private String observacion;
    @JoinColumn(name = "IDEVENTO", referencedColumnName = "ID")
    @ManyToOne
    private Evento idevento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactividad")
    private List<ActividadUsuario> actividadUsuarioList;

    public Actividad() {
    }

    public Actividad(BigDecimal id) {
        this.id = id;
    }

    public Actividad(BigDecimal id, String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Evento getIdevento() {
        return idevento;
    }

    public void setIdevento(Evento idevento) {
        this.idevento = idevento;
    }

    public List<ActividadUsuario> getActividadUsuarioList() {
        return actividadUsuarioList;
    }

    public void setActividadUsuarioList(List<ActividadUsuario> actividadUsuarioList) {
        this.actividadUsuarioList = actividadUsuarioList;
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "personal.app.agenda.models.Actividad[ id=" + id + " ]";
    }
    
}
