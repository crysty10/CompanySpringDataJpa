/*PgaAdmin III*/
/*DB name: Company*/

/*Create table Address*/
CREATE TABLE Address(
  add_ID SERIAL NOT NULL,
  street TEXT NOT NULL,
  street_nr INT,
  building CHAR(10),
  floor INT,
  apartment INT,
  locality TEXT NOT NULL,
  country TEXT NOT NULL,
  createdDate TIMESTAMP,
  modifiedDate TIMESTAMP,
  PRIMARY KEY (add_ID)
);

/*Create table Car*/
CREATE TABLE Car(
  car_ID SERIAL NOT NULL,
  car_name TEXT NOT NULL,
  car_model CHAR(5) NOT NULL,
  createdDate TIMESTAMP,
  modifiedDate TIMESTAMP,
  PRIMARY KEY (car_ID)
);

/*Create table Department*/
CREATE TABLE Department (
  dep_ID SERIAL NOT NULL,
  deptname VARCHAR(30) NOT NULL,
  createdDate TIMESTAMP,
  modifiedDate TIMESTAMP,
  PRIMARY KEY (dep_ID)
);

/*Create table Employee*/
CREATE TABLE Employee (
  emp_ID SERIAL NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  salary DOUBLE PRECISION NOT NULL,
  dep_ID INTEGER REFERENCES Department(dep_ID),
  createdDate TIMESTAMP,
  modifiedDate TIMESTAMP,
  PRIMARY KEY (emp_ID)
);

/*Create table for relation Employee Car*/
CREATE Table Employee_Car(
  emp_ID INTEGER REFERENCES Employee(emp_ID),
  car_ID INTEGER REFERENCES Car(car_ID),
  PRIMARY KEY (emp_ID, car_ID)
);

/*Create table for relation Employee Address*/
CREATE TABLE Employee_Address(
  emp_ID INTEGER REFERENCES Employee(emp_ID),
  add_ID INTEGER REFERENCES Address(add_ID),
  PRIMARY KEY (emp_ID, add_ID)
);

/*Create table for saving DateTime for every created object or modified object*/
CREATE TABLE Audit(
  id SERIAL NOT NULL,
  objectID INTEGER NOT NULL,
  objectType VARCHAR(30) NOT NULL,
  action VARCHAR(30) NOT NULL,
  modifiedDate TIMESTAMP,
  PRIMARY KEY (id)
);