/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concreteclasses;

import obspattern.Observer;
import obspattern.Subject;

/**
 *
 * @author Stefan
 */
public class WeatherData implements  Subject{
    
    public int getTemperature(){
        return 3;
    }
    
    public int getHumidity(){
        return 10;
    }
    public int getPressure(){
        return 90;
    }

    @Override
    public void addObserver(obspattern.Observer o) {
        
    }

    @Override
    public void removeObserver(Observer o) {
        
    }

    @Override
    public void notifyObservers() {
        
    }
    
    public void measurementsChanged(){
        
    }
}
