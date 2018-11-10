package model;

import java.util.Calendar;

/*
* сеанс просмотра фильма с временем, залом, фильмом, ценой, билета
* */

public class Seance {
    private Film filmName; // название фильма
    private Calendar startSeance; // дата и время начала сеанса
    // окончание
    private Double priceTicket; // цена на билет
    private CinemaHall cinemaHall; //имя зала

    public Seance(Film filmName, Calendar startSeance, Double priceTicket, CinemaHall cinemaHall) {
        this.filmName = filmName;
        this.startSeance = startSeance;
        this.priceTicket = priceTicket;
        this.cinemaHall = cinemaHall;
    }

    public Film getFilmName() {
        return filmName;
    }

    public Calendar getStartSeance() {
        return startSeance;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }


    public void setFilmName(Film filmName) {
        this.filmName = filmName;
    }

    public void setStartSeance(Calendar startSeance) {
        this.startSeance = startSeance;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seance seance = (Seance) o;

        if (filmName != null ? !filmName.equals(seance.filmName) : seance.filmName != null) return false;
        if (startSeance != null ? !startSeance.equals(seance.startSeance) : seance.startSeance != null) return false;
        if (priceTicket != null ? !priceTicket.equals(seance.priceTicket) : seance.priceTicket != null) return false;
        return cinemaHall != null ? cinemaHall.equals(seance.cinemaHall) : seance.cinemaHall == null;
    }

    @Override
    public int hashCode() {
        int result = filmName != null ? filmName.hashCode() : 0;
        result = 31 * result + (startSeance != null ? startSeance.hashCode() : 0);
        result = 31 * result + (priceTicket != null ? priceTicket.hashCode() : 0);
        result = 31 * result + (cinemaHall != null ? cinemaHall.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return filmName.getName() + " в " + startSeance.getTime() + " " + filmName.getTypeVideo() + " в зале " + cinemaHall.getName() + " цена билета " + priceTicket + " рублей";
    }
}
