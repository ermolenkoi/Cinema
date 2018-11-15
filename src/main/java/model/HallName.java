package model;

/*
* Имена залов
* */

public enum HallName {
    NUMBER_1(1), // зал IMAX
    NUMBER_2(2), // зал 3d
    NUMBER_3(3), // зал обычного VIDEO
    NUMBER_4(4);  // зал обычного VIDEO

    int num = 0;

    HallName(int num) {
        this.num = num;
    }

    public static HallName getHallName(int num){
        for (HallName hn: HallName.values()){
            if (hn.num == num){
                return hn;
            }
        }
        return null;
    }

    public static int getNumHallName(HallName hallName){
        return hallName.num;
    }

}
