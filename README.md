```bash
  Java Spring Boot REST api CRUD with -> arayList

  - Controller
    * UserController
  - Model
    * User
  - Service
    * UserService

  Key notes:
    - In Controller class, it is not ideal to build logic on it, logic should be
      implemented in Service class.
    - Service class should have @Service annotation.
    - To use UserService methods in Cotroller class, need to @Autowired
      the UserService class.

```

t
