package ro.marian.vicea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.marian.vicea.dao.ProductDao;
import ro.marian.vicea.db.ProduseDB;

@Service
public class ProductService {
    
    @Autowired
    private ProductDao productDao;
    
    @Transactional
    public void adaugaZeceProduse() {
        ProduseDB produs;
        for (int i = 1; i <= 10; i++) {
            produs = new ProduseDB();
            produs.setNume("Produs " + i);
            productDao.adaugaProdus(produs);
        }
    }
}
