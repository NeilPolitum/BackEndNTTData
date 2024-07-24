CREATE TABLE tipo_documento (
    id VARCHAR(2) PRIMARY KEY,
    tipo VARCHAR(50)
);

CREATE TABLE cliente (
    id INT PRIMARY KEY,
    tipo_documento_id VARCHAR(2),
    first_name VARCHAR(50),
    middle_name VARCHAR(50),
    last_name VARCHAR(50),
    second_last_name VARCHAR(50),
    phone VARCHAR(20),
    address VARCHAR(100),
    city VARCHAR(50),
    FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento(id)
);