package interfases;

import exceptions.ScheduleServiceException;
import model.HallName;
import model.Schedule;
import model.Seance;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * интерфейс для определения функций расписания
 */
public interface ScheduleService {
    //создать расписание на заданную дату для зала
    Schedule createSchedule (LocalDate date);
    //добавить сеанс в расписание
    Schedule addSeance(Schedule schedule, Seance seance) throws ScheduleServiceException;
    //получить сеанс по id
    Seance getSeance(Schedule schedule, int id);
    //изменить сеанс в расписании
    Schedule updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException;
    //удалить сеанс из расписания
    Schedule deleteSeance(Schedule schedule, Seance seance);

}
