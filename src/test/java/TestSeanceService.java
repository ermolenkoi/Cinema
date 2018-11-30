import exceptions.SeanceServiceException;
import model.CinemaHall;
import model.Film;
import model.Seance;
import model.TypeVideo;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestSeanceService {
    public static void main(String[] args) {
        SeanceService seanceService = new SeanceServiceImpl();
        CinemaHallService cinemaHallService = new CinemaHallServiceImpl();
        FilmService filmService = new FilmServiceImpl();

        List<Seance> seances = null;
        try {
            seances = seanceService.getSeancesByDate(LocalDate.of(2018, 1, 25));
        } catch (SeanceServiceException e) {
            e.printStackTrace();
        }
        System.out.println(seances.get(1));

        Film film = filmService.getFilm(1245);
        CinemaHall cinemaHall = cinemaHallService.getCinemaHall(3);

        Seance seance = new Seance(-1, film, LocalDateTime.of(2018, 12, 5, 10, 10, 0), 250.00, cinemaHall);

        try {
            //seanceService.addSeance(seance);
            //seance.setPriceTicket(300.00);
            //seanceService.updateSeance(seance);
            System.out.println(seanceService.getSeance(6));
            //seanceService.deleteSeance(6);
        } catch (SeanceServiceException e) {
            e.printStackTrace();
        }

    }
}
