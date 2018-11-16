package model;

/*
 * статус муста
 * */

public enum Status {
    FREE(1),
    RESERVED(2),
    CLOSED(3);

    int num = 0;

    Status(int num) {
        this.num = num;
    }

    public static Status getType(int num){
        for (Status tp: Status.values()){
            if (tp.num == num){
                return tp;
            }
        }
        return null;
    }

    public static int getNumType(Status status){
        return status.num;
    }
}
