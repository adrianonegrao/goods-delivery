[![Build Status](https://travis-ci.org/tayguer/goods-delivery.svg?branch=develop)](https://travis-ci.org/tayguer/goods-delivery)

## Goods Delivery
This project contains the source code of Goods Delivery, a Rest API of a delivery system that provides the less expensive cost of a delivery and its route. It provides features for getting, creating, updating or deleting maps and routes. Additionally this project also provides a web interface to consume and document the Rest API.

### Motivation

This project was created to answer one of the items from Wallmart's selective process.

### Frameworks used

* Apache CXF: Because it supports a JAX-RS frontend and Maven plug-ins to make tooling integration easy.
* Neo4j: Because it is embeddable, one of the fastest and most scalable native graph database, besides providing a good implementation of dijkstra algorithm which answers routing problems.
* Spring-data: Makes it easy to use new data access technologies, such as non-relational databases, a graph database in this case, and cloud based data services that allows scalability.
* Swagger: Swagger is a simple yet powerful representation of a RESTful API and with a Swagger-enabled API you get interactive documentation, client SDK generation and "discoverability".
* Jetty - Because it is embeddable, enterprise scalable, a lightweight web server, flexible and extensible.
* Maven - To manage the project's dependencies and build.
* JUnit - JUnit is a simple framework to write repeatable tests.
* Mockito - Tasty mocking framework that tastes really good. It lets you write beautiful tests clean & simple. 

### Getting Started

[Download](https://github.com/tayguer/goods-delivery/archive/develop.zip) or clone from GIT and then use Maven (3.2.*) and reJava (1.7 or better):

### Running the application

[ base dir project ]: mvn jetty:run

###How to use the Goods Delivery Rest API?

There are two ways to use the Goods Delivery Rest API. The first one is accessing the application context and using the web interface available, the second one is using some rest service client, as postman, and making calls to API.

* Adding a new map: [ PUT /goods-delivery/delivery/map ]
![createMap](https://github.com/tayguer/goods-delivery/blob/develop/docs/images/createMap.png)

* Finding the less expensive cost of a delivery and its route: [ GET /goods-delivery/delivery/lessExpensiveCostRoute/ ]
![shortestPath](https://github.com/tayguer/goods-delivery/blob/develop/docs/images/shortestPath.png)

* Cleaning up the database: [ DELETE /goods-delivery/map/delete ]
![deleteMap](https://github.com/tayguer/goods-delivery/blob/develop/docs/images/deleteMap.png)

* There are also other map operations found at: [ GET /goods-delivery/ ]
![api](https://github.com/tayguer/goods-delivery/blob/develop/docs/images/api.png)

### Documentation

* Detailed:[ base url: /goods-delivery/ ]
* Short:[ base url: /goods-delivery/api/?_wadl ]
* Shortest:[ base url: /goods-delivery/api/-docs ]

### Code coverage

![coverage](https://github.com/tayguer/goods-delivery/blob/develop/docs/images/coverage.png)

### Contributors
* Suggestions.
* Adding REST-assured into the project.
* Collaborating with unit tests and new features.

###Contact the developer

* mailto: tayguer@gmail.com
* Access: 
 * http://tayguer.branded.me
 * www.facebook.com/tayguer.onofre 
 * https://br.linkedin.com/in/tayguer

