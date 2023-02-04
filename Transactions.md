# **TRANSACTIONS**
[back](README.md)

![UML Transactions](/images/UMLTransaction.png)

- Transfer
- Deposit
- Withdraw

*Require*
- Fraud
- Validation



- BothAccountAreEqualsException 
- AmountNotPositiveException
- AccountNotBelongsToSenderException
- AccountNotActiveException
- InsufficientBalanceException
- UserNotFoundException

| MethodName | Parameters |  verb  | Admin                                      | JSON |
|-----------:|:----------:|:------:|:-------------------------------------------|:----:|
|   transfer |            |  POST  | http://localhost:8080/Transaction/transfer |  #1  |
|       cash |            |  POST  | http://localhost:8080/Transaction/cash     |  #2  |



### Sent
#### Transfer
##### input
{
"accountFrom":1,
"accountTo":2,
"amount":{"amount":"5997"},
"senderId":"111111i",
"targetName":".",
"observations":"None"
}


## Admin
- Required ROLE ADMIN to access the Endpoints.
- Handle errors
    - UserAlredyExistsException
    - MethodArgumentNotValidException
    - Validations in attributes