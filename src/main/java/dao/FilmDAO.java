package dao;

import exceptions.FilmDaoException;
import model.Film;
import model.TypeVideo;

import java.util.Calendar;
import java.util.List;

public interface FilmDAO {
    //добавить новый фильм
    void addFilm(Film film) throws FilmDaoException;
    //удалить фильм из проката
    void deleteFilm(int filmId) throws FilmDaoException;
    //получить список всех фильмов
    List<Film> getAllFilms() throws FilmDaoException;
    //изменить фильм
    void updateFilm(Film film) throws FilmDaoException;
}
