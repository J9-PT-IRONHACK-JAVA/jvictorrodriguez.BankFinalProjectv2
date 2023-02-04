# **ACCOUNTS**
[back](README.md)
![UML Accounts](/images/UMLAccount.png)


- Checking Account
- Student Account
- Credit Card
- Savings Account


:rocket: **- we have improved the design including the possibility of an unlimited client list**

- Required ROLE ADMIN to access the Endpoints.
- Handle errors
    - AccountIdNotFoundException
    - AccountTypeNotFoundException
    - CannotCancelAnAccountWithBalanceException
    - MethodArgumentNotValidException
    - UserNotFoundException
    - Validations in attributes

| MethodName | Parameters |  verb  | Admin                                           | JSON |
|-----------:|:----------:|:------:|:------------------------------------------------|:----:|
|        All |            |  GET   | http://localhost:8080/AdminAcces/Account/All    |      |
|     create | AccountDTO |  POST  | http://localhost:8080/AdminAcces/Account/Create |  #1  | 
|     Active | AccountDTO | PATCH  | http://localhost:8080/AdminAcces/Account/Active |  #2  |   
|     Freeze | AccountDTO | PATCH  | http://localhost:8080/AdminAcces/Account/Freeze |  #3  |
|     Delete | AccountDTO | DELETE | http://localhost:8080/AdminAcces/Account/Delete |  #4  | 

#### FindByAll
##### output

![Account Find All](/images/AccountFindAll.png)

#### Create an Account
##### input

{
"customers":[{"dni":"222222i"}],
"accountType": "CHECKING_ACCOUNT"

}

#### output
{
"id": 3,
"description": "CHECKING ACCOUNT",
"balance": {
"currency": "EUR",
"amount": 0.00
},
"status": "ACTIVE",
"creationDate": "2023-02-04T10:47:13.291446400Z",
"minimumBalance": {
"currency": "EUR",
"amount": 250.00
},
"monthlyMaintenance": {
"currency": "EUR",
"amount": 12.00
},
"penaltyFee": {
"currency": "EUR",
"amount": 40.00
},
"owners": [
{
"id": 5,
"username": "22222222i",
"password": "12345678",
"roles": "ROLE_USER",
"creationDate": "2023-02-03T15:18:00.588022Z",
"updateDate": "2023-02-03T15:18:00.588022Z",
"dni": "222222i",
"email": "correo@correo2.com",
"name": "nombre de usuario",
"address": {
"street": "Mayor",
"code": "25530",
"city": "Vielh",
"country": "España"
},
"dob": "20/05/1978",
"enabled": true,
"accountNonExpired": true,
"accountNonLocked": true,
"credentialNonExpired": true
}
],
"monthly_MAINTENANCE_FEE": 12,
"minimum_BALANCE": 250,
"penalty_FEE": 40
}

#### Active
##### input
{
"id": 3
}

#### output
{
"id": 3,
"description": "CHECKING ACCOUNT",
"balance": {
"currency": "EUR",
"amount": 0.00
},
"status": "ACTIVE",
"creationDate": "2023-02-04T10:47:13.291446Z",
"minimumBalance": {
"currency": "EUR",
"amount": 250.00
},
"monthlyMaintenance": {
"currency": "EUR",
"amount": 12.00
},
"penaltyFee": {
"currency": "EUR",
"amount": 40.00
},
"owners": [
{
"id": 5,
"username": "22222222i",
"password": "12345678",
"roles": "ROLE_USER",
"creationDate": "2023-02-03T15:18:00.588022Z",
"updateDate": "2023-02-03T15:18:00.588022Z",
"dni": "222222i",
"email": "correo@correo2.com",
"name": "nombre de usuario",
"address": {
"street": "Mayor",
"code": "25530",
"city": "Vielh",
"country": "España"
},
"dob": "20/05/1978",
"enabled": true,
"accountNonExpired": true,
"accountNonLocked": true,
"credentialNonExpired": true
}
#### Freeze
##### input
{
"id": 3
}

#### output
{
"id": 3,
"description": "CHECKING ACCOUNT",
"balance": {
"currency": "EUR",
"amount": 0.00
},
"status": "FROZEN",
"creationDate": "2023-02-04T10:47:13.291446Z",
"minimumBalance": {
"currency": "EUR",
"amount": 250.00
},
"monthlyMaintenance": {
"currency": "EUR",
"amount": 12.00
},
"penaltyFee": {
"currency": "EUR",
"amount": 40.00
},
"owners": [
{
"id": 5,
"username": "22222222i",
"password": "12345678",
"roles": "ROLE_USER",
"creationDate": "2023-02-03T15:18:00.588022Z",
"updateDate": "2023-02-03T15:18:00.588022Z",
"dni": "222222i",
"email": "correo@correo2.com",
"name": "nombre de usuario",
"address": {
"street": "Mayor",
"code": "25530",
"city": "Vielh",
"country": "España"
},
"dob": "20/05/1978",
"enabled": true,
"accountNonExpired": true,
"accountNonLocked": true,
"credentialNonExpired": true
}
],
"monthly_MAINTENANCE_FEE": 12.00,
"minimum_BALANCE": null,
"penalty_FEE": 40.00
}
#### Delete
##### input
{
"id":1
}

##### output
The are balance in the Account id 1