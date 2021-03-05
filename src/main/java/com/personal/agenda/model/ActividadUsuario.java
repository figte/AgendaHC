/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personal.agenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author FIGTE
 */
@Entity
@Table(name = "ACTIVIDADES_USUARIOS")
@NamedQueries({
    @NamedQuery(name = "ActividadUsuario.findAll", query = "SELECT a FROM ActividadUsuario a"),
    @NamedQuery(name = "ActividadUsuario.findById", query = "SELECT a FROM ActividadUsuario a WHERE a.id = :id")})
public class ActividadUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
 
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "IDACTIVIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Actividad idactividad;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public ActividadUsuario() {
    }

    public ActividadUsuario(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Actividad getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Actividad idactividad) {
        this.idactividad = idactividad;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
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
        if (!(object instanceof ActividadUsuario)) {
            return false;
        }
        ActividadUsuario other = (ActividadUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "personal.app.agenda.models.ActividadUsuario[ id=" + id + " ]";
    }
    
}
