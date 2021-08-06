# blogbuddy
A blog engine that helps people blog whatever they want to blog about.


## Local Setup

This application uses cassandra datastore to store and retrieve blogs.

#### why cassandra
Since a blog engine is ideally a content management system and would need to handle high volume of contents efficiently and have a scalability feature available if needed in the future. Also since a Blog Engine doesn't need to handle lot of relational entities and transactions, it is ideal to use a no-sql datastore

### Prerequisites

You need:

```
* Gradle
* Java 1.8 (jdk)
```

### Installing
```
./gradle build
```

### Deploying Local Cassandra

For the initial implementation there is a script to install Cassandra locally using Docker.
You will need to install Docker and Docker-Compose.

There is a script in the local folder: 

```
./start_resources.sh
```

This will start up the Cassandra cluster using docker-compose and run each script in the db/migrations folder.


### DB scripts

Scripts for creating tables, views, etc are found in the db/migrations folder.
The local installation will load these scripts when it is run.

## Running the tests



### Start application

```
./lightRun
```

### Swagger
```
localhost:8080/swagger-ui.html
```

<img width="1669" alt="Screen Shot 2021-08-06 at 3 51 17 PM" src="https://user-images.githubusercontent.com/87956524/128569752-2ae4a4b0-8d3b-4c35-b5e4-aa84b94284a7.png">

