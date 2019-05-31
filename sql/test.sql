USE WGOfwLQC1X;

SELECT * FROM booking WHERE booking_id = 1;

SELECT * FROM booking WHERE phone_no = 4591876777;

DELETE FROM booking WHERE screening_id = 2;

SELECT * FROM movie WHERE movie_id = 100;


UPDATE movie  
SET title= "Aladdin", genre = "Adventure", duration="102", director="Guy Ritchie", plot="A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.", format="2D", image="http://tiny.cc/r1pe7y" 
WHERE movie_id= 91;


DELETE FROM movie WHERE movie_id = 103;

SELECT * FROM screening WHERE screening_id = 1;

SELECT * FROM screening;


UPDATE screening 
SET showing = '2019-06-29 21:00', movie_id = 1, theater_id = 1 WHERE screening_id = 1;

SELECT * FROM screening WHERE movie_id =1;

SELECT * FROM screening where DATE(showing) = DATE ('2019-06-29 21:00');

SELECT row_no,seat_no from booking where screening_id= 1;

SELECT * FROM theater;

DELETE FROM theater WHERE theater_id =3;

SELECT * FROM theater WHERE theater_id =1;

UPDATE theater 
SET theater_name="Blue", theater_format="2D", number_of_rows=14, seats_per_row=20 
WHERE theater_id= 6;
