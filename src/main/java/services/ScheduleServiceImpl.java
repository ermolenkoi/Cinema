package services;


import dao.ScheduleDAO;
import dao.ScheduleDAOImpl;
import dao.SeanceDAO;
import dao.SeanceDAOImpl;
import exceptions.ScheduleDaoException;
import exceptions.ScheduleServiceException;
import exceptions.SeanceDaoException;
import model.Schedule;
import model.Seance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
 * сервис управления расписанием
 * */
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    private SeanceDAO seanceDAO = new SeanceDAOImpl();

    //получить расписание по дате
    @Override
    public Schedule getSchedule(LocalDate date) throws ScheduleServiceException {
        if (date != null) {
            try {
                List<Long> idSeances = scheduleDAO.getSchedule(date);
                List<Seance> seances = seanceDAO.getSeancesByDate(date);
                for (Seance s : seances) {
                    if (idSeances.contains(s.getId())) {
                        idSeances.remove(s.getId());
                    } else {
                        throw new ScheduleServiceException("Список сеансов на заданную дату не сходится" +
                                " со списком сеансов в расписании");
                    }
                }
                if (idSeances.size() == 0) {
                    Schedule schedule = new Schedule(date);
                    schedule.setSeances(seances);
                    return schedule;
                } else {
                    throw new ScheduleServiceException("Список сеансов на заданную дату не сходится" +
                            " со списком сеансов в расписании");
                }
            } catch (SeanceDaoException | ScheduleDaoException e) {
                throw new ScheduleServiceException("На данную дату сеансов в расписании нет");
            }
        }
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public Long addSeance(Schedule schedule, Seance seance) throws ScheduleServiceException {
        if (schedule != null && seance != null) {
            Boolean flag = true;
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s : schedule.getSeances()) {
                if (s.getCinemaHall().getId() == seance.getCinemaHall().getId()) {
                    if (startSeance.equals(s.getStartSeance())) {
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (startSeance.isAfter(s.getStartSeance()) && startSeance.isBefore(s.getEndingSeance())) {
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (endingSeance.isAfter(s.getStartSeance()) && endingSeance.isBefore(s.getEndingSeance())) {
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                }
            }
            if (flag) {
                schedule.getSeances().add(seance);
                try {
                    Long idSeance = seanceDAO.addSeance(seance);
                    scheduleDAO.addSeance(schedule, idSeance);
                    return idSeance;
                } catch (ScheduleDaoException | SeanceDaoException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
        return null;
    }

    //изменить сеанс в расписании
    @Override
    public Boolean updateSchedule(Schedule schedule, Seance seance) throws ScheduleServiceException {
        if (schedule != null && seance != null) {
            Boolean flag = true;
            LocalDateTime startSeance = seance.getStartSeance();
            LocalDateTime endingSeance = seance.getEndingSeance();
            for (Seance s : schedule.getSeances()) {
                if (s.getCinemaHall().getId() == seance.getCinemaHall().getId() && s.getId() != seance.getId()) {
                    if (startSeance.isAfter(s.getStartSeance()) && startSeance.isBefore(s.getEndingSeance())) {
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                    if (endingSeance.isAfter(s.getStartSeance()) && endingSeance.isBefore(s.getEndingSeance())) {
                        flag = false;
                        throw new ScheduleServiceException("В это время уже идет другой фильм");
                    }
                }
            }
            if (flag) {
                try {
                    seanceDAO.updateSeance(seance);
                } catch (SeanceDaoException e) {
                    throw new ScheduleServiceException(e);
                }
            }
            return flag;
        }
        return null;
    }

    //удалить сеанс из расписания
    @Override
    public Schedule deleteSeance(Schedule schedule, Long idSeance) throws ScheduleServiceException {
        if (schedule != null && idSeance != null) {
            List<Seance> seances = schedule.getSeances();
            for (Seance s : seances) {
                if (s.getId() == idSeance) {
                    try {
                        scheduleDAO.deleteSeance(schedule, idSeance);
                        seanceDAO.deleteSeance(idSeance);
                    } catch (SeanceDaoException | ScheduleDaoException e) {
                        throw new ScheduleServiceException(e);
                    }
                }
            }
            return schedule;
        }
        return null;
    }
}
