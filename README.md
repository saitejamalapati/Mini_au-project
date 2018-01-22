# Mini_au-project

Online Pizza Delievery Project


Getting started:
1.This project is build using the Maven Build tool as Project Management Tool and MySql is used for database and Spring for the backend.

Software requirements:
1.Apache Tomcat 
2.nginx
3.log4j
4.Junit
5.Jdk 1.8

Features of Project:
1.Login and Signup Options for the Application.
2.Options to view the pizzas category wise.
3.Option to Customise your Pizza.
4.Option to add the Items to Cart and delete.

Database Schema Contents:
The schema consists of tables as below:
1.Customer
2.Orders
3.Cart
4.CustomizedPizza
5.RegisteredCustomers
6.Staff
7.Reviews
8.Menu
9.OrderDetails

Link for database creation:https://github.com/Sandeep-Banuka/Schema

Populate the menu as follows:
insert into menu values("11","onion","vegTopping",1,20.00,0,0," ");
insert into menu values("12","green pepper","vegTopping",1,20.00,0,0," ");
insert into menu values("13","red pepper","vegTopping",1,20.00,0,0," ");
insert into menu values("14","yellow pepper","vegTopping",1,20.00,0,0," ");
insert into menu values("15","corn","vegTopping",1,30.00,0,0," ");
insert into menu values("16","jalepeno","vegTopping",1,30.00,0,0," ");
insert into menu values("17","green olives","vegTopping",1,30.00,0,0," ");
insert into menu values("18","black olives","vegTopping",1,30.00,0,0," ");
insert into menu values("19","paneer chunks","vegTopping",1,40.00,0,0," ");
insert into menu values("20","mushroom","vegTopping",1,40.00,0,0," ");
insert into menu values("21","sundried tomato","vegTopping",1,40.00,0,0," ");
insert into menu values("22","spinach","vegTopping",1,40.00,0,0," ");
insert into menu values("23","cilantro","vegTopping",1,40.00,0,0," ");
insert into menu values("24","chicken sausage","nonvegTopping",1,40.00,0,0," ");
insert into menu values("25","chicken salami","nonvegTopping",1,40.00,0,0," ");
insert into menu values("26","chicken nuggets","nonvegTopping",1,40.00,0,0," ");
insert into menu values("27","chicken chunks","nonvegTopping",1,40.00,0,0," ");
insert into menu values("28","chorizo sausage","nonvegTopping",1,50.00,0,0," ");
insert into menu values("29","pepperoni","nonvegTopping",1,50.00,0,0," ");
insert into menu values("30","bacon strips","nonvegTopping",1,50.00,0,0," ");
insert into menu values("31","spicy italian sausage","nonvegTopping",1,50.00,0,0," ");
insert into menu values("32","italian ham","nonvegTopping",1,50.00,0,0," ");
insert into menu values("33","bacon crumble","nonvegTopping",1,60.00,0,0," ");
insert into menu values("34","Anchovies","nonvegTopping",1,60.00,0,0," ");
insert into menu values("35","Feta Cheese","vegTopping",1,40.00,0,0," ");
insert into menu values("36","Goat Cheese","vegTopping",1,40.00,0,0," ");
insert into menu values("37","Four Cheese topping","vegTopping",1,50.00,0,0," ");
insert into menu values("38","Parmesan Cheese","vegTopping",1,40.00,0,0," ");
insert into menu values("39","Mozzarella","vegTopping",1,40.00,0,0," ");
insert into menu values("40","Wheat Thin Crust","crust",1,100.00,0,0," ");
insert into menu values("41","Cheese Burst","crust",1,120.00,0,0," ");
insert into menu values("42","Cheese crunch- thin crust","crust",1,120.00,0,0," ");
insert into menu values("43","Fresh Pan crust","crust",1,90.00,0,0," ");
insert into menu values("44","Flatbread Crust","crust",1,100.00,0,0," ");
insert into menu values("45","Focaccia","crust",1,120.00,0,0," ");
insert into menu values("46","Multigrain Crust","crust",1,130.00,0,0," ");
insert into menu values("47","Chicken Sausage stuffed Crust","crust",1,130.00,0,0," ");
insert into menu values("48","Veg stuffed Crust","crust",1,130.00,0,0," ");

Running the project:
1.First start running nginx
2.Then start running project on Tomcat.


Project description:This project is about ordering a pizza Online.This Application also contain many features where in you can customize your pizza and pay for it.
The other features include adding items to your cart and deleting items from the cart.
