package controllers;

import beans.Card;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Stefan
 */
public class Controller {

    private Connection con;
    private Statement st;
    // private static Controller controller = null;

    private Controller() {
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost/java2curs2", "root", "");
            st = con.createStatement();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static final class SingletonHolder {
        private static final Controller SINGLETON = new Controller();
    }
    
    public static Controller getInstance(){
        return SingletonHolder.SINGLETON;
    }

   public void adugaCard(Card c){
       try {
           st.executeUpdate("INSERT INTO `carduri` VALUES (NULL, '" + c.getIban() + "', " + c.getAmount() + ", 1)");
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
       }
   }
}
