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