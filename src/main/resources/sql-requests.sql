CREATE SCHEMA dice1

CREATE TABLE dice1.gamblers1 (
     id serial primary key,
     name varchar(255),
     gamblers integer,
     bolt integer
);


INSERT INTO dice1.gamblers1
("name", "gamblers", "bolt")
VALUES ('Pro100Gamer', '3', '50'),
       ('4eJLoBeK', '2', '50'),
       ('Killer2005', '5', '100');

select name
from dice1.gamblers1;

select name
from dice1.gamblers1
where bolt = 50;

update dice1.gamblers1
set gamblers = 4
where name = 'Killer2005';