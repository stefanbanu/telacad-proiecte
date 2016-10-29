/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dto.ProdusDTO;
import model.ProduseDB;

/**
 *
 * @author Stefan
 */
public class ProdusMapper {
    
    public static ProdusDTO convert(ProduseDB pDb){
        ProdusDTO p = new ProdusDTO();
        p.setId(pDb.getId());
        p.setNume(pDb.getProdus());
        
        return p;
    }
    
    public static ProduseDB convert(ProdusDTO pDto){
        ProduseDB p = new ProduseDB();
        p.setId(pDto.getId());
        p.setProdus(pDto.getNume());
        
        return p;
    }
}
