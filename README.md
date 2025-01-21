# kogito_reproducer
Reproducer project for kogito with KieRuntimeBuilder

This is a project that uses (injects) the KieRuntimeBuilder to create a KieSession using which to fire rules (drools). 
Rule execution is orchestrated through a bpmn process. 

Below are the steps to run and build the program:

Prerequisites: Java 17

1. To build and deploy this project in quarkus dev mode: run this command: mvn clean compile quarkus:dev
2. To run the service: curl -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' -d '{"loanId":12345, "paymentAmount": 2300.45}' http://localhost:8080/validate-payment
3. The validate-payment service should return a json with a loan id and a boolean "valid" (true/false)
