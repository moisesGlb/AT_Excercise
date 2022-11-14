# Technical Challenge AT

## Description

This Repo is part of a technical challenge, it works with the [heroku app shop](https://juice-shop.herokuapp.com). The main idea is to create a small smoke test suite with a few login tests and also a few Purchase test. The repo has automatic reports. It works with Serenity, bdd and cucumber. For a report example go to the test-output folder

## Execute

To execute this repo you have to open a console and navigate to the project directory. Then execute it with Maven command

```sh
$ cd /project/Directory
$ mvn clean verify
```

There are also options to execute using the suite tags


```sh
$ cd /project/Directory

$ mvn clean verify -Dtag@smokeTest -> To execute everything

$ mvn clean verify -Dtag@loginTest -> to execute login tests only
$ mvn clean verify -Dtag@purchaseTest -> to execute purchase tests only
```

## The tecnologies used:

* Maven
* Java 8
* Serenity
* Cucumber

## Design Patterns

* BDD
* Page Object Model

## Screenshots

![Screenshot](url.png)

![Screenshot](url.png)



## Links

To do this excercise i use the [Serenity Starter project](https://github.com/serenity-bdd/serenity-cucumber-starter).