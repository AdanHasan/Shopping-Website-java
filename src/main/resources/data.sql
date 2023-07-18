--DROP TABLE IF EXISTS item;
--DROP TABLE IF EXISTS user;
--DROP TABLE IF EXISTS orders;
--DROP TABLE IF EXISTS registered;
----DROP TABLE IF EXISTS try;
--
----CREATE TABLE item (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    title varchar(300) NOT NULL ,
----    price DOUBLE  NOT NULL ,
----    quantity int(11) NOT NULL ,
----   picture_url varchar(max) NOT NULL,
----   liked BIT(1) NOT NULL,
----   cart BIT(1) NOT NULL ,
----    PRIMARY KEY (id)
----);
--
--CREATE TABLE item (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    title varchar(300) DEFAULT '' ,
--    price DOUBLE DEFAULT ''  ,
--    in_stock int(11) DEFAULT '' ,
--    quantity int(11) DEFAULT '' ,
--   picture_url varchar(max) DEFAULT '',
--   liked BIT(1) DEFAULT '' ,
--   cart BIT(1) DEFAULT '' ,
--    PRIMARY KEY (id)
--);
--
--
--CREATE TABLE user (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    first_name varchar(300)  DEFAULT '',
--    last_name varchar(300)  DEFAULT '',
--    email varchar(300)  DEFAULT '',
--     username varchar(20)  DEFAULT '' UNIQUE,
----    password int(11) NOT NULL ,
--    password varchar(30)  ,
----    phone int(11) NOT NULL,
--    phone varchar(30) ,
--    address varchar(300)  ,
----    active tinyint(1) NOT NULL DEFAULT '1',
--    active BIT(1)  DEFAULT '',
--         roles varchar(200)  DEFAULT '',
--         permissions varchar(200)  DEFAULT '',
--    PRIMARY KEY (username)
--);
--
--
----
----CREATE TABLE registered (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----     username varchar(20)  DEFAULT '',
------    password int(11) NOT NULL ,
----    password varchar(30)  ,
------    phone int(11) NOT NULL,
----
------    active tinyint(1) NOT NULL DEFAULT '1',
----    active BIT(1)  DEFAULT '',
----    PRIMARY KEY (id)
----);
--
----CREATE TABLE orders (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    user_id int(11) NOT NULL ,
----    order_date date NOT NULL DEFAULT '',
----    shipping_address varchar(300) NOT NULL DEFAULT '' ,
----    total_price int(11) NOT NULL ,
----    status varchar(300) NOT NULL ,
----    item_id int(11) NOT NULL DEFAULT '',
----    PRIMARY KEY (id),
----     FOREIGN KEY (user_id) REFERENCES user(id),
----        FOREIGN KEY (item_id) REFERENCES item(id)
----
----);
--
--
----CREATE TABLE orders (
----    id int(11) unsigned NOT NULL AUTO_INCREMENT,
----    user_id int(11)  DEFAULT'1'  ,
----    order_date date NOT NULL DEFAULT '',
----    shipping_address varchar(300) NOT NULL  DEFAULT '' ,
----    total_price int(11)  DEFAULT'' ,
----    status varchar(300)  DEFAULT 'TEMP' ,
----    item_id  int(11)  DEFAULT'1',
----    PRIMARY KEY (id),
----     FOREIGN KEY (user_id) REFERENCES user(id),
----        FOREIGN KEY (item_id) REFERENCES item(id)
----);
--
--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) DEFAULT '',
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL DEFAULT '',
--    status varchar(300) DEFAULT '',
----    item_id int(11) DEFAULT '',
--    items varchar(2000) NOT NULL,
----    item_id long NOT NULL DEFAULT '',
--
--    PRIMARY KEY (id),
--        FOREIGN KEY (user_id) REFERENCES user(id)
----           FOREIGN KEY (item_id) REFERENCES item(id)
--);
--
--
--INSERT INTO item (title , price , in_stock, quantity , picture_url , liked , cart ) VALUES
--('Oversized Check Detail Geometric Frame Sunglasses',235.59 , 10,10 ,'https://assets.burberry.com/is/image/Burberryltd/25AFC121-C9BB-4E61-907B-E84AC4DD7BB4?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0 , 0),
--('Monogram Motif Oversized Round Frame Lola Sunglasses',321.92 , 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/DF899DEE-DCB7-4613-98B7-736262E12BA9?$BBY_V2_ML_1x1$&wid=2500&hei=2500' ,0, 0),
--('Cat-eye Frame Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/A9531EAC-A872-4D09-BD80-E11C4B38E696?$BBY_V2_ML_1x1$&wid=1500&hei=1500' , 0, 0),
--('Monogram Motif Oversized Square Frame Lola Sunglasses',288.27 , 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/2D19261A-3DA3-4805-91B2-F821B03E954C?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0),
--('Logo Detail Cat-eye Frame Sunglasses',321.92, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/C357BB30-A4A8-4BDB-A40D-3D2399514B93?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Check Square Frame Sunglasses',261.93, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/67587F1D-2DBA-44DB-83DB-4C8A83F3DD3E?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Motif Square Frame Sunglasses',351.19, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/12822736-2D81-44D4-A30C-B05BD548FEA7?$BBY_V2_ML_1x1$&wid=2500&hei=2500' , 0, 0),
--('Vintage Check Detail Pilot Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/c2ba9184d9c58a3de4409f3c1aaaea7b73a5ab02?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
--('Logo Lens D-frame Sunglasses',261.93, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/25640660-F83A-441E-ACE5-497D5E52151D?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('B Lens Detail Rectangular Frame Sunglasses',321.92, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/46a5a94d88131384bc0f594a81b2902f326a856e?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
--('Vintage Check Detail Butterfly Frame Sunglasses',235.59, 10 ,10, 'https://assets.burberry.com/is/image/Burberryltd/680e0ef168727a1be1deb616aed64c5fc866448c?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0 ),
--('B Motif Rectangular Frame Sunglasses',351.19, 10,10 , 'https://assets.burberry.com/is/image/Burberryltd/76BD3C41-FFD1-4D72-B7D9-3CD110B83F91?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 );
--
--INSERT INTO user (first_name , last_name , email ,username, password , phone , address, active, roles, permissions ) VALUES
--('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'lole3','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
--('lelian','hasan' , 'lelian@gmail.com' , 'lole2','Lole123!','0983903444' , 'nazareth' , 0, '', '');
-- ******************
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS orderItems;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS registered;

--DROP TABLE IF EXISTS try;

--CREATE TABLE item (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    title varchar(300) NOT NULL ,
--    price DOUBLE  NOT NULL ,
--    quantity int(11) NOT NULL ,
--   picture_url varchar(max) NOT NULL,
--   liked BIT(1) NOT NULL,
--   cart BIT(1) NOT NULL ,
--    PRIMARY KEY (id)
--);

CREATE TABLE item (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    title varchar(300) DEFAULT '' ,
    price DOUBLE DEFAULT ''  ,
    in_stock int(11) DEFAULT '' ,
    quantity int(11) DEFAULT '' ,
   picture_url varchar(max) DEFAULT '',
   liked BIT(1) DEFAULT '' ,
   cart BIT(1) DEFAULT '' ,
    PRIMARY KEY (id)
);


CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300)  DEFAULT '',
    last_name varchar(300)  DEFAULT '',
    email varchar(300)  DEFAULT '',
     username varchar(20)  DEFAULT '',
--    password int(11) NOT NULL ,
    password varchar(30)  ,
--    phone int(11) NOT NULL,
    phone varchar(30) ,
    address varchar(300)  ,
--    active tinyint(1) NOT NULL DEFAULT '1',
    active BIT(1)  DEFAULT '',
         roles varchar(200)  DEFAULT '',
         permissions varchar(200)  DEFAULT '',
    PRIMARY KEY (id)
);


--
--CREATE TABLE registered (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--     username varchar(20)  DEFAULT '',
----    password int(11) NOT NULL ,
--    password varchar(30)  ,
----    phone int(11) NOT NULL,
--
----    active tinyint(1) NOT NULL DEFAULT '1',
--    active BIT(1)  DEFAULT '',
--    PRIMARY KEY (id)
--);

--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) NOT NULL ,
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL ,
--    status varchar(300) NOT NULL ,
--    item_id int(11) NOT NULL DEFAULT '',
--    PRIMARY KEY (id),
--     FOREIGN KEY (user_id) REFERENCES user(id),
--        FOREIGN KEY (item_id) REFERENCES item(id)
--
--);


--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11)  DEFAULT'1'  ,
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL  DEFAULT '' ,
--    total_price int(11)  DEFAULT'' ,
--    status varchar(300)  DEFAULT 'TEMP' ,
--    item_id  int(11)  DEFAULT'1',
--    PRIMARY KEY (id),
--     FOREIGN KEY (user_id) REFERENCES user(id),
--        FOREIGN KEY (item_id) REFERENCES item(id)
--);

--CREATE TABLE orders (
--    id int(11) unsigned NOT NULL AUTO_INCREMENT,
--    user_id int(11) DEFAULT '',
--    order_date date NOT NULL DEFAULT '',
--    shipping_address varchar(300) NOT NULL DEFAULT '' ,
--    total_price int(11) NOT NULL DEFAULT '',
--    status varchar(300) DEFAULT '',
----    item_id int(11) DEFAULT '',
--    item_id int (11) NOT NULL DEFAULT '',
----    item_id  long NOT NULL DEFAULT ''
--    PRIMARY KEY (id),
--        FOREIGN KEY (user_id) REFERENCES user(id)
----           FOREIGN KEY (item_id) REFERENCES item(id)
--);

CREATE TABLE orders (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    user_id int(11) DEFAULT '',
    order_date date NOT NULL DEFAULT '',
    shipping_address varchar(300) NOT NULL DEFAULT '' ,
    total_price int(11) NOT NULL DEFAULT '',
    status varchar(300) DEFAULT '',
    items_id varchar(2000) DEFAULT '' ,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
--    FOREIGN KEY (orderItems_id) REFERENCES orderItems(id),

);

CREATE TABLE orderItems (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_id int(11) DEFAULT '',
    order_id int(11) DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);








INSERT INTO item (title , price , in_stock, quantity , picture_url , liked , cart ) VALUES
('Oversized Check Detail Geometric Frame Sunglasses',235.59 , 10,1 ,'https://assets.burberry.com/is/image/Burberryltd/25AFC121-C9BB-4E61-907B-E84AC4DD7BB4?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0 , 0),
('Monogram Motif Oversized Round Frame Lola Sunglasses',321.92 , 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/DF899DEE-DCB7-4613-98B7-736262E12BA9?$BBY_V2_ML_1x1$&wid=2500&hei=2500' ,0, 0),
('Cat-eye Frame Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/A9531EAC-A872-4D09-BD80-E11C4B38E696?$BBY_V2_ML_1x1$&wid=1500&hei=1500' , 0, 0),
('Monogram Motif Oversized Square Frame Lola Sunglasses',288.27 , 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/2D19261A-3DA3-4805-91B2-F821B03E954C?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0),
('Logo Detail Cat-eye Frame Sunglasses',321.92, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/C357BB30-A4A8-4BDB-A40D-3D2399514B93?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
('Check Square Frame Sunglasses',261.93, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/67587F1D-2DBA-44DB-83DB-4C8A83F3DD3E?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
('B Motif Square Frame Sunglasses',351.19, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/12822736-2D81-44D4-A30C-B05BD548FEA7?$BBY_V2_ML_1x1$&wid=2500&hei=2500' , 0, 0),
('Vintage Check Detail Pilot Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/c2ba9184d9c58a3de4409f3c1aaaea7b73a5ab02?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 ),
('Logo Lens D-frame Sunglasses',261.93, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/25640660-F83A-441E-ACE5-497D5E52151D?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
('B Lens Detail Rectangular Frame Sunglasses',321.92, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/46a5a94d88131384bc0f594a81b2902f326a856e?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0 , 0),
('Vintage Check Detail Butterfly Frame Sunglasses',235.59, 10 ,1, 'https://assets.burberry.com/is/image/Burberryltd/680e0ef168727a1be1deb616aed64c5fc866448c?$BBY_V2_ML_1x1$&wid=2500&hei=2500',0, 0 ),
('B Motif Rectangular Frame Sunglasses',351.19, 10,1 , 'https://assets.burberry.com/is/image/Burberryltd/76BD3C41-FFD1-4D72-B7D9-3CD110B83F91?$BBY_V2_ML_1x1$&wid=2500&hei=2500', 0, 0 );

INSERT INTO user (first_name , last_name , email ,username, password , phone , address, active, roles, permissions ) VALUES
('lelian','hasan' , 'lelian@gmail.com' , 'lole','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'adan','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'ali','Lole123!','0983903444' , 'nazareth' , 0, '', ''),
('lelian','hasan' , 'lelian@gmail.com' , 'zozo','Lole123!','0983903444' , 'nazareth' , 0, '', '');
