package com.ironhack.bankproject.user.repository;

import com.ironhack.bankproject.user.model.Admin;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByUsername(String username);
}
