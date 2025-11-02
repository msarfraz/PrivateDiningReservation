## System Setup Information

The following steps can be followed to run the application

 - Install PostgreSQL database with PostGIS extension locally/docker.
   The `docker-compose.yml` file is available in the “`docs`” folder of
   “`PrivateDiningReservation`” Project, it deploys PostgreSql and PostGIS
   in the docker container
 - Create a database named “`opentable`”
   
  
 - Update the database user/password in `application.properties` file of  
   “`PrivateDiningReservation`” project

   

 - Enable PostGIS extension (To enable the PostGIS extension in a   
   PostgreSQL database, execute the following SQL command while   
   connected to the target database as a superuser or a user with   
   appropriate permissions) 

    > CREATE EXTENSION postgis;

 - Run the PrivateDiningReservation project via `spring-boot:run`, it will
   create the required tables on the database
 - Run `init_db.sql` file on the “`opentable`” database to initialise the
   tables with dummy data
 - Once the project is started, swagger can be used to invoke different
   endpoints
 - Payloads of restaurant search and reservation in available in
   `docs/payloads.txt` file of project
 - The `NotificationService` prints the messages in the console, when it
   receives table reservation/cancellation events
 - Application URL:    
   [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
 - PG Admin(docker container) URL: 
   [http://localhost:8080/browser/](http://localhost:8080/browser/)

