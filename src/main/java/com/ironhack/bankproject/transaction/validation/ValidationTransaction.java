package com.ironhack.bankproject.transaction.validation;

import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.transaction.dto.TransferDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class ValidationTransaction {

    private final AccountRepository accountRepository;

    public void checksAccountExist(TransferDTO transferDTO){
        //Checks if accounts exist
//        transferDTO.getAccountTo()
//        transferDTO.getAccountFrom()

    }

    public Account findAccountById(Long id){
        return null;
    }

}
