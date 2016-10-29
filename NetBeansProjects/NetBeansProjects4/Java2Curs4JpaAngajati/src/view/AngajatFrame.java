/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.AngajatDB;
import service.AngajatService;

/**
 *
 * @author student
 */
public class AngajatFrame extends JFrame {

    private JPanel p1;
    private JScrollPane p2;
    private JLabel e1;
    private JLabel e2;
    private JTextField t1;
    private JTextField t2;
    private JButton b1;

    private DefaultListModel<AngajatDB> model;
    private JList<AngajatDB> list;
    
    private JPopupMenu menu;
    private JMenuItem mi1;

    public AngajatFrame() {
        super("Angajati");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        assambleLayout();
        registerEvents();
        afisareAngajati();

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));

        model = new DefaultListModel<>();
        list = new JList<>();
        list.setModel(model);
        
        p2 = new JScrollPane(list);

        e1 = new JLabel("NUME:");
        e2 = new JLabel("PRENUME:");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        b1 = new JButton("ADAUGA");
        
        menu = new JPopupMenu();
        mi1 = new JMenuItem("MODIFICA ANGAJAT");
        menu.add(mi1);
    }

    private void assambleLayout() {
        add(p2);
        add(p1, BorderLayout.SOUTH);

        p1.add(e1);
        p1.add(t1);
        p1.add(e2);
        p1.add(t2);
        p1.add(b1);
    }

    private void registerEvents() {
        b1.addActionListener(ev -> adaugaAngajat());
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                if(ev.getButton() == MouseEvent.BUTTON1 && 
                   ev.getClickCount() == 2){
                    stergeAngajat();
                }
                
                if(ev.getButton() == MouseEvent.BUTTON3){
                    if(list.getSelectedIndex() > 0){
                        menu.show(list, ev.getX(), ev.getY());
                    }
                }
            }

        });
        mi1.addActionListener(ev -> modificaAngajat());
    }
    
    private void modificaAngajat(){
        AngajatDB a = list.getSelectedValue();
        new ModifcareAngajatDialog(this, a);
    }

    private void stergeAngajat() {
        AngajatDB a = list.getSelectedValue();
        AngajatService.getInstance().stergeAngajat(a);
        afisareAngajati();
    }

    private void adaugaAngajat() {
        String nume = t1.getText();
        String prenume = t2.getText();
        AngajatService.getInstance().adaugaAngajat(nume, prenume);
        afisareAngajati();
        JOptionPane.showMessageDialog(this, "A fost adaugat angajatul!");
    }

    private void afisareAngajati() {
        List<AngajatDB> angajati = AngajatService.getInstance().getAngajati();
        model.clear();
        angajati.stream().forEach(a -> model.addElement(a));
    }
}
