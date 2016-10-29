/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import lib.dto.ProduseDTO;
import lib.dto.UserDTO;
import model.ProduseDB;
import model.UsersDB;

/**
 *
 * @author Stefan
 */
public class UsersMapper {
    public static UserDTO convert(UsersDB uDB){
        UserDTO uDto = new UserDTO();
        uDto.setId(uDB.getId());
        uDto.setUsername(uDB.getUsername());
        uDto.setPassword(uDB.getPassword());
        
        return uDto;
    }
    
     public static UsersDB convert(UserDTO uDto){
        UsersDB uDB = new UsersDB();
        uDB.setId(uDto.getId());
        uDB.setUsername(uDto.getUsername());
        uDB.setPassword(uDto.getPassword());
        
        return uDB;
    }
}
