package com.ironhack.bankproject.transaction.validation;

import com.ironhack.bankproject.account.enums.Status;
import com.ironhack.bankproject.account.exceptions.*;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.security.JpaUserDetailsService;
import com.ironhack.bankproject.transaction.dto.TransactionDTO;
import com.ironhack.bankproject.transaction.enums.TransactionType;
import com.ironhack.bankproject.user.model.Customer;
import lombok.Data;

import lombok.RequiredArgsConstructor;
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

    public void checkForTransfer(TransactionDTO transactionDTO) {
        checksAccountExist(transactionDTO);
        checksPositiveAmount(transactionDTO);
        checksCustomerAccount(transactionDTO);
        checksSenderAccountBalance(transactionDTO);
//todo         var userInfo=jpaUserDetailsService.loadUserByUsername();
       // System.out.println("UserInfo==========="+ userInfo);
        //checksPassword(transferDTO);
    }

    public void checkForCash(TransactionDTO transactionDTO){
        checksAccountExist(transactionDTO.getAccountFrom());
        checksPositiveAmount(transactionDTO);
        checksCustomerAccount(transactionDTO);
    }

    public void checksAccountExist(Long id) {
        //Checks if accounts exist and they are different
        findAccountById(id);

    }
//    public void checksPositiveAmount(BigDecimal amount) {
//        //Checks if the amount is positive
//        if (!(amount.compareTo(BigDecimal.ZERO) > 0))
//            throw new AmountNotPositiveException();
//    }


    public void checksAccountExist(TransactionDTO transactionDTO) {
        //Checks if accounts exist and they are different
        var accountFromId = transactionDTO.getAccountFrom();
        var accountToId = transactionDTO.getAccountTo();
        if (Objects.equals(accountFromId, accountToId)) throw new BothAccountAreEqualsException();

        findAccountById(accountFromId);
        findAccountById(accountToId);
    }


    public void checksPositiveAmount(TransactionDTO transactionDTO) {
        //Checks if the amount is positive
        var amount = transactionDTO.getAmount().getAmount();
        if (!(amount.compareTo(BigDecimal.ZERO) > 0))
            throw new AmountNotPositiveException();
    }

    public void checksCustomerAccount(TransactionDTO transactionDTO) {
        //Check senders account
        var senderAccount = accountRepository.findById(transactionDTO.getAccountFrom()).orElseThrow();

        //Check if the account belongs to the accountHolder
        var ownerList = senderAccount.getOwners();
        boolean accountBelongsToSender = false;
        for (Customer customer : ownerList) {
            if (customer.getDni().equalsIgnoreCase((transactionDTO.getSenderId()))) {
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
        if (transactionDTO.getTransactionType()== TransactionType.TRANSFER) {

            var targetAccount = accountRepository.findById(transactionDTO.getAccountTo()).orElseThrow();
            var statusTargetAccount = targetAccount.getStatus();
            if (statusTargetAccount == Status.FROZEN)
                throw new AccountNotActiveException("Target");
        }

    }

    public void checksSenderAccountBalance(TransactionDTO transactionDTO) {
        var amountToTransfer = transactionDTO.getAmount().getAmount();
        var senderAccount = findAccountById(transactionDTO.getAccountFrom());
        var senderAccountBalance = senderAccount.getBalance().getAmount();
        if (!(senderAccountBalance.compareTo(amountToTransfer) > 0)) {
            throw new InsufficientBalanceException();
        }
    }
}
