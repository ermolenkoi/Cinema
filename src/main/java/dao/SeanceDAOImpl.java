package dao;

import exceptions.SeanceDaoException;
import model.TypeVideo;
import model.CinemaHall;
import model.Film;
import model.Seance;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*
 * сервис взаимодействия сеанса с БД
 * */
public class SeanceDAOImpl extends BasicDAO implements SeanceDAO {

    private static final String SELECT_BY_LIST_ID
            = "Select id_seance, start_time, ending_time, film_id, price, film_name, X.type, duration, cinema_hall" +
            " from (select s.id AS id_seance, start_time, ending_time, film AS film_id, price, name AS film_name, " +
            "type, duration, cinema_hall  from seances s join films f on s.film = f.id) AS X join cinema_hall AS C" +
            " ON X.cinema_hall = C.id WHERE id_seance IN(?)";
    private static final String SELECT_BY_DATE
            = "Select id_seance, start_time, ending_time, film_id, price, film_name, X.type, duration, cinema_hall" +
            " from (select s.id AS id_seance, start_time, ending_time, film AS film_id, price, name AS film_name, " +
            "type, duration, cinema_hall  from seances s join films f on s.film = f.id) AS X join cinema_hall AS C" +
            " ON X.cinema_hall = C.id WHERE start_time>? AND start_time<?";
    private static final String SELECT
            = "Select id_seance, start_time, ending_time, film_id, price, film_name, X.type, duration, cinema_hall" +
            " from (select s.id AS id_seance, start_time, ending_time, film AS film_id, price, name AS film_name, " +
            "type, duration, cinema_hall  from seances s join films f on s.film = f.id) AS X join cinema_hall AS C" +
            " ON X.cinema_hall = C.id WHERE id_seance=?";
    private static final String INSERT
            = "INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE
            = "DELETE FROM Seances WHERE id=?";
    private static final String UPDATE
            = "UPDATE Seances SET start_time=?, ending_time=?, film=?, cinema_hall=?, price=? WHERE id=?";

    private final int START_HOUR_BY_DAY_SCHEDULE = 6; //дата расписания начинается с 6 утра
    private final int PLUS_DAY = 24;  //24 часа с начала даты расписания для определения конца даты расписания

    //добфвить сеанс в базу данных
    @Override
    public Long addSeance(Seance seance) throws SeanceDaoException{
        if (seance != null){
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(INSERT, new String[]{"id"})){
                Long idSeance = -1L;
                pst.setTimestamp(1, Timestamp.valueOf(seance.getStartSeance()));
                pst.setTimestamp(2, Timestamp.valueOf(seance.getEndingSeance()));
                pst.setLong(3, seance.getFilm().getFilmId());
                pst.setLong(4, seance.getCinemaHall().getId());
                pst.setDouble(5, seance.getPriceTicket());
                pst.executeUpdate();
                try (ResultSet rs = pst.getGeneratedKeys()) {
                    while (rs.next()) {
                        idSeance = rs.getLong("id");
                    }
                    return idSeance;
                } catch (SQLException ex) {
                    throw new SeanceDaoException(ex);
                }
            }catch (SQLException ex){
                throw new SeanceDaoException(ex);
            }
        }
        return null;
    }

    //удалить сеанс из базы данных
    @Override
    public void deleteSeance(long seanceId) throws SeanceDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE)){
            pst.setLong(1, seanceId);
            pst.executeUpdate();
        }catch (Exception ex){
            throw new SeanceDaoException(ex);
        }
    }

    //Изменить сеанс в базе данных
    @Override
    public void updateSeance(Seance seance) throws SeanceDaoException {
        if (seance != null) {
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(UPDATE)) {
                pst.setTimestamp(1, Timestamp.valueOf(seance.getStartSeance()));
                pst.setTimestamp(2, Timestamp.valueOf(seance.getEndingSeance()));
                pst.setLong(3, seance.getFilm().getFilmId());
                pst.setLong(4, seance.getCinemaHall().getId());
                pst.setDouble(5, seance.getPriceTicket());
                pst.setLong(6, seance.getId());
                pst.executeUpdate();
            } catch (SQLException ex) {
                throw new SeanceDaoException(ex);
            }
        }
    }

    //получить сеанс по id
    @Override
    public Seance getSeance(long seanceId) throws SeanceDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(SELECT);){
            pst.setLong(1, seanceId);
            try(ResultSet resultSet = pst.executeQuery();){
                Seance seance = null;
                while (resultSet.next()){
                    return seance = fillSeance(resultSet);
                }
            }catch (SQLException ex){
                throw new SeanceDaoException(ex);
            }
        }catch (SQLException ex){
            throw new SeanceDaoException(ex);
        }
        return null;
    }

    //получить список сеансов на заданную дату
    @Override
    public List<Seance> getSeancesByDate(LocalDate date) throws SeanceDaoException {
        if (date != null) {
            List<Seance> seances = new ArrayList<>();
            LocalDateTime ldt = LocalDateTime.of(date, LocalTime.of(START_HOUR_BY_DAY_SCHEDULE, 0));
            try (Connection connection = simpleConnection.getConnection();
                 PreparedStatement pst = connection.prepareStatement(SELECT_BY_DATE);) {
                pst.setTimestamp(1, Timestamp.valueOf(ldt));
                pst.setTimestamp(2, Timestamp.valueOf(ldt.plusHours(PLUS_DAY)));
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        seances.add(fillSeance(rs));
                    }
                } catch (SQLException ex) {
                    throw new SeanceDaoException(ex);
                }
                return seances;
            } catch (SQLException ex) {
                throw new SeanceDaoException(ex);
            }
        }
        return null;
    }


    //собрать объект Seance из строки таблици Seances в базе данных
    public Seance fillSeance (ResultSet resultSet) throws SQLException{
        long idSeance = resultSet.getInt("id_seance");
        LocalDateTime startTime = resultSet.getTimestamp("start_time").toLocalDateTime();
        LocalDateTime endingTime = resultSet.getTimestamp("ending_time").toLocalDateTime();
        long film_id = resultSet.getLong("film_id");
        Double price = resultSet.getDouble("price");
        String filmName = resultSet.getString("film_name");
        TypeVideo typeVideo = TypeVideo.getType(resultSet.getInt("type"));
        int duration = resultSet.getInt("duration");
        int cinemaHallId = resultSet.getInt("cinema_hall");

        Film film = new Film(film_id, filmName, typeVideo, duration);
        CinemaHall cinemaHall = new CinemaHall(cinemaHallId, typeVideo, null);
        return new Seance(idSeance, film, startTime, price, cinemaHall);
    }


}
