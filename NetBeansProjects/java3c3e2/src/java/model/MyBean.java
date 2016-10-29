
package model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyBean implements java.io.Serializable{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public void afisareText(){
        System.out.println("TEXT: "+text);
    }
}
