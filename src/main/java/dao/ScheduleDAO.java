package dao;

import exceptions.ScheduleDaoException;
import model.Schedule;
import model.Seance;

import java.time.LocalDate;
import java.util.List;

/*
 * интерфейс взаимодействия расписания с БД
 * */
public interface ScheduleDAO {
    //получить список id сеансов из базы данных на заданную дату
    List<Long> getSchedule (LocalDate date) throws ScheduleDaoException;
    //добавить сеанс в расписание
    Schedule addSeance (Schedule schedule, Long idSeance) throws ScheduleDaoException;
    //удалить сеанс из расписания
    void deleteSeance (Schedule schedule, Long idSeance) throws ScheduleDaoException;

}
