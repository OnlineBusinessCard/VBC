USE vbc_db;

# users
INSERT INTO users (id, username, first_name, last_name, email, password, card_id)
VALUES (1, 'jane123', 'Jane', 'Doe', 'jane0@mail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 1);
INSERT INTO  users (id, username, first_name, last_name, email, password, card_id)
VALUES (2, 'john321', 'John', 'Smith', 'john@gmail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 2);
INSERT INTO  users (id, username, first_name, last_name, email, password, card_id)
VALUES (3, 'andrew123', 'Andrew', 'Jones', 'jones@gmail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 3);
INSERT INTO  users (id, username, first_name, last_name, email, password, card_id)
VALUES (4, 'cody123', 'Cody', 'Adams', 'cody@yahoo.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 4);
INSERT INTO  users (id, username, first_name, last_name, email, password, card_id)
VALUES (5, 'jeff79', 'Jeff', 'Harris', 'jeff@gmail.com', '$2a$10$9TtfTJFAdZlJziSknY69QOmakPUx8E5f4j7OUtivNIEBkrVwAmm4e!', 5);

# cards
INSERT INTO cards (id, first_name, last_name, email, phone, title, website, company, city, state, country)
VALUES (1, 'Jane', 'Doe', 'jane0@mail.com','2101231234', 'agent', 'www.mywebsite.com', 'MyCompany', 'Austin', 'Tx', 'USA');
INSERT INTO cards (id, first_name, last_name, email, phone, title, website, company, city, state, country)
VALUES (2, 'John', 'Smith', 'john@gmail.com','2101231234', 'agent', 'www.mywebsite.com', 'MyCompany', 'Austin', 'Tx', 'USA');
INSERT INTO cards (id, first_name, last_name, email, phone, title, website, company, city, state, country)
VALUES (3, 'Andrew', 'Jones', 'jones0@gmail.com','2101231234', 'agent', 'www.mywebsite.com', 'MyCompany', 'Austin', 'Tx', 'USA');
INSERT INTO cards (id, first_name, last_name, email, phone, title, website, company, city, state, country)
VALUES (4, 'Cody', 'Adams', 'cody@yahoo.com','2101231234', 'agent', 'www.mywebsite.com', 'MyCompany', 'Austin', 'Tx', 'USA');
INSERT INTO cards (id, first_name, last_name, email, phone, title, website, company, city, state, country)
VALUES (5, 'Jeff', 'Harris', 'jeff@gmail.com','2101231234', 'agent', 'www.mywebsite.com', 'MyCompany', 'Austin', 'Tx', 'USA');

# images
INSERT INTO images (id, filestack_url, service_id)
VALUES (1, 'https://cdn.filestackcontent.com/AsXkBLtTybLfQCsHT0QW', 1);
INSERT INTO images (id, filestack_url, service_id)
VALUES (2, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 2);
INSERT INTO images (id, filestack_url, service_id)
VALUES (3, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 3);
INSERT INTO images (id, filestack_url, service_id)
VALUES (4, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 4);
INSERT INTO images (id, filestack_url, service_id)
VALUES (5, 'https://cdn.filestackcontent.com/9u7NzKMPT3670xrhdJXD', 5);