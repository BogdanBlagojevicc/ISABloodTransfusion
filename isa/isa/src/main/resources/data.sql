INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time) 
VALUES ('Kisacka 1', 8, 'Republika Srbija', 'odlicno', '2000-10-11', 'srbija',  '2000-10-10');

INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time) 
VALUES ('Kisacka 1', 2, 'Mepublika Srbija', 'dobro', '2000-10-11', 'braon',  '2000-10-10');

INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time) 
VALUES ('Kisacka 1', 9, 'Aepublika Srbija', 'lose', '2000-10-11', 'zeleni',  '2000-10-10');

INSERT INTO systemadministrators (address, city, country, education, email, first_name, gender, jmbg, last_name, password, phone_number, profession)
VALUES ('micurinova 72', 'novi sad', 'srbija', 'srednja', 'nenaad@gmail.com', 'nenad', 'MALE', '30040032432', 'joldic', '1234j', '234234', 'student');

INSERT INTO warehouses (bandage, blood_quantity0, blood_quantitya, blood_quantityab, blood_quantityb, needles, test_tubes, center_id)
VALUES (1, 2, 3, 4, 5, 6, 7, 1);

INSERT INTO regularusers (address, city, country, education, email, first_name, gender, jmbg, last_name, password, phone_number, profession,loyalty, penalties, points)
VALUES ('micurinova 72', 'novi sad', 'srbija', 'srednja', 'nenad@gmail.com', 'nenad', 'MALE', '30040032432', 'joldic', '1234j', '234234', 'student','GOLD', 1, 1);

INSERT INTO terms(date_term, duration, center_term_id, regular_user_id)
VALUES ('2000-10-10', 10, 1, 1);

INSERT INTO centeradministrators (address, city, country, education, email, first_name, gender, jmbg, last_name, password, phone_number, profession,center_id, term_id)
VALUES ('micurinova 72', 'novi sad', 'srbija', 'srednja', 'nenad@gmail.com', 'nenad', 'MALE', '30040032432', 'joldic', '1234j', '234234', 'student',1, 1);

INSERT INTO complaints (response, text, center_id, center_administrator_id, regular_user_id, system_administrator_id) 
VALUES (NULL, 'WC nema sapuna', 1, 1, 1, 1);

INSERT INTO grades (grade, center_id, regular_user_id)
VALUES (5, 1, 1);

INSERT INTO questionnaries (blood_type, regular_user_id)
VALUES ('ZERO', 1);