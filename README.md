# Blockchain-API CRUD Implementation

This project is a simple API model to consulting and consuming a chaincode by Hyperledger Fabric.

## Getting Started

This API will connect with a network and call instatiate chaincode. Then is possible to interact with this network creating, consulting, updating or deleting a asset.

Hyperledger Fabric whitch could be local development and testing it execution using 
[IBM Blockchain Platform Extension for VS Code](https://marketplace.visualstudio.com/items?itemName=IBMBlockchain.ibm-blockchain-platform).

Fist at all, it is necessary to have an instanced chaincode, which can be done using the following chaincode model: 
[DigitalContract](https://github.com/rafael-lima-rodrigues/DigitalContract).

## Prerequisites

Java 1.8

Maven 4.0.0

A running blockchain network with chaincode instantiated.

## Running

Next, clone this repository and open in yours favorite IDE (for this project was used Intellij IDE).

After that, downloaded this project and open in yours favorite IDE. Then, whether you have maven installed open the Terminal and run the command: **mvn spring-boot:run**.
It will deploy to 8081/api on a tomcat server.

## Built With
* Java 1.8
* Maven - Dependency Management
* Fabric-java-sdk 1.4.7
* Spring Boot
