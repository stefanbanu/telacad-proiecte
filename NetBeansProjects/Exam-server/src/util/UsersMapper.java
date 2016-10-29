/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import dto.UserDTO;
import model.UtilizatoriDB;

/**
 *
 * @author Stefan
 */
public class UsersMapper {
    public static UserDTO convert(UtilizatoriDB uDB){
        UserDTO uDto = new UserDTO();
        uDto.setId(uDB.getId());
        uDto.setUser(uDB.getUser());
        uDto.setParola(uDB.getParola());
        
        return uDto;
    }
    
     public static UtilizatoriDB convert(UserDTO uDto){
        UtilizatoriDB uDB = new UtilizatoriDB();
        uDB.setId(uDto.getId());
        uDB.setUser(uDto.getUser());
        uDB.setParola(uDto.getParola());
        
        return uDB;
    }
}
