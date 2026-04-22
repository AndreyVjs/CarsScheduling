Create table employee(

    id_employee INT PRIMARY KEY AUTO_INCREMENT,
    name_employee VARCHAR(255),
    telefone_employee VARCHAR(20),
    email_employee VARCHAR(255),
    salary_employee float,
    entry_date_employee datetime,
    birthday_employee date,
    role_employee varchar(255)

);

Create table service(

id_service INT PRIMARY KEY AUTO_INCREMENT,
name_service varchar(255),
description_service varchar(255),
price_service float,
estimated_time_service Varchar(255),
id_employee INT,
FOREIGN KEY (id_employee) REFERENCES employee(id_employee)

);

Create table work_order(

id_work_order INT PRIMARY KEY AUTO_INCREMENT,
start_date_work_order datetime,
end_date_work_order datetime,
status_work_order varchar(255),
id_customer INT,
id_car INT,
id_service INT,
FOREIGN KEY (id_customer) REFERENCES customer(id_customer),
FOREIGN KEY (id_car) REFERENCES car(id_car),
FOREIGN KEY (id_service) REFERENCES service(id_service)
);