package interfases;

import model.Film;
import model.TypeVideo;

import java.util.Calendar;

public interface FilmService {
    //создать новый фильм (добавить в прокат)
    Film createFilm(int id, String name, TypeVideo typeVideo, int duration);
    //удалить фильм из проката
    void deleteFilm(Film film);
    //изменить фильм

}
