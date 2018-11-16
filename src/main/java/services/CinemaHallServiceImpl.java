package services;

import interfases.CinemaHallService;
import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

import java.util.HashMap;
import java.util.Map;

/*
 * сервис управления кинозалами
 * */
public class CinemaHallServiceImpl implements CinemaHallService {
    @Override
    public CinemaHall createCinemaHall(int id, TypeVideo typeVideo, Map<Integer, Integer> scheme) {
        if (typeVideo != null && scheme != null){
            return new CinemaHall(id, typeVideo, scheme);
        }
        return null;
    }

    @Override
    public CinemaHall createCinemaHall() {
        return new CinemaHall();
    }
}
