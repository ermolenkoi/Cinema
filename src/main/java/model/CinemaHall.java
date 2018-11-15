package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* Зал кинотеатра с типом фильмв, набором мест. Всего 4 зала
* */

public class CinemaHall {
    private HallName name; //название зала
    private TypeVideo type; //тип задла IMAX/3D/VIDEO
    private List<Position> setPositions = new ArrayList<Position>(); //набор всех мест в зале


    public CinemaHall(HallName name, TypeVideo type, Map<Integer, Integer> scheme){
        this.name = name;
        this.type = type;
        setPositions = createSetPositions(scheme);
    }

    //создает набор мест по заданной схеме
    private List<Position> createSetPositions(Map<Integer, Integer> schema) {
        List<Position> positions = new ArrayList<Position>();
        for (Map.Entry<Integer, Integer> entry: schema.entrySet()){
            for (int i = 1; i <= entry.getValue() ; i++) {
                positions.add(new Position(entry.getKey(), i));
            }
        }
        return positions;
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

    public TypeVideo getType() {
        return type;
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

