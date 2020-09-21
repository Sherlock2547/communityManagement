-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE users IF EXISTS;
DROP TABLE residents IF EXISTS;
DROP TABLE houses IF EXISTS;

DROP TABLE patient IF EXISTS;

create table patient
(
  id  INTEGER IDENTITY PRIMARY KEY,
  name      varchar(18),
  phone     NUMBER,
  start_time Date
);
DROP TABLE department IF EXISTS;
create table department
(
  id  INTEGER IDENTITY PRIMARY KEY,
  name    varchar(20)
);





CREATE TABLE  users  (
   id  INTEGER IDENTITY PRIMARY KEY,
   name varchar(10) NOT NULL,
   pwd varchar(18) NOT NULL
); 
CREATE INDEX users_name ON users (name);

CREATE TABLE  houses  (
   id  INTEGER IDENTITY PRIMARY KEY,
   address varchar(20) NOT NULL,
   area FLOAT NOT NULL,
   struct varchar(20) NOT NULL,
   status varchar(20) NOT NULL
);
CREATE INDEX house_address ON houses (address);


CREATE TABLE  residents  (
   id  INTEGER IDENTITY PRIMARY KEY,
   name varchar(10) NOT NULL,
   age INTEGER NOT NULL,
   gender varchar(10) NOT NULL,
   house_address varchar(20) NOT NULL,
   number NUMBER NOT NULL,
   phone NUMBER NOT NULL,
   start Date
);
ALTER TABLE residents ADD CONSTRAINT fk_residents_houses FOREIGN KEY (house_address) REFERENCES houses (address);
CREATE INDEX residents_name ON residents (name);

