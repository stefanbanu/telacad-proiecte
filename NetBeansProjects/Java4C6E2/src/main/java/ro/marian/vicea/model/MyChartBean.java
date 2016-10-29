/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.marian.vicea.model;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.marian.vicea.service.PieService;

@ManagedBean
@Component
@RequestScoped
public class MyChartBean implements Serializable {
    private PieChartModel pie;
    
    @Autowired
    private PieService service;

    @PostConstruct
    public void init() {
        pie = new PieChartModel();
        pie.setData(service.getPieData());
        pie.setTitle("My first PrimeFaces pie :)");
        pie.setLegendPosition("w");
    }

    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }
}
