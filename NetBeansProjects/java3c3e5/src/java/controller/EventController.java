package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Eveniment;


@ManagedBean
@ViewScoped
public class EventController implements java.io.Serializable{
    private String currentName;
    private Date currentDate;
    private List<Eveniment> evenimente;
    
    @PostConstruct
    private void init(){
        evenimente = new ArrayList<>();
    }

    public List<Eveniment> getEvenimente() {
        return evenimente;
    }

    public void setEvenimente(List<Eveniment> evenimente) {
        this.evenimente = evenimente;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    public void adaugaEveniment(){
        Eveniment ev = new Eveniment();
        ev.setNume(currentName);
        ev.setData(currentDate);
        evenimente.add(ev);
        currentName = null;
        currentDate = null;
    }
}
