package dao;

import exceptions.CinemaHallDaoException;
import exceptions.FilmDaoException;
import exceptions.SeanceDaoException;
import interfases.CinemaHallService;
import interfases.FilmService;
import interfases.SeanceService;
import model.CinemaHall;
import model.Film;
import model.HallName;
import model.Seance;
import services.CinemaHallServiceImpl;
import services.FilmServiceImpl;
import services.SeanceServiceImpl;

import java.sql.*;

/*
 * сервис взаимодействия сеанса с БД
 * */
public class SeanceDAOImpl implements SeanceDAO {


    private static final String SELECT
            = "SELECT id, start_time, ending_time, film, cinema_hall, price FROM Seances WHERE id=?";
    private static final String INSERT
            = "INSERT INTO Seances (start_time, ending_time, film, cinema_hall, price) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE
            = "DELETE FROM Seances WHERE id=?";
    private static final String UPDATE
            = "UPDATE Seances SET start_time=?, ending_time=?, film=?, cinema_hall=?, price=? WHERE id=?";

    private SimpleConnection simpleConnection = new SimpleConnection();

    //добфвить сеанс в базу данных
    @Override
    public Integer addSeance(Seance seance) throws SeanceDaoException{
        if (seance != null){
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(INSERT)){
                pst.setTimestamp(1, Timestamp.valueOf(seance.getStartSeance()));
                pst.setTimestamp(2, Timestamp.valueOf(seance.getEndingSeance()));
                pst.setInt(3, seance.getFilm().getFilmId());
                pst.setInt(4, seance.getCinemaHall().getId());
                pst.setDouble(5, seance.getPriceTicket());
                pst.executeUpdate();
            }catch (SQLException ex){
                throw new SeanceDaoException(ex);
            }
        }
        return null;
    }

    //удалить сеанс из базы данных
    @Override
    public void deleteSeance(int SeanceId) throws SeanceDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE)){
            pst.setInt(1, SeanceId);
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
                pst.setInt(3, seance.getFilm().getFilmId());
                pst.setInt(4, seance.getCinemaHall().getId());
                pst.setDouble(5, seance.getPriceTicket());
                pst.setInt(6, seance.getId());
                pst.executeUpdate();
            } catch (SQLException ex) {
                throw new SeanceDaoException(ex);
            }
        }
    }

    //получить сеанс по id
    @Override
    public Seance getSeance(int seanceId) throws SeanceDaoException {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(SELECT);){
            pst.setInt(1, seanceId);
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

    //собрать объект Seance из строки таблици Seances в базе данных
    public Seance fillSeance (ResultSet resultSet) throws SQLException{
        FilmService filmService = new FilmServiceImpl();
        CinemaHallService cinemaHallService = new CinemaHallServiceImpl();
        SeanceService seanceService = new SeanceServiceImpl();
        Seance seance = seanceService.createSeance();

        seance.setId(resultSet.getInt("id"));
        seance.setStartSeance(resultSet.getTimestamp("start_time").toLocalDateTime());
        seance.setEndingSeance(resultSet.getTimestamp("ending_time").toLocalDateTime());
        Film film = filmService.createFilm();
        film.setFilmId(resultSet.getInt("film"));
        seance.setFilm(film);
        CinemaHall cinemaHall = cinemaHallService.createCinemaHall();
        cinemaHall.setId(resultSet.getInt("cinema_hall"));
        seance.setCinemaHall(cinemaHall);
        seance.setPriceTicket(resultSet.getDouble("price"));
        return seance;
    }
}
