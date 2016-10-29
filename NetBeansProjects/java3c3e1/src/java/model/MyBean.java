
package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyBean implements Serializable{
    
    private String text;
    
    public MyBean(){
        this.text = "Hello from MyBean!";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
}
