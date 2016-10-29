/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.exceptions;

/**
 *
 * @author Laur
 */
public class ExisentUserException extends Exception{
    public ExisentUserException(){
        super("User existent");
    }
}
