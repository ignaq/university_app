






INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Rodriguez', 'Mariano');
INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Benitez', 'Mariana');
INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Terrizi', 'Maria');
INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Piñeyro', 'Javier');
INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Garciarena', 'Diego');
INSERT INTO teachers (active , last_name, name) VALUES ('1', 'Montero', 'Andrea');

INSERT INTO teachers (active , last_name, name) VALUES ('0', 'Montero', 'Pablo');



INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('30', 'Algebra', '0', '12:00', 1);

INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('36', 'Arquitectura', '0', '14:00', 2);

INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('32', 'Estadística', '0', '16:00', 3);

INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('20', 'Análisis', '0', '08:00', 4);

INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('4', 'Inglés', '0', '10:00', 5);

INSERT INTO courses (maximum_quota, name, quota, schedule, teacher_id) VALUES ('20', 'Física', '0', '12:00', 6);







/*Users y roles*/

/* alumno = 8878979 - password = 1234 */
insert into users (dni, legajo, enabled) values ('8878979','$2a$10$S.QKKAEvxBcFTYtko1Dt9.jzjXIKVgr.l06MbDBx4g5i3TqV10/EW',1);
insert into students (name, last_name, fk_user) values ('Ricardo','Lopez',1);


/* admin = admin - password = admin */
insert into users (dni, legajo, enabled) values ('admin','$2a$10$WNjvCrQNCpim/R/bGWVxw.LOC68JxJQQE64QjoyMtp9mF.NcfdRDG',1);

insert into students (name, last_name, fk_user) values ('El Admin' ,'web', 2);


/* admin = admin2 - password = admin */
insert into users (dni, legajo, enabled) values ('admin2','$2a$10$WNjvCrQNCpim/R/bGWVxw.LOC68JxJQQE64QjoyMtp9mF.NcfdRDG',1);

insert into students (name, last_name, fk_user) values ('admin2' ,'nuevo Admin', 3);

/* alumno = 44223422 - password = 1234 */
insert into users (dni, legajo, enabled) values ('44223422','$2a$10$S.QKKAEvxBcFTYtko1Dt9.jzjXIKVgr.l06MbDBx4g5i3TqV10/EW',1);
insert into students (name, last_name, fk_user) values ('Moralez','Patricio',4);



insert into authorities (user_id, authority) values (1, 'ROLE_USER');
insert into authorities (user_id, authority) values (2, 'ROLE_ADMIN');
insert into authorities (user_id, authority) values (2, 'ROLE_USER');
insert into authorities (user_id, authority) values (3, 'ROLE_ADMIN');
insert into authorities (user_id, authority) values (3, 'ROLE_USER');

insert into authorities (user_id, authority) values (4, 'ROLE_USER');


INSERT INTO course_student (course_id, student_id) VALUES ('1', '1');






