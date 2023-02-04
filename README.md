# Final Project: Iron Banking System


Iron Banking System is my bootcamp final project.
It has been made with part of what has been learned during these 16 weeks and I have also learned a lot doing it. 
We have learned design form layers. Starting with the model,repository,service,controller,...
Wrapped with Exceptions and ExceptionHandlers, validations,  and of course security.

### Let's start
#### There are 3 kind of users: [- know more](User.md)

- Admin
- Customer
- Thirdparty


#### There are 4 kind of accounts: [- know more](Accounts.md)

- Checking Account
- Student Account
- Credit Card
- Savings Account

  :rocket: **- we have improved the design including the possibility of an unlimited client list**
 
**Attributes**

Balance

SecretKey

Set of Owners.


MinimumBalance
PenaltyFee
MonthlyMaintenanceFee
CreationDate
Status (FROZEN, ACTIVE)


### Structure
|       Model        |       Dto        |
|:------------------:|:----------------:|
|                    |    Customers     |
|                    |   AccountType    |
|    interestRate    |   interestRate   |
|                    |   creditLimit    |
|   minimumBalance   |  minimumBalance  |
|                    |        id        |
|       status       |      status      |
|    description     |                  |
|      balance       |                  |
|    creationDate    |                  |
| monthlyMaintenance |                  |
|     penaltyFee     |                  |


- Repository
- Service
- Controller
- 


