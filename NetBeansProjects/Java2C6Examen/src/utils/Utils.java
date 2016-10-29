/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public final class Utils {
    private Utils() {}
    
    public static String encryptPasswordMD5(String password) {
        StringBuilder result = new StringBuilder();
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] toBeDigested = password.getBytes();
            byte[] digested = md.digest(toBeDigested);
            
            for(int i = 0; i < digested.length; i++) {
                String charRes = Integer.toHexString(0xFF & digested[i]);
                result.append(charRes.length() == 1 ? "0" + charRes : charRes);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result.toString();
    }
}
