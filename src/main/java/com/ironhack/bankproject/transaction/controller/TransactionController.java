package com.ironhack.bankproject.transaction.controller;

import com.ironhack.bankproject.transaction.dto.CashDTO;
import com.ironhack.bankproject.transaction.model.Cash;
import com.ironhack.bankproject.transaction.model.Transfer;
import com.ironhack.bankproject.transaction.dto.TransactionDTO;
import com.ironhack.bankproject.transaction.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public Transfer sendMoney(@RequestBody @Valid TransactionDTO transactionDTO) {
        return transactionService.sendMoney(transactionDTO);
    }

    @PostMapping("/cash")
    public Cash depositWithdraw(@RequestBody @Valid TransactionDTO transactionDTO) {
        return transactionService.depositWithdraw(transactionDTO);
    }
}
