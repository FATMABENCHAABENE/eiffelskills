-- insert admin user
insert into public.users(name,mail,password,role) values('admin','admin@es.fr','testadmin','admin');
-- insert student users
insert into public.users(name,surname,mail,password,role) values('Elliot','Handersen','ehandersen@es.fr','studentsic','student_SIC');
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

-- insert MCQ SI security
insert into public.mcq(description, id_module) VALUES ('MCQ SI security',1);
-- ## with questions
    insert into public.questions(description, id_mcq, id_skill) VALUES ('A quoi sert NMAP ?',1,1);
    insert into public.questions(description, id_mcq, id_skill) VALUES ('Quel command metasploit permet de lancer un exploit ?',1,2);
-- ### with awnsers
        insert into public.awnsers(description, id_question, is_good) VALUES ('Faire une injection SQL',1,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Scanner un réseau ou un appareil',1,true);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Les deux réponses précédentes',1,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Aucune réponse',1,false);

        insert into public.awnsers(description, id_question, is_good) VALUES ('start',2,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('launch',2,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('attack',2,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('run',2,true);

-- insert MCQ Machine Learning
insert into public.mcq(description, id_module) VALUES ('MCQ Machine Learning',3);
-- ## with questions
    insert into public.questions(description, id_mcq, id_skill) VALUES ('Quel est le type de l algorithme K-mean ?',2,3);
-- ### with awnsers
        insert into public.awnsers(description, id_question, is_good) VALUES ('Arbre de désision',3,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Voisinage',3,true);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Basé sur un modèle',3,false);
        insert into public.awnsers(description, id_question, is_good) VALUES ('Aucune réponse',3,false);

-- insert a resource in SI security
insert into public.resources(content, id_module, name) VALUES ('nmap.org',1,'Site officiel de NMAP');

-- insert eval
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (1,2,'acquiring');
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (2,2,'acquired');