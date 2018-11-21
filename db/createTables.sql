
CREATE TABLE Type_video (
id bigint  PRIMARY KEY,
type VARCHAR(20) NOT NULL
);

CREATE TABLE Films (
id bigint PRIMARY KEY NOT NULL,
name VARCHAR(20) NOT NULL,
type int REFERENCES type_video(id),
duration int NOT NULL
);

CREATE TABLE Cinema_hall (
id bigint PRIMARY KEY,
name VARCHAR(20) NOT NULL,
type int REFERENCES type_video(id)
);

CREATE TABLE Cinema_hall_scheme (
id SERIAL PRIMARY KEY,
cinema_hall bigint REFERENCES cinema_hall(id),
row int NOT NULL,
place int NOT NULL
);

CREATE TABLE Seances (
id SERIAL PRIMARY KEY,
start_time timestamp NOT NULL,
ending_time timestamp NOT NULL,
film bigint REFERENCES films(id),
cinema_hall bigint REFERENCES cinema_hall(id),
price DOUBLE PRECISION  NOT NULL
);


CREATE TABLE Place_Status (
id int PRIMARY KEY NOT NULL,
status VARCHAR(20) NOT NULL
);

CREATE TABLE Booking_Positions (
id_Seance bigint REFERENCES Seances(id),
id int NOT NULL,
row int NOT NULL,
place int NOT NULL,
status int NOT NUll,
PRIMARY KEY (id_Seance, id)
);

CREATE TABLE Schedule (
date timestamp NOT NULL,
id_Seance bigint REFERENCES Seances(id),
PRIMARY KEY (date, id_Seance)
);