import dao.FilmDAOImpl;
import exceptions.FilmDaoException;
import model.Film;
import model.TypeVideo;
import services.FilmServiceImpl;

import java.util.List;

public class TestDbConnection {
    public static void main(String[] args) {

        FilmServiceImpl filmService = new FilmServiceImpl();
        FilmDAOImpl filmDAOImpl = new FilmDAOImpl();

        //создание фильма
        Film film = filmService.createFilm(1247,"Tor", TypeVideo.IMAX, 110);
        Film film1 = null;

        /*//добавление в базу данных
        try {
            filmDAOImpl.addFilm(film);
        } catch (FilmDaoException e) {
            e.printStackTrace();
        }*/

        /*//удалить из базы данных
        filmDAOImpl.deleteFilm(1247);*/

        //изменить фильм
        try{
            List<Film> filmsFoUpdate = filmDAOImpl.getAllFilms();
            for (Film f: filmsFoUpdate){
                f.setDuration(f.getDuration()+1);
                filmDAOImpl.updateFilm(f);
            }
        }catch (FilmDaoException ex){
            ex.printStackTrace();
        }



        //получить все фильмы
        try{
            List<Film> films = filmDAOImpl.getAllFilms();
            for (Film f: films){
                System.out.println(f);
            }
        }catch (FilmDaoException ex){
            ex.printStackTrace();
        }




    }
}
