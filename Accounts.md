# **ACCOUNTS**
![UML Accounts](/images/UMLAccount.png)

## Checking Account
## Student Account
## Credit Card
## Savings Account



- Required ROLE ADMIN to access the Endpoints.
- Handle errors
    - UserAlredyExistsException
    - MethodArgumentNotValidException
    - Validations in attributes

| MethodName | Parameters |  verb  | Admin                                          | JSON  |
|-----------:|:----------:|:------:|:-----------------------------------------------|:-----:|
|       All  |            |  GET   | http://localhost:8080/AdminAcces/Account/All     |       |
|     create | AccountDTO |  POST  | http://localhost:8080/AdminAcces/Account/Create |  #1   | 
|     Update | AccountDTO |  PUT   | http://localhost:8080/AdminAcces/Account/Update |  #1   |   
|     Update | AccountDTO | PATCH  | http://localhost:8080/AdminAcces/Account/Update |       |
|     Delete | AccountDTO | DELETE | http://localhost:8080/AdminAcces/Account/Delete |  #2   | 

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

