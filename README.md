# Springs SimpleJdbcInsert class usage.
Demonstrates the Spring's SimpleJdbcInsert class usage with H2 InMemory DB.

#Tech Stack.
Spring JDBC. <br/>
H2 InMemory DB. <br/>
Lombok. <br/>
Gradle. <br/>

#PreRequisites.
JDK 1.7 +. <br/>
Gradle(https://gradle.org/docs/current/userguide/installation.html)

#DB configuration?
Since I am using inMemory Db, no configuration required.

#How to Run?
Clone the project into your local machine. <br/>
Enter into the directory through command promt. <br/>
Run below gradle task. It build the project and run the test cases. <br/>
<code> >gradle clean test </code>

#How to import into Eclipse IDE?
Run the below gradle task to create .eclipse and .project file. <br/>
<code>gradle clean eclipse</code>
<br/>
Above command runs successfully import as existing project.<br/>

IntelliJIDEA user can directly import as gradle project.

#Run the test cases from IDE?
Open java file called SimpleJdbcInsertTest.java and highlight the method you want to run, Run as Junit test.
