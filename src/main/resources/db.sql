-- login as root user
-- mysql -u root -p
create database api;
grant all privileges on api.* to 'api'@'%';

-- login as api user
--mysql -u api -p
use api;
create table item_inventory(
   id INT NOT NULL AUTO_INCREMENT,
   item_number INT,
   price_per_unit INT,
   available_units INT,
   weight_per_unit_in_kg INT,
   PRIMARY KEY (id)
);

create table orders(
   id INT NOT NULL AUTO_INCREMENT,
   item_number INT,
   order_quantity INT,
   logistics_company VARCHAR(20),
   shipping_cost_sub_total INT,
   weight_per_unit_in_kg INT,
   PRIMARY KEY (id)
);

INSERT INTO item_inventory(item_number, price_per_unit, available_units, weight_per_unit_in_kg) VALUES (1234, 12, 10, 1);
INSERT INTO item_inventory(item_number, price_per_unit, available_units, weight_per_unit_in_kg) VALUES (5678, 10, 6, 2);