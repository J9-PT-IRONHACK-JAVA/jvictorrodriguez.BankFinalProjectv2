package com.ironhack.bankproject.account.dto;

import com.ironhack.bankproject.account.enums.AccountType;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.model.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
 private Set<CustomerDTO> customers;
 @Enumerated (EnumType.STRING)
 private AccountType accountType;
 private double interestRate;
 private String creditLimit;
 private String minimumBalance;
 private Long id;

 public static AccountDTO fromAccount(Account account){
  var accountDTO=new AccountDTO();
  accountDTO.setId(accountDTO.getId());
  return accountDTO;
 }

}
