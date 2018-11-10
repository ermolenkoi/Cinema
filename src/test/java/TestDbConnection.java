import dao.FilmDbDAO;
import model.Film;
import model.TypeVideo;
import services.FilmServiceImpl;

import java.util.List;

public class TestDbConnection {
    public static void main(String[] args) {

        FilmServiceImpl filmService = new FilmServiceImpl();
        FilmDbDAO filmDbDAO = new FilmDbDAO();

        //создание фильма
        Film film = filmService.createFilm("Tor", TypeVideo.IMAX, 110);

       /* //добавление в базу данных
        System.out.println(filmDbDAO.addFilm(film));
        System.out.println(filmDbDAO.addFilm(film));

        //удалить из базы данных
        filmDbDAO.deleteFilm(3);*/

        //изменить фильм
        List<Film> filmsFoUpdate = filmDbDAO.getAllFilms();
        for (Film f: filmsFoUpdate){
            f.setDuration(f.getDuration()+1);
            filmDbDAO.updateFilm(f);
        }


        //получить все фильмы
        List<Film> films = filmDbDAO.getAllFilms();
        for (Film f: films){
            System.out.println(f);
        }



    }
}
