package services;

import model.*;
import interfases.SeanceService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

/*
 * сервис управления сеансами
 * */

public class SeanceServiceImpl implements SeanceService {

    //создать сеанс
    @Override
    public Seance createSeance(int id, Film film, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall) {
        if (film != null && startSeance != null && cinemaHall != null) {
            if (film.getTypeVideo().equals(cinemaHall.getType())) {
                Seance seance = new Seance(id, film, startSeance, priceTicket, cinemaHall);
                return seance;
            }
        }
        return null;
    }
    @Override
    public Seance createSeance(Film film, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall) {
        if (film != null && startSeance != null && cinemaHall != null) {
            if (film.getTypeVideo().equals(cinemaHall.getType())) {
                Seance seance = new Seance(film, startSeance, priceTicket, cinemaHall);
                return seance;
            }
        }
        return null;
    }


}
