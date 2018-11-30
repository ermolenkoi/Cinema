INSERT INTO type_video (id, type) VALUES (1, 'IMAX');
INSERT INTO type_video (id, type) VALUES (2, 'D3');
INSERT INTO type_video (id, type) VALUES (3, 'VIDEO');

INSERT INTO films (id, name, type, duration) VALUES (1245, 'Brother', 3, 90);
INSERT INTO films (id, name, type, duration) VALUES (1486, 'Brother 2', 3, 85);

INSERT INTO cinema_hall (id, name, type) VALUES (1, 'NUMBER_1', 1);
INSERT INTO cinema_hall (id, name, type) VALUES (2, 'NUMBER_2', 2);
INSERT INTO cinema_hall (id, name, type) VALUES (3, 'NUMBER_3', 3);
INSERT INTO cinema_hall (id, name, type) VALUES (4, 'NUMBER_4', 3);

INSERT INTO cinema_hall_scheme (cinema_hall, row, place) VALUES (1, 1, 10), (1, 2, 8), (1, 3, 8), (1, 4, 8);
INSERT INTO cinema_hall_scheme (cinema_hall, row, place) VALUES (2, 1, 10), (2, 2, 8), (2, 3, 8);
INSERT INTO cinema_hall_scheme (cinema_hall, row, place) VALUES (3, 1, 10), (3, 2, 8), (3, 3, 8);
INSERT INTO cinema_hall_scheme (cinema_hall, row, place) VALUES (4, 1, 10), (4, 2, 8), (4, 3, 8), (4, 4, 8), (4, 5, 6);

INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES ('2018-01-25 8:00', '2018-01-25 10:00', 1245, 4, 250.00);
INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES ('2018-01-25 10:00', '2018-01-25 12:00', 1245, 4, 250.00);
INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES ('2018-01-25 12:00', '2018-01-25 14:00', 1486, 4, 250.00);
INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES ('2018-01-25 14:00', '2018-01-25 16:00', 1245, 3, 250.00);
INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES ('2018-01-25 14:00', '2018-01-25 16:00', 1486, 3, 280.00);

INSERT INTO Place_Status (id, status) VALUES (1, 'FREE');
INSERT INTO Place_Status (id, status) VALUES (2, 'RESERVED');
INSERT INTO Place_Status (id, status) VALUES (3, 'CLOSED');

INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (1, 101, 1, 1, 3);
INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (1, 201, 2, 1, 3);
INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (1, 103, 1, 3, 3);
INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (1, 104, 1, 4, 2);
INSERT INTO Booking_Positions (id_Seance, id, row, place, status) VALUES (1, 105, 1, 5, 3);

INSERT INTO Schedule (date, id_Seance) VALUES ('2018-01-25', 1);
INSERT INTO Schedule (date, id_Seance) VALUES ('2018-01-25', 2);
INSERT INTO Schedule (date, id_Seance) VALUES ('2018-01-25', 3);
INSERT INTO Schedule (date, id_Seance) VALUES ('2018-01-25', 4);
INSERT INTO Schedule (date, id_Seance) VALUES ('2018-01-25', 5);