package dao;

import exceptions.CinemaHallDaoException;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

/*
 * интерфейс взаимодействия кинозала с БД
 * */
public interface CinemaHallDAO {
    //получить зал по id
    CinemaHall getCinemaHall (int id) throws CinemaHallDaoException;
    //получить тип зала по имени
    TypeVideo getTypeVideoCinemaHall(HallName hallName) throws CinemaHallDaoException;


}
