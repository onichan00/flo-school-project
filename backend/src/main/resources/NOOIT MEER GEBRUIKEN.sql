insert into ADMIN VALUES (1);
insert into CLIENT VALUES (1,'clientenwebsite.com');

-- insert into SPECIALIST values (1,0,'Frontend Engineer',null);
-- insert into SPECIALIST values (2,0,'Backend Engineer',null);
insert into SPECIALIST values (1,2,0,'Frontend Engineer',null);
insert into SPECIALIST values (2,2,0,'Web Developer',null);
insert into SPECIALIST values (3,2,0,'Backend Developer',null);

insert into USER_TABLE values (1,'admin','admin','admin','admin','admin','admin','admin',123,'https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80','admin',0,'admin',1,null,null);
insert into USER_TABLE values (2,'client','client','client','client','client','client','client',123,'https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80','client',1,'client',null,1,null);
insert into USER_TABLE values (3,'specialist','specialist','specialist','specialist','specialist','specialist','specialist',123,'https://images.unsplash.com/photo-1608597003542-9d831d8d6ff4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80','specialist',2,'specialist',null,null,1);
insert into USER_TABLE values (4,'testSpecialist','testSpecialist','testSpecialist','testSpecialist','testSpecialist','testSpecialist','testSpecialist',123,'https://images.unsplash.com/photo-1608597003542-9d831d8d6ff4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80','testSpecialist',2,'testSpecialist',null,null,2);
insert into USER_TABLE values (5, 'Straat 45', 'leeg', 'Stad', 'specialist@florijn-app.com', 'Gregory', 'Gnomes', 'wachtwoord', '+31612345678', 'https://tinyurl.com/yc6efeze', '', 2, '1234AB', null, null, 3);

insert into PROJECT values (2, 'https://images.unsplash.com/photo-1614850715649-1d0106293bd1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80', NOW(),' test123', 'Project 1', 0, 2);

insert into PROJECT_SPECIALISTS values (2, 1);
insert into PROJECT_SPECIALISTS values (2, 2);
insert into PROJECT_SPECIALISTS values (2, 3);