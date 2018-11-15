package interfases;

import model.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

/*
 * интерфейс для определения функций для хранения данных о сеансах
 **/
public interface SeanceService {
    //создать сеанс
    Seance createSeance(int id, Film film, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall);
    Seance createSeance(Film film, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall);

    //изменить статус места
    //void updateStatusPosition(Seance seance, Position position, Status status);

}
