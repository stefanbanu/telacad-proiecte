package ro.marian.vicea.dao;

import org.springframework.stereotype.Repository;
import ro.marian.vicea.model.User;

@Repository
public class UserDao {
     public void adaugaUser(String username, String password){
         System.out.println("DAO: " + username + " " + password);
     }
     
     public User findUser(String username) {
         User user = new User();
         user.setUsername("gigel");
         user.setPassword("12345");
         return user;
     }
}
