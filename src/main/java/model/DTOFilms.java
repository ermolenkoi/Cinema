package model;

import java.util.ArrayList;
import java.util.List;

public class DTOFilms {
    long id;
    String filmName;
    TypeVideo typeVideo;
    List<DTOCinema> dtoCinemas = new ArrayList<>();

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

    public TypeVideo getTypeVideo() {
        return typeVideo;
    }

    public void setTypeVideo(TypeVideo typeVideo) {
        this.typeVideo = typeVideo;
    }

    public List<DTOCinema> getDtoCinemas() {
        return dtoCinemas;
    }

    public void setDtoCinemas(List<DTOCinema> dtoCinemas) {
        this.dtoCinemas = dtoCinemas;
    }
}
