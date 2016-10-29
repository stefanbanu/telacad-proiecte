package server.util;

import lib.dto.ProduseDto;
import server.model.ProduseDB;

public class ProductMapper {
    public static ProduseDto convert(ProduseDB produs) {
        ProduseDto p = new ProduseDto();
        p.setId(produs.getId());
        p.setNume(produs.getNume());
        return p;
    }
    
    public static ProduseDB convert(ProduseDto produs) {
        ProduseDB p = new ProduseDB();
        p.setId(produs.getId());
        p.setNume(produs.getNume());
        return p;
    }
}
