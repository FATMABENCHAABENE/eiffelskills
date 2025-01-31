-- insert admin user
insert into public.users(name,mail,password,role) values('admin','admin@es.fr','testadmin','admin');
-- insert student users
insert into public.users(name,surname,mail,password,role) values('Elliot','Handersen','ehandersen@es.fr','studentsic','student_SIC');
insert into public.users(name, surname, mail, password, role) VALUES ('Aelita','Stones','astones@es.fr','studentbda','student_BDA');
insert into public.users (name, surname, mail, password, role) values ('Henry','Case','hcase@es.fr','studentse','student_SE');
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

-- DEMO ELEMENTS
    -- User
insert into public.users(name, surname, mail, password, role) values ('Antoine','The Finn','athefinn@es.fr','teacherse','teacher');
    -- Modules
insert into public.modules(description, major, id_teacher) VALUES ('Modélisation 3D & Fusion 360', 'SE',8);
INSERT INTO public.modules (description, major, id_teacher) VALUES ('Bases de la modélisation 3D', 'SE', 8);
    -- Skills
INSERT INTO public.skills (description, id_module) VALUES ('Les fonctions de Fusion 360', 5);
INSERT INTO public.skills (description, id_module) VALUES ('Bases de Fusion 360', 5);

INSERT INTO public.skills (description, id_module) VALUES ('Fondements de la modélisation 3D', 6);
INSERT INTO public.skills (description, id_module) VALUES ('Usages de la modélisation 3D', 6);
    -- MCQ
INSERT INTO public.mcq (description, id_module) VALUES ('Modélisation 3D & Fusion 360', 5);

INSERT INTO public.mcq (description, id_module) VALUES ('Bases de la modélisation 3D', 6);
    -- Questions
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est la principale fonction de Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Où sont stockées les données des projets Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel type de conception Fusion 360 utilise-t-il principalement ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel espace de travail est utilisé pour créer des esquisses en 2D dans Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel outil permet de transformer une esquisse 2D en objet 3D ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Que permet l''outil "Loft" dans Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle est la différence entre un "Body" et un "Component" dans Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle fonction permet d’arrondir les bords d’un objet ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle option permet de définir une liaison entre deux pièces d''un assemblage ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel type de fichier est couramment utilisé pour l''impression 3D avec Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est l’intérêt du mode "As-Built Joint" ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel outil permet de percer un trou dans un solide ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel espace de travail permet de réaliser des rendus réalistes ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel format est couramment utilisé pour exporter des fichiers de CAO ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle commande permet de déplacer un composant dans un assemblage ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle technique permet d’alléger un modèle en supprimant de la matière tout en conservant la rigidité ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel outil est utilisé pour créer une rainure autour d’un cylindre ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel élément est nécessaire pour commencer une esquisse dans Fusion 360 ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Comment appelle-t-on l’historique des opérations réalisées sur un modèle ?', 3, 5);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle fonction permet de créer un objet en suivant un chemin défini ?', 3, 5);

INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est le principal avantage de la modélisation 3D par rapport au dessin 2D ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est le format de fichier standard pour l’impression 3D ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel type de modélisation 3D est le plus utilisé pour les jeux vidéo ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel logiciel parmi les suivants n''est pas un logiciel de modélisation 3D ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle est la différence entre la modélisation paramétrique et la modélisation directe ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel terme désigne l’enveloppe extérieure d’un objet 3D sans épaisseur ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est le principal inconvénient de la modélisation polygonale ?', 4, 8);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quelle est la principale différence entre un fichier STL et un fichier OBJ ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est l’intérêt du rendu (rendering) en modélisation 3D ?', 4, 7);
INSERT INTO public.questions (description, id_mcq, id_skill) VALUES ('Quel est le principal avantage de l’impression 3D par rapport aux méthodes de fabrication traditionnelles ?', 4, 8);
    -- Awnsers
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Création de vidéos animées', false, 4);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Montage photo', false, 4);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Programmation informatique', false, 4);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modélisation et conception assistée par ordinateur', true, 4);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sur le disque dur local uniquement', false, 5);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sur une clé USB', false, 5);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Dans la mémoire vive', false, 5);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Dans le cloud', true, 5);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Conception ascendante (bottom-up)', false, 6);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Conception paramétrique', false, 6);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Conception aléatoire', false, 6);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Conception descendante (top-down)', true, 6);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Manufacture', false, 7);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Simulation', false, 7);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Animation', false, 7);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Design', true, 7);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Mise à l''échelle', false, 8);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Réduction', false, 8);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Rotation', false, 8);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Extrusion', true, 8);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Créer un cercle à partir d’un point', false, 9);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Extruder une forme en spirale', false, 9);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Supprimer une surface', false, 9);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Relier deux formes différentes par une transition fluide', true, 9);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un "Component" est immuable alors qu’un "Body" est modifiable', false, 10);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Il n''y a pas de différence', false, 10);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un "Body" est plus grand qu’un "Component"', false, 10);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un "Body" est un objet physique, un "Component" peut contenir plusieurs "Bodies"', true, 10);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Loft', false, 11);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Chamfer', false, 11);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Shell', false, 11);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Fillet', true, 11);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Fusion', false, 12);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Offset', false, 12);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sweep', false, 12);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Rigid Joint', true, 12);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.docx', false, 13);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.mp4', false, 13);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.jpeg', false, 13);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.stl', true, 13);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Déplacer librement les objets sans contrainte', false, 14);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Générer automatiquement des pièces', false, 14);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modifier l’échelle d’un modèle', false, 14);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Contraindre des composants déjà positionnés correctement', true, 14);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Fillet', false, 15);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Patch', false, 15);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Trim', false, 15);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Hole', true, 15);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Animation', false, 16);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Drawing', false, 16);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Manufacture', false, 16);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Render', true, 16);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.mp3', false, 17);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.fbx', false, 17);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.exe', false, 17);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.dwg', true, 17);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Offset', false, 18);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Fillet', false, 18);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sweep', false, 18);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Move', true, 18);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Loft', false, 19);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Extrusion', false, 19);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Offset', false, 19);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Shell', true, 19);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sweep', false, 20);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Fillet', false, 20);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Hole', false, 20);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Revolve', true, 20);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un plan ou une face', true, 21);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un composant', false, 21);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un fichier STL', false, 21);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Un rendu photoréaliste', false, 21);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Console', false, 22);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Browser', false, 22);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Terminal', false, 22);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Timeline', true, 22);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Loft', false, 23);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Chamfer', false, 23);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Mirror', false, 23);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Sweep', true, 23);

INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle permet d’imprimer directement sur papier', false, 24);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle est plus facile à apprendre que le dessin 2D', false, 24);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle ne nécessite aucun logiciel spécialisé', false, 24);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle offre une meilleure visualisation et simulation des objets', true, 24);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.jpg', false, 25);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.pdf', false, 25);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.doc', false, 25);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('.stl', true, 25);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modélisation procédurale', false, 26);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modélisation volumétrique', false, 26);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modélisation filaire', false, 26);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modélisation polygonale', true, 26);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Blender', false, 27);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('AutoCAD', false, 27);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('SolidWork', false, 27);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Photoshop', true, 27);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Il n’y a pas de différence', false, 28);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('La modélisation directe est utilisée uniquement pour l’impression 3D', false, 28);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('La modélisation paramétrique est plus rapide que la modélisation directe', false, 28);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('La modélisation paramétrique utilise des contraintes et des dimensions modifiables, tandis que la modélisation directe permet des modifications sans historique', true, 28);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Volume', false, 29);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Pixel', false, 29);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Maillage', false, 29);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Mesh', true, 29);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle ne permet pas de créer des objets complexes', false, 30);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle est trop réaliste', false, 30);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Convertir un modèle en code informatique', false, 32);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle est uniquement utilisée pour l’architecture', false, 30);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle peut créer des surfaces non lisses à cause de la faible résolution des polygones', true, 30);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Le STL est uniquement compatible avec Fusion 360', false, 31);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Le format OBJ est exclusivement utilisé pour l’architecture', false, 31);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Il n’y a aucune différence entre les deux', false, 31);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('L’OBJ peut contenir des couleurs et des textures, alors que le STL ne contient que de la géométrie', true, 31);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Transformer un modèle 3D en fichier STL', false, 32);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Modifier directement la structure interne d’un objet 3D', false, 32);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Générer une image réaliste de l’objet avec éclairage et matériaux', true, 32);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle est plus coûteuse mais plus rapide', false, 33);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle ne nécessite aucune compétence en modélisation 3D', false, 33);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle ne peut être utilisée que pour des objets en plastique', false, 33);
INSERT INTO public.awnsers (description, is_good, id_question) VALUES ('Elle permet de créer des objets complexes avec moins de matière', true, 33);

-- insert eval
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (1,2,'acquiring');
--insert into public.autoevaluations(id_skill, id_student, eval) VALUES (2,2,'acquired');