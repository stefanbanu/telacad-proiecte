/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Persoana;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obspattern.PersoanaListener;
import obspattern.SubiectPersoana;

/**
 *
 * @author Laur
 */
public class Controller implements SubiectPersoana{
    
    private Connection con;
    private static Controller singleton = null;
    private PreparedStatement ps1,ps2;
    
    private Controller(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/j2c3e2","root","");
            ps1 = con.prepareStatement("INSERT INTO `persoane` VALUES (NULL,?)");
            ps2 = con.prepareStatement("SELECT * FROM `persoane`");
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Controller getInstance(){
        if(singleton == null) singleton = new Controller();
        return singleton;
    }
    
    public void adaugaPersoana(Persoana p){
        try {
            ps1.setNString(1, p.getNume());
            ps1.executeUpdate();
            notifica();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Persoana> getPersoane(){
        ArrayList<Persoana> persoane = new ArrayList<Persoana>();
        try {
            ResultSet rs = ps2.executeQuery();
            while(rs.next()){
                persoane.add(new Persoana(rs.getInt("id"),rs.getString("nume")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persoane;
    }

    @Override
    public void addPersoanaListener(PersoanaListener p) {
        obs.add(p);
    }

    @Override
    public void notifica() {
        for(PersoanaListener p:obs) p.persoanaModificata();
    }
}
