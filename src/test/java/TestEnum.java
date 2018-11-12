import model.TypeVideo;

public class TestEnum {
    public static void main(String[] args) {
        TypeVideo t = TypeVideo.IMAX;
        System.out.println(TypeVideo.getType(2));
        System.out.println(t);

        System.out.println(TypeVideo.VIDEO.ordinal());
        System.out.println(TypeVideo.getNumType(t));
    }
}
