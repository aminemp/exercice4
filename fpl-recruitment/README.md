# Worldline Technical Test

## Content

* [Prerequisites](#prerequisites)
* [Evaluation](#eval)
	* [Criterias](#criterias)
		* [Code](#code)
		* [Commit](#commit)
		* [Production](#prod)
	* [Exercises](#exercises)
		* [Exercise 1](#exercise1)
		* [Exercise 2](#exercise2)
		* [Exercise 3](#exercise3)
		* [Exercise 4](#exercise4)
		* [Exercise 5](#exercise5)
		* [Exercise 6](#exercise6)

## <a name="prerequisites"></a>Prerequisites

List of prerequisites to realize the test:
* On your PC, you must have :
   * _Maven_ installed (Version __3.x__)
   * _Git_ Installed (Version __2.x__) 
   * _JAVA JDK_ installed (Version __8__)
   * _JAVA IDE_ installed (__Eclipse__ / __IntelliJ IDEA__ / …)
   * _REST Client tool_ to make HTTP Requests 
     * _Chrome_ Extension
       * Postman - REST Client shortcut
       * Sense (Beta)
     * …
   * [Lombok](https://projectlombok.org/)

## <a name="eval"></a>Evaluation
### <a name="criterias"></a>Criterias

The aim of this evaluation is to check if you have the basic competences to integrate a Worldline FPL Digital Banking development team. To verify these competences, we will analyze the following elements: 

* Your developments
* Your analysis
* The way of working

To evaluate these elements, we have created the following categories:

* [Code](#code)
* [Commit](#commit)
* [Production](#prod)

The following sections explain what is expected. 

#### <a name="code"></a>Code

We will be attentive to the “Quality of code”
* Complexity
* Duplication
* Performance
* Readable / Maintainable
* Reusable / Evolutivity
* Comment

#### <a name="commit"></a>Commit

We will be attentive to the “Quality of Commit”

* Relevant 
* Readable
* Comment

A real Git Repository will be available to realize this evaluation. You must use this repository like in a real development project (commit/branch/comment…).

#### <a name="prod"></a>Production

The code must be Production Ready
* Rules compliance
* Work
* Tested

### <a name="exercises"></a>Exercises

#### <a name="exercise1"></a>Exercise 1

Install and run the project on your device/PC

1. Retrieve the __GITHUB__ project : [__Fork the repository__](https://help.github.com/articles/fork-a-repo/)
2. Mount the project on your development IDE (Eclipse or other …)
3. Compile the project (Java and Maven compilation)
4. Launch the project (Launch the Main class of project : com.worldline.fpl.recruitment.StartBoot)

#### <a name="exercise2"></a>Exercise 2

Understand the project and make several tests on it in the current state 

1.	Understand the project (This project simulates a bank __REST__ server)
	* __SAAS__ project (Software as a service)
	* __REST__ server (Representational state transfer)
		* __Host__ : http://localhost:8080/api
	* __Bank service__
		* __Account__ Management
		* __Transaction__ Management

2.	Try to retrieve all accounts (Launch a REST request with these parameters)
	* __Verb__ : _GET_
	* __URL__ : /accounts

3.	Try to retrieve the detail of an account (Replace the __YOUR_ID__ by your account ID)
	* __Verb__ : _GET_
	* __URL__ : /accounts/__YOUR_ID__

4. Try to execute the JUnit tests in __AccountTest__ and __TransactionTest__

There are any other functions that you can find in the correspondent services.

#### <a name="exercise3"></a>Exercise 3

Currently, it is possible to retrieve the transaction list related to an account with the application.

For the next sprint, the client wants to add new administration feature:
* Remove a transaction

You must implement this new feature in the application and add on more tests at the future test plan.

Send a merge request.

#### <a name="exercise4"></a>Exercise 4

For the next sprint, the client wants to add new administration features:
* Add a new transaction on an account
* Update an existing transaction

You must implement those new features in the application and add on more tests at the future test plan.
Moreover, make sure that the existing JUnit tests (__AdminTransactionTest__) are OK.

Send a merge request.

#### <a name="exercise5"></a>Exercise 5

For the next application version, Worldline wants to change the management of data in application. Indeed, currently the application stores the accounts and the transactions directly in the JAVA services. 

This situation is no longer acceptable and the application must be refactored with a real database service.

In the evaluation case, you must implement a memory database (hsql) in the application and refactor the services.

Make sure that all the JUnit tests are OK.

Send a merge request.

#### <a name="exercise6"></a>Exercise 6

Currently, some services can be used by passing a pageable object in parameter.

However, this object is never used.

You have to used this object in order to sort and order the list and add more tests at the future test plan.

Send a merge request.
