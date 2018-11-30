import exceptions.ScheduleServiceException;
import model.DTOFilms;
import model.Schedule;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Test {
    public static void main(String[] args) {

        SeanceService seanceService = new SeanceServiceImpl();
        CinemaHallService cinemaHallService = new CinemaHallServiceImpl();
        FilmService filmService = new FilmServiceImpl();
        ScheduleService scheduleService = new ScheduleServiceImpl();

        Schedule schedule = null;

        LocalDate dateString = LocalDate.of(2018, 1, 25);
        try {
            schedule = scheduleService.getSchedule(dateString);
        } catch (ScheduleServiceException e) {
            e.printStackTrace();
        }

        List<DTOFilms> dtoSeances = ModelMapper.convertToDto(schedule);


    }
}
