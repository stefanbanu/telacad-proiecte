/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.AngajatDB;
import service.AngajatService;

/**
 *
 * @author student
 */
public class ModifcareAngajatDialog extends JDialog{
    private JPanel p1,p2,p3;
    private JLabel e1,e2;
    private JTextField t1,t2;
    private JButton b1;
    
    private AngajatDB angajat;
    
    public ModifcareAngajatDialog(JFrame parent, AngajatDB angajat){
        super(parent, "Modifica angajat");
        this.angajat = angajat;
        
        initComponents();
        setValuesOnComponents();
        assambleLayout();
        registerEvents();
        
        pack();
        setLocationRelativeTo(parent);
        setModal(true);
        setVisible(true);
    }
    
    private void initComponents(){
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        e1 = new JLabel("NUME:");
        e2 = new JLabel("PRENUME:");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        b1 = new JButton("MODIFICA ANGAJAT");
    }

    private void assambleLayout() {
        setLayout(new GridLayout(3,1));
        add(p1); add(p2); add(p3);
        p1.add(e1); p1.add(t1);
        p2.add(e2); p2.add(t2);
        p3.add(b1);
    }

    private void registerEvents() {
        b1.addActionListener(ev -> modificaAngajat());
    }
    
    private void modificaAngajat(){
        String nume = t1.getText();
        String prenume = t2.getText();
        angajat.setNume(nume);
        angajat.setPrenume(prenume);
        AngajatService.getInstance().modificaAngajat(angajat);
        dispose();
    }

    private void setValuesOnComponents() {
       t1.setText(angajat.getNume());
       t2.setText(angajat.getPrenume());
    }
}
