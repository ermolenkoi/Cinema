package dao;

import exceptions.CinemaHallDaoException;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

public interface CinemaHallDAO {
    //получить зал по имени
    CinemaHall getCinemaHall (Integer hallNameId) throws CinemaHallDaoException;
    //получить тип зала по имени
    TypeVideo getTypeVideoCinemaHall(HallName hallName) throws CinemaHallDaoException;


}
