package com.ironhack.bankproject.transaction.service;

import com.ironhack.bankproject.transaction.Transfer;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
import com.ironhack.bankproject.transaction.repository.TransactionRepository;
import com.ironhack.bankproject.transaction.validation.ValidationTransaction;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final ValidationTransaction validationTransaction;

    //public Transfer findById
    public Transfer sendMoney(TransferDTO transferDTO) {


        var newTransfer = new Transfer();
        newTransfer.setAccountFrom(transferDTO.getAccountFrom());
        newTransfer.setAccountTo(transferDTO.getAccountTo());
        newTransfer.setAmount(transferDTO.getAmount());
        newTransfer.setSenderId(transferDTO.getSenderId());
        newTransfer.setSenderName(getSendersName(transferDTO.getSenderId()));
        newTransfer.setTargetName(transferDTO.getTargetName());
        newTransfer.setObservations(transferDTO.getObservations());
        return transactionRepository.save(newTransfer);
    }


    public String getSendersName(String id){
        var sender= customerRepository.findByDni(id).orElseThrow();
        return sender.getName();
    }
}
