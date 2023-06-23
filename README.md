# DXC-Tech-Assessment
Encoder and Login Application

For Encoder Program, the code can be compiled and run on the command prompt.
For the Login Application, running the application on bootstrap compatible browsers such as Chrome would enable better appearance.

For Login Application, a local database has to be set up on mySQL.
Follow the following SQL commands:
1) create database useraccount;
2) use useraccount;
3) create table accountinfo (
      userid varchar(20) primary key,
      password varchar(20),
      name varchar(40),
      role varchar(7)
   );
 4) insert into accountinfo values('userone', 'pw1', 'John', 'user');
 5) insert into accountinfo values('usertwo','pw2','Jane','manager');

For the LoginServlet.java code, ensure the following lines is written correctly:

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/useraccount?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
		               "root", "xxxx");

1) "com.mysql.cj.jdbc.Driver" is the correct path to Driver
2) jdbc:mysql://localhost:3306, the correct localhost is chosen
3) useraccount, the correct database is written
4) "root", "xxxx", the correct user and password of mySQL is written
