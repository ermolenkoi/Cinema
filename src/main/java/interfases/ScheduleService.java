package interfases;

import model.Schedule;
import model.Seance;

import java.util.Calendar;

/*
интерфейс для определения функций для хранения данных о сеансах
*/
public interface ScheduleService {
    //создать расписание на заданную дату для зала
    String createSchedule (Calendar date);
    //удалить расписание
    String deleteSchedule(Calendar date);
    //получить расписание
    Schedule getSchedule(Calendar date);
    //добавить сеанс в расписание
    String addSeance(Calendar date, Seance seance);
    //изменить сеанс в расписании
    String updateSchedule(Seance seance);

}
