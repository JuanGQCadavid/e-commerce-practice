mysql --password // secret

// Lets creates the dbs

create database OrdersDB;
create user 'ordersUser' identified by 'AsdF1357.';
grant all on OrdersDB.* to 'ordersUser';

create database ProductsDB;
create user 'productUser' identified by 'AsdF1357.';
grant all on ProductsDB.* to 'productUser';


create database CartsDB;
create user 'cartUser' identified by 'AsdF1357.';
grant all on CartsDB.* to 'cartUser';


create database StockDB;
create user 'stockUser' identified by 'AsdF1357.';
grant all on StockDB.* to 'stockUser';


create database UsersDB;
create user 'userUser' identified by 'AsdF1357.';
grant all on UsersDB.* to 'userUser';


create database PaymentDB;
create user 'paymentUser' identified by 'AsdF1357.';
grant all on PaymentDB.* to 'paymentUser';


create database AuthenticationDB;
create user 'authUser' identified by 'AsdF1357.';
grant all on AuthenticationDB.* to 'authUser';
