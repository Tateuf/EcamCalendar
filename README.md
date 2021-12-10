# EcamCalendar 
###Description
This EcamCalendar project has been started as part of the Software Architecture class to improve the current website ECAM (College for industrial engineers) uses to provide the schedules of students and teachers.
This is working as a microservice that is supposed to be part of the school website.

Programming language: java


###Set up

To start the project on your environment click and maven > lifecycle > install. </br>
After that, you can run your project : </br>
Right click on CalendarApplication and run the project. </br>

Project Structure : </br>

to resolve the DBConnect error go on : file > project Structure > module > calendar > + :</br>
- Select mysql-connector-java-8.0.11.jar </br>
- Select jsch-0.1.54.jar  </br>

To import unit test : 
- go on your project structure > source > define > and modify your implementation
to add unit_tests in test.


those 2 are in the next folder : /src/main/java/com.ecam.Calendar/ </br>

Communication with other microservices is possible thanks to the YAML file.

### Database
Connection to the database is established in the next file: /src/main/java/com.ecam.Calendar/DBConnect

### Used Tools
- **Maven** <br/>
  Maven is used to automate continuous integration during software development.


- **Postman**<br/>
Since this microservice is purely backend development, *postman* is used to check the queries made to the database.


- **OpenApi**<br/>
OpenApi defines the format in which the YAML file should be written.
https://spec.openapis.org/oas/latest.html
###Current features

- The teacher can add a time slot with the class he wants to teach.
  Teacher can put his schedule together by choosing 
  - time slots;
  - the course he wants to teach;
  - a room (compatible with the number of students enrolled in each course);
  - He can also add the session number of the class.
  

- The students and teachers have access to their schedules.
Visible elements are: 
  - the course title and code; 
  - the name of the teacher; 
  - the room where the class is given;
  - the time slot;
  - the session number.


- Check the availability of a room: it is possible to display all the courses taking place in a room.


- Check that the number of students attending the class matches the possible capacity of the room.


###Possible future features
Here are a few other features we were hoping to implement in the future. 

- Add a sign to the class on the schedule to differentiate mandatory classes from classes where attendance is not required: Sending a code through the YAML so that the frontend microservice can change the color of the different kinds of classes (theoretical, exercises, labs or mandatory and non mandatory)


- Update function that updates


- Ability to add personal notifications.


- Add student/teacher support - on the schedule: being able to add a meeting (appointment with a colleague for an assignment, project or other)
