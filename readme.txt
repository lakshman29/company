Steps to test the service
Technology
Springboot
Jersy
SpringDataJPA
H2-Memory Database

Functionality

RestApi  - will have methods to modifiy and  display the  company,owner details
Service - Responsible for inteacting with Repository
Repository - This contain Company and Owner Entity

Junit will cover the  following layers
Rest
Service 
Repository



Steps to build and test the Project

Import the project  to IDE
clean complie install - This will create the war file
Run the project: 
Mvn spring-boot:run


Note :Spring boot have Embedded server . we can test without installing server



Todo:
Exception Handling
Integrate with Angularjs
