package services;

import model.Film;
import model.TypeVideo;

import java.util.Calendar;
import java.util.List;

/*
 * интерфейс для определения функций для хранения данных о фильмах
 **/
public interface FilmService {
    //добавить новый фильм в прокат
    void addFilm(Film film);
    //удалить фильм
    void deleteFilm(long id);
    //изменить фильм
    Film updateFilm(Film film);
    //получить фильм по id
    Film getFilm(long id);
    //получить список всех фильмов
    List<Film> getAllFilms();

}
