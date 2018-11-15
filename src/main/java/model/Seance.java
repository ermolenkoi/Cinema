package model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 * сеанс просмотра фильма с временем, залом, фильмом, ценой, билета
 * */

public class Seance {
    private Film film;                  // название фильма
    private LocalDateTime startSeance;  // время начала сеанса
    private LocalDateTime endingSeance; // окончание сеанса
    private Double priceTicket;         // цена на билет
    private CinemaHall cinemaHall;      // имя зала

    public Seance(Film filmName, LocalDateTime startSeance, Double priceTicket, CinemaHall cinemaHall) {
        this.film = filmName;
        this.startSeance = startSeance;
        this.endingSeance = startSeance.plusMinutes(filmName.getDuration());
        this.priceTicket = priceTicket;
        this.cinemaHall = cinemaHall;
    }

    public Film getFilmName() {
        return film;
    }

    public LocalDateTime getStartSeance() {
        return startSeance;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }


    public void setFilmName(Film filmName) {
        this.film = filmName;
    }

    public void setStartSeance(LocalDateTime startSeance) {
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

        if (film != null ? !film.equals(seance.film) : seance.film != null) return false;
        if (startSeance != null ? !startSeance.equals(seance.startSeance) : seance.startSeance != null) return false;
        if (priceTicket != null ? !priceTicket.equals(seance.priceTicket) : seance.priceTicket != null) return false;
        return cinemaHall != null ? cinemaHall.equals(seance.cinemaHall) : seance.cinemaHall == null;
    }

    @Override
    public int hashCode() {
        int result = film != null ? film.hashCode() : 0;
        result = 31 * result + (startSeance != null ? startSeance.hashCode() : 0);
        result = 31 * result + (priceTicket != null ? priceTicket.hashCode() : 0);
        result = 31 * result + (cinemaHall != null ? cinemaHall.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return film.getName() + " в " + startSeance.toString() + " " + film.getTypeVideo()
                + " в зале " + cinemaHall.getName() + " цена билета " + priceTicket
                + " рублей. Окончание сенса в " + endingSeance.toString();
    }
}
