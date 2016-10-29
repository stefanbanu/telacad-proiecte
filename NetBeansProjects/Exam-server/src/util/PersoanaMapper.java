/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import dto.PersoaneDTO;
import dto.UserDTO;
import model.PersoaneDB;
import model.UtilizatoriDB;

/**
 *
 * @author student
 */
public class PersoanaMapper {
     public static PersoaneDTO convert(PersoaneDB pDB){
        PersoaneDTO uDto = new PersoaneDTO();
        uDto.setId(pDB.getId());
        uDto.setNume(pDB.getNume());
        uDto.setPrenume(pDB.getPrenume());
        uDto.setCnp(pDB.getCnp());
        
        return uDto;
    }
    
  public static PersoaneDB convert(PersoaneDTO pDto){
        PersoaneDB uDto = new PersoaneDB();
        uDto.setId(pDto.getId());
        uDto.setNume(pDto.getNume());
        uDto.setPrenume(pDto.getPrenume());
        uDto.setCnp(pDto.getCnp());
        
        return uDto;
    }
}
