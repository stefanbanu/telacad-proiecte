package ro.marian.vicea.main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {
    
    @RequestMapping("/cat")
    public Pisica getPisica(@RequestParam(value="name", defaultValue="Tom") String name) {
        Pisica p = new Pisica();
        
        p.setNume(name);
        p.setCuloare("albastru cu alb");
        
        return p;
    }
}
