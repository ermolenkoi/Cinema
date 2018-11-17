package model;

/*
 * место в зале с номером, рядом, статусом
 **/

public class Position {
    private int id;         //идентификационный номер места в зале
    private int row;        //номер ряда
    private int place;      //номер места
    private Status status;  //статус меса - свободно/забронированно/занято

    public Position(int row, int place){
        this.row = row;
        this.place = place;
        this.status = Status.FREE;
        id = row * 100 + place;
    }
    public Position (int row, int place, Status st){
        this.row = row;
        this.place = place;
        this.status = st;
        id = row * 100 + place;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getPlace() {
        return place;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (id != position.id) return false;
        if (row != position.row) return false;
        if (place != position.place) return false;
        return status == position.status;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + row;
        result = 31 * result + place;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
