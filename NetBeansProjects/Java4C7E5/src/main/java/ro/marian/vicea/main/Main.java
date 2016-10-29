package ro.marian.vicea.main;

import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        
        String method = "http://localhost:8080/cat";
        Pisica p = restTemplate.getForObject(method, Pisica.class);
        
        System.out.println(p.getNume() + " " + p.getCuloare());
    }
}
