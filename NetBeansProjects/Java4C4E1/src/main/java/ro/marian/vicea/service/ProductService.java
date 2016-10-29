package ro.marian.vicea.service;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.marian.vicea.dao.ProductDao;
import ro.marian.vicea.db.Product;

@Service
public class ProductService {
    
    @Autowired
    private ProductDao productDao;
    
    @Transactional
    public void adaugaZeceProduse() {
        Product product;
        for (int i = 1; i <= 10; i++) {
            product = new Product("Produs " + i);
            productDao.addProduct(product);
        }
    }
    
    @Transactional
    public void adaugaDouaProduse() {
        ((ProductService) AopContext.currentProxy()).adaugaProdusOne();
        ((ProductService) AopContext.currentProxy()).adaugaProdusTwo();
    }
    
    @Transactional
    public void adaugaProdusOne() {
        productDao.addProductOne();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void adaugaProdusTwo() {
        try {
            productDao.addProductTwo();
        } catch(Exception e) {
            System.out.println("two");
        }
    }
}
