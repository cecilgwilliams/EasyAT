# Overview

This is an example of creating your own domain specific language using personas to automate acceptance testing.

The DSL steps are combined in the XML files in /resources/scenarios/demo/.

The implementation uses Groovy, Selenium, and Firefox.

## Install Apache Maven

- [Apache Maven Download Page](http://maven.apache.org/download.cgi)

## Build JAR

From source checkout directory, run:

```bash
mvn clean package
```

## Run Demo

From source checkout directory, run:

```bash
cd ./target
java -cp EasyAT-1.0.0-SNAPSHOT.jar com.cecilgwilliams.ExecuteTests
```
