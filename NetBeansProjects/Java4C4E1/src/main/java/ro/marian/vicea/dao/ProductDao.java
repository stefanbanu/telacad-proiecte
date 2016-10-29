package ro.marian.vicea.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ro.marian.vicea.db.Product;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class ProductDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void addProduct(Product product) {
        String sql = "INSERT INTO produse VALUES (NULL, ?)";
        jdbcTemplate.update(sql, product.getNume());
    }
    
    public void addProductOne() {
        String sql = "INSERT INTO produse VALUES (NULL, ?)";
        jdbcTemplate.update(sql, "ONE");
    }
    
    public void addProductTwo() {
        String sql = "INSERT INTO produse VALUES (NULL, ?)";
        jdbcTemplate.update(sql, "TWO");
        throw new RuntimeException();
    }
}
