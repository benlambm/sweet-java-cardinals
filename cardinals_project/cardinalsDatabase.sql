Create database if not exists cardinals220;
Use cardinals220;

CREATE TABLE users (
	username varchar(35) NOT NULL,
	password varchar(35) NOT NULL,
	owner Boolean,
	UNIQUE(username),
	PRIMARY KEY (username)
);

CREATE TABLE desserts (
	itemId int NOT NULL,
	itemName varchar(50) NOT NULL,
	cost decimal(5, 2),
	numInStock int,
	expDate date,
	UNIQUE(itemId),
	PRIMARY KEY (itemId)
);

CREATE TABLE allOrders (
	orderId int NOT NULL,
	userId varchar(35),
	orderDate date,
	PRIMARY KEY (orderId),
	FOREIGN KEY (userId) REFERENCES users (username)
);

CREATE TABLE lineItem (
	itemId int NOT NULL,
	orderId int NOT NULL,
	numberOrdered int,
	FOREIGN KEY (itemId) REFERENCES desserts (itemId),
	FOREIGN KEY (orderId) REFERENCES allOrders (orderId)
);

insert into users (username, password, owner) values ('cardinal', 'cardinal', true);
insert into users (username, password, owner) values ('guest', 'guest', false);
insert into users (username, password, owner) values ('JamesBond', '007', false);

insert into desserts (itemId, itemName, cost, numInStock, expDate) values (1, 'Pumpkin Pie', 12.95, 5, '2021-11-31');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (2, 'Apple Cider Donut', 1.79, 35, '2020-11-31');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (3, 'Pecan Roll', 15.00, 8, '2021-11-31');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (4, 'Maple-Syrup Candies', 2.18, 234, '2021-11-31');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (5, 'Caramel-Dipped Apple', 1.50, 13, '2020-11-31');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (6, 'Pumpkin-Banana Bread', 6.95, 14, '2020-11-31');

insert into allOrders (orderId, userId, orderDate) values (101, 'guest', '2021-10-24');
insert into allOrders (orderId, userId, orderDate) values (102, 'guest', '2021-09-27');
insert into allOrders (orderId, userId, orderDate) values (103, 'guest', '2021-10-20');
insert into allOrders (orderId, userId, orderDate) values (104, 'JamesBond', '2021-11-18');
insert into allOrders (orderId, userId, orderDate) values (105, 'JamesBond', '2021-11-18');

insert into lineItem (itemId, orderId, numberOrdered) values (1, 101, 2);
insert into lineItem (itemId, orderId, numberOrdered) values (2, 101, 5);
insert into lineItem (itemId, orderId, numberOrdered) values (3, 102, 1);
insert into lineItem (itemId, orderId, numberOrdered) values (4, 103, 12);
insert into lineItem (itemId, orderId, numberOrdered) values (5, 103, 2);
insert into lineItem (itemId, orderId, numberOrdered) values (6, 104, 4);
insert into lineItem (itemId, orderId, numberOrdered) values (6, 105, 3);
insert into lineItem (itemId, orderId, numberOrdered) values (1, 105, 1);
insert into lineItem (itemId, orderId, numberOrdered) values (2, 105, 6);




