package services;


import model.Schedule;
import model.Seance;
import interfases.ScheduleService;

import java.util.Calendar;
import java.util.Map;

public class ScheduleServiceImpl implements ScheduleService {

    //создать расписание если оно еще не создано
    @Override
    public String createSchedule(Calendar date) {

        return null;
    }



    //получить расписание по дате
    @Override
    public Schedule getSchedule(Calendar date) {
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public String addSeance(Calendar date ,Seance seance) {


        getSchedule(date).getSeances().add(seance);
        return "Сеанс добавлен в расписание";
    }

    @Override
    public String updateSchedule(Seance seance) {
        return null;
    }
}
