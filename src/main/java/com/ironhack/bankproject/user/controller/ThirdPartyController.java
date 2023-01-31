package com.ironhack.bankproject.user.controller;

import com.ironhack.bankproject.user.dto.ThirdPartyDTO;
import com.ironhack.bankproject.user.model.ThirdParty;
import com.ironhack.bankproject.user.service.ThirdPartyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("AdminAcces(ThirdParty")
@RequiredArgsConstructor
public class ThirdPartyController {
    private final ThirdPartyService thirdPartyService;

    @GetMapping("FindAll")
    public List<ThirdParty> findAll() {
        return thirdPartyService.findAll();
    }

    @PostMapping("Create")
    public ThirdPartyDTO create(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.create(thirdPartyDTO);
    }

    @PutMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public ThirdPartyDTO updatePutMethod(@RequestBody @Valid ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.update(thirdPartyDTO);
    }

    @PatchMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public ThirdPartyDTO updatePatchMethod(ThirdPartyDTO thirdPartyDTO) {
        return thirdPartyService.updatePatchMethod(thirdPartyDTO);
    }

    @DeleteMapping("Delete")
    public void delete(ThirdPartyDTO thirdPartyDTO){
        thirdPartyService.delete(thirdPartyDTO);
    }
}