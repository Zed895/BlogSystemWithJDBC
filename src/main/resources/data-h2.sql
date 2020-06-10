insert into Blogger (id, age, name) VALUES (1, 38, 'Zoltan');
insert into Blogger (id, age, name) VALUES (2, 21, 'John');
insert into story (id, title, content, posted, blogger_id) values (1, 'First title', 'First content', '2020-05-07', 1);
insert into story (id, title, content, posted, blogger_id) values (2, 'Second title2', 'Second content from SQL file', '2020-05-08', 2);
insert into story (id, title, content, posted, blogger_id) values (3, 'Test title', 'Test content from SQL file', '2020-05-3', (select id from blogger where name = 'Zoltan'));
insert into story (id, title, content, posted, blogger_id) values (4, 'Test title2', 'Test content2', '2020-05-4', (select id from blogger where name = 'John'));
insert into story (id, title, content, posted, blogger_id) values (5, 'Hi', 'Some content', CURRENT_DATE(), (select id from blogger where name = 'Zoltan'));
