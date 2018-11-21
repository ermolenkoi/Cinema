import exceptions.ScheduleDaoException;
import exceptions.ScheduleServiceException;
import exceptions.SeanceServiceException;
import model.Schedule;
import model.Seance;
import services.ScheduleService;
import services.ScheduleServiceImpl;
import services.SeanceService;
import services.SeanceServiceImpl;

import java.time.LocalDate;

public class TestScheduleService {
    public static void main(String[] args) {
        ScheduleService scheduleService = new ScheduleServiceImpl();
        SeanceService seanceService = new SeanceServiceImpl();

        LocalDate day = LocalDate.of(2018, 1, 25);
        Seance updateSeance = null;
        try {
            updateSeance = seanceService.getSeance(5);
        } catch (SeanceServiceException e) {
            e.printStackTrace();
        }
        try {
            Schedule schedule = scheduleService.getSchedule(day);
            updateSeance.setStartSeance(updateSeance.getStartSeance().plusMinutes(240));
            updateSeance.setEndingSeance(updateSeance.getEndingSeance().plusMinutes(240));
            scheduleService.updateSchedule(schedule, updateSeance);


            updateSeance.setStartSeance(updateSeance.getStartSeance().minusMinutes(120));
            updateSeance.setEndingSeance(updateSeance.getEndingSeance().minusMinutes(120));


            schedule = scheduleService.getSchedule(day);
            long id = scheduleService.addSeance(schedule, updateSeance);

            schedule = scheduleService.getSchedule(day);
            scheduleService.deleteSeance(schedule, id);
            System.out.println(id);
        } catch (ScheduleServiceException e) {
            e.printStackTrace();
        }
    }
}
