package com.ironhack.bankproject.transaction.controller;

import com.ironhack.bankproject.transaction.model.Transfer;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
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
    public Transfer sendMoney (@RequestBody @Valid TransferDTO transferDTO){
        return transactionService.sendMoney(transferDTO);
    }
}
