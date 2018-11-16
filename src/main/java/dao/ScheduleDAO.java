package dao;

import exceptions.ScheduleDaoException;
import model.Schedule;
import model.Seance;

import java.time.LocalDate;

/*
 * интерфейс взаимодействия расписания с БД
 * */
public interface ScheduleDAO {
    //получить расписание из базы данных на заданную дату
    Schedule getSchedule (LocalDate date) throws ScheduleDaoException;
    //добавить сеанс в расписание
    Schedule addSeance (Schedule schedule, Seance seance) throws ScheduleDaoException;
    //удалить сеанс в расписании по id
    Schedule deleteSeance(Schedule schedule, int idSeance) throws ScheduleDaoException;
    //изменить сеанс и вернуть расписание
    Schedule updateSeance(Schedule schedule, Seance seance) throws ScheduleDaoException;
}
