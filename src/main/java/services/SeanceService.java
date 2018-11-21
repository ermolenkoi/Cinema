package services;

import exceptions.SeanceServiceException;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * интерфейс для определения функций для хранения данных о сеансах
 **/
public interface SeanceService {
    //добавить сеанс в расписание
    void addSeance(Seance seance) throws SeanceServiceException;
    //получить сеанс по id
    Seance getSeance(long id) throws SeanceServiceException;
    //удалить сеанс по id
    void deleteSeance(long id) throws SeanceServiceException;
    //изменить сеанс
    void updateSeance(Seance seance) throws SeanceServiceException;
    //получить список сеансов на заданную дату
    List<Seance> getSeancesByDate(LocalDate localDate) throws SeanceServiceException;


}
