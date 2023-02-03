package com.ironhack.bankproject.account.controller;

import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.model.Account;
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
    public Account create(@RequestBody @Valid AccountDTO accountDTO){
        return accountService.create(accountDTO);
    }
    @PatchMapping("Freeze")
    public Account freezeAccount(@RequestBody @Valid AccountDTO accountDTO){
        return accountService.freezeAccount(accountDTO);
    }
    @PatchMapping("Active")
    public Account activeAccount(@RequestBody @Valid AccountDTO accountDTO){
        return accountService.activeAccount(accountDTO);
    }
    @DeleteMapping("Delete")
    public void delete(@RequestBody AccountDTO accountDTO){
        accountService.delete(accountDTO);
    }
}
