package com.ironhack.bankproject.user.service;

import com.ironhack.bankproject.user.dto.AdminDTO;
import com.ironhack.bankproject.user.exception.UserAlredyExistsException;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import com.ironhack.bankproject.user.model.Admin;
import com.ironhack.bankproject.user.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public AdminDTO create(AdminDTO adminDTO){
        var adminNew= adminRepository.save(Admin.fromDTO(adminDTO));
        return AdminDTO.fromAdmin(adminNew);
    }

    public AdminDTO update(AdminDTO adminDTO) {
        //Looks for the user by username. if it doesn't exist throws an exception
        //else updates all 4 attributes
        var adminToUpdate =findByUsername(adminDTO.getUsername());
        adminToUpdate.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminToUpdate.setName(adminToUpdate.getName());
        adminToUpdate.setEmail(adminToUpdate.getEmail());
        adminToUpdate.setRoles(adminToUpdate.getRoles());
        adminToUpdate=adminRepository.save(adminToUpdate);
        return AdminDTO.fromAdmin(adminToUpdate);
    }


    public AdminDTO updatePatchMethod(AdminDTO adminDTO) {
        var adminToUpdate =findByUsername(adminDTO.getUsername());
        if(!adminDTO.getRoles().isEmpty()){
            adminToUpdate.setRoles(adminDTO.getRoles());
        }
        if (!adminDTO.getEmail().isEmpty()){
            adminToUpdate.setEmail(adminDTO.getEmail());
        }
        if(!adminDTO.getName().isEmpty()){
            adminToUpdate.setName(adminDTO.getName());
        }
        if(!adminDTO.getPassword().isEmpty()){
            adminToUpdate.setPassword(passwordEncoder.encode(adminDTO.getPassword()));}
        return AdminDTO.fromAdmin(adminToUpdate);
    }


    public void delete(AdminDTO adminDTO) {
              adminRepository.deleteById(adminDTO.getId());
    }

    private Admin findByUsername(String username){
        return adminRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }

}
