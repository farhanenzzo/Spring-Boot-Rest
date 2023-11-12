

```bash
  # Java Spring Boot REST api CRUD with -> Spring Data JPA -> MySQL

  - Controller
    * UserController
  - Model
    * User
  - Service
    * UserService
  - Repository
    * UserRepo

  Key notes:
  # Why default constructor in Entity class ?
    [baeldung](https://www.baeldung.com/jpa-no-argument-constructor-entity-class)

  # Hibernate ?

  # ORM ?

  # What is Spring Data JPA ?

    - it is an abstraction on top of JPA and hibernate.
    - it reduces the boilerplate code 
    - it gives us lots of generated queries
    - we can access our databases without having to write any SQl through
      Repositories


  # application.properties :
  
    server.port=8080
    spring.datasource.url=jdbc:mysql://localhost:3306/turf
    spring.datasource.username=root
    spring.datasource.password=
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update

  # pom.xml :

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
  
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <scope>runtime</scope>
    </dependency>


    

```

