package com.ironhack.bankproject.account.dto;

import com.ironhack.bankproject.account.enums.AccountType;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.model.CheckingAccount;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
 private List<CustomerDTO> customerDTOList;
 @Enumerated (EnumType.STRING)
 private AccountType accountType;
 private double interestRate;
 private String creditLimit;
 private String minimumBalance;

 public static CheckingAccount fromAccount(Account account){
  var accountDTO=new CheckingAccount();
  accountDTO.setDescription("CheckingAccount");
  return accountDTO;
 }
}
