package tx;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionManager {
    private EntityManagerFactory emf;
    private EntityManager em;
    private ThreadLocal<EntityTransaction> currentTransaction = new ThreadLocal<>();
    
    private TransactionManager() {
        emf = Persistence.createEntityManagerFactory("Java2C6ExamenPU");
        em = emf.createEntityManager();
    }
    
    private static final class SingletonHolder {
        private static final TransactionManager INSTANCE = new TransactionManager();
    }
    
    public static TransactionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public EntityManager getEntityManager() {
        return em;
    }
    
    public void startTransaction() {
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        // Setam tranzactia la thread-ul local
        currentTransaction.set(trans);
    }
    
    public void commit() {
        currentTransaction.get().commit();
        currentTransaction.remove();
    }
    
    public void rollback() {
        currentTransaction.get().rollback();
        currentTransaction.remove();
    }
}
