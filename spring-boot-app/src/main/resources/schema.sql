drop table if exists  employee;

CREATE TABLE employee (
                          ID int NOT NULL,
                          name varchar(255) NOT NULL,
                          email varchar(255),
                          Age int,
                          PRIMARY KEY (ID)
);

insert into employee(ID,name,email,Age) VALUES(1, 'Test', 'uuu1@ttt.com',45);
insert into employee(ID,name,email,Age) VALUES(2, 'Test2', 'uuu2@ttt.com',12);
insert into employee(ID,name,email,Age) VALUES(3, 'Test3', 'uuu3@ttt.com',34);
insert into employee(ID,name,email,Age) VALUES(4, 'Test4', 'uuu4@ttt.com',43);
insert into employee(ID,name,email,Age) VALUES(5, 'Test5', 'uuu5@ttt.com',44);
insert into employee(ID,name,email,Age) VALUES(6, 'Test6', 'uuu6@ttt.com',54);
insert into employee(ID,name,email,Age) VALUES(7, 'Test7', 'uuu7@ttt.com',23);
insert into employee(ID,name,email,Age) VALUES(8, 'Test8', 'uuu8@ttt.com',78);
insert into employee(ID,name,email,Age) VALUES(9, 'Test9', 'uuu9@ttt.com',90);