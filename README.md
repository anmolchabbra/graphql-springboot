# User Oeder Management GraphQL API

## Overview

This project provides a GraphQL-based API for managing users and orders using Spring Boot and Hibernate. The API allows you to perform operations such as creating users, retrieving users, deleting users, and managing orders.

## Features

- **User Management**:
  - Create a new user
  - Retrieve all users
  - Retrieve a single user by ID
  - Delete a user

- **Order Management**:
  - Create a new order
  - Retrieve all orders
  - Retrieve a single order by ID
  - Delete an order

## Technologies Used

- **Spring Boot**: For building the RESTful API
- **Spring GraphQL**: For GraphQL endpoint support
- **Hibernate**: For ORM and database interactions
- **MySQL**: Database for persisting user and order information

## Getting Started

### Prerequisites

- **Java 17** or later
- **Maven** for dependency management
- **MySQL** database setup

### Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/anmolchabbra/graphsql-springboot.git
    cd yourproject
    ```

2. **Configure the database**:

   Ensure you have MySQL running and create a database for the project. Update the `application.properties` file with your database details:

   ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
   
    jpa/hibernate configurations
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    
    #GraphQL Config
    spring.graphql.graphiql.enabled=true
   
## Post-Installation

Once you have successfully installed and configured the application, here are some next steps to get started with using and exploring the API:

### Explore GraphQL API

1. **Access GraphQL Playground**

   The GraphQL Playground is available at (http://localhost:9091/graphiql). You can use it to interact with your GraphQL API by writing queries and mutations.

2. **Sample Queries and Mutations**

   - **Create a User**:

     ```graphql
     mutation {
       createUser(
         name: "Alice Johnson", 
         phone: "555-1234", 
         email: "alice.johnson@example.com", 
         password: "securePassword123"
       ) {
         userId
         name
       }
     }
     ```

   - **Get All Users**:

     ```graphql
     query {
       getUsers {
         userId
         name
         email
       }
     }
     ```

   - **Get a Specific User**:

     ```graphql
     query {
       getUser(userId: 1) {
         userId
         name
         email
         phone
       }
     }
     ```

   - **Delete a User**:

     ```graphql
     mutation {
       deleteUser(userId: 1)
     }
     ```

3. **Create and Manage Orders**

   - **Create an Order**:

     ```graphql
     mutation {
       createOrder(
         orderDetail: "New Laptop", 
         address: "123 Main St, Anytown", 
         price: 1200, 
         userId: 1
       ) {
         orderId
         orderDetail
         price
       }
     }
     ```

   - **Get All Orders**:

     ```graphql
     query {
       getOrders {
         orderId
         orderDetail
         address
         price
         user {
           userId
           name
         }
       }
     }
     ```

   - **Get a Specific Order**:

     ```graphql
     query {
       getOrder(orderId: 1) {
         orderId
         orderDetail
         address
         price
         user {
           userId
           name
         }
       }
     }
     ```

   - **Delete an Order**:

     ```graphql
     mutation {
       deleteOrder(orderId: 1)
     }
     ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

We welcome contributions! If you'd like to contribute, please fork the repository and use a feature branch. Pull requests are welcome.

## Acknowledgements

- Thanks to the Spring Boot community for their fantastic documentation and support.
- Special thanks to all contributors and users of this project.

## Contact

For questions or suggestions, please open an issue or contact the project maintainers through the GitHub repository.

## Conclusion

This project demonstrates a basic implementation of a GraphQL API with Spring Boot and JPA. Feel free to explore, modify, and contribute to this project. We hope you find it useful and informative!

Thank you for using this project!


