import dao.*;
import exceptions.CinemaHallDaoException;
import exceptions.ScheduleDaoException;
import exceptions.SeanceDaoException;
import exceptions.SeanceServiceException;
import interfases.CinemaHallService;
import interfases.FilmService;
import interfases.ScheduleService;
import interfases.SeanceService;
import model.*;
import services.CinemaHallServiceImpl;
import services.FilmServiceImpl;
import services.ScheduleServiceImpl;
import services.SeanceServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TestScheduleDAOImpl {
    public static void main(String[] args) throws SeanceDaoException {
        ScheduleDAOImpl scheduleDAO = new ScheduleDAOImpl();
        SeanceService seanceService = new SeanceServiceImpl();
        CinemaHallDAO cinemaHallDAO = new CinemaHallDAOImpl();
        FilmService filmService = new FilmServiceImpl();
        SeanceDAO seanceDAO = new SeanceDAOImpl();

        Map<Integer,Integer> map = new HashMap<>();
        CinemaHall cinemaHall = null;
        try {
            cinemaHall = cinemaHallDAO.getCinemaHall(3);
        } catch (CinemaHallDaoException e) {
            e.printStackTrace();
        }


        Film film = filmService.createFilm(1245, "1234", TypeVideo.VIDEO, 90);

        LocalDateTime ld_9_00 = LocalDateTime.of(2018, 12, 2, 9, 0);
        LocalDateTime ld_11_00 = LocalDateTime.of(2018, 12, 2, 11, 0);
        LocalDateTime ld_10_00 = LocalDateTime.of(2018, 12, 4, 5, 59);

        Seance seance_1 = null;
        Seance seance_2 = seanceDAO.getSeance(16);
        Seance seance_3 = null;

        try{
            seance_1 = seanceService.createSeance(film, ld_9_00, 220.00, cinemaHall);
            //seance_2 = seanceService.createSeance(2,film, ld_11_00, 220.00, cinemaHall);
            seance_3 = seanceService.createSeance(3,film, ld_10_00, 220.00, cinemaHall);
        }catch (SeanceServiceException ex){
            ex.printStackTrace();
        }


        LocalDate date_schedule = LocalDate.of(2018, 12, 3);


        try {
            Schedule schedule = scheduleDAO.getSchedule(date_schedule);
            //scheduleDAO.deleteSeance(schedule,22);
            //scheduleDAO.addSeance(schedule, seance_1);
            //seance_2.setStartSeance(ld_10_00);
            seance_2.setEndingSeance(ld_10_00);
            System.out.println(seance_2);

            scheduleDAO.updateSeance(schedule, seance_2);
            System.out.println(scheduleDAO.getSchedule(date_schedule));
        } catch (ScheduleDaoException e) {
            e.printStackTrace();
        }
    }
}
