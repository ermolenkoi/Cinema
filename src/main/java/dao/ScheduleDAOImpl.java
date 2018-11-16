package dao;

import exceptions.ScheduleDaoException;
import exceptions.ScheduleServiceException;
import exceptions.SeanceDaoException;
import interfases.ScheduleService;
import model.Schedule;
import model.Seance;
import services.ScheduleServiceImpl;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO{

    private static final String SELECT
            = "SELECT id, start_time, ending_time, film, cinema_hall, price FROM Seances WHERE start_time>? AND start_time<?";

    private SimpleConnection simpleConnection = new SimpleConnection();
    private ScheduleService scheduleService = new ScheduleServiceImpl();
    private SeanceDAOImpl seanceDAO = new SeanceDAOImpl();

    //получить расписание из базы данных на заданную дату
    @Override
    public Schedule getSchedule(LocalDate date) throws ScheduleDaoException {
        if (date != null){
            Schedule schedule = scheduleService.createSchedule(date);
            List<Seance> seances = new ArrayList<>();
            LocalDateTime ldt = LocalDateTime.of(date, LocalTime.of(6,0));
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(SELECT);){
                pst.setTimestamp(1, Timestamp.valueOf(ldt));
                pst.setTimestamp(2, Timestamp.valueOf(ldt.plusHours(24)));
                try(ResultSet rs = pst.executeQuery()){
                    while (rs.next()){
                        seances.add(seanceDAO.fillSeance(rs));
                    }
                }catch (SQLException ex){
                    throw new ScheduleDaoException();
                }
                schedule.setSeances(seances);
                return schedule;
            }catch (SQLException ex){
                throw new ScheduleDaoException(ex);
            }
        }
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public Schedule addSeance(Schedule schedule, Seance seance) throws ScheduleDaoException {
        if (schedule != null && seance != null){
            if (seance.getStartSeance().isAfter(LocalDateTime.of(schedule.getDate(),LocalTime.of(6,0)))
                    && seance.getEndingSeance().isBefore(LocalDateTime.of(schedule.getDate().plusDays(1),LocalTime.of(6,0)))){
                ScheduleService scheduleService = new ScheduleServiceImpl();
                SeanceDAO seanceDAO = new SeanceDAOImpl();
                try {
                    if (scheduleService.addSeance(schedule, seance)){
                        seanceDAO.addSeance(seance);
                        this.getSchedule(schedule.getDate());
                    }
                } catch (ScheduleServiceException | SeanceDaoException ex) {
                    throw new ScheduleDaoException(ex);
                }
            }else throw new ScheduleDaoException("сеанс не пренадлежит этому расписанию");
        }
        return null;
    }

    //удалить сеанс и вернуть расписание
    @Override
    public Schedule deleteSeance(Schedule schedule, int idSeance) throws ScheduleDaoException {
        if (schedule != null){
            SeanceDAO seanceDAO = new SeanceDAOImpl();
            try {
                seanceDAO.deleteSeance(idSeance);
                return this.getSchedule(schedule.getDate());
            } catch (SeanceDaoException ex) {
                throw new ScheduleDaoException(ex);
            }
        }return null;
    }

    //изменить сеанс
    @Override
    public Schedule updateSeance(Schedule schedule, Seance seance) throws ScheduleDaoException {
        if (schedule != null && seance != null){
            if (seance.getStartSeance().isAfter(LocalDateTime.of(schedule.getDate(),LocalTime.of(6,0)))
                && seance.getEndingSeance().isBefore(LocalDateTime.of(schedule.getDate().plusDays(1),LocalTime.of(6,0)))){
                ScheduleService scheduleService = new ScheduleServiceImpl();
                SeanceDAO seanceDAO = new SeanceDAOImpl();
                try {
                    if (scheduleService.updateSchedule(schedule, seance)){
                        seanceDAO.updateSeance(seance);
                        this.getSchedule(schedule.getDate());
                    }
                } catch (ScheduleServiceException | SeanceDaoException ex) {
                    throw new ScheduleDaoException(ex);
                }
            }else throw new ScheduleDaoException("сеанс не пренадлежит этому расписанию");

        }
        return null;
    }

}
