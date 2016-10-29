/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicatie1;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Stefan
 */
public class FereastraPrincipala extends  JFrame{

    public Icon img = new ImageIcon(FereastraPrincipala.class.getResource("animal.jpg"));
    public JButton b = new JButton("Button", img);
    
    public FereastraPrincipala(String titlu) throws HeadlessException {
            super(titlu);
           // getContentPane().add(b);
           JMenuBar mb = new JMenuBar();
           JMenu m1 = new JMenu("File");
           JMenu m2 = new JMenu("Submeniu File");
           
           this.setJMenuBar(mb);
           mb.add(m1);
          // mb.add(m2);
          m1.add(m2);
          
          JTextArea txtArea = new JTextArea("Hello, World\n", 20, 20);
            txtArea.append("Goodbye Cruel World\n");
            JScrollPane scrollPane = new JScrollPane(txtArea);
            this.add(scrollPane, BorderLayout.CENTER);
            pack();
            JCheckBoxMenuItem fd = new JCheckBoxMenuItem();
     
             JOptionPane.showInputDialog(txtArea);
           // this.setLayout(new FlowLayout());
            
            
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   b.setText("maimutica");
                }
            });
            
    }
    
    
}
