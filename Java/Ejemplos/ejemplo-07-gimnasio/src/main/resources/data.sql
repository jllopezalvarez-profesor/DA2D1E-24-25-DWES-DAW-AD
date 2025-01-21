INSERT INTO classes (name)
VALUES ('Yoga for Beginners'),
       ('Advanced Pilates'),
       ('Cardio Blast'),
       ('Strength Training'),
       ('Zumba Dance'),
       ('CrossFit Basics'),
       ('Meditation Session'),
       ('Kickboxing Essentials'),
       ('Aqua Aerobics'),
       ('Spin Class');

INSERT INTO teachers (document, first_name, last_name, email, class_id)
VALUES ('DOC001', 'John', 'Smith', 'john.smith@example.com', 1),
       ('DOC002', 'Emily', 'Johnson', 'emily.johnson@example.com', 1),
       ('DOC003', 'Michael', 'Brown', 'michael.brown@example.com', 2),
       ('DOC004', 'Emma', 'Davis', 'emma.davis@example.com', 3),
       ('DOC005', 'James', 'Miller', 'james.miller@example.com', 3),
       ('DOC006', 'Sophia', 'Wilson', 'sophia.wilson@example.com', 4),
       ('DOC007', 'William', 'Moore', 'william.moore@example.com', 4),
       ('DOC008', 'Olivia', 'Taylor', 'olivia.taylor@example.com', 5),
       ('DOC009', 'Benjamin', 'Anderson', 'benjamin.anderson@example.com', 6),
       ('DOC010', 'Charlotte', 'Thomas', 'charlotte.thomas@example.com', 7);



INSERT INTO members (first_name, last_name, email, phone, age)
VALUES ('Alice', 'Williams', 'alice.williams@example.com', '123-456-7890', 20),
       ('Bob', 'Taylor', 'bob.taylor@example.com', '234-567-8901', 30),
       ('Charlie', 'Harris', 'charlie.harris@example.com', '345-678-9012', 34),
       ('Diana', 'Martin', 'diana.martin@example.com', '456-789-0123', 53),
       ('Ethan', 'Walker', 'ethan.walker@example.com', '567-890-1234', 40),
       ('Fiona', 'Scott', 'fiona.scott@example.com', '678-901-2345', 30),
       ('George', 'Hall', 'george.hall@example.com', '789-012-3456', 20),
       ('Hannah', 'Young', 'hannah.young@example.com', '890-123-4567', 18),
       ('Ian', 'King', 'ian.king@example.com', '901-234-5678', 16),
       ('Julia', 'Wright', 'julia.wright@example.com', '012-345-6789', 20);


INSERT INTO members_classes (member_id, class_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (2, 5),
       (3, 3),
       (4, 4),
       (4, 1),
       (5, 6),
       (6, 7),
       (7, 8),
       (8, 9),
       (9, 10),
       (10, 2),
       (10, 4);
