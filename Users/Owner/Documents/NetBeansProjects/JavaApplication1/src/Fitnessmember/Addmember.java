/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitnessmember;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Owner
 */
@Entity
@Table(name = "ADDMEMBER")
@SequenceGenerator(name = "seq", initialValue=1)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addmember.findAll", query = "SELECT a FROM Addmember a"),
    @NamedQuery(name = "Addmember.findById", query = "SELECT a FROM Addmember a WHERE a.id = :id"),
    @NamedQuery(name = "Addmember.findByAddress", query = "SELECT a FROM Addmember a WHERE a.address = :address"),
    @NamedQuery(name = "Addmember.findByFirstname", query = "SELECT a FROM Addmember a WHERE a.firstname = :firstname"),
    @NamedQuery(name = "Addmember.findByLastname", query = "SELECT a FROM Addmember a WHERE a.lastname = :lastname"),
    @NamedQuery(name = "Addmember.findByPhone", query = "SELECT a FROM Addmember a WHERE a.phone = :phone"),
    @NamedQuery(name = "Addmember.findByGander", query = "SELECT a FROM Addmember a WHERE a.gander = :gander")})
public class Addmember implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Integer id;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "GANDER")
    private String gander;

    public Addmember() {
    }

    public Addmember(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        String oldGander = this.gander;
        this.gander = gander;
        changeSupport.firePropertyChange("gander", oldGander, gander);
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
        if (!(object instanceof Addmember)) {
            return false;
        }
        Addmember other = (Addmember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fitnessmember.Addmember[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
