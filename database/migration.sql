DROP DATABASE IF EXISTS vbc_db;
CREATE DATABASE IF NOT EXISTS vbc_db;
USE vbc_db;

SHOW TABLES;

DESCRIBE users;
DESCRIBE cards;
DESCRIBE images;
DESCRIBE leads;
DESCRIBE reviews;

CREATE TABLE IF NOT EXISTS users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    card_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (username, email),
    FOREIGN KEY (card_id) REFERENCES cards (id)
);

CREATE TABLE IF NOT EXISTS cards (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    website VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY (email)
);

CREATE TABLE IF NOT EXISTS images (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    filestack_url VARCHAR(255) NOT NULL ,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS leads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    create_date_time datetime,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS reviews (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    content longtext NOT NULL ,
    rating decimal(2,1) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

