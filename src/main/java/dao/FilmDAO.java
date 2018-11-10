package dao;

import model.Film;
import model.TypeVideo;

import java.util.Calendar;
import java.util.List;

public interface FilmDAO {
    //добавить новый фильм
    int addFilm(Film film);
    //удалить фильм из проката
    void deleteFilm(int filmId);
    //получить список всех фильмов
    List<Film> getAllFilms();
    //изменить фильм
    void updateFilm(Film film);
}
