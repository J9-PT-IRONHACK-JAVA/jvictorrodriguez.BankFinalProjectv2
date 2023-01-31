package com.ironhack.bankproject.user.controller;

import com.ironhack.bankproject.user.dto.AdminDTO;
import com.ironhack.bankproject.user.model.Admin;
import com.ironhack.bankproject.user.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminAccess/Admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("FindAll")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @PostMapping("Create")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminDTO create(@RequestBody @Valid AdminDTO adminDTO){
        return adminService.create(adminDTO);
    }

    @PutMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public AdminDTO updatePutMethod(@RequestBody @Valid AdminDTO adminDTO){
        return adminService.update(adminDTO);
    }
    @PatchMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public AdminDTO updatePatchMethod(@RequestBody AdminDTO adminDTO){
        return adminService.updatePatchMethod(adminDTO);
    }

    @DeleteMapping("Delete")
    public void delete(@RequestBody AdminDTO adminDTO){
        adminService.delete(adminDTO);
    }
}
