package com.ironhack.bankproject.transaction.service;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.transaction.dto.CashDTO;
import com.ironhack.bankproject.transaction.model.Cash;
import com.ironhack.bankproject.transaction.model.Transfer;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
import com.ironhack.bankproject.transaction.repository.TransactionRepository;
import com.ironhack.bankproject.transaction.validation.ValidationTransaction;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final ValidationTransaction validationTransaction;


    public Transfer sendMoney(TransferDTO transferDTO) {
        //Checks all the data
        validationTransaction.checkAll(transferDTO);
        //Creates the Transfer
        var newTransfer = new Transfer();
        newTransfer.setAccountFrom(transferDTO.getAccountFrom());
        newTransfer.setAccountTo(transferDTO.getAccountTo());
        newTransfer.setAmount(transferDTO.getAmount());
        newTransfer.setSenderId(transferDTO.getSenderId());
        newTransfer.setSenderName(getSendersName(transferDTO.getSenderId()));
        newTransfer.setTargetName(transferDTO.getTargetName());
        newTransfer.setObservations(transferDTO.getObservations());
        moveTheMoney(transferDTO);
        return transactionRepository.save(newTransfer);
    }




    @Transactional
    public void moveTheMoney(TransferDTO transferDTO) {
       var accountSender=validationTransaction.findAccountById(transferDTO.getAccountFrom());
       var accountTarget=validationTransaction.findAccountById( transferDTO.getAccountTo());
       accountSender.setBalance(new Money(accountSender.getBalance().decreaseAmount(transferDTO.getAmount())));
       accountTarget.setBalance(new Money(accountTarget.getBalance().increaseAmount(transferDTO.getAmount())));
    }

    @Transactional
    public void moveTheMoney(CashDTO cashDTO) {
        var accountSender=validationTransaction.findAccountById(cashDTO.getAccountFrom());
        accountSender.setBalance(new Money(accountSender.getBalance().decreaseAmount(cashDTO.getAmount())));
    }
    public String getSendersName(String id) {
        var sender = customerRepository.findByDni(id).orElseThrow();
        return sender.getName();
    }

    public Cash depositWithdraw(CashDTO cashDTO) {

        var cash= new Cash();
        cash.setAccountFrom(cash.getAccountFrom());
        cash.setAmount(cashDTO.getAmount());
        cash.setTransactionType(cashDTO.getTransactionType());
        moveTheMoney(cashDTO);
        return transactionRepository.save(cash);
    }
}
