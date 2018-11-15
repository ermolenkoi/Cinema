package model;

import java.time.LocalDate;
import java.util.*;

/*
 *расписание сеансов
 */
public class Schedule {
    private LocalDate date; // дата расписания
    private ArrayList<Seance> seances = new ArrayList<Seance>(); //расписание сеансов на дату

    public Schedule(LocalDate date){
        this.date = date;

    }

    public LocalDate getDate() {
        return date;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void addSeance (Seance seance){
        seances.add(seance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (date != null ? !date.equals(schedule.date) : schedule.date != null) return false;
        return seances != null ? seances.equals(schedule.seances) : schedule.seances == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (seances != null ? seances.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Расписание на дату " + date + " :\n");
        for (Seance s: seances){
            stringBuilder.append(s.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
