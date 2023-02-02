package com.ironhack.bankproject.user.model;

import com.ironhack.bankproject.user.dto.ThirdPartyDTO;
import com.ironhack.bankproject.user.enums.Roles;
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

    public ThirdParty(String hashedKey, String name) {
        this.hashedKey = hashedKey;
        this.name = name;
        this.setRoles(Roles.THIRD_PARTY);
    }

    public static ThirdParty fromThirdParty(ThirdPartyDTO thirdPartyDTO){
        var thirdParty= new ThirdParty();

        thirdParty.setPassword(thirdPartyDTO.getPassword());
        thirdParty.setName(thirdPartyDTO.getName());
        thirdParty.setHashedKey(thirdPartyDTO.getHashedKey());
        thirdParty.setId(thirdParty.getId());
        return thirdParty;
    }
}
