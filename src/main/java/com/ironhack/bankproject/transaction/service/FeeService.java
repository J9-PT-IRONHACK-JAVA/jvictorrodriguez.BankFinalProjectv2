package com.ironhack.bankproject.transaction.service;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.transaction.dto.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class FeeService {

    private final AccountRepository accountRepository;

    public Money doIApplyFee(TransactionDTO transactionDTO) {
        var appliedFee = new Money(BigDecimal.ZERO);
        var accountId = transactionDTO.getAccountFrom();
        var optionalAccount = accountRepository.findById(accountId);
        var amountTransaction = transactionDTO.getAmount();


        if (optionalAccount.isPresent()) {
            var fee = optionalAccount.get().getPenaltyFee();
            var accountMinimumBalance = optionalAccount.get().getMinimumBalance();
            var accountBalance = optionalAccount.get().getBalance();
            var balanceAfterTransaction = optionalAccount.get().getBalance().decreaseAmount(amountTransaction);

            if (balanceAfterTransaction.compareTo(accountMinimumBalance.getAmount()) < 0) {
                appliedFee = fee;
            }

        }
        return appliedFee;
    }
}
