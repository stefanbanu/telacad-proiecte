/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.sql.ResultSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class Model extends AbstractTableModel{
    
    private String[] columnNames = {"ID", "Nume"};
    private Object[][] data;

    public Model(ResultSet rs) throws Exception{

        int n = 0;
        while (rs.next()) {            
            n++;
           
        }
         int r = 0;
        data = new Object[n][2];
        rs.beforeFirst();
        while (rs.next()) {            
            data[r][0] = rs.getString("id");
            data[r][1] = rs.getString("nume");
            r++;
        }
    }
    
    public Object getValueAt(int rand, int col){
        return data[rand][col];
    }
    
    public void setValueAt(Object o, int rand, int col){
        data[rand][col]=o;
    }
    public int getColumnCount(){return columnNames.length;}
    public int getRowCount() {return data.length;}
    
}
