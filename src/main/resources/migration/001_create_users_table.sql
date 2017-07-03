--liquibase formatted sql
--changeset author:jderda
CREATE TABLE `users` (
  `email` VARCHAR(254) NOT NULL PRIMARY KEY,
  `passwordHash` VARCHAR(60) NOT NULL,
  `token` VARCHAR(65) NULL,
  `active` BOOL NOT NULL DEFAULT 0,
  `deleted` BOOL NOT NULL DEFAULT 0
);