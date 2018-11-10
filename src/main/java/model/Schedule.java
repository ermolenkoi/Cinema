package model;

import java.util.*;

/*
расписание сеансов
*/
public class Schedule {
    private Calendar date; // дата расписания
    private ArrayList<Seance> seances = new ArrayList<Seance>(); //расписание сеансов на дату с групированное по залам

    public Schedule(Calendar date){
        this.date = date;

    }

    public Calendar getDate() {
        return date;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

}
