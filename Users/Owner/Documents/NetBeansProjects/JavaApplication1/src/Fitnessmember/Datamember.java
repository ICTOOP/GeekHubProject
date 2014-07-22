/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitnessmember;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Owner
 */
@Entity
public class Datamember {
    
    
    
        @Id
        EntityManagerFactory emf;
        EntityManager em;
        Addmember c;
        
        
    
    public Datamember(){
        emf =Persistence.createEntityManagerFactory("JavaApplication1PU");
        em = emf.createEntityManager();
        
        
    }
    public Datamember(Addmember c){
        emf =Persistence.createEntityManagerFactory("JavaApplication1PU");
        em = emf.createEntityManager();
        
        this.c=c;
    }
    
    public void close(){
        em.close();
        emf.close();
        
        
    }
    
    
    public void insert(Addmember c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
     public Addmember  findById(int id) {
        Addmember c = em.find(Addmember.class, id);
        return c;
    }
    public void delete(Addmember c) {
        em.getTransaction().begin();
        //
        Addmember addmember =findById(c.getId());
        em.remove(addmember);
        em.getTransaction().commit();
    }
    public void update(Addmember c) {
        Addmember addmember = em.find(Addmember.class, c.getId());
        em.getTransaction().begin();
        addmember.setFirstname(c.getFirstname());
        addmember.setLastname(c.getLastname());
        addmember.setAddress(c.getAddress());
        addmember.setPhone(c.getPhone());
        addmember.setGander(c.getGander());
        em.getTransaction().commit();
    }
   
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (c != null ? c.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datamember)) {
            return false;
        }
        Datamember other = (Datamember) object;
        if ((this.c == null && other.c != null) || (this.c != null && !this.c.equals(other.c))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fitnessmember.Datamember[ id=" + c + " ]";
    
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}

    
