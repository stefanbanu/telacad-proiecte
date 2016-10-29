/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Carduri;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import obspattern.CardListener;
import obspattern.SubiectCard;

/**
 *
 * @author Laur
 */
public class CarduriJpaController implements Serializable,SubiectCard {

    public CarduriJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carduri carduri) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carduri);
            em.getTransaction().commit();
            notifica(carduri);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carduri carduri) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carduri = em.merge(carduri);
            em.getTransaction().commit();
            notifica(carduri);
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = carduri.getId();
                if (findCarduri(id) == null) {
                    throw new NonexistentEntityException("The carduri with id " + id + " no longer exists.");
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
            Carduri carduri;
            try {
                carduri = em.getReference(Carduri.class, id);
                carduri.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carduri with id " + id + " no longer exists.", enfe);
            }
            em.remove(carduri);
            em.getTransaction().commit();
            notifica(carduri);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carduri> findCarduriEntities() {
        return findCarduriEntities(true, -1, -1);
    }

    public List<Carduri> findCarduriEntities(int maxResults, int firstResult) {
        return findCarduriEntities(false, maxResults, firstResult);
    }

    private List<Carduri> findCarduriEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carduri.class));
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

    public Carduri findCarduri(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carduri.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarduriCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carduri> rt = cq.from(Carduri.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Carduri> getCarduriByClient(Integer id){
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Carduri.findByClient");
            q.setParameter("client", id);
        List<Carduri> carduri = (List<Carduri>) q.getResultList();
        return carduri;
    }

    @Override
    public void addCardListener(CardListener cl) {
        obs.add(cl);
    }

    @Override
    public void notifica(Carduri c) {
        for(CardListener cl: obs) cl.cardModificat(c);
    }
    
}
