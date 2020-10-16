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

# leads
INSERT INTO leads (id, create_date_time, first_name, last_name, email, phone, user_id)
VALUES (1, '2020-09-02 14:22:21', 'Jane', 'Doe', 'jane@email.com', '2101231234', 1);
INSERT INTO leads (id, create_date_time, first_name, last_name, email, phone, user_id)
VALUES (2, '2020-09-02 14:22:21', 'John', 'Smith', 'john@email.com', '2101231234', 2);
INSERT INTO leads (id, create_date_time, first_name, last_name, email, phone, user_id)
VALUES (3, '2020-09-02 14:22:21', 'Andrew', 'Jones', 'andrew@email.com', '2101231234', 3);
INSERT INTO leads (id, create_date_time, first_name, last_name, email, phone, user_id)
VALUES (4, '2020-09-02 14:22:21', 'Cody', 'Adams', 'cody@email.com', '2101231234', 4);
INSERT INTO leads (id, create_date_time, first_name, last_name, email, phone, user_id)
VALUES (5, '2020-09-02 14:22:21', 'Jeff', 'Harris', 'jeff@email.com', '2101231234', 5);

# reviews
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (1, 'Easy to connect to set up appointment', 'Was able to fit me in for an appointment the next day', 4.0, 1);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (2, 'Best barber in town!', 'Quick service and good communication', 5.0, 2);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (3, 'Great Communication.', 'Good Service', 5.0, 3);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (4, 'Very professional', 'Enjoyed the quick trim.', 4.0, 4);
INSERT INTO reviews (id, title, content, rating, user_id)
VALUES (5, 'Okay experience', 'Ended up starting appointment ten minutes late', 2.0, 5);
