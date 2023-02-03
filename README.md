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
|  MethodName | Parameters | verb | EndPoint                                         |
|------------:|:----------:|:----:|:-------------------------------------------------|
|   findByAll |            | GET  | http://localhost:8080/AdminAcces/Account/All --  |
|    findById |  Long id   | GET  |                                                  |


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

