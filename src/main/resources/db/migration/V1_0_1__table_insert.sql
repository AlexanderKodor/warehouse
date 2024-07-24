
INSERT INTO nomenclature VALUES
(1,'Бензин АИ-92','литр','л.'),
(2,'Бензин АИ-95','литр','л.'),
(3,'Дизельное топливо','литр','л.');


INSERT INTO address(post_index,country,region,city,street,house) VALUES
('440000','Россия','Пензенская область','Пенза','Кирова','88'),
('440000','Россия','Пензенская область','Пенза','Калинина','89Б'),
('440000','Россия','Пензенская область','Кузнецк','Ленина','19-1');


INSERT INTO companies(company_name,inn,kpp,ogrn,address_id,phone_number,email,contact_name) VALUES
('Роснефть','7706107510','770601001','1027700043502',1,'89000000001','rosneft@email.ru','Иван Васильевич'),
('Лукойл','7453011758','027401001','1027402893418',2,'89000900001','lukoil@email.ru','Пётр Иванович'),
('Татнефть','1644040195','164401001','1061644064371',3,'89000700001','tatneft@email.ru','Ильяс Фатихович');


INSERT INTO status VALUES
(1,'в работе'),
(2,'в ожидании'),
(3,'выполнена');

INSERT INTO roles VALUES
(1,'админ'),
(2,'завхоз'),
(3,'оператор'),
(4,'менеджер');


INSERT INTO employees(name,surname,phone_number,role_id) VALUES
('Гриша','Длиноухов','89273777700',1),
('Владислав Игоревич','Забота','89279998800',2),
('Алёна','Климова','89273888800',3),
('Ирина','Ждун','89272288800',4);


INSERT INTO requests(number_request,nomenclature_id,quantity,company_id,status_id,employee_id,date_create,date_change) VALUES
(2024001,1,28000,1,1,3,'2024.07.20 09:30:00','2024.07.20 09:30:00'),
(2024002,2,17000,2,2,3,'2024.07.20 10:37:00','2024.07.20 10:37:00'),
(2024003,3,9000,3,1,3,'2024.07.20 12:01:00','2024.07.20 12:01:00');


INSERT INTO drivers(name,surname,phone_number) VALUES
('не заполнено','',''),
('Игорь','Иванов','89273777700'),
('Сергей','Фролов','89279998800'),
('Семён','Слипаков','89273888800');



INSERT INTO warehouse(nomenclature_id,quantity) VALUES
(1,100000),
(2,100000),
(3,100000);


INSERT INTO tankers(tanker_number,certificate) VALUES
('пусто',''),
('к478ке58','wy45yrtghs54'),
('м882фо58','1o8397ro4'),
('а555ам77','1p908y34rt0982h39f');


INSERT INTO blanks(request_id,driver_id,tanker_id,status_id,employee_id,date_create,date_change) VALUES
(1,1,1,1,4,'2024.07.20 09:30:00','2024.07.20 09:40:00'),
(2,2,2,2,4,'2024.07.20 10:37:00','2024.07.20 10:47:00'),
(3,3,3,1,4,'2024.07.20 12:01:00','2024.07.20 12:11:00');



INSERT INTO invoices(blank_id,invoice_number,nomenclature_id,quantity,company_id,employee_id,date_invoice,date_create,date_change,status_id) VALUES
(1,'G-101',1,28000,1,2,'2024.07.20 11:30:00','2024.07.20 09:30:00','2024.07.20 09:40:00',2),
(2,'G-102',2,17000,2,2,'2024.07.20 12:37:00','2024.07.20 10:37:00','2024.07.20 10:47:00',2),
(3,'G-103',3,9000,3,2,'2024.07.20 14:01:00','2024.07.20 12:01:00','2024.07.20 12:11:00',2);