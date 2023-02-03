package com.ironhack.bankproject.transaction.controller;

import com.ironhack.bankproject.transaction.Transfer;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
import com.ironhack.bankproject.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    @GetMapping("/transfer")
    public Transfer sendMoney (TransferDTO transferDTO){
        return transactionService.sendMoney(transferDTO);
    }
}
