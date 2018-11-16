package services;

import interfases.FilmService;
import model.Film;
import model.TypeVideo;

/*
 * сервис управления фильмами
 * */
public class FilmServiceImpl implements FilmService {

    @Override
    public Film createFilm(int id, String name, TypeVideo typeVideo, int duration) {
        if (name != null && typeVideo != null && duration>0){
            Film film = new Film(id, name, typeVideo, duration);
            return film;
        }
        return null;
    }

    @Override
    public Film createFilm() {
        return new Film();
    }
}
