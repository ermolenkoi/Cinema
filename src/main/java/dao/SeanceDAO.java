package dao;

import exceptions.SeanceDaoException;
import model.Seance;

/*
 * интерфейс взаимодействия сеанса с БД
 * */
public interface SeanceDAO {
    //добфвить сеанс в базу данных
    Integer addSeance (Seance seance) throws SeanceDaoException;
    //удалить сеанс из базы данных
    void deleteSeance (int seanceId) throws SeanceDaoException;
    //Изменить сеанс
    void updateSeance (Seance seance) throws SeanceDaoException;
    //получить сеанс по id
    Seance getSeance(int seanceId) throws SeanceDaoException;
}
