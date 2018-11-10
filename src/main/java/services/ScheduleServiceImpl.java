package services;

import model.BDTest;
import model.Schedule;
import model.Seance;
import interfases.ScheduleService;

import java.util.Calendar;
import java.util.Map;

public class ScheduleServiceImpl implements ScheduleService {
    private Map<Calendar, Schedule> schedules = BDTest.getInstance().getSchedules();

    //создать расписание если оно еще не создано
    @Override
    public String createSchedule(Calendar date) {
        if(schedules.keySet().contains(date)){
            return "Расписание на " + date + " уже существует";
        }else {
            schedules.put(date, new Schedule(date));
            return "Расписание на " + date + " создано";
        }
    }

    //удалить расписание если оно ранее было создано
    @Override
    public String deleteSchedule(Calendar date) {
        if(schedules.keySet().contains(date)){
            schedules.remove(date);
            return "Расписание на " + date + " удалено";
        }else {
            return "Расписание на " + date + " не создавалось";
        }
    }

    //получить расписание по дате
    @Override
    public Schedule getSchedule(Calendar date) {
        return schedules.get(date);
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
