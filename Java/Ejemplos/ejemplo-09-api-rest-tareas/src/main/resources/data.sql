-- Insertar estados de las tareas
INSERT INTO task_status (task_status_id, name) VALUES (1, 'Pending');
INSERT INTO task_status (task_status_id, name) VALUES (2, 'In Progress');
INSERT INTO task_status (task_status_id, name) VALUES (3, 'Completed');

-- Insertar miembros de la familia
INSERT INTO family_member (family_member_id, name, age) VALUES (1, 'Alice', 34);
INSERT INTO family_member (family_member_id, name, age) VALUES (2, 'Bob', 38);
INSERT INTO family_member (family_member_id, name, age) VALUES (3, 'Charlie', 15);
INSERT INTO family_member (family_member_id, name, age) VALUES (4, 'Daisy', 12);

-- Insertar categorías de tareas
INSERT INTO task_category (task_category_id, name) VALUES (1, 'Household');
INSERT INTO task_category (task_category_id, name) VALUES (2, 'Outdoor');

-- Insertar tareas
INSERT INTO task (task_id, title, description, task_category_id) VALUES (1, 'Clean the kitchen', 'Clean all surfaces and mop the floor', 1);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (2, 'Mow the lawn', 'Mow the front and backyard lawns', 2);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (3, 'Do the laundry', 'Wash, dry, and fold clothes', 1);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (4, 'Wash the car', 'Clean the car inside and out', 2);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (5, 'Grocery shopping', 'Buy groceries for the week', 1);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (6, 'Trim the hedges', 'Trim the hedges in the front yard', 2);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (7, 'Vacuum the house', 'Vacuum all rooms and hallways', 1);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (8, 'Take out the trash', 'Empty all trash cans and take to the curb', 1);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (9, 'Water the plants', 'Water all indoor and outdoor plants', 2);
INSERT INTO task (task_id, title, description, task_category_id) VALUES (10, 'Cook dinner', 'Prepare and cook dinner for the family', 1);

-- Insertar asignaciones de tareas
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (1, 1, '2024-06-10 10:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (2, 2, '2024-06-10 11:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (3, 3, '2024-06-10 12:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (4, 4, '2024-06-10 13:00:00', 3);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (1, 5, '2024-06-10 14:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (2, 6, '2024-06-10 15:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (3, 7, '2024-06-10 16:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (4, 8, '2024-06-10 17:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (1, 9, '2024-06-10 18:00:00', 3);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (2, 10, '2024-06-10 19:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (3, 1, '2024-06-11 10:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (4, 2, '2024-06-11 11:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (1, 3, '2024-06-11 12:00:00', 3);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (2, 4, '2024-06-11 13:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (3, 5, '2024-06-11 14:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (4, 6, '2024-06-11 15:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (1, 7, '2024-06-11 16:00:00', 2);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (2, 8, '2024-06-11 17:00:00', 3);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (3, 9, '2024-06-11 18:00:00', 1);
INSERT INTO task_assignment (family_member_id, task_id, assignment_datetime, task_status_id) VALUES (4, 10, '2024-06-11 19:00:00', 2);

-- Insertar habitaciones
insert into room(name) values ('Bedroom'), ('Bathroom');