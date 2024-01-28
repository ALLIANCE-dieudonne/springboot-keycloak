![Screenshot 2024-01-28 164733](https://github.com/ALLIANCE-dieudonne/springboot-keycloak/assets/123922500/bc3f05fe-c41e-46aa-a542-0431497d0737)

# Spring Boot Keycloak Integration

This repository demonstrates how to securely integrate your Spring Boot application with Keycloak, an open-source identity and access management (IAM) platform.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup Keycloak](#setup-keycloak)
- [Configure Spring Boot](#configure-spring-boot)
- [Build and Run](#build-and-run)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- **Java Development Kit (JDK):** Install JDK 11 or later.
- **Keycloak:**
  - *Option 1: Manual Installation*
    - Install and run Keycloak on your machine.
    - Create a new realm, client, and user in Keycloak.
    - Configure the client settings like client ID, client secret, and issuer URI.
  - *Option 2: Docker Compose*
    - Configure Keycloak settings in `docker-compose.yml`.
    - Run `docker-compose up -d` to start Keycloak in a container.
    - Access the Keycloak Admin Console at [http://localhost:8180](http://localhost:8180).
    - Log in using the default credentials:
      - Username: admin
      - Password: admin
    - Set up a new realm, client, and user in Keycloak.
- **Maven:** Build tool for the project.

## Setup Keycloak

### Option 1: Manual Installation

1. Install and run Keycloak on your machine.
2. Create a new realm, client, and user in Keycloak.
3. Configure the client settings like client ID, client secret, and issuer URI.

### Option 2: Docker Compose

1. Configure Keycloak settings in `docker-compose.yml`.
2. Run `docker-compose up -d` to start Keycloak in a container.
3. Access the Keycloak Admin Console at [http://localhost:8180](http://localhost:8180).
4. Log in using the default credentials:
   - Username: admin
   - Password: admin
5. Set up a new realm, client, and user in Keycloak.

## Configure Spring Boot

1. Clone this repository:

   ```bash
   git clone https://github.com/yourusername/spring-boot-keycloak-integration.git
   
Navigate to the project directory and open src/main/resources/application.yml.

Update the following configurations:

yaml
Copy code
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8180/realms/your-realm-name
          jwk-set-uri: ${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/certs
server:
  port: 4041
jwt:
  auth:
    converter:
      resource-id: "spring-rest-api"
      principle-attribute: "preferred_username"

or use this in your application.properties file
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8181/realms/Alliance
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=${spring.security.oauth2.resourceserver.jwt.issuer-uri}/protocol/openid-connect/certs
server.port=4041
jwt.auth.converter.resource-id=spring-rest-api
jwt.auth.converter.principle-attribute=preferred_username

Build and Run
Build the Spring Boot application using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
java -jar target/spring-boot-keycloak-integration-0.0.1-SNAPSHOT.jar
Access the application at http://localhost:4041 and log in using your Keycloak credentials.

Usage
The protected resources in your Spring Boot application will now require users to be authenticated and authorized through Keycloak. Customize access control by defining roles and permissions in Keycloak and mapping them to your application's security restrictions.

Contributing
Feel free to contribute to this project by submitting issues or pull requests. See the CONTRIBUTING.md file for more information.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Bonus: You can also include an image of Keycloak's login interface in the README to provide a visual reference. Remember to choose an appropriate image license if you do this.

Note: Replace yourusername with your actual GitHub username. Update any other information to match your specific setup.

Feel free to further customize it according to your preferences and speci
