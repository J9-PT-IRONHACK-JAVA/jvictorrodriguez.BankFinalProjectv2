package com.ironhack.bankproject.user.dto;

import com.ironhack.bankproject.user.enums.Roles;
import com.ironhack.bankproject.user.model.ThirdParty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ThirdPartyDTO {

    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Size(min = 6, max = 8, message = "Size between 6 and 8 characters")
    private String password;
    private Roles roles;
    private String name;
    private String hashedKey;
    private Long id;

    public ThirdPartyDTO() {
        this.roles=Roles.THIRD_PARTY;
    }

    public ThirdPartyDTO(String username, String password, String name, String hashedKey) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.hashedKey = hashedKey;
        this.roles=Roles.THIRD_PARTY;
    }
    public static ThirdPartyDTO fromThirdParty(ThirdParty thirdParty){
        var thirdPartyDTO= new ThirdPartyDTO();
        thirdPartyDTO.setUsername(thirdParty.getUsername());
        thirdPartyDTO.setPassword(thirdParty.getPassword());
        thirdPartyDTO.setName(thirdParty.getName());
        thirdPartyDTO.setHashedKey(thirdParty.getHashedKey());
        thirdPartyDTO.setId(thirdParty.getId());
        return thirdPartyDTO;
    }
}
