CREATE TABLE nomenclature(
	nomenclature_id int PRIMARY KEY,
	nomenclature_name varchar(100),
	nomenclature_unit varchar(10),
	nomenclature_unit_reduce varchar(2)
);


CREATE TABLE address(
	address_id serial PRIMARY KEY,
	post_index varchar(6),
	country varchar(100),
	region varchar(100),
	city varchar(100),
	street varchar(100),
	house varchar(4)	
);



CREATE TABLE companies(
	company_id serial,
	company_name varchar(100),
	inn varchar(10),
	kpp varchar(9),
	ogrn varchar(13),
	address_id int,
	phone_number varchar(15),
	email varchar(100),
	contact_name varchar(100),
	
	CONSTRAINT PK_companies_company_id_key PRIMARY KEY (company_id),
	CONSTRAINT FK_companies_address_key FOREIGN KEY (address_id) REFERENCES address(address_id)
);



CREATE TABLE roles
(
    role_id int PRIMARY KEY,
	role_name varchar(20)
);


CREATE TABLE status(
	status_id int PRIMARY KEY,
	status_name varchar(10)
);



CREATE TABLE employees(
	employee_id serial,
	name varchar(20),
	surname varchar(20),
	phone_number varchar(15),
	role_id int,
	
	CONSTRAINT PK_employees_employee_id_key PRIMARY KEY (employee_id),
	CONSTRAINT FK_employees_roles_key FOREIGN KEY (role_id) REFERENCES roles(role_id)
);



CREATE TABLE requests(
	request_id serial,
	number_request int,
	nomenclature_id int,
	quantity int,
	company_id int,
	status_id int default 1,
	employee_id int,
	date_create timestamp without time zone NOT NULL,
	date_change timestamp without time zone NOT NULL,
	
	CONSTRAINT PK_requests_request_id_key PRIMARY KEY (request_id),
	CONSTRAINT FK_requests_nomenclature_key FOREIGN KEY (nomenclature_id) REFERENCES nomenclature(nomenclature_id),
	CONSTRAINT FK_requests_companies_key FOREIGN KEY (company_id) REFERENCES companies(company_id),
	CONSTRAINT FK_requests_status_key FOREIGN KEY (status_id) REFERENCES status(status_id),
	CONSTRAINT FK_requests_employees_key FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);



CREATE TABLE drivers(
	driver_id serial PRIMARY KEY,
	name varchar(20),
	surname varchar(20),
	phone_number varchar(15)
);



CREATE TABLE warehouse(
	warehouse_id serial,
	nomenclature_id int,
	quantity int,
	CONSTRAINT PK_warehouse_warehouse_id_key PRIMARY KEY (warehouse_id),
	CONSTRAINT FK_warehouse_nomenclature_key FOREIGN KEY (nomenclature_id) REFERENCES nomenclature(nomenclature_id)
);



CREATE TABLE tankers(
	tanker_id serial PRIMARY KEY,
	tanker_number varchar(8),
	certificate varchar(20)
);



CREATE TABLE blanks(
	blank_id serial,
	request_id int,
	driver_id int,
	tanker_id int,
	status_id int default 1,
	employee_id int,
	date_create timestamp without time zone NOT NULL,
	date_change timestamp without time zone NOT NULL,
	
	CONSTRAINT PK_blanks_blank_id_key PRIMARY KEY (blank_id),
	CONSTRAINT FK_blanks_requests_key FOREIGN KEY (request_id) REFERENCES requests(request_id),
	CONSTRAINT FK_blanks_drivers_key FOREIGN KEY (driver_id) REFERENCES drivers(driver_id),
	CONSTRAINT FK_blanks_tankers_key FOREIGN KEY (tanker_id) REFERENCES tankers(tanker_id),
	CONSTRAINT FK_blanks_status_key FOREIGN KEY (status_id) REFERENCES status(status_id),
	CONSTRAINT FK_blanks_employees_key FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);




CREATE TABLE invoices(
	invoice_id serial,
	blank_id int,
	invoice_number varchar(8),
	nomenclature_id int,
	quantity int,
	company_id int,
	employee_id int,
	date_invoice timestamp without time zone NOT NULL,
	date_create timestamp without time zone NOT NULL,
	date_change timestamp without time zone NOT NULL,
	status_id integer,
	
	CONSTRAINT PK_invoices_invoice_id_key PRIMARY KEY (invoice_id),
	CONSTRAINT FK_invoices_blanks_key FOREIGN KEY (blank_id) REFERENCES blanks(blank_id),
	CONSTRAINT FK_invoice_nomenclature_key FOREIGN KEY (nomenclature_id) REFERENCES nomenclature(nomenclature_id),
	CONSTRAINT FK_invoice_companies_key FOREIGN KEY (company_id) REFERENCES companies(company_id),
	CONSTRAINT FK_invoices_employees_key FOREIGN KEY (employee_id) REFERENCES employees(employee_id),
	CONSTRAINT FK_invoices_status_key FOREIGN KEY (status_id) REFERENCES status (status_id)
);
