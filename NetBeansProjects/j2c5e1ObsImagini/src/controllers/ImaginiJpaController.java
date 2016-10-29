/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Imagini;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import obspattern.ImaginiListener;
import obspattern.SubiectImagini;

/**
 *
 * @author Laur
 */
public class ImaginiJpaController implements Serializable, SubiectImagini {

    public ImaginiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Imagini imagini) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(imagini);
            em.getTransaction().commit();
            notificareImagini();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Imagini imagini) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            imagini = em.merge(imagini);
            em.getTransaction().commit();
            notificareImagini();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = imagini.getId();
                if (findImagini(id) == null) {
                    throw new NonexistentEntityException("The imagini with id " + id + " no longer exists.");
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
            Imagini imagini;
            try {
                imagini = em.getReference(Imagini.class, id);
                imagini.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The imagini with id " + id + " no longer exists.", enfe);
            }
            em.remove(imagini);
            em.getTransaction().commit();
            notificareImagini();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Imagini> findImaginiEntities() {
        return findImaginiEntities(true, -1, -1);
    }

    public List<Imagini> findImaginiEntities(int maxResults, int firstResult) {
        return findImaginiEntities(false, maxResults, firstResult);
    }

    private List<Imagini> findImaginiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Imagini.class));
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

    public Imagini findImagini(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Imagini.class, id);
        } finally {
            em.close();
        }
    }

    public int getImaginiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Imagini> rt = cq.from(Imagini.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Imagini> getImaginiByUser(int id){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Imagini.findByUser");
        q.setParameter("user", id);
        List<Imagini> imagini = q.getResultList();
        return imagini;
    }

    @Override
    public void addImaginiListener(ImaginiListener il) {
        obs.add(il);
    }

    @Override
    public void notificareImagini() {
        for(ImaginiListener il: obs) il.imagineModificata();
    }
    
    
}
