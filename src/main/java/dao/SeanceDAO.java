package dao;

import exceptions.SeanceDaoException;
import model.Seance;

import java.time.LocalDate;
import java.util.List;

/*
 * интерфейс взаимодействия сеанса с БД
 * */
public interface SeanceDAO {
    //добфвить сеанс в базу данных
    Long addSeance (Seance seance) throws SeanceDaoException;
    //удалить сеанс из базы данных
    void deleteSeance (long seanceId) throws SeanceDaoException;
    //Изменить сеанс
    void updateSeance (Seance seance) throws SeanceDaoException;
    //получить сеанс по id
    Seance getSeance(long seanceId) throws SeanceDaoException;
    //получить список сеансов на заданную дату
    List<Seance> getSeancesByDate(LocalDate date) throws SeanceDaoException;

}
