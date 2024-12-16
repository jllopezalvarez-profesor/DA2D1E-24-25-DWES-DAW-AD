INSERT INTO books (isbn, title, description)
VALUES ('9780132350884', 'Clean Code', 'A Handbook of Agile Software Craftsmanship by Robert C. Martin'),
       ('9780201616224', 'The Pragmatic Programmer', 'Your Journey To Mastery by Andrew Hunt and David Thomas'),
       ('9780137081073', 'Effective Java', 'Programming best practices for Java by Joshua Bloch'),
       ('9781492078005', 'Learning Spring Boot', 'Spring Boot application development by Greg Turnquist'),
       ('9780596009205', 'Head First Java', 'A Brain-Friendly Guide by Kathy Sierra and Bert Bates'),
       ('9780134685991', 'Core Java Volume I', 'Fundamentals by Cay S. Horstmann'),
       ('9780596158059', 'Java Concurrency in Practice', 'Concurrency patterns and practices by Brian Goetz'),
       ('9780134494166', 'Modern Java in Action', 'Functional programming and streams by Raoul-Gabriel Urma'),
       ('9780135166307', 'Spring in Action', 'Spring Framework development by Craig Walls'),
       ('9780134854182', 'Effective Kotlin', 'Best practices for Kotlin development by Marcin Moskala');


INSERT INTO authors (name, description)
VALUES ('Robert C. Martin', 'Author of Clean Code and other influential software development books'),
       ('Andrew Hunt', 'Co-author of The Pragmatic Programmer and expert in agile methodologies'),
       ('Joshua Bloch', 'Java expert and author of Effective Java, former Sun Microsystems engineer'),
       ('Kathy Sierra', 'Co-author of Head First Java and advocate for brain-friendly learning');

-- Asociación entre libros y autores
INSERT INTO authors_books (book_id, author_id)
VALUES
-- 'Clean Code' by Robert C. Martin
(1, 1),
-- 'The Pragmatic Programmer' by Andrew Hunt
(2, 2),
-- 'Effective Java' by Joshua Bloch
(3, 3),
-- 'Head First Java' by Kathy Sierra
(5, 4),

-- Libros con más de un autor
-- 'The Pragmatic Programmer' by Andrew Hunt and Robert C. Martin
(2, 1),
-- 'Learning Spring Boot' by Greg Turnquist (as a collaboration with Joshua Bloch)
(4, 3),
-- 'Head First Java' by Kathy Sierra and Andrew Hunt
(5, 2),

-- Autores con más de un libro
-- Robert C. Martin also wrote 'Core Java Volume I'
(6, 1),
-- Joshua Bloch also wrote 'Java Concurrency in Practice'
(7, 3),
-- Andrew Hunt also contributed to 'Spring in Action'
(9, 2),
-- Kathy Sierra contributed to 'Modern Java in Action'
(8, 4);

INSERT INTO users (user_id, email)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'john.doe@example.com'),
       ('550e8400-e29b-41d4-a716-446655440001', 'jane.smith@example.com'),
       ('550e8400-e29b-41d4-a716-446655440002', 'mike.jones@example.com'),
       ('550e8400-e29b-41d4-a716-446655440003', 'susan.taylor@example.com');

-- Préstamos devueltos
INSERT INTO loans (loan_date, return_date, book_id, user_id)
VALUES ('2024-11-01', '2024-11-10', 1, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-11-03', '2024-11-12', 2, '550e8400-e29b-41d4-a716-446655440001'),
       ('2024-11-05', '2024-11-15', 3, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-07', '2024-11-17', 4, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-11-08', '2024-11-18', 5, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-11-10', '2024-11-20', 6, '550e8400-e29b-41d4-a716-446655440001'),
       ('2024-11-12', '2024-11-22', 7, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-15', '2024-11-25', 8, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-11-18', '2024-11-28', 9, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-11-20', '2024-11-30', 10, '550e8400-e29b-41d4-a716-446655440001');

-- Préstamos no devueltos aún
INSERT INTO loans (loan_date, return_date, book_id, user_id)
VALUES ('2024-11-25', NULL, 1, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-26', NULL, 2, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-11-27', NULL, 3, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-11-28', NULL, 4, '550e8400-e29b-41d4-a716-446655440001'),
       ('2024-11-29', NULL, 5, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-30', NULL, 6, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-12-01', NULL, 7, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-12-02', NULL, 8, '550e8400-e29b-41d4-a716-446655440001'),
       ('2024-12-03', NULL, 9, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-12-04', NULL, 10, '550e8400-e29b-41d4-a716-446655440003');

-- Préstamos mixtos (devueltos y no devueltos para los mismos libros)
INSERT INTO loans (loan_date, return_date, book_id, user_id)
VALUES ('2024-11-01', '2024-11-05', 1, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-11-06', NULL, 1, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-10', '2024-11-15', 2, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-11-16', NULL, 2, '550e8400-e29b-41d4-a716-446655440001'),
       ('2024-11-20', '2024-11-25', 3, '550e8400-e29b-41d4-a716-446655440002'),
       ('2024-11-26', NULL, 3, '550e8400-e29b-41d4-a716-446655440003'),
       ('2024-11-30', '2024-12-05', 4, '550e8400-e29b-41d4-a716-446655440000'),
       ('2024-12-06', NULL, 4, '550e8400-e29b-41d4-a716-446655440001');

