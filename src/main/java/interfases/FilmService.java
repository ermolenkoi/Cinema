package interfases;

import model.Film;
import model.TypeVideo;

import java.util.Calendar;

public interface FilmService {
    //создать новый фильм (добавить в прокат)
    Film createFilm(String name, TypeVideo typeVideo, int duration);
    //удалить фильм из проката
    void deleteFilm(Film film);
}
