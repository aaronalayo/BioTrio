USE WGOfwLQC1X;

INSERT INTO theater VALUES(null ,"Red","2D",8,12);
INSERT INTO theater VALUES(null ,"Orange","2D",8,6);
INSERT INTO theater VALUES(null ,"Blue","2D",14,20);



INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("A Dog's Journey", "Adventure","102","Gail Mancuso", "A dog finds the meaning of his own existence through the lives of the humans he meets.","2D","http://tiny.cc/gcqe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Aladdin", "Adventure","128", "Guy Ritchie", "A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.","2D","http://tiny.cc/r1pe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Toy Story", "Animation","81","John Lasseter", "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room.","2D","http://tiny.cc/j6pe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Avengers: Endgame", "Action","181","Anthony Russo", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins","2D","http://tiny.cc/j8pe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Brightburn", "Horror","81","David Yarovesky", "What if a child from another world crash-landed on Earth, but instead of becoming a hero to mankind, he proved to be something far more sinister?","2D","http://tiny.cc/faqe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Pokémon Detective Pikachu", "Action","104","Rob Letterman", "In a world where people collect Pokémon to do battle, a boy comes across an intelligent talking Pikachu who seeks to be a detective.","2D","http://tiny.cc/l9pe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Booksmart", "Comedy","102","Olivia Wilde", "On the eve of their high school graduation, two academic superstars and best friends realize they should have worked less and played more.","2D","http://tiny.cc/hbqe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("The Hustle", "Comedy","93","Chris Addison", "Anne Hathaway and Rebel Wilson star as female scam artists, one low rent and the other high class, who team up to take down the men who have wronged them.","2D","http://tiny.cc/8pue7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("Long Shot", "Romance","125","Jonathan Levine", "Journalist Fred Flarsky reunites with his childhood crush, Charlotte Field, now one of the most influential women in the world.","2D","http://tiny.cc/ngqe7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("The Intruder
", "Drama","102"," Deon Taylor", "A young married couple buy a beautiful house on several acres of land only to find out that the man they bought it from refuses to let go of the property.","2D","http://tiny.cc/437k7y");

INSERT INTO movie (title,genre,duration,director,plot,format,image) VALUES ("John Wick 3: Parabellum
", "Crime","150"," Chad Stahelski", "Super-assassin John Wick is on the run after killing a member of the international assassins guild, and with a $14 million price tag on his head - he is the target of hit men and women everywhere.","2D","http://tiny.cc/b87k7y");



# WEEK 26: from 24 to 28-06-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-06-24 17:30', 90, 2), ('2019-06-24 20:30', 91, 6), ('2019-06-24 17:45', 92, 6), ('2019-06-24 20:15', 93, 2), ('2019-06-25 17:30', 90, 2), ('2019-06-25 20:30', 91, 6), ('2019-06-25 17:45', 92, 6), ('2019-06-25 20:15', 93, 2), ('2019-06-26 17:30', 94, 2), ('2019-06-26 20:30', 95, 6), ('2019-06-26 17:45', 96, 6), ('2019-06-26 20:15', 97, 2), ('2019-06-27 17:30', 98, 2), ('2019-06-27 20:30', 99, 6), ('2019-06-27 17:45', 100, 6), ('2019-06-27 20:15', 90, 2), ('2019-06-28 17:30', 91, 2), ('2019-06-28 20:30', 92, 6), ('2019-06-28 17:45', 93, 6), ('2019-06-28 20:15', 94, 2);

# WEEKEND 26: from 29 to 30-06-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-06-29 11:00', 92, 5), ('2019-06-29 17:00', 93, 2), ('2019-06-29 21:00', 94, 6), ('2019-06-30 11:00', 90, 5), ('2019-06-30 17:00', 95, 2), ('2019-06-30 21:00', 96, 6);

# WEEK 27: from 1 to 5-07-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-01 17:30', 90, 2), ('2019-07-01 20:30', 91, 6), ('2019-07-01 17:45', 92, 6), ('2019-07-01 20:15', 93, 2), ('2019-07-02 17:30', 90, 2), ('2019-07-02 20:30', 91, 6), ('2019-07-02 17:45', 92, 6), ('2019-07-02 20:15', 93, 2), ('2019-07-03 17:30', 94, 2), ('2019-07-03 20:30', 95, 6), ('2019-07-03 17:45', 96, 6), ('2019-07-03 20:15', 97, 2), ('2019-07-04 17:30', 98, 2), ('2019-07-04 20:30', 99, 6), ('2019-07-04 17:45', 100, 6), ('2019-07-04 20:15', 90, 2), ('2019-07-05 17:30', 91, 2), ('2019-07-05 20:30', 92, 6), ('2019-07-05 17:45', 93, 6), ('2019-07-05 20:15', 94, 2);

# WEEKEND 27: from 6 to 7-06-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-06 11:00', 92, 5), ('2019-07-06 17:00', 93, 2), ('2019-07-06 21:00', 94, 6), ('2019-07-07 11:00', 90, 5), ('2019-07-07 17:00', 95, 2), ('2019-07-07 21:00', 96, 6);

# WEEK 28: from 8 to 12-07-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-08 17:30', 90, 2), ('2019-07-08 20:30', 91, 6), ('2019-07-08 17:45', 92, 6), ('2019-07-08 20:15', 93, 2), ('2019-07-09 17:30', 90, 2), ('2019-07-09 20:30', 91, 6), ('2019-07-09 17:45', 92, 6), ('2019-07-09 20:15', 93, 2), ('2019-07-10 17:30', 94, 2), ('2019-07-10 20:30', 95, 6), ('2019-07-10 17:45', 96, 6), ('2019-07-10 20:15', 97, 2), ('2019-07-11 17:30', 98, 2), ('2019-07-11 20:30', 99, 6), ('2019-07-11 17:45', 100, 6), ('2019-07-11 20:15', 90, 2), ('2019-07-12 17:30', 91, 2), ('2019-07-12 20:30', 92, 6), ('2019-07-12 17:45', 93, 6), ('2019-07-12 20:15', 94, 2);

# WEEKEND 28: from 13 to 14-06-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-13 11:00', 92, 5), ('2019-07-13 17:00', 93, 2), ('2019-07-13 21:00', 94, 6), ('2019-07-14 11:00', 90, 5), ('2019-07-14 17:00', 95, 2), ('2019-07-14 21:00', 96, 6);

# WEEK 29: from 15 to 19-07-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-15 17:30', 90, 2), ('2019-07-15 20:30', 91, 6), ('2019-07-15 17:45', 92, 6), ('2019-07-15 20:15', 93, 2), ('2019-07-16 17:30', 90, 2), ('2019-07-16 20:30', 91, 6), ('2019-07-16 17:45', 92, 6), ('2019-07-16 20:15', 93, 2), ('2019-07-17 17:30', 94, 2), ('2019-07-17 20:30', 95, 6), ('2019-07-17 17:45', 96, 6), ('2019-07-17 20:15', 97, 2), ('2019-07-18 17:30', 98, 2), ('2019-07-18 20:30', 99, 6), ('2019-07-18 17:45', 100, 6), ('2019-07-18 20:15', 90, 2), ('2019-07-19 17:30', 91, 2), ('2019-07-19 20:30', 92, 6), ('2019-07-19 17:45', 93, 6), ('2019-07-19 20:15', 94, 2);

# WEEKEND 29: from 20 to 21-07-2019

INSERT INTO screening (showing, movie_id, theater_id) VALUES ('2019-07-20 11:00', 92, 5), ('2019-07-20 17:00', 93, 2), ('2019-07-20 21:00', 94, 6), ('2019-07-21 11:00', 90, 5), ('2019-07-21 17:00', 95, 2), ('2019-07-21 21:00', 96, 6);



#example

INSERT INTO booking VALUES (null,1,2,4591876777,1);

