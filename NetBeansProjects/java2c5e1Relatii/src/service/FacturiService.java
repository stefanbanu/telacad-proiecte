/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FacturiDao;
import dao.LinieFacturaDao;
import dao.ProdusDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.FacturaDB;
import model.LinieFacturaDB;
import model.ProdusDB;
import obspattern.FacturiSubject;

/**
 *
 * @author student
 */
public class FacturiService implements FacturiSubject{

    private EntityManager em;
    private EntityManagerFactory emf;

    private final ProdusDao produsDao;
    private final FacturiDao facturiDao;
    private final LinieFacturaDao liniiFacturaDao;

    private FacturiService() {
        emf = Persistence.createEntityManagerFactory("java2c5e1PU");
        em = emf.createEntityManager();

        produsDao = new ProdusDao(em);
        facturiDao = new FacturiDao(em);
        liniiFacturaDao = new LinieFacturaDao(em);
    }

    private static final class SingletonHolder {

        private static final FacturiService SINGLETON = new FacturiService();
    }

    public static FacturiService getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public void adaugaProdus(String nume, double pret) {
        try {
            em.getTransaction().begin();
            ProdusDB produs = new ProdusDB();
            produs.setNume(nume);
            produs.setPret(pret);
            produsDao.adaugaProdus(produs);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<ProdusDB> findAllProducts() {
        return produsDao.findAllProducts();
    }

    public void adaugaFactura(String serie, String numar) {
        try {
            em.getTransaction().begin();
            FacturaDB factura = new FacturaDB();
            factura.setNumar(numar);
            factura.setSerie(serie);
            facturiDao.adaugaFactura(factura);
            em.getTransaction().commit();
            notifyFacturiListeners();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public List<FacturaDB> getAllFacturi(){
        return facturiDao.getAllFacturi();
    }
    
    public void adaugaLinieFactura(FacturaDB factura, ProdusDB produs, int qty){
        try{
            em.getTransaction().begin();
            LinieFacturaDB linie = new LinieFacturaDB();
            linie.setFactura(factura);
            linie.setProdus(produs);
            linie.setQty(qty);
            liniiFacturaDao.adaugaLinieFactura(linie);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public List<LinieFacturaDB> getLiniiFactura(FacturaDB factura){
        return liniiFacturaDao.getAllLiniiFactura(factura);
    }
}
