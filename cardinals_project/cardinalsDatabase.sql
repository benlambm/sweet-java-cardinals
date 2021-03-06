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

insert into desserts (itemId, itemName, cost, numInStock, expDate) values (1, 'Pumpkin Pie', 12.95, 5, '2021-11-30');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (2, 'Apple Cider Donut', 1.79, 35, '2020-11-30');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (3, 'Pecan Roll', 15.00, 8, '2021-11-30');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (4, 'Maple-Syrup Candies', 2.18, 234, '2021-11-30');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (5, 'Caramel-Dipped Apple', 1.50, 13, '2020-11-30');
insert into desserts (itemId, itemName, cost, numInStock, expDate) values (6, 'Pumpkin-Banana Bread', 6.95, 14, '2020-11-30');


CREATE PROCEDURE sp_adjuststock
(tmp_itemId int,
tmp_num int)
UPDATE desserts
SET numInStock = tmp_num
WHERE itemId = tmp_itemId;

CREATE PROCEDURE sp_addinventory
(tmp_itemId int,
tmp_itemName varchar(50),
tmp_cost decimal(5,2),
tmp_numInStock int,
tmp_expDate date)
INSERT INTO desserts
VALUES (tmp_itemId, tmp_itemName, tmp_cost, tmp_numInStock, tmp_expDate);

CREATE PROCEDURE sp_removeinventory
(tmp_itemId int)
DELETE FROM desserts
WHERE itemId = tmp_itemId;

CREATE PROCEDURE sp_updateprice
(tmp_itemId int,
tmp_cost decimal(5,2))
UPDATE desserts
SET cost = tmp_cost
WHERE itemId = tmp_itemId;

CREATE PROCEDURE sp_adduser
(tmp_uname varchar(35),
tmp_pword varchar(35))
INSERT INTO users
VALUES (tmp_uname, tmp_pword, false);

CREATE PROCEDURE sp_addorder
(tmp_orderId int,
tmp_userId varchar(35),
tmp_orderDate date
)
INSERT INTO allorders
VALUES (tmp_orderId, tmp_userId, tmp_orderDate);

CREATE PROCEDURE sp_addlineitem
(tmp_itemId int,
tmp_orderId int,
tmp_numberOrdered int
)
INSERT INTO lineitem
VALUES (tmp_itemId, tmp_orderId, tmp_numberOrdered);


  



