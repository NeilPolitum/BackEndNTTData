INSERT INTO tipo_documento (id, tipo) VALUES ('C', 'Cédula de ciudadanía');
INSERT INTO tipo_documento (id, tipo) VALUES ('P', 'Pasaporte');

INSERT INTO cliente (id, tipo_documento_id, first_name, middle_name, last_name, second_last_name, phone, address, city) VALUES 
(23445322, 'C', 'Daniel', 'Santiago', 'Rubiano', 'Pulido', '1234567890', 'Calle 95 con 21', 'Bogota DC');