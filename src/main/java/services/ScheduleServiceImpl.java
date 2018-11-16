package services;


import exceptions.ScheduleServiceException;
import model.HallName;
import model.Schedule;
import model.Seance;
import interfases.ScheduleService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/*
 * сервис управления расписанием
 * */
public class ScheduleServiceImpl implements ScheduleService {

    //создать расписание
    @Override
    public Schedule createSchedule(LocalDate date) {
        if (date != null){
            Schedule schedule = new Schedule(date);
            return schedule;
        }
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public Boolean addSeance(Schedule schedule ,Seance seance) throws ScheduleServiceException {
        if (schedule != null && seance != null){
            Boolean flag = true;
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s: schedule.getSeances()){
                if (s.getCinemaHall().getId() == seance.getCinemaHall().getId()){
                    if (startSeance.equals(s.getStartSeance())){
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (startSeance.isAfter(s.getStartSeance()) && startSeance.isBefore(s.getEndingSeance())){
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (endingSeance.isAfter(s.getStartSeance()) && endingSeance.isBefore(s.getEndingSeance())){
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                }
            }
            if (flag){
                schedule.getSeances().add(seance);
            }
            return flag;
        }
        return null;
    }

    //получить сеанс по id
    @Override
    public Seance getSeance(Schedule schedule ,int id) {
        if (schedule != null){
            List<Seance> seances = schedule.getSeances();
            for (Seance s: seances){
                if (s.getId() == id){
                    return s;
                }
            }
        }
        return null;
    }

    //получить все сеансы расписания
    @Override
    public List<Seance> getAllSeances(Schedule schedule) throws ScheduleServiceException {
        if (schedule != null){
            return schedule.getSeances();
        }
        return null;
    }

    //изменить сеанс в расписании
    @Override
    public Boolean updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException{
        if (schedule != null && seance != null){
            Boolean flag = true;
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s: schedule.getSeances()){
                if (s.getCinemaHall().getId() == seance.getCinemaHall().getId() && s.getId() != seance.getId()){
                    if (startSeance.isAfter(s.getStartSeance()) && startSeance.isBefore(s.getEndingSeance())){
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (endingSeance.isAfter(s.getStartSeance()) && endingSeance.isBefore(s.getEndingSeance())){
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                }
            }
            if (flag){
                Seance updateSeance = this.getSeance(schedule, seance.getId());
                updateSeance.setCinemaHall(seance.getCinemaHall());
                updateSeance.setFilm(seance.getFilm());
                updateSeance.setStartSeance(seance.getStartSeance());
                updateSeance.setEndingSeance(seance.getEndingSeance());
                updateSeance.setPriceTicket(seance.getPriceTicket());
            }
            return flag;
        }
        return null;
    }

    //удалить сеанс из расписания
    @Override
    public Schedule deleteSeance(Schedule schedule, Seance seance) {
        if (schedule != null && seance != null){
            List<Seance> seances = schedule.getSeances();
            for (Seance s: seances){
                if (s.equals(seance)){
                    seances.remove(s);
                }
            }
            return schedule;
        }
        return null;
    }
}
