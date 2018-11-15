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
    public Seance createSeance(Film film, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall) {
        if (film.getTypeVideo().equals(cinemaHall.getType())){
            Seance seance = new Seance(film ,startSeance, priceTicket, cinemaHall);
        }
        return null;
    }

    //изменить цену сеанса
    @Override
    public Seance updatePriceSeance(Seance seance, Double price) {
        seance.setPriceTicket(price);
        return seance;
    }
}
