CREATE TABLE IF NOT EXISTS product (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  description varchar(255) NOT NULL,
  cost varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


insert into product (name, description, cost) values ('13 Fishing Rod', 'Awesome Rod', 300.00);
insert into product (name, description, cost) values ('13 Fishing Rod 2', 'Awesome Rod', 300.00);
insert into product (name, description, cost) values ('13 Fishing Rod 3', 'Awesome Rod', 300.00);
insert into product (name, description, cost) values ('13 Fishing Rod 4', 'Awesome Rod', 300.00);
