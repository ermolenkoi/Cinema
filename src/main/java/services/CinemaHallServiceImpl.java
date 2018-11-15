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
    public CinemaHall createCinemaHall(HallName hallName, TypeVideo typeVideo, Map<Integer, Integer> scheme) {
        if (hallName != null && typeVideo != null && scheme != null){
            return new CinemaHall(hallName, typeVideo, scheme);
        }
        return null;
    }
}
