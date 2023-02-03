package com.ironhack.bankproject.transaction.validation;

import com.ironhack.bankproject.account.enums.Status;
import com.ironhack.bankproject.account.exceptions.*;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.security.JpaUserDetailsService;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
import com.ironhack.bankproject.user.model.Customer;
import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Service
@RequiredArgsConstructor
public class ValidationTransaction {

    private final AccountRepository accountRepository;
    private final JpaUserDetailsService jpaUserDetailsService;



    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountIdNotFoundException(id));
    }

    public void checkAll(TransferDTO transferDTO) {
        checksAccountExist(transferDTO);
        checksAmount(transferDTO);
        checksCustomerAccount(transferDTO);
        checksSenderAccountBalance(transferDTO);
//todo         var userInfo=jpaUserDetailsService.loadUserByUsername();
       // System.out.println("UserInfo==========="+ userInfo);
        //checksPassword(transferDTO);

    }


    public void checksAccountExist(TransferDTO transferDTO) {
        //Checks if accounts exist and they are different
        var accountFromId = transferDTO.getAccountFrom();
        var accountToId = transferDTO.getAccountTo();
        if (Objects.equals(accountFromId, accountToId)) throw new BothAccountAreEqualsException();

        findAccountById(accountFromId);
        findAccountById(accountToId);
    }

    public void checksAmount(TransferDTO transferDTO) {
        //Checks if the amount is positive
        var amount = transferDTO.getAmount().getAmount();
        if (!(amount.compareTo(BigDecimal.ZERO) > 0))
            throw new AmountNotPositiveException();
    }

    public void checksCustomerAccount(TransferDTO transferDTO) {
        //Check senders account
        var senderAccount = accountRepository.findById(transferDTO.getAccountFrom()).orElseThrow();

        //Check if the account belongs to the accountHolder
        var ownerList = senderAccount.getOwners();
        boolean accountBelongsToSender = false;
        for (Customer customer : ownerList) {
            if (customer.getDni().equalsIgnoreCase((transferDTO.getSenderId()))) {
                accountBelongsToSender = true;
                break;
            }
        }
        if (!accountBelongsToSender) throw new AccountNotBelongsToSenderException();

        //Checks if the account is Active
        var statusSenderAccount = senderAccount.getStatus();
        if (statusSenderAccount == Status.FROZEN)
            throw new AccountNotActiveException("Sender");

        //Check target account
        var targetAccount = accountRepository.findById(transferDTO.getAccountTo()).orElseThrow();
        var statusTargetAccount = targetAccount.getStatus();
        if (statusTargetAccount == Status.FROZEN)
            throw new AccountNotActiveException("Target");
    }

    public void checksSenderAccountBalance(TransferDTO transferDTO) {
        var amountToTransfer = transferDTO.getAmount().getAmount();
        var senderAccount = findAccountById(transferDTO.getAccountFrom());
        var senderAccountBalance = senderAccount.getBalance().getAmount();
        if (!(senderAccountBalance.compareTo(amountToTransfer) > 0)) {
            throw new InsufficientBalanceException();
        }
    }
}
