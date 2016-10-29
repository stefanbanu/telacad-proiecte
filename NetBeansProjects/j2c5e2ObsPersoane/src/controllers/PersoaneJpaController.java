/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Persoane;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import obspattern.PersoaneListener;
import obspattern.SubiectPersoane;

/**
 *
 * @author Laur
 */
public class PersoaneJpaController implements Serializable,SubiectPersoane {

    public PersoaneJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Persoane persoane) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(persoane);
            em.getTransaction().commit();
            notifica();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Persoane persoane) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            persoane = em.merge(persoane);
            em.getTransaction().commit();
            notifica();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = persoane.getId();
                if (findPersoane(id) == null) {
                    throw new NonexistentEntityException("The persoane with id " + id + " no longer exists.");
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
            Persoane persoane;
            try {
                persoane = em.getReference(Persoane.class, id);
                persoane.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persoane with id " + id + " no longer exists.", enfe);
            }
            em.remove(persoane);
            em.getTransaction().commit();
            notifica();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persoane> findPersoaneEntities() {
        return findPersoaneEntities(true, -1, -1);
    }

    public List<Persoane> findPersoaneEntities(int maxResults, int firstResult) {
        return findPersoaneEntities(false, maxResults, firstResult);
    }

    private List<Persoane> findPersoaneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persoane.class));
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

    public Persoane findPersoane(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persoane.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersoaneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persoane> rt = cq.from(Persoane.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    @Override
    public void addPersoaneListener(PersoaneListener pl) {
        obs.add(pl);
    }

    @Override
    public void notifica() {
        for(PersoaneListener p: obs) p.persoanaModificata();
    }
    
}
