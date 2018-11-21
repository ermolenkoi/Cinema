package dao;

import exceptions.FilmDaoException;
import model.Film;
import model.TypeVideo;

import java.util.Calendar;
import java.util.List;

/*
 * интерфейс взаимодействия фильма с БД
 * */
public interface FilmDAO {
    //добавить новый фильм
    void addFilm(Film film) throws FilmDaoException;
    //удалить фильм из проката
    void deleteFilm(long filmId) throws FilmDaoException;
    //получить список всех фильмов
    List<Film> getAllFilms() throws FilmDaoException;
    //получить фильм по id
    Film getFilm(long filmId) throws FilmDaoException;
    //изменить фильм
    void updateFilm(Film film) throws FilmDaoException;
}
