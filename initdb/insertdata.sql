-- insert admin user
insert into public.users(name,mail,password,role) values('admin','admin@es.fr','testadmin','admin');
insert into public.users(name,mail,password,role) values('student','student@es.fr','teststudent','student_SIC');


-- insert a module
insert into public.modules(description, major) values ('SI security','SIC');

-- insert a skill
insert into public.skills(description, id_module) values ('NMAP',1);

-- insert an eval
insert into public.autoevaluations(id_skill, id_student, eval) VALUES (1,1,'acquiring');