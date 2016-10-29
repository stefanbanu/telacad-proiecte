/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.telacad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author student
 */
@Repository
public class ProductDao {

    @Autowired
    private DataSource dataSource;

    public void adaugaProdus(String nume) {
        try (Connection con = dataSource.getConnection()) {
            String sql = "INSERT INTO produse VALUES (NULL, ?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nume);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void stergeProdus(String nume) {
        try (Connection con = dataSource.getConnection()) {
            String sql = "delete from produse where nume=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nume);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
