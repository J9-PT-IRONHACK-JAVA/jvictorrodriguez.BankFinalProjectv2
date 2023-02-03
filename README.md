# Final Project: Iron Banking System

## Quick Start
### ACCOUNT

#### Entities
| Model              | Dto            |
|--------------------|----------------|
|                    | Customers      |
|                    | AccountType    |
| :interestRate:     | interesRate    |
|                    | creditLimit    |
| minimumBalance:    | minimumBalance |
|                    | id             |
| status:            | status         |
| description        |                |
| balance            |                |
| creationDate       |                |
| monthlyMaintenance |                |
| penaltieFee        |                |
|                    |                |
| Content Cell       |                |

#### Repository
#### Service
| MethodName | Parameters | Parameters |EndPoint     |
|--------- ---|-----------|----------- |-------------------------------------------------|
| findByAll:  | :Long id: |  :Long id: |http://localhost:8080/AdminAcces/Account/All --|
| findById:   | Long id   | -----------|                                              |


- findById(Long id)
- findAll()
  - create(AccountDTO accountDTO)
        -CheckingAccount
        -StudentAccount
        -SavingsAcount   
Model
- Account
- CheckingAccount
- CreditCard
- SavingAccount
- 
- StudentAccount

