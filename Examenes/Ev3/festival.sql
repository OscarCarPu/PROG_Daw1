CREATE Database festival;
use festival;

CREATE TABLE festival (
  idFest int NOT NULL,
  nombre varchar(30) NOT NULL,
  aforo int NOT NULL,
  tipo bit,
  presupuesto float,
  PRIMARY KEY (idFest)
);

CREATE TABLE grupos (
  idGrupo int NOT NULL,
  nombre varchar(30) NOT NULL,
  cache float,
  tipo varchar(30),
  PRIMARY KEY (idGrupo)
);

CREATE TABLE slots (
  idSlot int NOT NULL,
  dia varchar(30) NOT NULL,
  franja int NOT NULL,
  idGrupo int NOT NULL,
  PRIMARY KEY (idSlot),
  CONSTRAINT slots FOREIGN KEY (idGrupo) REFERENCES grupos (idGrupo) ON DELETE CASCADE ON UPDATE CASCADE

);

INSERT INTO festival VALUES (1,"Son do Camiño",20000,0,15000000);
INSERT INTO grupos VALUES (1,"MGMT", 12000,"Pop"),(2,"U2", 18000,"Rock"),(3,"Los suaves", 8000,"Rock"),(4,"Smiths", 20000,"Pop"),(5,"Air", 45000,"Electronica"),(6,"Justice",80000,"Electronica"),(7,"Taylor", 100000,"Pop"),(8,"Red Hot", 30000,"Rock"),(9,"Hot Chip", 23000,"Electronica"),(10,"Thom Yorke", 12000,"Electronica"),(11,"Michael", 9000,"Pop"),(12,"Mundo Prestigio", 3000,"Pop");
INSERT INTO slots VALUES (1,"V",2,3),(2,"V",1,4),(3,"S",3,1),(4,"S",1,5),(5,"V",3,6),(6,"S",2,7),(7,"V",4,8),(8,"V",5,12),(9,"V",6,9),(10,"S",4,2),(11,"S",5,10),(12,"S",4,11);





