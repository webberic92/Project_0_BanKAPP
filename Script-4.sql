CREATE SCHEMA IF NOT EXISTS Project_0 AUTHORIZATION webbadmin;
    create TABLE if not exists project_0.UserLoginTable (user_id serial primary key not null, username varchar(15), password varchar(15),creditscore int );
    drop TABLE  project_0.UserLoginTable;
   
   insert into  project_0.UserLoginTable (username,password) values ('ERIC','ERIC',750);
   insert into  project_0.UserLoginTable (username,password) values ('WEBBY','WEBBY',550);
   insert into  project_0.UserLoginTable (username,password) values ('WEBBRICO','WEBBRICO',400);

    commit;
    
   select * from project_0.userlogintable where "user_id" = 1;
   select * from project_0.userlogintable;

  drop table project_0.useraccounttable;
 create TABLE if not exists project_0.UserAccountTable (account_id serial primary key not null, user_id int references project_0.userlogintable(user_id), account_type varchar(15), balance decimal);	

 create TABLE if not exists project_0.UserAccountTable (account_id serial primary key not null, user_id int references project_0.userlogintable(user_id), account_type varchar(15), balance numeric(20,2));	
insert into project_0.useraccounttable (user_id,account_type, balance) values (1,'Savings',10000.00);
insert into project_0.useraccounttable (user_id,account_type, balance) values (1,'Checkings',10000.50);
insert into project_0.useraccounttable (user_id,account_type, balance) values (2,'Savings',10000.55);
insert into project_0.useraccounttable (user_id,account_type, balance) values (2,'Checkings',10000.55);
insert into project_0.useraccounttable (user_id,account_type, balance) values (3,'Savings',10000.55);
insert into project_0.useraccounttable (user_id,account_type, balance) values (3,'Checkings',10000.55);


commit;

Update project_0.useraccounttable set balance=9000 where account_id=1;

drop table project_0.transactiontable;
 create TABLE if not exists project_0.transactiontable (transaction_id serial primary key not null, account_id int references project_0.useraccounttable(account_id), transaction_type varchar(15), amount decimal);	
insert into project_0.transactiontable (account_id, transaction_type, amount) values (1,'Gained',50);
insert into project_0.transactiontable (account_id, transaction_type, amount) values (2,'Lost',500);
insert into project_0.transactiontable (account_id, transaction_type, amount) values (3,'Gained',150);


select * from project_0.transactiontable where account_id =1;
select * from project_0.transactiontable where account_id =6;

