package services;

import dao.FilmDAO;
import dao.FilmDAOImpl;
import exceptions.FilmDaoException;
import model.Film;

import java.util.List;

/*
 * сервис управления фильмами
 * */
public class FilmServiceImpl implements FilmService {
    private FilmDAO filmDAO = new FilmDAOImpl();

    @Override
    public void addFilm(Film film) {
        if (film != null) {
            try {
                filmDAO.addFilm(film);
            } catch (FilmDaoException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteFilm(long id) {
        try {
            filmDAO.deleteFilm(id);
        } catch (FilmDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film updateFilm(Film film) {
        if (film != null){
            try {
                filmDAO.updateFilm(film);
                return film;
            } catch (FilmDaoException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Film getFilm(long id) {
        try {
            return filmDAO.getFilm(id);
        } catch (FilmDaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Film> getAllFilms() {
        try {
            return filmDAO.getAllFilms();
        } catch (FilmDaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
