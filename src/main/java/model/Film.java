package model;

import java.util.Calendar;

/*
* фильм добавляемый в прокат
* */

public class Film {
    int filmId; //идентификатор фильма
    private String name; // название фильма
    private TypeVideo typeVideo; // формат фильма
    private int duration; // продолжительность фильма в минутах


    public Film() {
    }

    public Film(int filmId, String name, TypeVideo typeVideo, int duration) {
        this.filmId = filmId;
        this.name = name;
        this.typeVideo = typeVideo;
        this.duration = duration;
    }

    //геттеры
    public int getFilmId() {
        return filmId;
    }

    public String getName() {
        return name;
    }

    public TypeVideo getTypeVideo() {
        return typeVideo;
    }

    public int getDuration() {
        return duration;
    }

    //сеттеры
    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeVideo(TypeVideo typeVideo) {
        this.typeVideo = typeVideo;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (duration != film.duration) return false;
        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        return typeVideo == film.typeVideo;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (typeVideo != null ? typeVideo.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", name='" + name + '\'' +
                ", typeVideo=" + typeVideo +
                ", duration=" + duration +
                '}';
    }
}
