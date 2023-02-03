# Final Project: Iron Banking System

## Quick Start
### ACCOUNT

#### Entities
| :Model:          | :Dto:          |
|------------------|----------------|
|                  | Customers      |
|                  | AccountType    |
| interestRate     | interestRate   |
|                  | creditLimit    |
| minimumBalance   | minimumBalance |
|                  | id             |
| status           | status         |
| description      |                |
| balance          |                |
| creationDate     |                |
| monthlyMaintenance |                |
| penaltieFee      |                |


- Repository
- Service
- Controller
<hr>
### Admin

| MethodName | Parameters  | verb | Admin                                             | JSON |
|-----------:|:-----------:|:----:|:--------------------------------------------------|------|
|  findByAll |             | GET  | http://localhost:8080/AdminAcces/Account/All      |      |
|     create | AccountDTO  | POST |  http://localhost:8080/AdminAccess/Admin/Create   | #1   | 
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |



| JSON | :attributes: | @Valid                                                               |
|------|--------------|----------------------------------------------------------------------|
| #1   | username     | @NotEmpty                                                            |    |
|      | password     | @Size(min = 6, max = 8, message = "Size between 6 and 8 characters") |
|      | email        | @Email(message = "Email should be valid")                            |
|      | name         | @NotEmpty(message = "Name cannot be empty")                          |
|      | roles        | @NotEmpty(message = "e.g. ROLE_ADMIN")                               |




{ "username": "u100100",
    "password": "password",
    "email": "admin1@correo.es",
    "name": "Federico Martín",
    "roles": "ROLE_ADMIN"
}  

| JSON | :attributes: | @Valid                                                              |
|------|--------------|---------------------------------------------------------------------|
| #1   | username     | @NotEmpty                                                       |    
|      | password     | @Size(min = 6, max = 8, message = "Size between 6 and 8 characters") |




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

