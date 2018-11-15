package dao;

import exceptions.CinemaHallDaoException;
import exceptions.FilmDaoException;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CinemaHallDAOImpl implements CinemaHallDAO {
    private static final String SELECT_ALL_PLACES = "SELECT row, place FROM cinema_Hall_Scheme WHERE cinema_Hall=?";
    private static final String SELECT_TYPE_VIDEO = "SELECT type FROM cinema_Hall WHERE id=?";
    private SimpleConnection simpleConnection = new SimpleConnection();


    @Override
    //получить зал по имени
    public CinemaHall getCinemaHall(HallName hallName) throws CinemaHallDaoException {
        if (hallName != null){
            Map<Integer,Integer> map = new HashMap<>();
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PLACES);){
                preparedStatement.setInt(1, HallName.getNumHallName(hallName));
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    map.put(rs.getInt("row"), rs.getInt("place"));
                }
                rs.close();
                TypeVideo typeVideo = this.getTypeVideoCinemaHall(hallName);
                CinemaHall cinemaHall = new CinemaHall(hallName, typeVideo, map);
                return cinemaHall;
            }catch (SQLException ex){
                throw new CinemaHallDaoException(ex);
            }
        }
        return null;
    }

    //получить тип видео в зале по имени
    @Override
    public TypeVideo getTypeVideoCinemaHall(HallName hallName) throws CinemaHallDaoException{
        if (hallName != null){
            TypeVideo typeVideo = null;
            try(Connection connection = simpleConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TYPE_VIDEO);){
                preparedStatement.setInt(1, HallName.getNumHallName(hallName));
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()){
                    typeVideo = TypeVideo.getType(rs.getInt("type"));
                }
                rs.close();
                return typeVideo;
            }catch (SQLException ex){
                throw new CinemaHallDaoException(ex);
            }
        }
        return null;
    }
}
