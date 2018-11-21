package model;

import java.time.LocalDateTime;

/*
 * сеанс просмотра фильма с временем, залом, фильмом, ценой, билета
 * */

public class Seance {
    private long id;                    // идентификационный номер сеанса
    private Film film;                  // название фильма
    private LocalDateTime startSeance;  // время начала сеанса
    private LocalDateTime endingSeance; // окончание сеанса
    private Double priceTicket;         // цена на билет
    private CinemaHall cinemaHall;      // имя зала
    private final int DURATION = 30;    // время уборки зала

    public Seance(long id, Film film, LocalDateTime startSeance,
                  Double priceTicket, CinemaHall cinemaHall) {
        this.id = id;
        this.film = film;
        this.startSeance = startSeance;
        this.endingSeance = startSeance.plusMinutes(DURATION + film.getDuration());
        this.priceTicket = priceTicket;
        this.cinemaHall = cinemaHall;
    }

    public long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public LocalDateTime getStartSeance() {
        return startSeance;
    }

    public LocalDateTime getEndingSeance() {
        return endingSeance;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
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

    public void setEndingSeance(LocalDateTime endingSeance) {
        this.endingSeance = endingSeance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seance seance = (Seance) o;

        if (id != seance.id) return false;
        if (DURATION != seance.DURATION) return false;
        if (film != null ? !film.equals(seance.film) : seance.film != null) return false;
        if (startSeance != null ? !startSeance.equals(seance.startSeance) : seance.startSeance != null) return false;
        if (endingSeance != null ? !endingSeance.equals(seance.endingSeance) : seance.endingSeance != null)
            return false;
        if (priceTicket != null ? !priceTicket.equals(seance.priceTicket) : seance.priceTicket != null) return false;
        return cinemaHall != null ? cinemaHall.equals(seance.cinemaHall) : seance.cinemaHall == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (startSeance != null ? startSeance.hashCode() : 0);
        result = 31 * result + (endingSeance != null ? endingSeance.hashCode() : 0);
        result = 31 * result + (priceTicket != null ? priceTicket.hashCode() : 0);
        result = 31 * result + (cinemaHall != null ? cinemaHall.hashCode() : 0);
        result = 31 * result + DURATION;
        return result;
    }

    @Override
    public String toString() {
        return film + " в " + startSeance.toString() + " " + film
                + " в зале №" + cinemaHall.getId() + " цена билета " + priceTicket
                + " рублей. Окончание сенса в " + endingSeance.toString();
    }
}
