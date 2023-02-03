package com.ironhack.bankproject.transaction.service;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.transaction.enums.TransactionType;
import com.ironhack.bankproject.transaction.model.Cash;
import com.ironhack.bankproject.transaction.model.Transfer;
import com.ironhack.bankproject.transaction.dto.TransactionDTO;
import com.ironhack.bankproject.transaction.repository.TransactionRepository;
import com.ironhack.bankproject.transaction.validation.ValidationTransaction;
import com.ironhack.bankproject.user.model.User;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import com.ironhack.bankproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final ValidationTransaction validationTransaction;
    private final FeeService feeService;


    public Transfer sendMoney(TransactionDTO transactionDTO) {
        //Checks all the data for the transaction
        validationTransaction.checkForTransfer(transactionDTO);
        //Obtains the applicable fee
        Money applyFee = feeService.doIApplyFee(transactionDTO);
        if (!(applyFee.getAmount().compareTo(BigDecimal.ZERO)==0)){
            applyFees(transactionDTO,applyFee);
        }
        //Creates the Transfer
        var newTransfer = new Transfer();
        newTransfer.setAccountFrom(transactionDTO.getAccountFrom());
        newTransfer.setAccountTo(transactionDTO.getAccountTo());
        newTransfer.setAmount(transactionDTO.getAmount());
        newTransfer.setSenderId(transactionDTO.getSenderId());
        newTransfer.setSenderName(getSendersName(transactionDTO.getSenderId()));
        newTransfer.setTargetName(transactionDTO.getTargetName());
        newTransfer.setObservations(transactionDTO.getObservations());
        moveTheMoney(transactionDTO);
        return transactionRepository.save(newTransfer);
    }
    public Cash depositWithdraw(TransactionDTO transactionDTO) {
        //Obtains the applicable fee

        var cash = new Cash();
        cash.setAccountFrom(cash.getAccountFrom());
        cash.setAmount(transactionDTO.getAmount());
        cash.setTransactionType(transactionDTO.getTransactionType());
        validationTransaction.checkForTransfer(transactionDTO);
        if (transactionDTO.getTransactionType() == TransactionType.WITHDRAW) {
            Money applyFee = feeService.doIApplyFee(transactionDTO);
            if (!(applyFee.getAmount().compareTo(BigDecimal.ZERO)==0)){
                applyFees(transactionDTO,applyFee);
            }
        }
        moveTheCash(transactionDTO);
        return transactionRepository.save(cash);
    }



    @Transactional
    public void moveTheMoney(TransactionDTO transactionDTO) {
        var accountSender = validationTransaction.findAccountById(transactionDTO.getAccountFrom());
        var accountTarget = validationTransaction.findAccountById(transactionDTO.getAccountTo());
        accountSender.setBalance(new Money(accountSender.getBalance().decreaseAmount(transactionDTO.getAmount())));
        accountTarget.setBalance(new Money(accountTarget.getBalance().increaseAmount(transactionDTO.getAmount())));
    }

    public void moveTheCash(TransactionDTO transactionDTO) {
        var accountSender = validationTransaction.findAccountById(transactionDTO.getAccountFrom());
        accountSender.setBalance(new Money(accountSender.getBalance().decreaseAmount(transactionDTO.getAmount())));
    }

    public void applyFees(TransactionDTO transactionDTO,Money fees) {
        var accountSender = validationTransaction.findAccountById(transactionDTO.getAccountFrom());
        accountSender.setBalance(new Money(accountSender.getBalance().decreaseAmount(fees)));
    }


    public String getSendersName(String id) {
        var sender = customerRepository.findByDni(id).orElseThrow();
        return sender.getName();
    }


}
