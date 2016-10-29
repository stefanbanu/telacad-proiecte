package com.mycompany.controller.dao;

import com.mycompany.db.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository // Ii spune Springului ca asta e DAO
@Transactional(propagation = Propagation.MANDATORY) // Ii spune Springului ca trebuie folosit acest DAO doar cu tranzactie
public class ProdusDao {
    
    @Autowired // Ia instanta direct din registrul Spring
    private JdbcTemplate jdbcTemplate;
    
    public void adaugaProdus(Produs produs) {
        String sql = "INSERT INTO produse VALUES (null, ?)";
        jdbcTemplate.update(sql, produs.getNume());
    }
}
