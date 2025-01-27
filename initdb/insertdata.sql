-- insert admin user
insert into public.users(name,mail,password,role) values('admin','admin@es.fr','testadmin','admin');
-- insert student users
insert into public.users(name,surname,mail,password,role) values('Elliot','Handersen','elliot@es.fr','studentsic','student_SIC');
insert into public.users(name, surname, mail, password, role) VALUES ('Aelita','Stones','astones@es.fr','studentbda','student_BDA');
insert into users (name, surname, mail, password, role) values ('Henry','Case','hcase@es.fr','studentse','student_SE');
-- insert teacher users
insert into public.users(name,surname,mail,password,role) values('Remy','Muller','rmuller@es.fr','teachersic','teacher');
insert into public.users(name,surname,mail,password,role) values ('Franz','Hopper','fhopper@es.fr','teacherbda','teacher');
insert into public.users(name, surname, mail, password, role) values ('Wilis','Corto','wcorto@es.fr','teacherse','teacher');


-- insert module SIC
insert into public.modules(description, major,id_teacher) values ('SI security','SIC',5);
insert into public.modules(description, major,id_teacher) values ('LINUX security','SIC',5);
-- insert module BDA
insert into public.modules(description, major,id_teacher) values ('Machine Learning','BDA',6);
-- insert SE
insert into public.modules(description, major,id_teacher) values ('Micro Controller','SIC',7);

-- insert skill
insert into public.skills(description, id_module) values ('NMAP',1);
insert into public.skills(description, id_module) values ('Metasploit',1);
insert into public.skills(description, id_module) values ('K-mean usage',3);
insert into public.skills(description, id_module) VALUES ('C++',4);

-- insert eval
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (1,2,'acquiring');
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (2,2,'acquired');