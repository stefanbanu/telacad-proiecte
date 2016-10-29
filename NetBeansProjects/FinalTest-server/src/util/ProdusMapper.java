/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import lib.dto.ProduseDTO;
import model.ProduseDB;

/**
 *
 * @author Stefan
 */
public class ProdusMapper {
    public static ProduseDTO convert(ProduseDB pDB){
        ProduseDTO pDto = new ProduseDTO();
        pDto.setId(pDB.getId());
        pDto.setNume(pDB.getProdus());
        
        return pDto;
    }
    
     public static ProduseDB convert(ProduseDTO pDto){
        ProduseDB pDB = new ProduseDB();
        pDB.setId(pDto.getId());
        pDB.setProdus(pDto.getNume());
        
        return pDB;
    }
}
