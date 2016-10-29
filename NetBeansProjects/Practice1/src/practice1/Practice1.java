
package practice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Practice1 {
static Statement stmt;

    public static void main(String[] args) {
        
         try{
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/test2";
            Connection con = DriverManager.getConnection(url, user, password);
            
            stmt = con.createStatement();
            //String sql = "INSERT INTO clienti VALUES (NULL,'Gigel','Pop')";
            
            //stmt.execute(sql);
           //stmt.execute
            System.out.println("A fost facut conexiunea");
        }catch(SQLException e){
            e.printStackTrace();
        }
         
        new Fereastra("", stmt);
    }
    
}
