package model;

/*
место в зале с номером, рядом, статусом
*/

public class Position {
    private int row; //номер ряда
    private int place; //номер места
    private Status status; //статус меса - свободно/забронированно/занято
    public Position(int row, int place){
        this.row = row;
        this.place = place;
        this.status = Status.FREE;
    }
    public Position (int row, int place, Status st){
        this.row = row;
        this.place = place;
        this.status = st;
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

        if (row != position.row) return false;
        return place == position.place;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + place;
        return result;
    }
}
