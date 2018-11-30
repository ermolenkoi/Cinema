package model;

/*
 * фильм добавляемый в прокат
 * */
public class Film {
    long filmId;                     // идентификатор фильма
    private String name;             // название фильма
    private TypeVideo typeVideo;     // формат фильма
    private int duration;            // продолжительность фильма в минутах

    public Film() {
    }

    public Film(long filmId, String name, TypeVideo typeVideo, int duration) {
        this.filmId = filmId;
        this.name = name;
        this.typeVideo = typeVideo;
        this.duration = duration;
    }

    public long getFilmId() {
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


    public void setFilmId(long filmId) {
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

        if (filmId != film.filmId) return false;
        if (duration != film.duration) return false;
        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        return typeVideo == film.typeVideo;
    }

    @Override
    public int hashCode() {
        int result = (int) (filmId ^ (filmId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (typeVideo != null ? typeVideo.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }

    @Override
    public String toString() {
        return "filmId= " + filmId +
                ", название='" + name + '\'' +
                ", формат видео=" + typeVideo +
                ", продолжительность=" + duration;
    }
}
