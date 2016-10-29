/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Stefan
 */
public class Fereastra extends JFrame{
    
    Model model;
    JTable table;
    JScrollPane scroll;
    JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JButton b = new JButton("Sterge");
    Statement statement;

    public Fereastra(String text, Statement s) throws Exception {
    
        this.statement = s;
        ResultSet rs = s.executeQuery("SELECT * FROM 'javacurs'");
        model = new Model(rs);
        table = new JTable(model);
        scroll = new JScrollPane(table);
        
        add(scroll);
        add(p, BorderLayout.SOUTH);
        p.add(b);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                try {
                    int[] randuri = table.getSelectedRows();
                    for (int i = 0; i < randuri.length; i++) {
                        String id = (String)table.getValueAt(i, 0);
                        String query = "DELETE FROM 'javacurs' WHERE 'id'=" + id;
                        statement.executeUpdate(query);
                    }
                    ResultSet res = statement.executeQuery("SELECT * FROM 'javacurs'");
                    refreshModel(res);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    public void refreshModel(ResultSet rs)throws  Exception{
        model = new Model(rs);
        table.setModel(model);
    }
}
