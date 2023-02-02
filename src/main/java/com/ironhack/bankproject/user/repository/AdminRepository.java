package com.ironhack.bankproject.user.repository;

import com.ironhack.bankproject.user.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByEmail(String email);


}
