/*Create table Employee*/
CREATE TABLE Employee (
  ID SERIAL NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  salary DOUBLE PRECISION NOT NULL,
  PRIMARY KEY (ID)
);

DROP TABLE Employee;