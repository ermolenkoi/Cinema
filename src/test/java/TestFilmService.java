import model.Film;
import model.TypeVideo;
import services.FilmService;
import services.FilmServiceImpl;

public class TestFilmService {
    public static void main(String[] args) {
        FilmService filmService = new FilmServiceImpl();
        System.out.println(filmService.getFilm(1245));

        Film film = new Film(1111, "Test", TypeVideo.VIDEO, 80);

        filmService.addFilm(film);

        film.setDuration(100);
        filmService.updateFilm(film);

        for (Film f: filmService.getAllFilms()){
            System.out.println(f);
        }

        filmService.deleteFilm(1111);


    }
}
