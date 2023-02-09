# Phrase TMS projects App (backend)

A simple REST API built using Spring Boot, with Java 17 and Gradle. This app allows to authenticate and retrieve the list of projects from a Phrase TMS account.

## Prerequisites

- Configure Gradle JVM to use Java 17

## Running Project

### Project setup and server start up

```
$ ./gradlew bootRun
```

### Or run server from your IDE. In case of IntelliJ

```
Open Gradle panel -> demo -> Tasks -> application -> bootRun -> Run 'demo [bootRun]'
```

## Notes

- The server runs on port **8081**
- The port can be configured in the **application.properties** file
- There is a frontend app as part of this same project
- The frontend server repository can be found here: https://github.com/luis-e-lopez/phrase-frontend
