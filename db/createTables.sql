
CREATE TABLE type_video (
id int PRIMARY KEY,
type VARCHAR(20) NOT NULL
);

CREATE TABLE films (
id int PRIMARY KEY NOT NULL,
name VARCHAR(20) NOT NULL,
type int REFERENCES type_video(id),
duration int NOT NULL
);


CREATE TABLE Place_Status (
id int PRIMARY KEY,
status VARCHAR(20) NOT NULL
);

CREATE TABLE cinema_hall (
id int PRIMARY KEY,
name VARCHAR(20) NOT NULL,
type int REFERENCES type_video(id)
);

CREATE TABLE cinema_hall_scheme (
id SERIAL PRIMARY KEY,
cinema_hall int REFERENCES cinema_hall(id),
row int NOT NULL,
place int NOT NULL
);

CREATE TABLE Seances (
id SERIAL PRIMARY KEY,
start_time timestamp NOT NULL,
ending_time timestamp NOT NULL,
film int REFERENCES films(id),
cinema_hall int REFERENCES cinema_hall(id),
price DOUBLE PRECISION NOT NULL
);

CREATE TABLE Booking_Positions (
id_Seance int REFERENCES Seances(id),
id int NOT NULL,
row int NOT NULL,
place int NOT NULL,
status int NOT NUll,
PRIMARY KEY (id_Seance, id)
);
