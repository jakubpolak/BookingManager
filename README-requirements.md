Booking Manager
===============

Let us imagine a Booking Manager for hotels: every customer can choose desired hotel and a particular room. There is also an information about accommodation price. It should be possible to browse hotels and available rooms. System Administrator should be also able to find customers who have some room reserved in a certain time range.

Project Requirements
====================

● Implement authentication and authorization on both presentation and service layer of the web application.

● The GUI will look differently for users with different roles.

● If user does not have permission for some functionality, he should not see it on the GUI.

● User must be registered to be able to work with the application (in some cases it might be reasonable for unregistered user to work with the system, but in this cases please consult it with your seminar tutor).

● User might be able to register himself, or only an administrator can register new user to the system (choose which option makes more sense for your project).

● REST client does not need to be authenticated, to be able to access protected service layer, default username “rest” with password “rest” should be hardcoded in the implementation of the REST/SOAP API layer. (but if you wish you can implement authentication even in the client)

Technology and setup Requirements
=================================

Server: Apache Tomcat

Framework: Spring

Database: JavaDB, port 1527

Database name: pa165

Database user: pa165

Database user password: pa165

Web application context localhost:8080/pa165

Milestone 1
===========

● create project in a some SCM repository that could be accessed by your seminar tutor (e.g svn at FI, Google Code, Github) with an appropriate name. It is allowed to use either Git or SVN versioning system. Create some project web page/wiki to publish some other information for your project.

● on the project wiki there will be project description, use case diagram and class diagram for entity classes. There will be at least two user roles in the use case diagram. Associations between entities will be present in class diagram.

● create 4 entity classes

● create DAO layer interface (with proper javadoc)

● create JPA implementation of DAO classes

● create unit tests for DAO classes (use in memory database)

● every team member should work with different entities on different parts of the project (e.g. member 1 will create implementation of DAO for entity A, but member 2 will create unit test for entity A). In every class there will be javadoc @author with the name of class author.

● project will be built using maven, and make sure you have all dependencies correctly configured, so your seminar tutor is able to build it and run tests on his local machine

Milestone 2
===========

● complete implementation of business logic in Spring or EJB

● implement service layer that uses DAO layer; if you choose Spring for implementation make sure that DataAccessException or its subclass is thrown in case of any exception on a persistence layer

● you might add other layers if you need, e.g.  adapter or service facade (but you do not have to)

● API of backend will use dedicated transfer objects, not entities

● transaction management on appropriate layer

● unit tests for service layer will use Mock DAO objects

● make sure all dependencies are correctly configured so we are able to build the project and run the tests without any other configuration

Milestone 3
===========

● complete implementation of web (presentation) layer

● usage of some MVC framework (Stripes, Struts, JSF, Spring Web MVC, Apache Wicket) is mandatory

● web application will be a separate maven module, that will depend on module with backend API (there will be parent project, web module, API module and business logic implementation module) ­ in case of Spring. EJB project will have standard EJB structure.

● authentication and authorization does not have to be implemented so far (but you will implement it later)

● GUI will be user friendly, graphical design will be also taken into account

● application will be localized in at least two languages (language will be chosen according to user’s browser preferences)

● Spring project will have configured web container (tomcat, jetty, ..) via maven plugin for us to be able to be able to launch the application easily.

● EJB project will have configured embedded application server (glassfish, ..) via maven plugin for us to be able to launch the application easily.

● embedded web server will listen on port 8080 and web application context will be set to pa165 (so your app could be found on  http://localhost:8080/pa165)

● you will use JavaDB (Apache Derby)  database, listening on port 1527 on localhost, database name will be pa165 (lowercase), username and password will also be pa165.

● make sure all above settings are correct, so your seminar tutor is able to start the application and check it

Milestone 4
===========

● SOAP or REST API for manipulation with two entities in your project. The API will be deployed together with the web application of your project. The API will allow user of the API to use Service methods for those two entities.

● simple client to test functionality of the API. The client will be implemented as a command line application or desktop application (Swing) or another web application. See requirements for your chosen type of client below

● project will have configured  maven plugin correctly, to be able to launch the client easily.  For command line/desktop application use exec maven plugin. For web application use tomcat/jetty maven plugin. Put instructions how to run your chosen client to README

● make sure that client would not crash or freeze in case of server unavailability. Friendly error message should be shown to the user

● The structure of your whole project must meet the standard Maven practice. Root project is the “parent project” and modules are placed in subdirectories with own POM

● You will have API project with no dependencies on any technology. This project will be one of the modules of your project.

● All the layers (excluding presentation layer) will be tested by unit tests. Running mvn:test will run ALL the unit tests and ALL must pass

● Every manipulation with the project (running it for example) must be done via maven. Place README to the parent project and put there instructions how to run your web application from command line by maven. Only external assumption you can make is clean DB machine running on respective port as described in 3. milestone requirements

● Make sure all your service methods (methods defined on the interface of the your service layer) are used in either Web Application or the REST API. No orphan service methods should be present. This will be randomly checked.

● Remove all commented­out code in your codebase.

● No garbage packages, classes or folders in your Subversion. Remove all the files that are not necessary to run/use your project.

● Make sure your project complies with standard Java code conventions: (http://www.oracle.com/technetwork/java/javase/documentation/codeconvtoc­136057.html). Some minor mistakes here will not be penalized. However failing to comply with the most basic of the conventions that are even enforced in prerequisity lectures will be penalized. If you choose Swing client:

● desktop application should be user friendly and intuitive to use

● Desktop client will be standalone maven module If you choose command line client:

● command line UI could be either batch or interactive, but it should be user friendly ­ e. g. it will print help with information about usage and report proper return code according to if exited normally or not. Exception stacktrace should never be printed to the output, not even if user enters invalid data.

● Client will be created as a standalone maven module

● Put example of usage into README. There will be 2 examples. One will query one of the entities and one will be creating entity in the database If you choose web application client:

● Application will be implemented as a standalone maven module.

● There are not any strict requirements for the technologies that should be used in web application. The application must be user friendly and intuitive to use.  The application will communicate with the server via its web interface (REST or SOAP API), for example using AJAX

Defense Requirements
====================

Prepare presentation slides and present your project to the committee, and prepare
answers to possible questions that your seminar tutor sent you in advance (latest 24
hours before defense). Part of the presentation should be short live demo of the
application.

Defense will take 15 minutes (no more, and this is strict) , your presentation should be prepared
for about 7 minutes and about 2 minutes should be live demo of your application.

Presentation should cover following topics:

● business logic (what is it for and what does it do)

● technologies used

● team cooperation (who did what)

● your feedback (what did you like and what not)
