package com.ironhack.bankproject.account.controller;

import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.model.CheckingAccount;
import com.ironhack.bankproject.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminAcces/Account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/All")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @PostMapping("Create")
    public AccountDTO create(@RequestBody @Valid AccountDTO accountDTO){
        return accountService.create(accountDTO);
    }
}
