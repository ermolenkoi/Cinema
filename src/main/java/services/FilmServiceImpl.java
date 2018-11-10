package services;

import interfases.FilmService;
import model.BDTest;
import model.Film;
import model.TypeVideo;

import java.util.Calendar;
import java.util.List;

public class FilmServiceImpl implements FilmService {
    private List<Film> films = BDTest.getInstance().getFilms();

    @Override
    public Film createFilm(String name, TypeVideo typeVideo, int duration) {
        Film film = new Film(name, typeVideo, duration);
        if (!films.contains(film)){
            films.add(film);
        }
        return film;
    }

    @Override
    public void deleteFilm(Film film) {
        if (films.contains(film)) {
            films.remove(film);
        }
    }
}
