package services;

import model.*;
import interfases.SeanceService;

import java.util.Calendar;
import java.util.List;

/*
* менеджер управления сеансами
* */

public class SeanceServiceImpl implements SeanceService {

    //создать сеанс
    public Seance createSeance(Film filmName, Calendar startSeance, Double priceTicket, CinemaHall cinemaHall) {
        //сдесь проработать проверку на возможность сосздания сеанса:
        // 1. время не накладывается на др. сеансы
        // 2. формат фильма соответствует залу
        Seance seance = new Seance(filmName ,startSeance, priceTicket, cinemaHall);
        return seance;

    }

    // изменить цену сеанса
    public void updatePriceSeance(Seance seance, Double price) {
    seance.setPriceTicket(price);
    }

    // изменить статус места
    public void updateStatusPosition(Seance seance, Position position, Status status) {
        List<Position> list = seance.getCinemaHall().getSetPositions();
        for (Position p: list){
            if (p.equals(position)) p.setStatus(status);
        }

    }
}
