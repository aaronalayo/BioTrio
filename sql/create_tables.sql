CREATE DATABASE IF NOT EXISTS WGOfwLQC1X;

USE WGOfwLQC1X;

CREATE TABLE theater(
theater_id INT NOT NULL AUTO_INCREMENT,
theater_name VARCHAR(255),
theater_format VARCHAR(255),
number_of_rows INT NOT NULL,
seats_per_row INT NOT NULL,
PRIMARY KEY (theater_id)
);

CREATE TABLE movie(
movie_id INT NOT NULL AUTO_INCREMENT,
title VARCHAR(255),
genre VARCHAR(25),
duration INT NOT NULL,
director VARCHAR(255),
plot VARCHAR(255),
format VARCHAR(255),
image VARCHAR(255),
PRIMARY KEY (movie_id)
);

CREATE TABLE screening (
screening_id INT NOT NULL AUTO_INCREMENT,
showing TIMESTAMP NOT NULL,
movie_id INT NOT NULL,
theater_id INT NOT NULL,
PRIMARY KEY (screening_id),
FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
FOREIGN KEY (theater_id) REFERENCES theater(theater_id));

CREATE TABLE booking(
 booking_id INT NOT NULL AUTO_INCREMENT,
 row_no INT(11),
 seat_no INT(11),
 phone_no  VARCHAR (25),
 PRIMARY KEY (booking_id),
screening_id INT(100),
 FOREIGN KEY (screening_id) REFERENCES screening(screening_id));
