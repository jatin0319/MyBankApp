<h1>My Bank Application</h1>

I have created a bank web application which is divided into 3 parts 
1. Frontend(HTML Pages)- I have hosted my web pages on Tomcat server
2. Backend(API)- I have created APIs in java language on Playframework 
3. Database - I have created database in Mysql workbench

<h2>Structure :-</h2>
I have created 2 portals for Admin and Customer

<h2>Functionality for admin:-</h2>
1. Login with password verification<br>
2. Register any customer with some validations<br>
3. View customer list with details<br>
4. Activate/ Deactivate customer

<h2>Functionality for customer:-</h2>
1. Login with password verification<br>
2. Send Money with Balance update<br>
3. view details of respective account<br>
4. view transaction history 

<h2>External Dependencies</h2>
1. Java version "1.8.0_301"<br>
2. Sbt version "1.3.13"<br>
3. Tomcat server<br>
4. IntelliJ<br> 
5. Workbench

<h2>How to Execute Project</h2>
1. First install all the dependencies.<br>
2. Clone this repo on your system.<br>
3. Open "Play backend Code" folder in IntelliJ<br>
4. Then build this project.<br>
5. Now open "Apache tomcat" directory and search for "webapps" folder in "Tomcat 9.0" folder.<br>
6. Now place the "Tomcat-Webpages" folder in "webapps" folder. <br>
7. Run Tomcat server by going to "bin" folder and double click on startup.exe file.<br>
8. Run the play server by the command "sbt run" (write this in terminal).<br> 
9. open the "Dump_database" folder in Workbench.<br>
10. Now hit "http://localhost:8080/Tomcat-Webpages/login.html  on ur browser.<br>
11. The site will load and work properly.<br>  <br>  


Please configure the project accordingly.

Always open to new ideas and changes

Thankyou
