import dao.SeanceDAO;
import dao.SeanceDAOImpl;
import exceptions.SeanceDaoException;
import interfases.CinemaHallService;
import interfases.FilmService;
import interfases.ScheduleService;
import interfases.SeanceService;
import model.*;
import services.CinemaHallServiceImpl;
import services.FilmServiceImpl;
import services.ScheduleServiceImpl;
import services.SeanceServiceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TestSeanceDAOImpl {
    public static void main(String[] args) {
        SeanceDAO seanceDAO = new SeanceDAOImpl();

        ScheduleService scheduleService = new ScheduleServiceImpl();
        SeanceService seanceService = new SeanceServiceImpl();
        CinemaHallService cinemaHallService = new CinemaHallServiceImpl();
        FilmService filmService = new FilmServiceImpl();
        Map<Integer, Integer> scheme = new HashMap<>();
        scheme.put(1, 10);
        scheme.put(2, 10);
        scheme.put(3, 8);

        CinemaHall cinemaHall = cinemaHallService.createCinemaHall(HallName.NUMBER_3, TypeVideo.VIDEO, scheme);
        Film film = filmService.createFilm(1245, "1234", TypeVideo.VIDEO, 90);
        LocalDateTime ld_9_00 = LocalDateTime.of(2018, 12, 2, 9, 0);
        LocalDateTime ld_11_00 = LocalDateTime.of(2018, 12, 2, 11, 0);
        LocalDateTime ld_10_00 = LocalDateTime.of(2018, 12, 2, 10, 0);

        Seance seance_1 = seanceService.createSeance(1,film, ld_9_00, 220.00, cinemaHall);
        Seance seance_2 = seanceService.createSeance(2,film, ld_11_00, 220.00, cinemaHall);
        Seance seance_3 = seanceService.createSeance(3,film, ld_10_00, 220.00, cinemaHall);

        try {
            //seanceDAO.addSeance(seance_1);
            //seanceDAO.deleteSeance(2);
            //Seance updateSeance = seanceService.createSeance(4, film, ld_9_00, 500.00, cinemaHall);
            //System.out.println(updateSeance);
            //seanceDAO.updateSeance(updateSeance);
            System.out.println(seanceDAO.getSeance(4));
        } catch (SeanceDaoException e) {
            e.printStackTrace();
        }
    }
}
