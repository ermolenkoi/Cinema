package interfases;

import model.CinemaHall;
import model.HallName;
import model.TypeVideo;

import java.util.Map;

/*
интерфейс для определения функций для хранения данных о залах
*/
public interface CinemaHallService {
    //создать новый зал по заданной схеме
    CinemaHall createCinemaHall(HallName hallName, TypeVideo typeVideo, Map<Integer, Integer> scheme);

}
