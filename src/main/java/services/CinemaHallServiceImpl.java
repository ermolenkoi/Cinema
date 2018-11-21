package services;

import dao.CinemaHallDAO;
import dao.CinemaHallDAOImpl;
import exceptions.CinemaHallDaoException;
import model.CinemaHall;
import model.TypeVideo;

import java.util.Map;

/*
 * сервис управления кинозалами
 * */
public class CinemaHallServiceImpl implements CinemaHallService {
    private CinemaHallDAO cinemaHallDAO = new CinemaHallDAOImpl();

    @Override
    public CinemaHall getCinemaHall(long id) {
        CinemaHall cinemaHall = null;
        try {
            cinemaHall = cinemaHallDAO.getCinemaHall(id);
            return cinemaHall;
        } catch (CinemaHallDaoException e) {
            e.printStackTrace();
        }
        return null;
    }



}
