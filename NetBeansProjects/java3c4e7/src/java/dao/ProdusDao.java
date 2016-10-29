package dao;

import db.Produs;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author student
 */
@ManagedBean
@RequestScoped
public class ProdusDao implements java.io.Serializable{
    
    @PersistenceContext
    private EntityManager em;
    
    public void adaugaProdus(Produs p){
        em.persist(p);
    }
    
    public List<Produs> getProduse(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Produs> cq = cb.createQuery(Produs.class);
        
        Root<Produs> produs = cq.from(Produs.class);
        TypedQuery<Produs> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    public List<Produs> getProduseJPQL(){
        String sql = "SELECT p FROM Produs p";
        TypedQuery<Produs> q = em.createQuery(sql, Produs.class);
        return q.getResultList();
    }
}
