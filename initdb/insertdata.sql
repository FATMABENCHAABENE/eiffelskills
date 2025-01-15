-- insert admin user
insert into public.users(name,mail,password,role) values('admin','admin@es.fr','testadmin','admin');
insert into public.users(name,mail,password,role) values('student','student@es.fr','teststudent','student_SIC');
insert into public.users(name,mail,password,role) values('teacher','teacher@es.fr','testteacher','teacher');


-- insert a module
insert into public.modules(description, major,id_teacher) values ('SI security','SIC',3);
insert into public.modules(description, major,id_teacher) values ('LINUX security','SIC',3);
--insert into public.modules(description, major) values ('SI management','SIC');
--insert into public.modules(description, major) values ('Windows security','SIC');

-- insert a skill
insert into public.skills(description, id_module) values ('NMAP',1);
insert into public.skills(description, id_module) values ('injection SQL',1);
insert into public.skills(description, id_module) values ('XSS',1);
insert into public.skills(description, id_module) values ('Metasploit',1);
insert into public.skills(description, id_module) values ('XSRF',1);

-- insert an eval
insert into public.autoevaluations(id_skill, id_student, eval) VALUES (1,2,'acquiring');
insert into public.autoevaluations(id_skill, id_student, eval) VALUES (2,2,'acquired');