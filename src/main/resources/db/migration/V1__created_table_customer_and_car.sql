CREATE TABLE customer (
    id_customer INT PRIMARY KEY AUTO_INCREMENT,
    name_customer VARCHAR(255),
    telefone_customer VARCHAR(20),
    email_customer VARCHAR(255)
);

CREATE TABLE car (
    id_car INT PRIMARY KEY AUTO_INCREMENT,
    name_car VARCHAR(255),
    color VARCHAR(255),
    mark_car VARCHAR(255),
    plate_car VARCHAR(255),
    id_customer INT,
	FOREIGN KEY (id_customer) REFERENCES customer(id_customer)
);