package model;

/*
 * типы фильмов
 * */

public enum TypeVideo {
    IMAX(1),
    D3(2),
    VIDEO(3);

    int num = 0;

    TypeVideo(int num) {
        this.num = num;
    }

    public static TypeVideo getType(int num){
        for (TypeVideo tp: TypeVideo.values()){
            if (tp.num == num){
                return tp;
            }
        }
        return null;
    }

    public static int getNumType(TypeVideo typeVideo){
        return typeVideo.num;
    }

}
