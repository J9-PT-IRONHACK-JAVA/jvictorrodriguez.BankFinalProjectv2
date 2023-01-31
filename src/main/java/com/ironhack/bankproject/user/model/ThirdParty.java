package com.ironhack.bankproject.user.model;

import com.ironhack.bankproject.user.dto.ThirdPartyDTO;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class ThirdParty extends User{
   private String hashedKey;
   private String name;

    public ThirdParty(String username, String password, String roles,
                      String hashedKey, String name) {
        super(username, password, roles);
        this.hashedKey = hashedKey;
        this.name = name;
    }
    public static ThirdParty fromThirdParty(ThirdPartyDTO thirdPartyDTO){
        var thirdParty= new ThirdParty();
        thirdParty.setUsername(thirdPartyDTO.getUsername());
        thirdParty.setPassword(thirdPartyDTO.getPassword());
        thirdParty.setName(thirdPartyDTO.getName());
        thirdParty.setHashedKey(thirdPartyDTO.getHashedKey());
        thirdParty.setId(thirdParty.getId());
        return thirdParty;
    }
}
