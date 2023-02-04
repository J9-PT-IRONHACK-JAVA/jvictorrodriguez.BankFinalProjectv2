# **USERS**

![UML User](/images/UMLUser.png)
## Admin

| MethodName | Parameters  | verb | Admin                                             | JSON |
|-----------:|:-----------:|:----:|:--------------------------------------------------|------|
|  findByAll |             | GET  | http://localhost:8080/AdminAcces/Account/All      |      |
|     create | AccountDTO  | POST |  http://localhost:8080/AdminAccess/Admin/Create   | #1   | 
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |
|   findById |   Long id   | GET  |                                                   |   |

#### OUTPUT **findByAll**

![AdminFindAll](/images/AdminFindAll.png)

#### INPUT **create an AdminUser**

<img alt="Create an Admin Input" height="100" src="/images/CreateANewAdminUser.png" width="100"/> <img alt="Create an Admin Output" height="100" src="/images/CreateANewAdminUserOutput.png" width="100"/>


| JSON | attributes | @Valid                                                               |
|------|:----------:|----------------------------------------------------------------------|
| #1   |  username  | @NotEmpty                                                            |    |
|      |  password  | @Size(min = 6, max = 8, message = "Size between 6 and 8 characters") |
|      |   email    | @Email(message = "Email should be valid")                            |
|      |    name    | @NotEmpty(message = "Name cannot be empty")                          |
|      |   roles    | @NotEmpty(message = "e.g. ROLE_ADMIN")                               |
<br>
{
    "username": "u100102",
    "password": "password",
    "email": "admin2@correo.es",
    "name": "Matías Ferández",
    "roles": "ROLE_ADMIN"
}


#### OUTPUT **create an AdminUser**

![Create an Admin Output](/images/CreateANewAdminUserOutput.png)



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
