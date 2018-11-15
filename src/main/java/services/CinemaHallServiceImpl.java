package services;

import interfases.CinemaHallService;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

import java.util.HashMap;

/*
 * сервис управления кинозалами
 * */
public class CinemaHallServiceImpl implements CinemaHallService {
    @Override
    public CinemaHall createCinemaHall(HallName hallName, TypeVideo typeVideo, HashMap<Integer, Integer> scheme) {
        return new CinemaHall(hallName, typeVideo, scheme);
    }
}
