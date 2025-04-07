
-- Insertar categorías
INSERT INTO categories (name)
VALUES ('Work'),
       ('Personal'),
       ('Urgent');

-- Insertar usuarios
INSERT INTO app_users (first_name, last_name, email, password)
VALUES ('Bill', 'Gates', 'billgates@taskapp.com', 'password'),
       ('Elon', 'Musk', 'elonmusk@taskapp.com', 'password');

-- Insertar tareas para user1
INSERT INTO tasks (title, description, status, user_id, category_id)
VALUES ('Task 1 - User1', 'Description of task 1 for user 1', 'PENDING', 1, 1),
       ('Task 2 - User1', 'Description of task 2 for user 1', 'IN_PROGRESS', 1, 2),
       ('Task 3 - User1', 'Description of task 3 for user 1', 'COMPLETED', 1, 3),
       ('Task 4 - User1', 'Description of task 4 for user 1', 'PENDING', 1, 1),
       ('Task 5 - User1', 'Description of task 5 for user 1', 'COMPLETED', 1, 2),
       ('Task 6 - User1', 'Description of task 6 for user 1', 'IN_PROGRESS', 1, 3);

-- Insertar tareas para user2
INSERT INTO tasks (title, description, status, user_id, category_id)
VALUES ('Task 1 - User2', 'Description of task 1 for user 2', 'PENDING', 2, 2),
       ('Task 2 - User2', 'Description of task 2 for user 2', 'COMPLETED', 2, 3),
       ('Task 3 - User2', 'Description of task 3 for user 2', 'IN_PROGRESS', 2, 1),
       ('Task 4 - User2', 'Description of task 4 for user 2', 'PENDING', 2, 3),
       ('Task 5 - User2', 'Description of task 5 for user 2', 'COMPLETED', 2, 2),
       ('Task 6 - User2', 'Description of task 6 for user 2', 'IN_PROGRESS', 2, 1);
