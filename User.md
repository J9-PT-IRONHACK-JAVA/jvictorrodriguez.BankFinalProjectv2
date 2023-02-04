# **USERS**

![UML User](/images/UMLUser.png)
## Admin
- Required ROLE ADMIN to access the Endpoints.
- Handle errors
  - UserAlredyExistsException
  - MethodArgumentNotValidException
  - Validations in attributes

| MethodName |  Parameters  |  verb  | Admin                                          | JSON  |
|-----------:|:------------:|:------:|:-----------------------------------------------|:-----:|
|  findByAll |              |  GET   | http://localhost:8080/AdminAcces/Admin/All     |       |
|     create |   AdminDTO   |  POST  | http://localhost:8080/AdminAccess/Admin/Create |  #1   | 
|     Update |   AdminDTO   |  PUT   | http://localhost:8080/AdminAccess/Admin/Update |  #1   |   
|     Update |   AdminDTO   | PATCH  | http://localhost:8080/AdminAccess/Admin/Update |       |
|     Delete |   AdminDTO   | DELETE | http://localhost:8080/AdminAccess/Admin/Delete |  #2   | 

#### FindByAll
##### output

![AdminFindAll](/images/AdminFindAll.png)

#### Create an Admin user
##### input

![Create an Admin Input](/images/CreateANewAdminUser.png) 


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


##### output

![Create an Admin Output](/images/CreateANewAdminUserOutput.png)


#### Delete an Admin user
##### input

![Delete an Admin Ueer](/images/AdminUserDelete.png)

{
"id": 12
}


## Customer
- Required ROLE ADMIN to access the Endpoints.
- Handle errors
  - UserAlredyExistsException
  - MethodArgumentNotValidException
  - Validations in attributes

| MethodName | Parameters  |  verb  | Admin                                             | JSON |
|-----------:|:-----------:|:------:|:--------------------------------------------------|:----:|
|  findByAll |             |  GET   | http://localhost:8080/AdminAcces/Customer/FindAll |      |
|     create | CustomerDTO |  POST  | http://localhost:8080/AdminAcces/Customer/Create |  #1  | 
|     Update | CustomerDTO |  PUT   | http://localhost:8080/AdminAcces/Customer/Update    |  #1  |   
|     Update | CustomerDTO | PATCH  | http://localhost:8080/AdminAcces/Customer/Update    |  #2  |
|     Delete | CustomerDTO | DELETE | http://localhost:8080/AdminAcces/Customer/Delete    |  #3  | 

#### FindByAll
##### output 
![Customer Find All](/images/CustomerFindAll.png)


| JSON | attributes | @Valid                                                               |
|------|:----------:|----------------------------------------------------------------------|
| #1   |  username  | @NotEmpty                                                            |    
|      |  password  | @Size(min = 6, max = 8, message = "Size between 6 and 8 characters") |
|      |    dni     | @Size(min = 6, max = 9, message = "Size between 6 and 9 characters") |
|      |   email    | @Email(message = "Email should be valid")                            |
|      |    name    | @NotEmpty(message = "Name cannot be empty")                          |
|      |    dob     | @Pattern(regexp = "^(0?[1-9][1... message = "format-> dd/MM/yyyy"    |                              
|      |  Address   | @NotBlank [street][code][city][country]                              |

#### CREATE
##### #1 input<br>
{
"username":"999999999",
"password":"password",
"dni":"99999999i",
"address" :  {
"street":"Mayor","code":"25530","city":"Vielha","country":"España"},
"email":"correo@correo3.com",
"name":"nombre de usuario",
"dob":"20/05/1978"
}

##### output<br>
{
"username": "999999999",
"password": "$2a$10$FjzMb9Bdc4XOKBOCTeHBbeZq4xOGNAOdBleaEdWis9KcTs0adEj4O",
"dni": "99999999i",
"email": "correo@correo3.com",
"name": "nombre de usuario",
"address": {
"street": "Mayor",
"code": "25530",
"city": "Vielha",
"country": "España"
},
"id": 21,
"roles": "ROLE_USER",
"dob": "20/05/1978"
}

#### UPDATE
##### #2 input
- User name is mandatory
- Other attributes are optional
{
"username":"12345678i",
"dob":"01/05/2005"
}

##### output  
{
"username": "12345678i",
"password": "12345678",
"dni": "111111i",
"email": "correo@correo.com",
"name": "nombre de usuario",
"address": {
"street": "Mayor",
"code": "25530",
"city": "Vielh",
"country": "España"
},
"id": 4,
"roles": "ROLE_USER",
"dob": "01/05/2005"
}

#### DELETE
##### input
{"username": "12345678i"}

##### output
 
Pending...
, also We think we don't should delete a customer

java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails (`j9_bank_final_project`.`accounts_customers`, CONSTRAINT `FK1yep6p303cimtupr59e9swnfc` FOREIGN KEY (`customer_id`) REFERENCES `users` (`id`))
{
"timestamp": "2023-02-04T10:14:49.481+00:00",
"status": 500,
"error": "Internal Server Error",
"path": "/AdminAcces/Customer/Delete"
}