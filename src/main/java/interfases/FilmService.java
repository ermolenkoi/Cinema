package interfases;

import model.Film;
import model.TypeVideo;

import java.util.Calendar;

/*
интерфейс для определения функций для хранения данных о фильмах
*/
public interface FilmService {
    //создать новый фильм (добавить в прокат)
    Film createFilm(int id, String name, TypeVideo typeVideo, int duration);
    //изменить фильм

}
