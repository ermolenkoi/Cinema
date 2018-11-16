package interfases;

import exceptions.ScheduleServiceException;
import model.HallName;
import model.Schedule;
import model.Seance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * интерфейс для определения функций расписания
 */
public interface ScheduleService {
    //создать расписание на заданную дату
    Schedule createSchedule (LocalDate date);
    //добавить сеанс в расписание
    Boolean addSeance(Schedule schedule, Seance seance) throws ScheduleServiceException;
    //получить сеанс по id
    Seance getSeance(Schedule schedule, int id);
    //получить все сеансы расписания
    List<Seance> getAllSeances (Schedule schedule) throws ScheduleServiceException;
    //изменить сеанс в расписании
    Boolean updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException;
    //удалить сеанс из расписания
    Schedule deleteSeance(Schedule schedule, Seance seance);

}
