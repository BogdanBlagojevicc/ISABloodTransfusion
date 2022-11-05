INSERT INTO centers ( address,end_time, average_grade,  country, description, name, start_time  ) VALUES ('Kisacka 1', '2000-10-11', 0,'Republika Srbija', 'dobro', 'LL',  '2000-10-10');

INSERT INTO users(dtype, address, city, country, education, email, first_name, gender, jmbg, last_name, password, phone_number, profession, loyalty, penalties, points, center_id)
VALUES(0, 'micurinova 72', 'novi sad', 'srbija', 'srednja', 'nenad@gmail.com', 'nenad', 'MALE', '30040032432', 'joldic', '1234j', '234234', 'student', 'REGULAR', 2, 2, 1);

INSERT INTO complaints (response, text, center_complaint_id, regular_user_id, user_complaint_id) 
VALUES ('Kisacka 1', 'Republika Srbija', 1, 1,  1);

INSERT INTO grades (grade, center_id, user_id)
VALUES (5, 1, 1);

INSERT INTO questionnaries (blood_type, regular_user_id)
VALUES ('ZERO', 1);

INSERT INTO terms(duration, date_term, center_administrator_id, center_term_id, regular_user_id)
VALUES (10, '2000-10-10', 1,  1, 1);

INSERT INTO warehouses (bandage, blood_quantity0, blood_quantitya, blood_quantityab, blood_quantityb, needles, test_tubes, center_id)
VALUES (1, 2, 3, 4, 5, 6, 7, 1);





