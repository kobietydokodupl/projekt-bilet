--liquibase formatted sql
--changeset author:jderda context:development
INSERT INTO `users` (`email`,`passwordHash`) VALUES 
	('admin@admin.pl', '$2a$10$d8gv6jyA/He8va6QMSEEmuwpQM1XFKgEgj8TTGxJ13lHBQ6ftT9Bm'), -- password is 'admin'
	('test@test.pl', '$2a$10$u3AJC2e8fQ7bapCZh6I6Re4siOLimyBkPp.E//Ae07CSdW1SrRrFu'); -- password is 'test'
