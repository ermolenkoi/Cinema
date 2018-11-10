package model;

import java.util.*;

public class BDTest {
    private static BDTest instance;

    private Map<Calendar, Schedule> schedules = new HashMap<Calendar, Schedule>();

    private List<Film> films = new ArrayList<>();

    private BDTest(){

    }

    public static BDTest getInstance(){
        if (instance == null) instance = new BDTest();
        return instance;
    }

    public Map<Calendar, Schedule> getSchedules() {
        return schedules;
    }

    public List<Film> getFilms() {
        return films;
    }
}
