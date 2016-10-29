/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Admin;
import beans.Medic;
import beans.Pacient;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obspattern.MedicListener;
import obspattern.PacientListener;
import obspattern.SubiectMedic;
import obspattern.SubiectPacient;

/**
 *
 * @author Laur
 */
public class Controller implements SubiectMedic,SubiectPacient{
    private Connection con;
    private static Controller singleton=null;
    private PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ps7;
    
    private Controller(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/j2c3e1","root","");
            
            ps1 = con.prepareStatement("SELECT * FROM `admini` WHERE `user`=?");
            ps2 = con.prepareStatement("INSERT INTO `pacienti` VALUES (NULL,?,?)");
            ps3 = con.prepareStatement("INSERT INTO `medici` VALUES (NULL,?,?)");
            ps4 = con.prepareStatement("SELECT * FROM `medici`");
            ps5 = con.prepareStatement("SELECT * FROM `pacienti`");
            ps6 = con.prepareStatement("INSERT INTO `registru` VALUES (NULL,?,?)");
            ps7 = con.prepareStatement("SELECT * FROM `medici` WHERE `id` IN (SELECT `medic` FROM `registru` WHERE `pacient`=?)");
        
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Controller getInstance(){
        if(singleton == null) singleton = new Controller();
        return singleton;
    }
    
    public Admin login(Admin admin){
        try {
            ps1.setNString(1, admin.getUser());
            ResultSet rs = ps1.executeQuery();
            if(rs.next()){
                if(rs.getString("parola").equals(admin.getParola()))
                    return new Admin(rs.getInt("id"),rs.getString("user"),rs.getString("parola"));
                else return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void adaugaPacient(Pacient pacient){
        try {
            
            ps2.setNString(1, pacient.getNume());
            ps2.setNString(2, pacient.getCnp());
            ps2.executeUpdate();
            notifica2();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adaugaMedic(Medic medic){
        try {
            ps3.setNString(1, medic.getNume());
            ps3.setNString(2, medic.getSerie());
            ps3.executeUpdate();
            notifica();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Medic> getAllMedici(){
        ArrayList<Medic> medici = new ArrayList<Medic>();
        try {
            
            ResultSet rs = ps4.executeQuery();
            while(rs.next()){
                medici.add(new Medic(rs.getInt("id"),rs.getString("nume"),rs.getString("serie")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medici;
    }
    
    public ArrayList<Pacient> getAllPacienti(){
        ArrayList<Pacient> pacienti = new ArrayList<Pacient>();
        try {
            ResultSet rs = ps5.executeQuery();
            while(rs.next()){
                  pacienti.add(new Pacient(rs.getInt("id"), rs.getString("nume"), rs.getString("cnp")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacienti;
    }
    
    public void inregistrare(Pacient p, Medic m){
        try {
            ps6.setInt(1,m.getId());
            ps6.setInt(2,p.getId());
            ps6.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void confirmareInregistrari(){
        try {
            ps6.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void renuntaInregisrari(){
        try {
            ps6.clearBatch();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Medic> getMediciForPacient(Pacient p){
        ArrayList<Medic> medici = new ArrayList<Medic>();
        try {
            
            ps7.setInt(1,p.getId());
            ResultSet rs = ps7.executeQuery();
            while(rs.next()){
                medici.add(new Medic(rs.getInt("id"), rs.getString("nume"), rs.getString("serie")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medici;
    }

    @Override
    public void addMedicListener(MedicListener ml) {
        obs.add(ml);
    }

    @Override
    public void notifica() {
        for(MedicListener ml:obs) ml.medicModificat();
    }

    @Override
    public void addPacientListener(PacientListener p) {
        obs2.add(p);
    }

    @Override
    public void notifica2() {
        for(PacientListener p:obs2) p.pacientModificat();
    }
}
