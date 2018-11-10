package dao;

import model.Film;
import model.TypeVideo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FilmDbDAO implements FilmDAO {

    private static final String SELECT
            = "SELECT film_id, film_name, film_type, film_duration FROM films";
    private static final String INSERT
            = "INSERT INTO films (film_name, film_type, film_duration) VALUES (?, ?, ?)";
    private static final String DELETE
            = "DELETE FROM films WHERE film_id=?";
    private static final String UPDATE
            = "UPDATE films SET film_name=?, film_type=?, film_duration=? WHERE film_id=?";

    private SimpleConnection simpleConnection = new SimpleConnection();

    //добавить фильм в базу данных
    @Override
    public int addFilm(Film film) {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(INSERT, new String[] {"film_id"})){
            int film_id = -1;
            pst.setString(1, film.getName());
            pst.setString(2, film.getTypeVideo().toString());
            pst.setInt(3, film.getDuration());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if(gk.next()){
                film_id = gk.getInt("film_id");
            }
            gk.close();
            return film_id;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }

    //удалить фильм по id
    @Override
    public void deleteFilm(int filmId) {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE)){
            pst.setInt(1, filmId);
            pst.executeUpdate();
        }catch (Exception ex){
                ex.printStackTrace();
        }
    }

    //получить список всех фильмов
    @Override
    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            ResultSet resultSet = preparedStatement.executeQuery()){
        while (resultSet.next()){
            films.add(fillFilm(resultSet));
        }
        }catch (Exception ex){
                ex.printStackTrace();
        }
        return films;
    }

    //изменить фильм
    @Override
    public void updateFilm(Film film) {
        try(Connection connection = simpleConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement(UPDATE)){
            pst.setString(1, film.getName());
            pst.setString(2, film.getTypeVideo().toString());
            pst.setInt(3, film.getDuration());
            pst.setInt(4, film.getFilmId());
            pst.executeUpdate();
        }catch (Exception ex){
                ex.printStackTrace();
        }
    }

    //собрать объект Film из строки таблици films в базе данных
    private Film fillFilm (ResultSet resultSet) throws SQLException{
        Film film = new Film();
        film.setFilmId(resultSet.getInt("film_id"));
        film.setName(resultSet.getString("film_name"));
        String type = resultSet.getString("film_type");
        switch (type){
            case "IMAX":
                film.setTypeVideo(TypeVideo.IMAX);
                break;
            case "D3":
                film.setTypeVideo(TypeVideo.D3);
                break;
            case "VIDEO":
                film.setTypeVideo(TypeVideo.VIDEO);
                break;
        }
        film.setDuration(resultSet.getInt("film_duration"));
        return film;
    }
}
