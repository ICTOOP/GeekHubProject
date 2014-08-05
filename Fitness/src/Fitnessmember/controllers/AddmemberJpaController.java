/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitnessmember.controllers;

import Fitnessmember.entities.Addmember;
import Fitnessmember.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Owner
 */
public class AddmemberJpaController implements Serializable {

    public AddmemberJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Addmember addmember) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(addmember);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Addmember addmember) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            addmember = em.merge(addmember);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = addmember.getId();
                if (findAddmember(id) == null) {
                    throw new NonexistentEntityException("The addmember with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Addmember addmember;
            try {
                addmember = em.getReference(Addmember.class, id);
                addmember.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The addmember with id " + id + " no longer exists.", enfe);
            }
            em.remove(addmember);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Addmember> findAddmemberEntities() {
        return findAddmemberEntities(true, -1, -1);
    }

    public List<Addmember> findAddmemberEntities(int maxResults, int firstResult) {
        return findAddmemberEntities(false, maxResults, firstResult);
    }

    private List<Addmember> findAddmemberEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Addmember.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Addmember findAddmember(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Addmember.class, id);
        } finally {
            em.close();
        }
    }

    public int getAddmemberCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Addmember> rt = cq.from(Addmember.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
