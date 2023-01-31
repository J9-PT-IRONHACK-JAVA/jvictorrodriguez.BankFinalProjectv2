package com.ironhack.bankproject.user.service;

import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.dto.ThirdPartyDTO;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import com.ironhack.bankproject.user.model.ThirdParty;
import com.ironhack.bankproject.user.repository.ThirdPartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThirdPartyService {
    private final ThirdPartyRepository thirdPartyRepository;

    public List<ThirdParty> findAll() {
        return thirdPartyRepository.findAll();
    }

    public void save(ThirdParty fromThirdParty) {
    }

    public ThirdPartyDTO create(ThirdPartyDTO thirdPartyDTO) {
        var thirdPartyNew= thirdPartyRepository.save(ThirdParty.fromThirdParty(thirdPartyDTO));
        return ThirdPartyDTO.fromThirdParty(thirdPartyNew);
    }

    public ThirdPartyDTO update(ThirdPartyDTO thirdPartyDTO){
        //Looks for the user by username. if it doesn't exist throws an exception
        //else updates all 5 attributes
        var thirdPartyToUpdate = findByUserName(thirdPartyDTO.getUsername());
        thirdPartyToUpdate.setPassword(thirdPartyDTO.getPassword());
        thirdPartyToUpdate.setName(thirdPartyDTO.getName());
        thirdPartyToUpdate.setHashedKey(thirdPartyDTO.getHashedKey());
        thirdPartyRepository.save(thirdPartyToUpdate);
        return ThirdPartyDTO.fromThirdParty(thirdPartyToUpdate);
    }

    public ThirdPartyDTO updatePatchMethod(ThirdPartyDTO thirdPartyDTO){
        var thirdPartyToUpdate= findByUserName(thirdPartyDTO.getUsername());
        if(!thirdPartyDTO.getRoles().isEmpty()){
            thirdPartyToUpdate.setRoles(thirdPartyDTO.getRoles());
        }
        if(!thirdPartyDTO.getName().isEmpty()){
            thirdPartyToUpdate.setName(thirdPartyDTO.getName());
        }
        if(!thirdPartyDTO.getPassword().isEmpty()){
            thirdPartyToUpdate.setPassword(thirdPartyDTO.getPassword());}
        return ThirdPartyDTO.fromThirdParty(thirdPartyToUpdate);
    }


    public void delete(ThirdPartyDTO thirdPartyDTO) {
        thirdPartyRepository.deleteById(thirdPartyDTO.getId());
    }

    private ThirdParty findByUserName(String username) {
        return thirdPartyRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }
}
