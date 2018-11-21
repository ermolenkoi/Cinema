package services;

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
    //получить расписание на заданную дату
    Schedule getSchedule(LocalDate date) throws ScheduleServiceException;

    //добавить сеанс в расписание
    Long addSeance(Schedule schedule, Seance seance) throws ScheduleServiceException;

    //изменить сеанс в расписании
    Boolean updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException;

    //удалить сеанс из расписания
    Schedule deleteSeance(Schedule schedule, Long idSeance) throws ScheduleServiceException;

}
