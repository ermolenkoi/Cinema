package dao;

import exceptions.ScheduleDaoException;
import exceptions.ScheduleServiceException;
import exceptions.SeanceDaoException;
import services.ScheduleService;
import model.Schedule;
import model.Seance;
import services.ScheduleServiceImpl;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl extends BasicDAO implements ScheduleDAO{

    private static final String SELECT
            = "SELECT date, id_seance FROM Schedule WHERE date=?";
    private static final String INSERT
            = "INSERT INTO Schedule (date, id_seance) VALUES (?, ?)";
    private static final String DELETE
            = "DELETE FROM Schedule WHERE id_seance = ?";
    //получить список id сеансов из базы данных на заданную дату
    @Override
    public List<Long> getSchedule(LocalDate date) throws ScheduleDaoException {
        if (date != null) {
            List<Long> seances = new ArrayList<>();
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(SELECT);) {
                pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.of(date, LocalTime.of(0,0))));
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        seances.add(rs.getLong("id_seance"));
                    }
                } catch (SQLException ex) {
                    throw new ScheduleDaoException(ex);
                }
                return seances;
            } catch (SQLException ex) {
                throw new ScheduleDaoException(ex);
            }
        }
        return null;
    }

    //добавить сеанс в расписание
    @Override
    public Schedule addSeance(Schedule schedule, Long idSeance) throws ScheduleDaoException {
        if (schedule != null && idSeance != null) {
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(INSERT)) {
                pst.setTimestamp(1, Timestamp.valueOf(LocalDateTime.of(schedule.getDate(),
                        LocalTime.of(0, 0))));
                pst.setLong(2, idSeance);
                pst.executeUpdate();
            } catch (SQLException ex) {
                throw new ScheduleDaoException(ex);
            }
        }
        return null;
    }

    //удалить сеанс из расписания
    @Override
    public void deleteSeance(Schedule schedule, Long idSeance) throws ScheduleDaoException {
        if (schedule != null && idSeance != null){
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(DELETE)) {
                pst.setLong(1, idSeance);
                pst.executeUpdate();
            } catch (SQLException ex) {
                throw new ScheduleDaoException(ex);
            }
        }
    }
}
