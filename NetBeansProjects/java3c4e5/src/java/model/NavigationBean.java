package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author student
 */
@ManagedBean
@RequestScoped
public class NavigationBean implements java.io.Serializable{
    
    public String goToPage1(){
        System.out.println("Going to page 1");
        return "unu";
    }
    
    public String goToPage2(){
        System.out.println("Going to page 2");
        return "doi";
    }
}
