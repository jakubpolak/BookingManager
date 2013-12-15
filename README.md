# Booking Manager

This is a team project for our advanced Java Course at Masaryk University.

## Technology and setup requirements

* __Server__ - Apache Tomcat
* __Framework__ - Spring
* __Database__ - JavaDB, port 1527
* __Database name__ - pa165
* __Database user__ - pa165
* __Database user password__ - pa165
* __Web application context__ - http://localhost:8080/pa165

## Modules
* __bm-api__ - contains DTO and Service interfaces
* __bm-api-impl__ - contains implementations of Convertors, interfaces and implementations of DAOs, implementations of DTOs, implementations of Entities and Services
* __bm-rest__ - implementation of REST
* __bm-rest-client__ application to access data from bm-rest, which is deployed together with bm-web, via REST
* __bm-web__ web presentation layer, uses Spring MVC

## Building and Testing

Project uses maven, to build it use:

```
mvn install
```

Run bm-rest-client module:
```
mvn exec:java -Dmaven.test.skip=true
```

Run bm-web module:
```
mvn tomcat:run -Dmaven.test.skip=true
```

## Set up database

* Change hibernate configuration in /bm-api-impl/src/main/resources/configuration/hibernate.xml to:

```
<prop key="hibernate.hbm2ddl.auto">create-drop</prop>
```

* Run application, database tables are created.

* Change hibernate configuration in /bm-api-impl/src/main/resources/configuration/hibernate.xml to original state.

* Run SQL script with sample data, the script can be found here:

```
/bm-api-impl/src/main/resources/data.testing/db-sample-data.sql
```

Passwords in database are saved in form of SHA-1 hash, default passwords are:

* user: admin@bm.com, password: 123456
* user: receptionist@bm.com, password: 123456