/*Create table Employee*/
CREATE TABLE Employee (
  employee_id SERIAL NOT NULL,
  firstname VARCHAR(30) NOT NULL,
  lastname VARCHAR(30) NOT NULL,
  salary DOUBLE PRECISION NOT NULL,
  PRIMARY KEY (employee_id)
);
<<<<<<< HEAD

CREATE TABLE Adress(

    adress_id INT PRIMARY KEY NOT NULL,
    street TEXT NOT NULL,
    street_nr INT,
    building CHAR(10),
    floor INT,
    apartment INT,
    locality TEXT NOT NULL,
    country TEXT NOT NULL);
=======
>>>>>>> fa386be12fbba9ec92f32e8b404bb2159bbf9633
