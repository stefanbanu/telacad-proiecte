package service;

import dao.ProdusDao;
import db.Produs;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.transaction.UserTransaction;

/**
 *
 * @author student
 */
@ManagedBean
@RequestScoped
public class MainService implements java.io.Serializable{
    private Produs produs;
    private List<Produs> allProducts;
    
    @ManagedProperty("#{produsDao}")
    private ProdusDao produsDao;
    
    @Resource
    private UserTransaction utx;
    
    @PostConstruct
    private void init(){
        produs = new Produs();
        loadAllProducts();
    }
    
    public void adaugaProdus(){
        try {
            utx.begin();
            produsDao.adaugaProdus(produs);
            loadAllProducts();
            utx.commit();
        } catch (Exception ex) {
            Logger.getLogger(MainService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
    
    public ProdusDao getProdusDao() {
        return produsDao;
    }

    public void setProdusDao(ProdusDao produsDao) {
        this.produsDao = produsDao;
    }

    public List<Produs> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Produs> allProducts) {
        this.allProducts = allProducts;
    }
    
    public void loadAllProducts(){
        allProducts = produsDao.getProduse();
    }
}
