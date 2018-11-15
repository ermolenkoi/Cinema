package services;


import exceptions.ScheduleServiceException;
import model.HallName;
import model.Schedule;
import model.Seance;
import interfases.ScheduleService;
import model.TypeVideo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ScheduleServiceImpl implements ScheduleService {

    //создать расписание если оно еще не создано
    @Override
    public Schedule createSchedule(LocalDate date) {
        if (date != date){
            Schedule schedule = new Schedule(date);
            return schedule;
        }
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public Schedule addSeance(Schedule schedule ,Seance seance) throws ScheduleServiceException {
        if (schedule != null && seance != null){
            Boolean flag = true;
            HallName hallName = seance.getCinemaHall().getName();
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s: schedule.getSeances()){
                if (s.getCinemaHall().getName().equals(hallName)){
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
            return schedule;
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

    //изменить сеанс в расписании
    @Override
    public Schedule updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException{
        if (schedule != null && seance != null){
            Boolean flag = true;
            HallName hallName = seance.getCinemaHall().getName();
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s: schedule.getSeances()){
                if (s.getCinemaHall().getName().equals(hallName) && s.getId() != seance.getId()){
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
            return schedule;
        }
        return null;
    }

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
