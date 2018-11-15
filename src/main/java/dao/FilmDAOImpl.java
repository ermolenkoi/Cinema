package dao;

import exceptions.FilmDaoException;
import model.Film;
import model.TypeVideo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FilmDAOImpl implements FilmDAO {

    private static final String SELECT
            = "SELECT id, name, type, duration FROM films";
    private static final String INSERT
            = "INSERT INTO films (id, name, type, duration) VALUES (?, ?, ?, ?)";
    private static final String DELETE
            = "DELETE FROM films WHERE id=?";
    private static final String UPDATE
            = "UPDATE films SET name=?, type=?, duration=? WHERE id=?";

    private SimpleConnection simpleConnection = new SimpleConnection();

    //добавить фильм в базу данных
    @Override
    public void addFilm(Film film) throws FilmDaoException {
        if (film != null){
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(INSERT)){
                pst.setInt(1, film.getFilmId());
                pst.setString(2, film.getName());
                pst.setInt(3, TypeVideo.getNumType(film.getTypeVideo()));
                pst.setInt(4, film.getDuration());
                pst.executeUpdate();
            }catch (SQLException ex){
                throw new FilmDaoException(ex);
            }
        }
    }

    //удалить фильм по id
    @Override
    public void deleteFilm(int filmId) throws FilmDaoException{
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE)){
            pst.setInt(1, filmId);
            pst.executeUpdate();
        }catch (Exception ex){
            throw new FilmDaoException(ex);
        }
    }

    //получить список всех фильмов
    @Override
    public List<Film> getAllFilms() throws FilmDaoException{
        List<Film> films = new ArrayList<>();
        try(Connection connection = MyDataSourceFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery()){
        while (resultSet.next()){
            films.add(fillFilm(resultSet));
        }
        }catch (Exception ex){
            throw new FilmDaoException(ex);
        }
        return films;
    }

    //изменить фильм
    @Override
    public void updateFilm(Film film) throws FilmDaoException{
        if (film != null){
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement pst = connection.prepareStatement(UPDATE)){
                pst.setString(1, film.getName());
                pst.setInt(2, TypeVideo.getNumType(film.getTypeVideo()));
                pst.setInt(3, film.getDuration());
                pst.setInt(4, film.getFilmId());
                pst.executeUpdate();
            }catch (Exception ex){
                throw new FilmDaoException(ex);
            }
        }
    }

    //собрать объект Film из строки таблици films в базе данных
    private Film fillFilm (ResultSet resultSet) throws SQLException{
        Film film = new Film();
        film.setFilmId(resultSet.getInt("id"));
        film.setName(resultSet.getString("name"));
        int type = resultSet.getInt("type");
        film.setTypeVideo(TypeVideo.getType(type));
        film.setDuration(resultSet.getInt("duration"));
        return film;
    }
}
