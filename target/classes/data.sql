delete from users;
INSERT INTO users (email, password, name) VALUES
('admin@gmail.com', 'admin', 'Admin'),
('david@gmail.com', 'david', 'David'),
('ron@gmail.com', 'ron', 'Ron');
insert into posts(title, content, created_on, updated_on) values
('Introducing SpringBoot', 'SpringBoot is awesome', '2017-05-10', null),
('Securing Web applications', 'This post will show how to use SpringSecurity',
'2017-05-20', null),
('Introducing Spring Social', 'Developing social web applications using Spring Social',
'2017-05-24', null);
insert into comments(post_id, name, email, content, created_on, updated_on) values
(1, 'John','john@gmail.com', 'This is cool', '2017-05-10', null),
(1, 'Rambo','rambo@gmail.com', 'Thanks for awesome tips', '2017-05-20', null),
(2, 'Paul', 'paul@gmail.com', 'Nice post buddy.', '2017-05-24', null);