/*Create table Employee*/
CREATE TABLE Employee (
  ID SERIAL NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  salary DOUBLE PRECISION NOT NULL,
  PRIMARY KEY (ID)
);

/*Create table Address*/
CREATE TABLE Address(
  ID SERIAL NOT NULL,
  street TEXT NOT NULL,
  street_nr INT,
  building CHAR(10),
  floor INT,
  apartment INT,
  locality TEXT NOT NULL,
  country TEXT NOT NULL,
  PRIMARY KEY (ID)
);

/*Create table Car*/
CREATE TABLE Car(
  ID SERIAL NOT NULL,
  car_name TEXT NOT NULL,
  car_model CHAR(5) NOT NULL,
  PRIMARY KEY (ID));
);

/*Create table Department*/
CREATE TABLE Department (
  ID SERIAL NOT NULL,
  deptname VARCHAR(30) NOT NULL,
  PRIMARY KEY (ID)
)
