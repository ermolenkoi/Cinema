package model;


import java.time.LocalDateTime;

public class DTOSeances {
    long id;
    String filmName;
    LocalDateTime startSeance;
    Double priceTicket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public LocalDateTime getStartSeance() {
        return startSeance;
    }

    public void setStartSeance(LocalDateTime startSeance) {
        this.startSeance = startSeance;
    }

    public Double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(Double priceTicket) {
        this.priceTicket = priceTicket;
    }
}
