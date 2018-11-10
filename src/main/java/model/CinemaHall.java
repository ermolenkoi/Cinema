package model;

import java.util.ArrayList;
import java.util.List;

/*
* Зал кинотеатра с типом фильмв, набором мест. Всего 4 зала
* */

public class CinemaHall {
    private HallName name; //название зала
    private TypeVideo type; //тип задла IMAX/3D/VIDEO
    private List<Position> setPositions = new ArrayList<Position>(); //набор всех мест в зале


    public CinemaHall(HallName name) {
        setName(name);
        switch (name) {
            case NUMBER_1:
                setSetPositions(create_NUMBER_1());
                setType(TypeVideo.IMAX);
                break;
            case NUMBER_2:
                setSetPositions(create_NUMBER_2());
                setType(TypeVideo.D3);
                break;
            case NUMBER_3:
                setSetPositions(create_NUMBER_3());
                setType(TypeVideo.VIDEO);
                break;
            case NUMBER_4:
                setSetPositions(create_NUMBER_4());
                setType(TypeVideo.VIDEO);
                break;
        }

    }

    // создать набор мест для зала №1
    private List<Position> create_NUMBER_1() {
        List<Position> setPlace = new ArrayList<Position>();
        int[] place = {10, 10, 10, 10, 16, 16, 18, 20};
        for (int i = 0; i < place.length; i++) {
            for (int j = 1; j <= place[i]; j++) {
                setPlace.add(new Position(i + 1, j));
            }
        }
        return setPlace;
    }

    // создать набор мест для зала №2
    private List<Position> create_NUMBER_2() {
        List<Position> setPlace = new ArrayList<Position>();
        int[] place = {10, 10, 10, 10, 10, 10, 16, 16, 18, 20};
        for (int i = 0; i < place.length; i++) {
            for (int j = 1; j <= place[i]; j++) {
                setPlace.add(new Position(i + 1, j));
            }
        }
        return setPlace;
    }

    // создать набор мест для зала №3
    private List<Position> create_NUMBER_3() {
        List<Position> setPlace = new ArrayList<Position>();
        int[] place = {10, 10, 10, 10, 10, 10, 10, 10, 14, 14, 16, 16};
        for (int i = 0; i < place.length; i++) {
            for (int j = 1; j <= place[i]; j++) {
                setPlace.add(new Position(i + 1, j));
            }
        }
        return setPlace;
    }

    // создать набор мест для зала №4
    private List<Position> create_NUMBER_4() {
        List<Position> setPlace = new ArrayList<Position>();
        int[] place = {8, 8, 8, 8, 8, 10, 10, 12, 12, 12};
        for (int i = 0; i < place.length; i++) {
            for (int j = 1; j <= place[i]; j++) {
                setPlace.add(new Position(i + 1, j));
            }
        }
        return setPlace;
    }


    private void setName(HallName name) {
        this.name = name;
    }

    private void setType(TypeVideo type) {
        this.type = type;
    }

    private void setSetPositions(List<Position> setPlace) {
        this.setPositions = setPlace;
    }

    public List<Position> getSetPositions() {
        return setPositions;
    }

    public HallName getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinemaHall that = (CinemaHall) o;

        if (name != that.name) return false;
        if (type != that.type) return false;
        return setPositions != null ? setPositions.equals(that.setPositions) : that.setPositions == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (setPositions != null ? setPositions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder positions = new StringBuilder();

        for (Position p: setPositions){
            positions.append("ряд №" + p.getRow() + " место№" + p.getPlace() + " " + p.getStatus() + "\n");
        }

        return positions.toString();
    }
}

