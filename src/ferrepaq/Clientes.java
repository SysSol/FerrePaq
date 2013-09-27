/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ferrepaq;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Omar Benitez
 */
@Entity
@Table(name = "clientes", catalog = "ferrepaq", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdCliente", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Clientes.findByTelefono", query = "SELECT c FROM Clientes c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Clientes.findByTelefonoAlt", query = "SELECT c FROM Clientes c WHERE c.telefonoAlt = :telefonoAlt")})
public class Clientes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Lob
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono_alt")
    private Integer telefonoAlt;

    public Clientes() {
    }

    public Clientes(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Clientes(Integer idCliente, String nombreCliente, int telefono, String direccion) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        Integer oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        String oldNombreCliente = this.nombreCliente;
        this.nombreCliente = nombreCliente;
        changeSupport.firePropertyChange("nombreCliente", oldNombreCliente, nombreCliente);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        int oldTelefono = this.telefono;
        this.telefono = telefono;
        changeSupport.firePropertyChange("telefono", oldTelefono, telefono);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        String oldDireccion = this.direccion;
        this.direccion = direccion;
        changeSupport.firePropertyChange("direccion", oldDireccion, direccion);
    }

    public Integer getTelefonoAlt() {
        return telefonoAlt;
    }

    public void setTelefonoAlt(Integer telefonoAlt) {
        Integer oldTelefonoAlt = this.telefonoAlt;
        this.telefonoAlt = telefonoAlt;
        changeSupport.firePropertyChange("telefonoAlt", oldTelefonoAlt, telefonoAlt);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ferrepaq.Clientes[ idCliente=" + idCliente + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
