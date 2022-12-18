INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time)
VALUES ('Kisacka 1', 8, 'Republika Srbija', 'odlicno', '08:00', 'srbija',  '16:00');

INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time)
VALUES ('Kisacka 1', 2, 'Mepublika Srbija', 'dobro', '08:00', 'braon',  '16:00');


INSERT INTO centers (address, average_grade, country, description, end_time, name, start_time)
VALUES ('Kisacka 1', 9, 'Aepublika Srbija', 'lose', '08:00', 'zeleni',  '16:00');

INSERT INTO ROLE (name) VALUES('ROLE_SYSTEM_ADMINISTRATOR');
INSERT INTO ROLE (name) VALUES('ROLE_REGULAR_USER');
INSERT INTO ROLE (name) VALUES('ROLE_CENTER_ADMINISTRATOR');


INSERT INTO warehouses (bandage, blood_quantity0, blood_quantitya, blood_quantityab, blood_quantityb, needles, test_tubes, centerwh_id)
VALUES (1, 2, 3, 4, 5, 6, 7, 1);

INSERT INTO users (address, city, country, education, username, first_name, gender, jmbg, last_name, password, phone_number, profession, enabled)
VALUES ('micurinova', 'novi sad', 'srbija', 'srednja', 'nenad@gmail.com', 'nenad', 'MALE', '3334444', 'jodlic', '1234', '333487445', 'student', TRUE);

INSERT INTO users (address, city, country, education, username, first_name, gender, jmbg, last_name, password, phone_number, profession, enabled)
VALUES ('micurinova1', 'novi sad', 'srbija', 'srednja', 'bogdan@gmail.com', 'nenad1', 'MALE', '33344464', 'jodlic', '12234', '33362487445', 'student', TRUE);


INSERT INTO users (address, city, country, education, username, first_name, gender, jmbg, last_name, password, phone_number, profession, enabled)
VALUES ('micurinova2', 'novi sad', 'srbija', 'srednja', 'sesa@gmail.com', 'nenad34', 'MALE', '3334423424', 'jodlac', '12634', '3363487445', 'student', TRUE);

INSERT INTO users (address, city, country, education, username, first_name, gender, jmbg, last_name, password, phone_number, profession, enabled)
VALUES ('zepsa', 'novi sad', 'bosna', 'srednja', 'sladjana@gmail.com', 'kava', 'MALE', '67452', 'solja', '1286634', '45445', 'radi', TRUE);


-- INSERT INTO users (address, city, country, education, username, first_name, gender, jmbg, last_name, password, phone_number, profession, enabled)
-- VALUES ('rumenacka3', 'novi sad', 'srb', 'srednja', 'marko@gmail.com', 'marko', 'MALE', '8778', 'markovic', '444545', '989746', 'prog', TRUE);

INSERT INTO regularusers (loyalty, penalties, points, user_id)
VALUES ('REGULAR', 0, 0, 1);

-- INSERT INTO regularusers (loyalty, penalties, points, user_id)
-- VALUES ('REGULAR', 0, 0, 5);

INSERT INTO systemadministrators(user_id)
VALUES(2);

INSERT INTO terms (date_term, duration, center_term_id, regular_user_id)
VALUES ('2000-10-10T12:30', 18, 1, 1);
INSERT INTO terms (date_term, duration, center_term_id, regular_user_id)
VALUES ('2000-10-10T11:30', 18, 1, 1);

-- INSERT INTO terms (date_term, duration, center_term_id, regular_user_id)
-- VALUES ('2000-11-11', 7, 1, 2);

INSERT INTO centeradministrators(user_id, centercas_id, term_id)
VALUES(3, 1, 1);

INSERT INTO centeradministrators(user_id, centercas_id, term_id)
VALUES(4, 1, 1);

INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
INSERT INTO user_role (user_id, role_id) VALUES (4, 3);

INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);

-- INSERT INTO user_role (user_id, role_id) VALUES (5, 2);

INSERT INTO complaints(response, text, centerco_id, center_administrator_id, regular_user_id, system_administrator_id)
VALUES ('dobar', 'neki test', 1, 1, 1 ,1);

-- INSERT INTO complaints(response, text, centerco_id, center_administrator_id, regular_user_id, system_administrator_id)
-- VALUES ('ok', 'nesto', 1, 1, 2 ,1);

INSERT INTO grades(grade, centergr_id, regular_user_id)
VALUES (5, 1, 1);


INSERT INTO questionnaries (blood_type, regular_user_id)
VALUES ('ZERO', 1);

-- INSERT INTO questionnaries (blood_type, regular_user_id)
-- VALUES ('ZERO', 2);

